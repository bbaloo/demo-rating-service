To run this project you need to follow two steps:
1. Run backend -> rating-service
2. Run frontend -> rating-app

# Run backend
## With docker
Go to rating-service directory run:
```
./gradlew build
```
then
```
./gradlew docker
```
then
```
docker-compose up
```
Now API service should be up and running on port 8080

swagger:
```
http://localhost:8080/swagger-ui.html
```

## Without docker

Edit `application.properties` to point to your MongoDB database:

```
spring.data.mongodb.host= your-host
spring.data.mongodb.port= your-mongodb-port
```

Build jar

```
./gradlew build
```

Run jar

```
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```
# Run frontend
Go to `rating-app` directory and run:
```
yarn install
```
then
```
yarn start
```
default address should be `http://localhost:3000`
