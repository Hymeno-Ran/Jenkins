def call(String pathApp) {
    stage('Path Check') {
        script {
            echo "Checking path: ${pathApp}"
            // Kiểm tra xem đường dẫn có tồn tại không
            if (fileExists(pathApp)) {
                echo "Path exists: ${pathApp}"
            } else {
                error "Path does not exist: ${pathApp}"
            }
        }
    }
}