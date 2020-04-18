#!/bin/bash

./mvnw clean -DskipTests=true package

docker build -t zuulserver .

docker run -d --rm -p 8765:8765 --name zuulserver --net spring_cloud_network zuulserver
