#!/bin/bash

DIRECTORIES=`/bin/ls -d */`

function CLEAN_AND_PACKAGE() {
    if [ -f "./mvnw" ]
    then
        ./mvnw clean -DskipTests=true install
    fi
}

function RUN() {
    DIRS_TO_RUN=$1
    for DIR in $DIRS_TO_RUN;
    do
        if [ -d "$DIR" ];
        then
            cd "$DIR" &&  echo "Running on $DIR" && CLEAN_AND_PACKAGE;
            cd ..
        fi
    done
}

function MAIN() {
    if [ -z "$1"  ] ;
    then
        echo "Running on all directories"
        RUN "$DIRECTORIES"
    else
        RUN $@
    fi
    docker-compose up --build
}

MAIN $@
