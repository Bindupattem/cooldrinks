pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "bindusravya/cooldrinks-java"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                https://github.com/Bindupattem/cooldrinks.git
            }
        }

        stage('Build Java') {
            steps {
                sh 'javac src/CoolDrinksMenu.java'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push Image') {
            steps {
                echo "Push step here"
            }
        }
    }
}
