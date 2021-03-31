cd ../../
cd first || exit
mvn package
cd target || exit
java -jar first-0.0.1-SNAPSHOT.jar --server.port=9000 &
java -jar first-0.0.1-SNAPSHOT.jar --server.port=9001 &
java -jar first-0.0.1-SNAPSHOT.jar --server.port=9002 &
java -jar first-0.0.1-SNAPSHOT.jar --server.port=9003
