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
            steps {
                sh 'docker push rperezv/selenium'
            }
        }
    }

    post {
        always {
            echo 'doing clean up'
        }
    }
}