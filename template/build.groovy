// templates/build.groovy
def call(String projectName) {
    stage('Build') {
        echo "Building project: ${pathApp}"
        // Thêm lệnh build ở đây, ví dụ:
        sh "'javac -d target ${pathApp}'"
    }
}