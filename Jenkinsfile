pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/Bindupattem/cooldrinks.git'
            }
        }

        stage('Compile Java') {
            steps {
                sh 'javac App.java'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t cooldrinks:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhubcred',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh 'docker login -u $USER -p $PASS'
                    sh 'docker tag cooldrinks:latest $USER/cooldrinks:latest'
                    sh 'docker push $USER/cooldrinks:latest'
                }
            }
        }

    }
}
