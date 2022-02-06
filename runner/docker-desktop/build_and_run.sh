#!/bin/bash

echo "preparing services..."

echo "build equipment-api"
cd ..
cd .. 
cd equipment-api
./mvnw clean compile jib:dockerBuild

echo "build order-api"
cd ..
ls -la
cd order-api
./mvnw clean compile jib:dockerBuild


echo "build order-consumer"
cd ..
ls -la
cd order-consumer
./gradlew jibDockerBuild

echo "that's all about build part.... "
echo "starting to build those apps with compose..."
cd ..
docker-compose -f "composes/local/docker-compose.yaml" up -d --build 
