# nodejs-helloworld -- Installation Guide

### 1. Setup Pre-requisites

#### Install Docker on your system
As this guide is for Mac, I will list the URL for Mac here: https://docs.docker.com/docker-for-mac/install/

#### Enable Kubernetes
After installing Docker for Mac, you have to enable Kubernetes in docker. Follow this guide to do this: https://docs.docker.com/docker-for-mac/#kubernetes

#### Ingress Controller
We need an Ingress controller to access the application on our system that is deployed on Kubernetes.
Ingress controller can be installed from here: https://kubernetes.github.io/ingress-nginx/deploy/

### 2. Jenkins Startup
There is a script named `bootstrap.sh` on the root of this repository. Execute this script to start Jenkins on your system.
bash <(curl -Ls https://raw.githubusercontent.com/umairadeeb/nodejs-helloworld/master/bootstrap.sh)

Once the Jenkins server is started, your can access it at:
Jenkins URL: http://localhost/jenkins
Username: admin
Password: admin

### 3. Start Jenkins Agent
After logging into Jenkins, go to below url and run the `agent.jar` on your system to connect your host to Jenkins server.

- Jenkins Agent URL: http://localhost/jenkins/computer/parent/
- Download agent.jar: http://localhost/jenkins/jnlpJars/agent.jar

Copy command written as `java -jar agent.jar ...` and execute it on your system's terminal.

### 4. Build NodeJS Application
On Jenkins server UI, there is a job named as `Build` that will create a Docker image for NodeJS application.

### 5. Deploy NodeJS Application
Once Build job is completed successfully, you can run `Deploy` job to deploy the application on *dev* or *prod* environment. When this job is executed first time, it will by default deploy on dev environment.

Application can be accessed after deployment at this URL:
http://localhost


### Notes about the techstack used
- Docker
- Kubernetes
- Ingress controller (for kubernetes)
- Helm
- Nodejs (to write hello world app)
- MariaDB (to store nodejs app data)
- Environment specific application properties using helm
- Jenkins
- Jenkins Shared Library
- Jenkins Configuration as Code plugin
- Jenkins Job DSL plugin
- Jenkins Startup trigger plugin
- Both DEV and PROD environments are deployed on different namespaces to keep them in a separate sandbox

### Improvements
- Support for Blue/Green deployments
- More modular code for Jenkins Shared Library
- Implement github webhooks to fully automate Pull Request Builds, Deploy on merge, and environment promotion using pull requests to upstream branches or release tags.
