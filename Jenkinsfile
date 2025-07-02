pipeline {
    agent any // This will run on any available Jenkins agent/node

    parameters {
        string(name: 'SOURCE_FILE', defaultValue: 'C:\\Users\\RK40167506\\Desktop\\Source folder\\git.txt', description: 'Absolute path to the source file to copy.')
        string(name: 'DEST_DIR', defaultValue: 'C:\\Users\\RK40167506\\Desktop\\Destination folder', description: 'Absolute path to the destination directory.')
    }

    stages {
        stage('Copy Local File') {
        stage('Copy File') {
            steps {
                script {
                        // For Windows
                        echo "Running on Windows. Using 'copy'..."
                        bat 'copy "C:\\Users\\RK40167506\\Desktop\\Source folder\\git.txt" "C:\\Users\\RK40167506\\Desktop\\Destination folder"'
                    }
                }
                echo "Attempting to copy '${params.SOURCE_FILE}' to '${params.DEST_DIR}'"

                // This is the recommended approach using the "File Operations" plugin.
                // It is platform-independent and more robust than using shell/batch commands.
                // Ensure the plugin is installed in your Jenkins instance.
                fileOperations([
                    fileCopyOperation(
                        destination: params.DEST_DIR,
                        source: params.SOURCE_FILE
                    )
                ])

                echo "Successfully copied file."
            }
        }
    }
    post {
        success {
            echo "Build successful. File copy completed."
        }
        failure {
            error "Build failed. Could not copy file. Check permissions and paths."
        }
        always {
            echo 'File copy attempt finished.'
        }
    }
}


