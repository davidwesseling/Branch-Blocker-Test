def nums = ["1", "2", "3"]

def parallelFlakyTestDetectorJob = nums.collectEntries {
    ["${it}" : generateStage(it)]
}

def outside_variable = 'OUTVAR'

def generateStage(num) {
    return {
        stage("Flaky Test Detector Run #${num}") {
                echo "This is ${num}."

                echo "This is an outside variable ${outside_variable}."
            
                sh script: "sleep 5"
        }
    }
}

pipeline {
    agent any

    stages {


        stage('Start Flaky Test Detector ') {
            steps {
                script {
                    parallel parallelFlakyTestDetectorJob
                }
            }
        }
    }
}
