## maven build and image
```shell
mvn compile jib:dockerBuild -Djib.to.image=order.service:v1
```

## Docker

```shell
docker run -p 8082:8082 --name order.service --network kubernetes-test order.service:v1
```