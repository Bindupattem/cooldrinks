pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "yourdockerhubusername/cooldrinks-java"
    }

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/yourusername/java-jenkins-docker-project.git'
            }
        }

        stage('Build Java Program') {
            steps {
                sh 'javac src/CoolDrinksMenu.java'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                }
            }
        }

        stage('Push Image to DockerHub') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
            }
        }
    }
}
