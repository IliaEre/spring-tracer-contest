# Trace contest

---

### main goal: save uniq request uuid
#### version 0.0.1-SNAPSHOT

# TODO LIST:
1. common sample [_]  
2. added web integration and kafka integration for common sample [_]  
3. async with Kafka sample [_]  
4. gRps sample [_]
5. multithreading and coroutines 

`
Kotlin, Spring Boot, WebFlux, Kafka, gRpc, 
ELK, Tracer with spring sleuth, Jaeger.

`
---

### Repositories:
1) stock-service  
`Spring webflux rest service with Prostgres and Kafka integraion`

2) stock-async-service
`Spring kafka consumer service`

3) stock-grpc-service
`Spring grpc service`

4) compose:
   Docker compose with [postgres here](https://github.com/IliaEre/composes/blob/main/db/postgres-compose.yaml)

5) integration-service:
`API web integration, multithreading`

--- 
## How to run and what we need:
1) compose file with todo...
2) todo

---
useful material:
1. [Spring sleuth](https://spring.io/projects/spring-cloud-sleuth)
2. [Kafka compose](https://github.com/conduktor/kafka-stack-docker-compose/blob/master/zk-single-kafka-single.yml)