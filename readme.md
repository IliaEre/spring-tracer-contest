# Tracer contest

If we are using Spring Framework, we can easily add tracing. 
Follow next steps:  
1. add sleught
2. add zipkin properties
3. run ELK + simple settings

#### version 0.0.4

Demo with:

`
Java, Spring Boot, Web, WebFlux, Kafka, ELK, Tracer with spring sleuth, Zipkin, Jib.
`

--- 

## Runner
1. Local with Docker Desktop:
`use runner/docker-desktop/build_and_run.sh`

2. Minikube (WIP)  
`use runner/minikube/build_and_run.sh`

### Scenario?   
> sh runner/create_equipment.sh and order_scenario.sh 

### How to check:
1. run services and all crucial images  
2. go to http://localhost:6001/v1/equipment/ 
3. use zipkin: http://localhost:9411/zipkin/
4. find your trace with ELK

---

useful material:  
0. Main idea by: [Source](https://cassiomolin.com/2019/06/30/log-aggregation-with-spring-boot-elastic-stack-and-docker/) 
1. [Spring sleuth](https://spring.io/projects/spring-cloud-sleuth)
2. [Kafka compose](https://github.com/conduktor/kafka-stack-docker-compose/blob/master/zk-single-kafka-single.yml) 
3. [Kafka compose cluster](https://www.baeldung.com/ops/kafka-docker-setup)   
4. [Zipkin](https://github.com/openzipkin-attic/docker-zipkin/blob/master/prometheus/prometheus.yml) 
5. [Minikube port problem](https://rtfm.co.ua/en/kubernetes-spec-ports0-nodeport-forbidden-may-not-be-used-when-type-is-clusterip-2/) 
6. [Minikube pods](https://kubernetes.io/docs/tasks/configure-pod-container/translate-compose-kubernetes/)   
7. Special thanks for [Hello minikube](https://itnext.io/goodbye-docker-desktop-hello-minikube-3649f2a1c469)  
8. Minicube one more userful [link](https://kubernetes.io/ru/docs/tutorials/hello-minikube/)  
9. [Spring boot + k8s](https://blog.nebrass.fr/playing-with-spring-boot-on-kubernetes/)  
10. [Docker + maven](https://medium.com/swlh/build-a-docker-image-using-maven-and-spring-boot-58147045a400) 
11. [Logs with jaeger](https://logz.io/blog/jaeger-and-the-elk-stack/) 
