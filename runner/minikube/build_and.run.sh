#!/bin/bash

### install part
homebrew install docker
homebrew install kubectl
homebrew install minikube

### MINIKUBE PART
minikube start --extra-config=apiserver.service-node-port-range=80-30000
mkdir dev 
cd dev
git clone https://github.com/IliaEre/tracer-contest.git

echo "build..."



# echo "preparing services..."
# cd ..
# cd ..

# echo "preparing order-api"
# cd order-api/
# docker build -t order-api .

