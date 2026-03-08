pipeline {
    agent any

    environment {
        IMAGE_NAME = "yourdockerhubusername/cooldrinks-java"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/yourusername/java-jenkins-docker-project.git'
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
