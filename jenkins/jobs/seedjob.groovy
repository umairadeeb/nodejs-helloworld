// CI Job for NodeJS App
pipelineJob("build") {
    displayName 'Build'

    scm {
        git {
            remote {
                github('umairadeeb/nodejs-helloworld', 'https')
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

    scm {
        git {
            remote {
                github('umairadeeb/nodejs-helloworld', 'https')
            }
        }
    }

    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}