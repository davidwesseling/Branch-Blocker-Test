// pipeline {
//     agent any 

//     stages {
//         script{
//             for (int i = 0; i < 3; i++) {
//                 stage("init"){
//                     steps{

//                         echo "\nScript testing number: ${i} "

//                     }
//                 } 
//             }   
//         }           
//     }
// }


def createStage(number) {

    for (int i = 0; i < number; i++) {
        stage("my stage ${i}") {
            steps {
                echo "this is my stgae number: ${i}"
            }
        }
    }
}


pipeline {
    agent any 

    stages {
        stage("init"){
            steps{
                script{
                    createStage(3)
                }
               

            }
        } 
            
        
    }
}
