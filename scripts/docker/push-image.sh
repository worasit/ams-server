#!/bin/bash -e
mvn package -Dmaven.test.skip=true
docker login -u ${DOCKER_USER_ENV} -p ${DOCKER_PASS_ENV}
docker build -t ${DOCKER_USER_ENV}/ams-server .
docker push ${DOCKER_USER_ENV}/ams-server:latest
