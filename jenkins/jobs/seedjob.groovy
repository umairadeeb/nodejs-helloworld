// CI Job for NodeJS App
multibranchPipelineJob("ci-build-job") {
    displayName 'CI Build'

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