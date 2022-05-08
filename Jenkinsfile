pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "my-maven"
    }

    stages {
        stage('Source Code Checkout') {
            steps {
                echo 'SpringBoot CRUD Application GitHub Repository Code Checkout'
                // Get some code from a GitHub repository
                git 'https://github.com/swagat030/springboot-k8s-cm-sc-app.git'
                
            }
        }
        stage('Maven Compile') {
            steps {
                echo 'SpringBoot CRUD Application Maven Compile'
                // Run Maven on a Unix agent.
                sh "mvn compile"
            }
        }
        stage('Maven Build') {
            steps {
                echo 'SpringBoot CRUD Application Maven Build'
                // Run Maven on a Unix agent.
                sh "mvn clean install"
            }
        }
        stage('Maven Packaging') {
            steps {
                echo 'SpringBoot CRUD Application Maven Packaging'
                sh "mvn package"
                archiveArtifacts 'target/*.jar'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                  echo 'SpringBoot CRUD Application Build Docker Image'
                  sh 'docker build -t swagatkm/springboot-crud-k8s:1.0 .'
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                 withCredentials([string(credentialsId: 'swagatkm', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u swagatkm -p ${dockerhubpwd}'
                 }  
                 sh 'docker push swagatkm/springboot-crud-k8s:1.0'
                }
            }
        }
    }
}
