# Distributed-Account-Management-System
Distributed Systems project 2019.  The purpose is to build a distributed user account system in 2 parts. First part being a gRPC password service, second part being a RESTful User Account Service

## References (Part 1):
* https://grpc.io/docs/guides/concepts/ 
* https://learnonline.gmit.ie/pluginfile.php/26017/course/section/26655/L8-gRPC.pdf
* https://www.youtube.com/watch?v=kUz2zjkKxFg

## References (Part 2):
* https://howtodoinjava.com/dropwizard/tutorial-and-hello-world-example/
* https://www.dropwizard.io/en/stable/getting-started.html
* https://www.dropwizard.io/en/stable/manual/core.html 

## Link to SwaggerHub API Documentation
* https://app.swaggerhub.com/apis/MorganReilly/UserAPI/1

### To Run Password Service -- Part 1

* Download .jar from release version 1.1 or v1.1
* $ cd path/to/jar/file
* $ java -jar gRPCPasswordService.jar

### To Run User Service -- Part 2

* Download .jar from release version 1.0
* $ cd path/to/jar/file
* $ java -jar DropWizardExample-1.0-SNAPSHOT.jar server userAccountServiceConfiguration.yml 

### To Test Both:

* Start Part 1 - See above
* Start Part 2 - See above
* Check Documentation from Swaggerhub link
* Open Postman to send REST requests and view responses
