#!/usr/bin/env bash

cd arquitectura-discovery-server
./generaImagen.sh

cd ../

cd arquitectura-monitor-server
./generaImagen.sh
cd ../

cd arquitectura-gateway
./generaImagen.sh
cd ../

cd ms-administracion
./generaImagen.sh
cd ../

cd entity-service-seguros-guadalupe
./generaImagen.sh
cd ../

cd entity-service-empleados
./generaImagen.sh
cd ../

cd entity-service-clientes
./generaImagen.sh
cd ../

cd task-service-creditos
./generaImagen.sh
cd ../

docker-compose up --build

docker-compose stop
docker-compose kill
docker-compose rm -f
