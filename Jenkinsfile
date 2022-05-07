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
                echo 'SpringBoot CRUD Application Project Maven Compile'
                // Run Maven on a Unix agent.
                sh "mvn compile"
            }
        }
        stage('Maven Packaging') {
            steps {
                echo 'SpringBoot CRUD Application Project Maven Packaging'
                sh "mvn package"
                archiveArtifacts 'target/*.jar'
            }
        }
    }
}
