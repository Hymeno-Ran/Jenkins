// templates/build.groovy
def call(String projectName) {
    stage('Build') {
        echo "Building project: ${projectName}"
        // Thêm lệnh build ở đây, ví dụ:
        sh 'mvn clean install'
    }
}