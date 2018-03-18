# Appdirect Challenge
This is an appdirect integration coding challenge project.
The application is deployed in the Pivotal cloud foundry space. The link for this is: https://krunal-appdirect.cfapps.io/.
To test the integration, created account and product in the Appdirect developer account. 
The project uses API first approach where you define your application end points using swagger tool which generates DAO and controller objects for the development. To persist the data, spring embedded H2 database is used. The project is also implemented in a way to use Appdirect oAuth signature verification. To change the secret key please navigate to  /src/main/resources and applcation.yml file. 

### Technology used
To build this project following technologies are used. 

* [Swagger](https://swagger.io/)
* [Spring boot](https://projects.spring.io/spring-boot/)
* [Maven 3.x](https://maven.apache.org/)
* [Java8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)

### Implemented End Points
* Subscription Create Notification URL: https://krunal-appdirect.cfapps.io/api/subscription/create?eventUrl={eventUrl}
* Subscription Change Notification URL : https://krunal-appdirect.cfapps.io/api/subscription/change?eventUrl={eventUrl}
* Subscription Cancel Notification URL: https://krunal-appdirect.cfapps.io/api/subscription/cancel?eventUrl={eventUrl}
* Subscription Status Notification URL : https://krunal-appdirect.cfapps.io/api/subscription/notification?eventUrl={eventUrl}
* User Assignment Notification URL : https://krunal-appdirect.cfapps.io/api/user/assignUser?eventUrl={eventUrl}
* User Unassignment Notification URL: https://krunal-appdirect.cfapps.io/api/user/unassignUser?eventUrl={eventUrl}

### Build and run locally
To run and build the project locally run following command. It will create two folders. One will be target folder under the root of the project and the second one will be gen folder in the src.

`clean install spring-boot:run`

The application will run on localhost:8080. To find the end points you may use following swagger HTML page.

https://krunal-appdirect.cfapps.io/swagger-ui.html

Embedded database H2 can be accessed through the following link.

https://krunal-appdirect.cfapps.io/h2-console/

#### Note: 
* Please change JDBC url to jdbc:h2:mem:testdb and press connect. It will open database schema and tables. 
* When asks for credential use username: admin password: admin.

### Deploy to cloud foundry
To deploy the application to the cloud foundry use following command.

`cf push`

It will take configuration from manifest.yml file.
