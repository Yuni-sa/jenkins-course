def buildApp() {
    echo "building..."
    echo "build version ${NEW_VERSION}"
}

def testApp() {
    echo "testing..."
}

def deployApp() {
    echo "deploying..."
    echo "deploying version ${params.VERSION}"
}

return this
