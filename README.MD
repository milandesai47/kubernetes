# Nothing to see here :) 

## To build local image
```shell
mvn compile jib:dockerBuild -Djib.to.image=kubernetes:v1
```

## To push image
```shell
mvn clean install jib:build -Djib.to.image=desaimilan001/kubernetes
```

or better yet, use profiles.

# Using minikube

## imperative approach

* start the node
```shell
minikube start --nodes=2
```
* create pod
```shell
kubectl run kubernetes \        
  --image=desaimilan001/kubernetes:latest \
  --port=8080
```

* port forward for testing
```shell
kubectl port-forward pod/kubernetes 3000:8080
```
note
syntax [{port-in-container}:{exposed-in-host}]

## Declarative approach

use [pod.yml](/pod.yml)
