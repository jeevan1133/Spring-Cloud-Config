#!/bin/bash

DIRECTORIES=`/bin/ls -d */`
RC=-1

function CLEAN_AND_PACKAGE() {
    #return
    if [ -f "./mvnw" ]
    then
        ./mvnw -DskipTests=true package
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
    docker-compose up --build  -d

    #PAUSE=0

    #while [ "$RC" != 0 ]
    #do
    #  echo "Running curl..."
    #  try_curl "localhost" "8888"
    #  echo "Try_curl returned $RC"
    #  sleep 15
    #  if [ "$PAUSE" == 0 ]
    #  then
    #    echo "Stopping limits service container"
    #    docker container stop limitsservice
    #    PAUSE=$(( $PAUSE + 1 ))
    #  fi
    #done
    #RUNNING=$(docker container inspect --format "{{ .State.Status }}" limitsservice)
    #if [[ "$RUNNING" != "running" ]]
    #then
    #  echo "Restarting limitsservice..."
    #  docker container start limitsservice
    #fi
}

MAIN $@
