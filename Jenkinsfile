// @Library('jenkins-shared-library@master')

pipeline {
    agent any
    environment {
        DEPLOY_ENV = '' // Simulate missing environment variable
    }
    stages {
        stage('Build') {
            steps {
                script{
                    build('estatment')
                }
            }
        }
        stage('Test') {
            steps {
                script{
                    sonarqube('testatment', 'Test Project')
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    if (env.DEPLOY_ENV == '') {
                        error 'Deployment failed: DEPLOY_ENV is not set!'
                    }
                    echo "Deploying to environment: ${env.DEPLOY_ENV}"
                    sh 'deploy.sh' // Example deployment script
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed. Check logs for details.'
        }
    }
}