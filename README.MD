## Nothing to see here :) 

### To build local image
mvn compile jib:dockerBuild -Djib.to.image=kubernetes:v1

### To push image
mvn clean install jib:build -Djib.to.image=desaimilan001/kubernetes

or better yet, use profiles