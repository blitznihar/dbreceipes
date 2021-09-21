./mvnw install -Dmaven.test.skip=true
docker build -t blitznihar/dbreceipes .
docker push blitznihar/dbreceipes
docker run -p 7109:7109 -p 6109:6109 -t blitznihar/dbreceipes:latest

docker-compose build

https://techsparx.com/software-development/docker/damp/mongodb.html

docker network create mnet