cd ../../
cd eureka || exit
mvn package
cd target || exit
java -jar eureka-1.0-SNAPSHOT.jar
