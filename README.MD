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
https://kubernetes.io/docs/reference/kubectl/cheatsheet/
```shell
minikube stop/start
kubectl api-resources
```
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

use [pod.yml](/pod.yml) or [deployment.yml] (/deployment.yml)

```shell
kubectl apply -f deployment.yml
```
```shell
kubectl delete -f deployment.yml
```


## Troubeshoot / Debugging
```shell
kubectl describe pod kubernetes
kubectl get pod kubernetes -o yaml
```

### Logs
For pod
```shell
kubectl logs kubernetes
```
For container in a pod
```shell
kubectl logs kubernetes -c kubernetes
```

### Exec into pod

```shell
kubectl exec -it kubernetes -- bash
```


```shell
kubectl exec -it kubernetes -- sh
```

### Exec into container in pod

```shell
kubectl exec -it kubernetes -c kubernetes -- bash
```