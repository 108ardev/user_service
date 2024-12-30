pipeline {
    agent any
    stages {
        stage('Set Permissions') {
            steps {
                sh 'chmod +x gradlew'
            }
        }
        stage('Checkout') {
            steps {
                // Клонирование репозитория
                git branch: 'main', url: 'https://github.com/108ardev/user_service.git'
            }
        }
        stage('Build') {
            steps {
                // Сборка Spring Boot проекта
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                // Запуск тестов
                sh './gradlew test'
            }
        }
    }
}
