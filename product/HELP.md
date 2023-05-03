## Maven build and image build
```shell
 mvn compile jib:dockerBuild -Djib.to.image=product.service:v1
```

## Docker
```shell
docker run -p 8083:8083 --name product.service --network kubernetes-test product.service:v1
```