#!/bin/bash

DIRECTORIES=`/bin/ls -d */`

function CLEAN_AND_PACKAGE() {
    [ -f "./mvnw" ] && ./mvnw clean -DskipTests=true  install
}

function RUN() {
    DIRS=$1
    for DIR in $DIRS;
    do
        cd $DIR
        CLEAN_AND_PACKAGE
        cd ..
    done
}

function MAIN() {
    if [ -z "$1"  ] ;
    then
        echo "Running on all directories"
        RUN $DIRECTORIES
    else
        RUN $@
    fi
    docker-compose up --build
}

MAIN $@
