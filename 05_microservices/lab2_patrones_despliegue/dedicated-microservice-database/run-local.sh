#!/usr/bin/env sh

cd api-clientes-microservicio
gradle clean buildImage 

docker-compose up --build

docker-compose stop
docker-compose kill
docker-compose rm -f
