#!/bin/bash

docker build -t exchangeservice .

docker run -d --rm -p 8001:8001 --name exchangeservice --net spring_cloud_network exchangeservice
