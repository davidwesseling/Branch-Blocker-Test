pipeline {
    agent any 

    stages {
        script{
            for (int i = 0; i < 3; i++) {
                stage("init"){
                    steps{

                        echo "\nScript testing number: ${i} "

                    }
                } 
            }   
        }           
    }
}
