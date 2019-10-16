pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'export CLASSPATH=~/Documents/Testing/PPA1/*.jar'
                sh 'javac PPA1.java'
                sh 'javac Tests.java'
            }
        }
    }
}
