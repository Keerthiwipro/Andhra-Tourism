pipeline {
    agent any // This will run on any available Jenkins agent/node

    stages {
        stage('Copy Local File') {
            steps {
                script {
                        // For Windows
                        echo "Running on Windows. Using 'copy'..."
                        bat 'copy "C:\\Users\\RK40167506\\Desktop\\Source folder\\git.txt" "C:\\Users\\RK40167506\\Desktop\\Destination folder"'
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'File copy attempt finished.'
        }
    }
}
