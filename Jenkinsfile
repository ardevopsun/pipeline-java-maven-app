pipeline {
    agent any
        tools {
            maven "Maven"
        }
        stages {
            stage("build Jar") {
                steps {
                    script {
                        echo "building the application ....."
                        sh 'mvn package'
                    }
                }
            }
            stage("build Image") {
                steps {
                    script {
                        echo "building the docker image ..."
                        withCredentials([usernamePassword(credentialsId: 'dockerHub-credntls', passwordVariable:'PASS', usernameVariable: 'USER')]) {
                            sh 'docker build -t ardevopsun/simple-java-maven-app:jma-2.0 .'
                            sh "echo $PASS | docker login -u $USER --password-stdin"
                            sh 'docker ardevopsun/simple-java-maven-app:jma-2.0'
                        }                        }
                        
                    }
                }
            stage("deploy") {
                steps {
                    script {
                        echo "deploying the application..."
                     }
                }
            }
        }
    }
