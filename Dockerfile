# Use the Maven 3.6.3 image with JDK 11 as the base image
FROM maven:3.6.3-jdk-11

# Set the working directory
WORKDIR /home/MicroJurisAutomationFramework

# Copy the pom.xml file and download dependencies first
COPY pom.xml .

# Download project dependencies
RUN mvn dependency:go-offline

# Copy the rest of the source code and test files
COPY src /home/SeleniumFramework/src
COPY testng.xml /home/SeleniumFramework/testng.xml
COPY extent-test-output /home/SeleniumFramework/extent-test-output

# Build the project
RUN mvn clean install

# Default command to run tests
ENTRYPOINT ["mvn", "clean", "test", "-Dsurefire.suiteXmlFiles=testng.xml"]