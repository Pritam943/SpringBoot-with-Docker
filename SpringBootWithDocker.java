SpringBoot-with-Docker

Create image of the SpringBoot application in Docker

Once you have chosen a build system, you don’t need the ARG. You can hard code the JAR location. For Maven, that would be as follows:
Dockerfile
COPYFROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
  target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

  
Then we can build an image with the following command:
docker build -t myorg/myapp .

  
Then we can run it by running the following command:
docker run -p 8080:8080 myorg/myapp
  
The output resembles the following sample output:
COPY.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.7.4)

Nov 06, 2018 2:45:16 PM org.springframework.boot.StartupInfoLogger logStarting
INFO: Starting Application v0.1.0 on b8469cdc9b87 with PID 1 (/app.jar started by root in /)
Nov 06, 2018 2:45:16 PM org.springframework.boot.SpringApplication logStartupProfileInfo
...

