def buildJar() {
    echo "building the application"
    sh "mvn package"
}
def buildImage() {
    echo "building  the docker Image..."
    withCredentials([usernamePassword(credentialsId: 'dockerHub-credntls', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ardevopsun/simple-java-maven-app:jma-3.0'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push ardevopsun/simple-java-maven-app:jma-3.0"
    }
}
def deployApp() {
    echo 'deploying the application ...'
}

return this
