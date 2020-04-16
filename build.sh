#!/bin/bash

DIRECTORIES=`/bin/ls -d */`

function CLEAN_AND_PACKAGE() {
    if [ -f "./mvnw" ];
    then
        ./mvnw clean package
    fi
}

function MAIN() {
    for DIR in $DIRECTORIES;
    do
        cd $DIR
        CLEAN_AND_PACKAGE
        cd ..
    done
    docker-compose up
}

MAIN
