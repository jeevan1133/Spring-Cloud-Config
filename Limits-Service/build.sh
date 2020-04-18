#!/bin/bash

docker build -t limits_service .

docker run -d --rm -p 8080:8080 --name limits_service --net spring_cloud_network limits_service
