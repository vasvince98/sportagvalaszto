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
                sh 'sudo cp -r /var/lib/jenkins/workspace/sportagvalasztomulti_production/* /home/vvince'
            }
        }

        stage('Docker compose') {
            steps {
                echo 'Docker compose'
                sh 'cd /home/vvince && sudo docker-compose up -d'
            }
        }

//         stage('Move file to apache root') {
//             steps {
//                 sh 'sudo cp -r /var/lib/jenkins/workspace/sportagvalasztomulti_production/* /var/www/html'
//             }
//         }
//
//         stage('Install dependencies') {
//             steps {
//                 sh 'cd /var/www/html && sudo npm install'
//             }
//         }
//
//         stage('Build') {
//             steps {
//                 sh 'cd /var/www/html/ && sudo npm run build'
//             }
//         }
//         stage('Moving build to apache root') {
//             steps {
//                 sh 'sudo cp -r /var/www/html/build/* /var/www/html/'
//             }
//         }
//         stage('Deploy') {
//             when {
//                 branch 'production'
//             }
//             steps {
//                 echo 'Deploying....'
//                 //Starting the json server in previous screen session
//                 sh 'sudo screen -dmS json-server sudo json-server --watch db.json'
//             }
//         }
    }
}
