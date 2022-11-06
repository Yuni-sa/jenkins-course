pipeline {

    agent any
    parameters {
        //string(name: 'VERSION', defaultValue: '', description: 'version to deploy')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }

    environment {
        NEW_VERSION = '1.3.0'
        //SERVER_CREDENTIALS = credentials('server-credentials')
    }
    stages {

        stage("build") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                echo "building..."
                echo "build version ${NEW_VERSION}"
            }
        }

        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'master' && params.executeTests == true
                }
            }
            steps {
                echo "testing..."
            }
        }

        stage("deploy") {

            steps {
                echo "deploying..."
                // withCredentials([
                //     usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
                // ]) {
                //     echo "some script ${USER} ${PWD}"
                // }
                echo "deploying version ${params.VERSION}"
            }
        }
    }   
}

post {
    always {
        //
    }
    success {
        //
    }
    failure {
        //
    }
}
