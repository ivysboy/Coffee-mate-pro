FROM java:8-jre
VOLUME /tmp
EXPOSE 8098

ENV APP_NAME=coffee-mate
ENV JAR_PATH=/coffee-mate.jar

ADD target/coffee-mate.jar $JAR_PATH
RUN sh -c 'touch /coffee-mate.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /coffee-mate.jar" ]