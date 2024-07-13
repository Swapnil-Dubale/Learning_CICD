//make sure to add git tool and create a jenkins credential for git token
pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                script {
					//clean workspace
					deleteDir()
                    // Define the Git credentials using the GitHub access token
                    withCredentials([string(credentialsId: 'GIT_TOKEN', variable: 'GIT_TOKEN')]) {
                        // Clone the repository using HTTPS and the token
                        checkout([$class: 'GitSCM',
                            branches: [[name: '*/main']],  // specify the branch if needed
                            userRemoteConfigs: [[
                                url: "https://github.com/Swapnil-Dubale/Learning_CICD.git",
                                credentialsId: 'GIT_TOKEN'
                            ]],
							    relativeTargetDir: 'CODE'
							])
                    }
                }
            }
        }
    }
}
