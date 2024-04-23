String name = 'flaky-test-detector'
// String repository = 'ssh://git@bitbucket.ipttools.info/ed/pass.git'
String repository = 'https://github.com/davidwesseling/Branch-Blocker-Test.git'

multibranchPipelineJob("${name}") {

    triggers {
        cron('*/30 * * * *')
    }

    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }

    branchSources {
        git {
            id('6f5eb371-0967-46a6-b8ae-7d6b03ddeca1')
            remote("${repository}")
            credentialsId("git")
        }
    }

    orphanedItemStrategy {
        discardOldItems {}
    }

    // useful ref: https://gist.github.com/djfdyuruiry/e3c891c6204bea602e770f9bf7a0cb1c
    // set defaultBranchPropertyStrategy to noTrigger
    configure {
        it / sources / 'data' / 'jenkins.branch.BranchSource' << {
            strategy(class: "jenkins.branch.DefaultBranchPropertyStrategy") {
                properties(class: "java.util.Arrays\$ArrayList") {
                    a(class: "jenkins.branch.BranchProperty-array") {
                        // don't trigger builds
                        "jenkins.branch.NoTriggerBranchProperty"()
                    }
                }

                // exceptions to the default strategy
                namedExceptions(class: "java.util.Arrays\$ArrayList") {
                    a(class: "jenkins.branch.NamedExceptionsBranchPropertyStrategy\$Named-array") {
                        "jenkins.branch.NamedExceptionsBranchPropertyStrategy_-Named"() {
                            // for the brach named `master` trigger builds
                            //   (this is default behaviour if no branch properties are specified)
                            props(class: "empty-list")
                            name("master")
                        }
                    }
                }
            }
        }
    }                
}
