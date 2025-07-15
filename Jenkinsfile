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
                sh 'docker build -t=rperezvicente/selenium:latest .'
            }
        }
        stage('Push Docker Image') {
            environment {
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps {
                sh 'echo ${DOCKER_HUB_PSW} | docker login -u $DOCKER_HUB_USR --password-stdin'
                sh 'docker push rperezvicente/selenium:latest'
                sh "docker tag rperezvicente/selenium:latest rperezvicente/selenium:${env.BUILD_NUMBER}"
                sh "docker push rperezvicente/selenium:${env.BUILD_NUMBER}"
            }
        }
    }

    post {
        always {
            sh 'docker logout'
        }
    }
}