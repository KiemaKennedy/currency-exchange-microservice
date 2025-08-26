// SCRIPTED

// with stages

// node {
// 	stage('Build') {
// 		echo "Build"
// 	}
// 	stage('Test') {
// 		echo "Test"
// 	}

// 	stage('Integration Test') {
// 		echo "Integration Test"
// 	}
// }

// without stages - not mandatory

// node {
// 	echo "Build"
// 	echo "Test"
// 	echo "Integration Test"
	
// }

// DECLARATIVE 
// use pipeline, MUST HAVE stages, stage, steps
pipeline {
	// agent any

	// Use a Docker image as an agent
	agent {
		docker {
			image 'maven:3.9.3-eclipse-temurin-17'
		
		}
	}

	stages {
		stage('Build') {
			steps {
				sh "mvn --version"
				// sh "node --version"
				// Variables
				echo "$PATH"
				echo "BUILD NUMBER ${env.BUILD_NUMBER}"
				 echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
			}
		}

		stage ('Test') {
			steps {
				echo "Test Stage"
				
			}
		}

		stage('Integration Stage') {
			steps {
				echo "Integration Stage"
			}
		}
	} 
	post {
		always {
			echo 'Always run'
		}
		success {
			echo 'I run when its successful'
		}
		failure {
			echo 'I run when you fail'
		}
	}
}


