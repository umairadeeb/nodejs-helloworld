# nodejs-helloworld

## Pre-requisites

### Ingress Controller
Ingress controller can be installed from here: https://kubernetes.github.io/ingress-nginx/deploy/

### Jenkins Startup

#### Enable Host as Agent
Go to below url and run the agent.jar on your system to connect your host to Jenkins server (assuming your setup is Mac).
Jenkins Node URL: http://localhost/jenkins/computer/parent/

Download agent.jar: http://localhost/jenkins/jnlpJars/agent.jar

Copy command written as `java -jar agent.jar ...` and execute it on your system's terminal.