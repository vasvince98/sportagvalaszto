node {
  stage('SCM') {
    checkout scm
  }

  stage('Print Workspace') {
      echo "Workspace path: ${workspace}"
      sh "ls -R ${workspace}"
    }

  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    dir("${workspace}") {
        withSonarQubeEnv() {
              sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=vasvince98_sportagvalaszto_AYumgtTK4Z13NZoCs9RU -Dsonar.projectName='sportagvalaszto'"
            }
    }
  }
}
