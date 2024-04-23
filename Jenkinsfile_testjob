def mynum 

pipeline {
    agent any 

    stages {
        stage("init"){
            steps{


                script{
                     for (int i = 0; i < 3; i++) {
                        script{

                            mynum = i
                            echo "\nScript testing number: ${mynum} "
                        }
                    }
                }
               
            }
        }
    }
}
