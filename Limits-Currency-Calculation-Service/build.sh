#!/bin/bash

./mvnw clean -DskipTests=true package

docker build -t calculation_service .

docker run -d --rm -p 8100:8100 --name calculation_service --net spring_cloud_network calculation_service
