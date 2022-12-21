def gv

pipeline {
    agent any
        tools {
            maven "Maven"
        }
        stages {
            stage("init") {
                steps {
                    script {
                        gv.buildJar()
                    }
                }
            }
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
                        gv.buildImage()
                            }                        
                        }
                    }
            stage("deploy") {
                steps {
                    script {
                        gv.deployApp()
                     }
                }
            }
        }
    }
