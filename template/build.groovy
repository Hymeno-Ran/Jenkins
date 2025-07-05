void runBuild() {
    echo 'Start building the application...'
    try {
        sh 'npm install' // Example build step
        echo 'Build completed successfully.'
    } catch (Exception e) {
        error "Build failed: ${e.message}"
    }
    echo 'Running tests...'
    try {
        sh 'npm test' // Example test step
        echo 'Tests completed successfully.'
    } catch (Exception e) {
        error "Test failed: ${e.message}"
    }
    echo 'Checking deployment environment...'
    if (env.DEPLOY_ENV == '') {
        error 'Deployment failed: DEPLOY_ENV is not set!'
    }
    echo "Deploying to environment: ${env.DEPLOY_ENV}"
    try {
        sh 'deploy.sh' // Example deployment script
        echo 'Deployment completed successfully.'
    } catch (Exception e) {
        error "Deployment failed: ${e.message}"
    }
    echo 'Pipeline completed.'
    if (currentBuild.result == 'SUCCESS') {
        echo 'Pipeline succeeded!'
    } else {
        echo 'Pipeline failed. Check logs for details.'
    }
    // Additional post-build actions can be added here
}