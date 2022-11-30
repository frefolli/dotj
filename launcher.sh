#!/bin/bash

# GOALS

GOAL_TEST="clean verify test"
GOAL_SONAR="$GOAL_TEST sonar:sonar"
GOAL_PACKAGE="clean verify package"

# FUNCTIONS

function loadSecrets () {
    source .secrets
}

function goal_sonar () {
    loadSecrets
    GOAL_SONAR="$GOAL_SONAR -Dsonar.login=$SONAR_TOKEN"
    mvn $GOAL_SONAR
}

function goal_test () {
    mvn $GOAL_TEST
}

function goal_package () {
    mvn $GOAL_PACKAGE
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
    *)
        echo "Usage: $0 { test | sonar | package }"
        exit 1
        ;;
    esac
}

cli $1
