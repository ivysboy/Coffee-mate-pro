echo ${JAVA_HOME}

/root/tomcat/bin/shutdown.sh
echo "Shut down tomcat!"

git pull
echo "Pull new code in local branch"

cd coffeemate_pro

mvn clean package
echo "Package new war"

rm /root/tomcat/webapps/coffee-mate.war
rm -rf /root/tomcat/webapps/coffee-mate
echo "remove former war"

mv target/coffee-mate.war /root/tomcat/webapps/coffee-mate.war

/root/tomcat/bin/startup.sh
echo "Start tomcat!"
