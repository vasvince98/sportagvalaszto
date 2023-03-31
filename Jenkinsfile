pipeline {
    agent any

    stages {
        stage('Clone repo') {
            steps {
                echo 'Cloning repo'
            }
        }

        stage('Move file to apache root') {
            steps {
                sh 'cp -r /var/lib/jenkins/workspace/sportagvalasztomulti_production /var/www/html/'
            }
        }
        stage('Build') {
            steps {
                sh 'cd /var/www/html/ && npm build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                echo env.BRANCH_NAME
            }
        }
        stage('Deploy') {
            when {
                branch 'production'
            }
            steps {
                echo 'Deploying....'
            }
        }
    }
}
