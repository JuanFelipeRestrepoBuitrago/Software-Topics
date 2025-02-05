#!/bin/bash

# Set the Tomcat directory from the first argument, or use a default value if no argument is provided
TOMCAT_DIR="${1:-/home/pipertpo/D/Aplicaciones/Apache Tomcat/App/apache-tomcat-10.1.34}"

# Get the name of the war file by reading the pom.xml file
WAR_FILE_NAME=$(grep -oPm1 "(?<=<artifactId>)[^<]+" pom.xml)-$(grep -oPm1 "(?<=<version>)[^<]+" pom.xml).war

echo "The name of the war file is: $WAR_FILE_NAME"

echo "Stopping the tomcat server..."
"$TOMCAT_DIR/bin/shutdown.sh"

echo "Cleaning the project..."
mvn clean

echo "Compiling and packaging the project..."
mvn clean package

echo "Removing the old war file from the tomcat webapps folder..."
rm -rf "$TOMCAT_DIR/webapps/test.war" "$TOMCAT_DIR/webapps/test"

echo "Copying the war $WAR_FILE_NAME file to the tomcat webapps folder as test.war..."
cp "target/$WAR_FILE_NAME" "$TOMCAT_DIR/webapps/test.war"

echo "Starting the tomcat server..."
"$TOMCAT_DIR/bin/startup.sh"

echo "Done!"
echo "You can access the application at: http://localhost:8080/test"