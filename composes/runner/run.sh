echo running db...
docker-compose -f "composes/db/docker-compose.yaml" up -d --build 

echo running kafka cluster...
docker-compose -f "composes/kafka/docker-compose.yaml" up -d --build 

echo running tracing tools...
docker-compose -f "composes/main/docker-compose.yaml" up -d --build 

echo preparing equipment-api
cd equipment-api
./mvnw clean compile jib:dockerBuild 

echo preparing order-api
cd ..
cd order-api
./mvnw clean compile jib:dockerBuild 

echo preparing order-consumer
cd ..
cd order-consumer
./gradlew jibDockerBuild

echo running services....
cd ..
docker-compose -f "composes/services/docker-compose.yaml" up -d --build 
