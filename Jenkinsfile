pipeline {
    agent any

    stages {
        stage('Test') {
            steps{
                
                sh "mvn test"
                
            }

        }

        stage('Package') {
            steps{
                
                sh "mvn clean install"
                
            }

        }

        stage ('Build Docker Image'){
            steps {
                script{
                    dockerapp = docker.build("edsontecno/quarkus-architecture:latest", '-f ./src/main/docker/Dockerfile.jvm .')
                }
            }
        }
    }
}
