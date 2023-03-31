pipeline {
    agent any

    stages {
        stage('Clone repo') {
            steps {
                echo 'Cloning repo'
            }
        stage('Build') {
            steps {
                echo 'ascasc..'
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
