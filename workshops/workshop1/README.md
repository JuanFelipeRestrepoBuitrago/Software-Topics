# Workshop 1: CRUD Offers with Spring Boot

## Content Table
- [Workshop 1: CRUD Offers with Spring Boot](#workshop-1-crud-offers-with-spring-boot)
  - [Content Table](#content-table)
  - [Authors](#authors)
  - [Introduction](#introduction)
  - [Project Structure](#project-structure)
  - [Setup Instructions](#setup-instructions)
    - [Versions](#versions)
    - [Requirements](#requirements)
    - [Execution](#execution)
  - [Activities](#activities)
    - [Activity 1](#activity-1)
    - [Activity 2](#activity-2)
    - [Activity 3](#activity-3)
    - [Activity 4](#activity-4)
    - [Activity 5](#activity-5)
    - [Activity 6](#activity-6)
  - [Contact](#contact)


## Authors

- Juan Felipe Restrepo Buitrago

## Introduction

This folder contains the project in which the first workshop of the Special Topics in Software Engineering Course is developed. This project is a Spring Boot application that uses Thymeleaf as a template engine to render views. The application is a CRUD for offers, which are stored in a MySQL database. The selected class to represent the offers is the `Offer` class, which is a class for our first project in the course and with this first approach I will have to implement just the primitive attributes, not relations or anything like that. Offer class:

```java
class Offer{
 - created_at: Date
 - user: User
 - auction: Auction
 - offer_price: int
 - state: boolean
 
 + create_offer(user: User, auction: Auction, offer_price: int): void
 + delete_offer(): void
 + setters()
 + getters() 
}
```

## Project Structure

```bash
. \
├── .mvn \
│ ├── wrapper \
│ │ └── maven-wrapper.properties # Maven wrapper properties. \
├── evidence # Folder with all the evidence images \
├── src \
│ ├── main \
│ │ ├── java \
│ │ │ ├── com \
│ │ │ │ ├── eafit \
│ │ │ │ │ ├── workshop1 \
│ │ │ │ │ │ ├── controllers \
│ │ │ │ │ │ │ ├── HomeController.java # Home controller. \
│ │ │ │ │ │ │ └── ProductController.java # Products controller. \
│ │ │ │ │ │ ├── dto \
│ │ │ │ │ │ │ └── OfferForm.java # Offer Form Model. \
│ │ │ │ │ │ ├── models \
│ │ │ │ │ │ │ └── Offer.java # Offer model. \
│ │ │ │ │ │ ├── repositories \
│ │ │ │ │ │ │ └── OfferRepository.java # Offers repository. \
│ │ │ │ │ │ ├── services \
│ │ │ │ │ │ │ └── OfferService.java # Offer service. \
│ │ │ │ │ │ └── Workshop1Application.java # Application main class. \
│ │ ├── resources \
│ │ │ ├── static \
│ │ │ │ ├── css \
│ │ │ │ │ └── app.css # CSS file. \
│ │ │ ├── templates \
│ │ │ │ ├── fragments \
│ │ │ │ │ ├── footer.html # Footer fragment. \
│ │ │ │ │ ├── head.html # Head fragment. \
│ │ │ │ │ └── header.html # Header fragment. \
│ │ │ │ ├── home \
│ │ │ │ │ └── index.html # Home page. \
│ │ │ │ ├── offers \
│ │ │ │ │ ├── create.html # Create offer page. \
│ │ │ │ │ ├── index.html # Offers list page. \
│ │ │ │ │ └── offer.html # Offer details page. \
│ │ │ └── application.properties # Application properties. \
│ ├── test \
│ │ ├── java \
│ │ │ ├── com \
│ │ │ │ ├── eafit \
│ │ │ │ │ ├── workshop1 \
│ │ │ │ │ │ ├── services \
│ │ │ │ │ │ │ └── OfferServiceTest.java # Offer service test. \
│ │ │ │ │ │ └── Workshop1ApplicationTests.java # Application tests. \
├── docker-compose.yaml # Docker compose file. \
├── .gitignore # Git ignore file. \
├── HELP.md # Help file. \
├── mvnw # Maven wrapper. \
├── mvnw.cmd # Maven wrapper. \
├── pom.xml # Maven dependencies. \
└── README.md # Readme file. \
```

## Setup Instructions

### Versions

This were the versions used to develop the project:

- Java 21
- Maven 3.9.9 (Optional)
- Spring Boot 3.4.2 (Optional)

### Requirements

To run this project you will need mysql running on your machine in the `localhost:3306` with a database named `workshop1_teis` and a user with the following credentials: `username: root` and `password: 123`.

You can run mysql and phpmyadmin with the following `docker-compose.yaml` file in the project root:

```bash
version: '3.8'

services:
  mysql:
    image: mysql:8.4.0
    container_name: mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: 123
    ports:
      - "3306:3306"
    networks:
      - mysql_network

  phpmyadmin:
    image: phpmyadmin/phpmyadmin:latest
    container_name: phpmyadmin-container
    restart: always
    environment:
      PMA_HOST: mysql
      PMA_PORT: 3306
    ports:
      - "8081:80"
    networks:
      - mysql_network

volumes:
  mysql_instance_data:

networks:
  mysql_network:
    driver: bridge
```

1. Go to the workshop1 folder:
```bash
cd $PROJECT_PATH/workshops/workshop1
```
2. Run the docker compose file:
```bash
docker-compose up
```
3. Open your browser and go to http://localhost:8081
4. Log in with the following credentials:
```bash
username: root
password: 123
```
If fails, try to log in again after a few seconds.
5. Create a new database named `workshop1_teis`
6. Once you have finished running the project, you can stop the containers by running in the workshop1 folder:
```bash
docker-compose down
```

### Execution

To run follow these steps:

1. Clone the repository (If you already have the project, skip this step):

SSH
```bash
git clone git@github.com:JuanFelipeRestrepoBuitrago/Software-Topics.git
```
or HTTP

```bash
git clone https://github.com/JuanFelipeRestrepoBuitrago/Software-Topics.git
```

2. Go to the workshop1 folder:

```bash
cd $PROJECT_PATH/workshops/workshop1
```

3. (Optional) To avoid dependency problems, run the following command:

```bash
mvn clean install
```
or in case you don't have maven installed:

```bash
./mvnw clean install
```

4. Run the project:

```bash
mvn spring-boot:run
```
or in case you don't have maven installed:

```bash
./mvnw spring-boot:run
```

5. Open the browser and go to http://localhost:8080/

## Activities
 
### Activity 1

Display an initial view with 2 buttons/links leading to activities 2 and 4.

#### Answer

The initial view is displayed in the home page. The view contains two buttons that lead to the `/offers` and `/offers/create` routes.

![Home Page](evidence/Activity%201.png)

### Activity 2

Display a form to the user that receives all the data required for the creation of the class. Forget about including data corresponding to non-primitive attributes (representing relationships). Omit for this workshop any connection with other classes in your class diagram. Focus only on the chosen class and its primitive attributes.

#### Answer

The form to create an offer is displayed in the `/offers/create` route. The form contains the following fields:
- Offer price
- Auction

The other fields are set by default or internally in the application.

![Create Offer](evidence/Activity%202.png)

### Activity 3
The above form should lead to another path where the information from the previous form is collected and the data is stored in the database (validate the information received). In case of success, display a message saying “Element created successfully”.

#### Answer

When the form is submitted, the data is stored in the database and a message is displayed saying "Your offer has been created successfully!".

![Offer Created](evidence/Activity%203.png)

### Activity 4

List the objects of the class with only 2 attributes, their id and their name or another attribute that helps to easily identify each object, and place a link to the id of each object that leads to activity 5.

#### Answer

The list of offers is displayed in the `/offers` route. The list contains the id and the auction of each offer. 

![Offers List](evidence/Activity%204.png)
![Offers List with New Object](evidence/Activity%204_add.png)

### Activity 5

Display the complete information (all values of all attributes) of the object clicked in activity 4, also create a button leading to activity 6.

#### Answer

The complete information of the object clicked in activity 4 is displayed in the `/offers/{id}` route. The view contains all the attributes of the offer.

![Offer Details](evidence/Activity%205.png)

### Activity 6

Delete the object clicked in activity 5 and redirect to the list objects section.

#### Answer

When the delete button is clicked in the offer details view, the offer is deleted from the database and the user is redirected to the offers list view.

![Offer Deleted](evidence/Activity%206.png)

## Contact

For any questions or issues, feel free to reach out to:
- Juan Felipe Restrepo Buitrago: [jfrestrepb@eafit.edu.co](jfrestrepb@eafit.edu.co)