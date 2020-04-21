#!/bin/bash

DIRECTORIES=`/bin/ls -d */`

function CLEAN_AND_PACKAGE() {
    [ -f "./mvnw" ] && ./mvnw clean -DskipTests=true  install
    return
}

function build() {
    docker build -t $1 .
}

function RUN() {
    YML_FILE=`find . -name "*.yml"  | grep -i 'resources'`
    PORT=`cat  $YML_FILE | grep -i 'port' | cut -d: -f2`
    PORT=`echo $PORT | tr -d '\n' | cut -c 1-4`
    echo `echo $PORT | hexdump -C`
    docker run -i --rm -p $PORT:$PORT --name $1 --net spring_cloud_network $1
}

function MAIN() {
    for DIR in $DIRECTORIES
    do
        cd $DIR
        CLEAN_AND_PACKAGE
        #./build.sh
        #FOLDER=`echo $DIR | tr '[:upper:]' '[:lower:]'`
        #IMAGE_NAME=`echo $FOLDER | tr -d /`
        #build $IMAGE_NAME
        #RUN $FOLDER
        cd ..
    done
}

MAIN
