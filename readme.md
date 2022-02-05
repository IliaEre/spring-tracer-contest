# Tracer contest

---

#### version 0.0.4-SNAPSHOT

--- 

Use with minikube:
1. minikube start --extra-config=apiserver.service-node-port-range=80-30000  
2. create deployments (each compose folder has a run file, just do it)  

---

### How to run it?  
> sh composes/runner/run.sh

### Scenario?   
> sh composes/runner/scenario.sh

--- 
Demo with:

`
Java, Spring Boot, Web, WebFlux, Kafka, ELK, Tracer with spring sleuth, Zipkin.
`

---

useful material:
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
