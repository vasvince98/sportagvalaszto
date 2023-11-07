node {
  stage('SCM') {
    checkout scm
  }

  stage('Print Workspace') {
      echo "Workspace path: ${workspace}"
    }

  stage('SonarQube Analysis - Backend') {
    def mvn = tool 'Default Maven';
    dir("${workspace}/backend") {
        withSonarQubeEnv() {
              sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=vasvince98_sportagvalaszto_AYumgtTK4Z13NZoCs9RU -Dsonar.projectName='sportagvalaszto'"
            }
    }
  }

  stage('Install dependencies - Frontend') {
        dir("${workspace}/frontend") {
          sh "npm install"
        }
    }

  stage('SonarQube Analysis - Frontend') {
      dir("${workspace}/frontend") {
        withSonarQubeEnv() {
          sh "npm run build -Dsonar.projectKey=vasvince98_sportagvalaszto_frontend_AYumgtTK4Z13NZoCs9RU -Dsonar.projectName='sportagvalaszto-frontend'"
        }
      }
  }
}
