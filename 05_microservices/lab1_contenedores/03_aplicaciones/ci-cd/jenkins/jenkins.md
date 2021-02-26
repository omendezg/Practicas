
docker run --rm  -u root -p 8090:8080 -v "$PWD/data-jenkins/":/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkinsci/blueocean

Docker containers are not automatically removed when you stop them unless you start the container using the --rm flag.

The flag --rm is used when you need the container to be deleted after the task for it is complete.

¿Cómo configuro una app?

Le damos click donde dice “create new jobs”, asignamos un nombre y en este caso haremos un pipeline.

https://git-codecommit.us-east-1.amazonaws.com/v1/repos/arquitecto_apis_microservicios_ci-cd

En este repo existe un Jenkinsfile:

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                 script {
                    try {
                        sh 'chmod 777 -R gradlew'
                        sh './gradlew clean buildImage --no-daemon' //run a gradle task
                    } finally {
                    echo 'Building OK'
                    }
                }       
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}

ejecutar comando de docker images para lista la imagen en local 