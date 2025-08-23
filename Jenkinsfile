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

node {
	echo "Build"
	echo "Test"
	echo "Integration Test"
	
}

// DECLARATIVE 
// use pipeline, MUST HAVE stages, stage, steps

pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
				echo "Build Stage"
				echo "Another Step"
				echo "Last Step"
			}
		}

		stage ('Test') {
			steps {
				echo "Test Stage"
				Step {
					echo "Step 1"
				}
				Step {
					echo "Step 2"
				}
			}
		}

		stage('Integration Stage') {
			steps {
				echo "Integration Stage"
			}
		}
	}
}


