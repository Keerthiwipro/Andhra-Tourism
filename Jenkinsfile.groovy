pipeline {
    agent any // This will run on any available Jenkins agent/node

    parameters {
        string(name: 'SOURCE_FILE', defaultValue: 'C:\\Users\\RK40167506\\Desktop\\Source folder\\git.txt', description: 'Absolute path to the source file to copy.')
        string(name: 'DEST_DIR', defaultValue: 'C:\\Users\\RK40167506\\Desktop\\Destination folder', description: 'Absolute path to the destination directory.')
    }

    stages {
        stage('Copy File') {
            steps {
                echo "Attempting to copy '${params.SOURCE_FILE}' to '${params.DEST_DIR}'"

                // Using the File Operations plugin is platform-independent and robust.
                fileOperations([
                    fileCopyOperation(
                        destination: params.DEST_DIR,
                        source: params.SOURCE_FILE
                    )
                ])
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
