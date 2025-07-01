pipeline {
    agent any

    environment {
        ANGULAR_PROJECT_DIR = 'your-angular-project' // Replace with your Angular project folder
        NGINX_DEPLOY_DIR = '/var/www/html' // Replace with your Nginx server directory
    }

    stages {
        stage('Install Dependencies') {
            steps {
                dir("${env.ANGULAR_PROJECT_DIR}") {
                    echo 'Installing npm dependencies...'
                    sh 'npm install'
                }
            }
        }

        stage('Build Angular App') {
            steps {
                dir("${env.ANGULAR_PROJECT_DIR}") {
                    echo 'Building Angular app...'
                    sh 'npm run build -- --configuration=production'
                }
            }
        }

        stage('Deploy to Nginx') {
            steps {
                echo 'Deploying to Nginx server...'
                sh "sudo rm -rf ${env.NGINX_DEPLOY_DIR}/*"
                sh "sudo cp -r ${env.ANGULAR_PROJECT_DIR}/dist/* ${env.NGINX_DEPLOY_DIR}/"
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed.'
        }
    }
}
