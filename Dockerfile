FROM markhobson/maven-chrome
ADD  . /
ENTRYPOINT ["mvn", "clean", "test", "-Dtest=org.czyz.VoteForBogdan", "-B"]