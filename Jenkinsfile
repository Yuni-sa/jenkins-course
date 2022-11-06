def gv

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
	stage("init") {
            steps {
                script {
			gv = load "script.groovy"
		}
            }
        }
        stage("build") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
		script {
                    gv.buildApp()
		}
            }
        }

        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'master' && params.executeTests == true
                }
            }
            steps {
		script {
		    gv.testApp()
		}
            }
        }

        stage("deploy") {

            steps {
                // withCredentials([
                //     usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
                // ]) {
                //     echo "some script ${USER} ${PWD}"
                // }
		script {
		    gv.deployApp()
		}
            }
        }
    }   
}

//post {
//    always {
//        //
//    }
//    success {
//        //
//    }
//    failure {
//        //
//    }
//}
