function eurekaRunner() {
  cd eureka || exit
  mvn package
  cd target || exit
  java -jar eureka-1.0-SNAPSHOT.jar &
  cd ../../
}

function zuulRunner() {
  cd zuul || exit
  mvn package
  cd target || exit
  java -jar zuul-1.0-SNAPSHOT.jar &
  cd ../../
}

function clientsRunner() {
  cd first || exit
  mvn package
  cd target || exit
  for i in {1..4}; do
    java -jar first-0.0.1-SNAPSHOT.jar --server.port="900$i" &
  done
}

eurekaRunner
zuulRunner
clientsRunner