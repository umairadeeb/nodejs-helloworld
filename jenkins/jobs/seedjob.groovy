// CI Job for NodeJS App
pipelineJob("build") {
    displayName 'Build'

    orphanedItemStrategy {
        discardOldItems {
            numToKeep(10)
        }
    }

    branchSources {
        github {
           // scanCredentialsId('github-ci-user-credentials')
            repoOwner('umairadeeb')
            repository('nodejs-helloworld')
            buildOriginBranch(true)
            buildOriginPRMerge(false)
            buildOriginBranchWithPR(false)
            id("nodejs-helloworld-branch-id")
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

    orphanedItemStrategy {
        discardOldItems {
            numToKeep(10)
        }
    }

    branchSources {
        github {
            // scanCredentialsId('github-ci-user-credentials')
            repoOwner('umairadeeb')
            repository('nodejs-helloworld')
            buildOriginBranch(false)
            buildOriginPRMerge(true)
            buildOriginBranchWithPR(false)
            id("nodejs-helloworld-branch-id")
        }
    }

    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}