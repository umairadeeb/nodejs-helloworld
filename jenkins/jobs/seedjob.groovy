// CI Job for NodeJS App
pipelineJob("build") {
    displayName 'Build'
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('umairadeeb/nodejs-helloworld', 'https')
                    }
                }
            }
        }
    }

    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}


// Deployment Job for NodeJS App
pipelineJob("deploy") {
    displayName 'Deploy'

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('umairadeeb/nodejs-helloworld', 'https')
                    }
                }
            }
        }
    }

    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}