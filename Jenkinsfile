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

	agent {
		docker {
		image 'maven:3.9.6-eclipse-temurin-11'
		args '-v $HOME/.m2:/root/.m2'   // cache dependencies
		}
  	}

	environment {
		// Ensure Jenkins talks to Docker Desktop via Windows named pipe
		DOCKER_HOST       = 'npipe:////./pipe/docker_engine'
		DOCKER_TLS_VERIFY = '0'
		DOCKER_CERT_PATH  = ''
  	}

	stages {
		stage('Docker sanity') {
		steps {
			bat 'where docker'
			bat 'docker version'
			bat 'docker info'
		}
    }
	}

	// Use a Docker image as an agent
	// agent {
	// 	docker {
	// 		image 'maven:3.9.2'
		
	// 	}
	// }



	stages {
		stage('Checkout') {
			steps {
				sh "mvn --version"
				// sh "node --version"
				// Variables
				echo "$PATH"
				echo "BUILD NUMBER ${env.BUILD_NUMBER}"
				 echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
			}
		}

		stage ('Compile') {
			steps {
				sh "mvn clean compile"
				
			}
		}
		
		// Run unit test
		stage ('Test') {
			steps {
				sh "mvn test"
				
			}
		}

		stage('Integration Stage') {
			steps {
				sh "mvn failsafe:integration-test failsafe:verify"
			}
		}

		stage('Package Stage') {
			steps {
				sh "mvn package -DskipTests"
			}
		}

		stage('Build Docker Image') {
			steps {
				// docker build -t repo:$env.BUILD_TAG  - old way
				script{
					dockerImage = docker.build("kennedy109/currency-exchange-devops:${env.BUILD_TAG}")


				}
					

			}
		}

		stage('Push Docker Image') {
			steps {
				script{
					docker.withRegistry('', 'dockerhub') {
						dockerImage.push();
						dockerImage.push('latest')

					}

				}
					

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


