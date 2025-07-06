// templates/sonarqube.groovy
def call() {
    stage('SonarQube Analysis') {
        script {
            echo "Running SonarQube analysis for project: ${projectName}"
            // Lệnh chạy SonarQube Scanner
            sh """
                sonar-scanner \
                -Dsonar.projectKey=aaa \
                -Dsonar.projectName=bbb \
                -Dsonar.sources=src
            """
        }
    }
}