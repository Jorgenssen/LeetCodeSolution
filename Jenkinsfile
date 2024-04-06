pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat "mvn clean test"
            }

            post {
                success {
                    allure([
                        includeProperties: false,
                        jdk: '17',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}