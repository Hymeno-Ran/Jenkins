// templates/sonarqube.groovy
def call(String projectKey, String projectName) {
    stage('SonarQube Analysis') {
        script {
            echo "Running SonarQube analysis for project: ${projectName}"
            // Lệnh chạy SonarQube Scanner
            sh """
                sonar-scanner \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName=${projectName} \
                -Dsonar.sources=src
            """
        }
    }
}