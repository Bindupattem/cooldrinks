pipeline {
    agent any

    environment {
        APP_NAME = "cooldrink"
        DOCKER_IMAGE = "cooldrink-app"
        DOCKER_TAG = "latest"
    }

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout Code') {
            steps {
                echo "Cloning CoolDrink project from Git"
                git branch: 'main', url: 'https://github.com/Bindupattem/cooldrinks.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the project"
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                echo "Running tests"
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo "Packaging application"
                sh 'mvn package'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image"
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                echo "Pushing image to Docker Hub"
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh """
                    echo $PASS | docker login -u $USER --password-stdin
                    docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} $USER/${DOCKER_IMAGE}:${DOCKER_TAG}
                    docker push $USER/${DOCKER_IMAGE}:${DOCKER_TAG}
                    """
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying CoolDrink application"
                sh """
                docker stop cooldrink-container || true
                docker rm cooldrink-container || true
                docker run -d -p 8080:8080 --name cooldrink-container $DOCKER_IMAGE:$DOCKER_TAG
                """
            }
        }
    }

    post {
        success {
            echo "CoolDrink pipeline executed successfully 🎉"
        }
        failure {
            echo "Pipeline failed ❌"
        }
    }
}
