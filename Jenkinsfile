def nums = ["1", "2", "3"]

def parallelFlakyTestDetectorJob = nums.collectEntries {
    ["${it}" : generateStage(it)]
}

def generateStage(num) {
    return {
        stage("Flaky Test Detector Run #${num}") {
                echo "This is ${num}."
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
