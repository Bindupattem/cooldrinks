pipeline {
    agent any

    environment {
        IMAGE_NAME = "bindusravya/cooldrinks-java"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git :main'https://github.com/Bindupattem/cooldrinks.git'
            }
        }

        stage('Compile Java') {
            steps {
                sh 'javac src/CoolDrinksMenu.java'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                sh "docker push ${IMAGE_NAME}"
            }
        }
    }
}
