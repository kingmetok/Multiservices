cd ../../
cd zuul || exit
mvn package
cd target || exit
java -jar zuul-1.0-SNAPSHOT.jar
