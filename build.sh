docker compose down

mvn clean compile install

docker rmi -f $(docker images -q)