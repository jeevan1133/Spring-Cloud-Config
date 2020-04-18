#!/bin/bash

docker build -t eurekaserver .

docker run -d --rm -p 8761:8761 --name eurekaserver --net spring_cloud_network eurekaserver
