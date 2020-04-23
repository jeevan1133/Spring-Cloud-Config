#!/bin/bash

DIRECTORIES=`/bin/ls -d */`
RC=-1

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

function try_curl() {
    host=$1
    port=$2

    curl $1:$2
    RC=$?
    echo "returning $RC"
}

function MAIN() {
    if [ -z "$1"  ] ;
    then
        echo "Running on all directories"
        RUN "$DIRECTORIES"
    else
        RUN $@
    fi
    docker-compose up --build -d
    docker-compose pause limitsservice
    while [ "$RC" != 0 ]
    do
      echo "Running curl..."
      try_curl "localhost" "8888"
      sleep 5
    done
    docker-compose unpause limitsservice
}

MAIN $@
