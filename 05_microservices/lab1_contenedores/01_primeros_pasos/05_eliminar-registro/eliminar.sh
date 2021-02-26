#!/usr/bin/env sh

#==== Remove all images and containers

docker image rm -f $(docker image ls -qa)

docker container rm -f $(docker container ls -aq)

# -f = forzar
