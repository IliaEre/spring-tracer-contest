#!/bin/bash

### install part
homebrew install docker
homebrew install kubectl
homebrew install minikube

eval $(minikube -p minikube docker-env)
eval $(minikube docker-env)

### MINIKUBE PART
echo "minikube start"
minikube start --extra-config=apiserver.service-node-port-range=80-30000
mkdir dev 
cd dev
git clone https://github.com/IliaEre/tracer-contest.git
cd tracer-contest

echo "build..."
pwd
cd equipment-api/
docker build -t equipment-api .



# echo "preparing services..."
# cd ..
# cd ..

# echo "preparing order-api"
# cd order-api/
# docker build -t order-api .

