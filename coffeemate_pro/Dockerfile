FROM java:8-jre
VOLUME /tmp
EXPOSE 8098

ENV APP_NAME=coffee-mate
ENV JAR_PATH=/coffee-mate.jar

ADD target/coffee-mate.jar $JAR_PATH
RUN sh -c 'touch /coffee-mate.jar'
ENV JAVA_OPTS="-Djava.net.preferIPv4Stack=true"
ENV JAVA_MEM_LIM="-Xms512m -Xmx1024m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS $JAVA_MEM_LIM -Djava.security.egd=file:/dev/./urandom -jar /coffee-mate.jar" ]
