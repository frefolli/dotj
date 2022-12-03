#!/bin/bash

# GOALS

GOAL_TEST="clean verify test"
GOAL_SONAR="clean verify test sonar:sonar"
GOAL_PACKAGE="clean verify package"
GOAL_JAVADOC="clean verify javadoc:javadoc"

# FUNCTIONS

function loadSecrets () {
    source .secrets
}

function goal_sonar () {
    loadSecrets
    GOAL_SONAR="$GOAL_SONAR -Dsonar.login=$SONAR_TOKEN"
    echo -e $GOAL_SONAR
    mvn $GOAL_SONAR
}

function goal_test () {
    mvn $GOAL_TEST
}

function goal_package () {
    mvn $GOAL_PACKAGE
}

function goal_javadoc () {
    mvn $GOAL_JAVADOC
}

function cli () {
    case "$1" in

    'sonar')
        goal_sonar
        ;;

    'test')
        goal_test
        ;;

    'package')
        goal_package
        ;;

    'javadoc')
        goal_javadoc
        ;;
    *)
        echo "Usage: $0 { test | sonar | package | javadoc }"
        exit 1
        ;;
    esac
}

cli $1
