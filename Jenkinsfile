pipeline {
    agent any

    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
                echo 'doing mvn package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t=rperezv/selenium .'
            }
        }
        stage('Push Docker Image') {
            environment {
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps {
                sh 'docker login -u $DOCKER_HUB_USR -p $DOCKER_HUB_PSW'
                sh 'docker push rperezv/selenium'
            }
        }
    }

    post {
        always {
            sh 'docker logout'
        }
    }
}