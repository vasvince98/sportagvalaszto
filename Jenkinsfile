pipeline {
    agent any

    stages {
        stage('Clone repo') {
            steps {
                echo 'Cloning repo'
            }
        }

        stage('Grant permission') {
            steps {
                sh 'chmod 777 /var/lib/jenkins/workspace/sportagvalasztomulti_production'
            }
        }

        stage('Move file to apache root') {
            steps {
                sh 'cp -r /var/lib/jenkins/workspace/sportagvalasztomulti_production/* /var/www/html'
            }
        }

        stage('Install dependencies') {
            steps {
                sh 'cd /var/www/html && npm install'
            }
        }

        stage('Build') {
            steps {
                sh 'cd /var/www/html/ && npm run build'
            }
        }
        stage('Moving build to apache root') {
            steps {
                sh 'cp -r /var/www/html/build/* /var/www/html/'
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
