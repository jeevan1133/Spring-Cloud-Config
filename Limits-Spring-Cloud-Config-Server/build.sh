#!/bin/bash

docker build -t configserver .

docker run -d --rm -p 8888:8888 --name configserver --net spring_cloud_network configserver
