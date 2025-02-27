# Tutorial 09 B: Dependency Injection with Spring Boot

## Content Table
- [Tutorial 09 B: Dependency Injection with Spring Boot](#tutorial-09-b-dependency-injection-with-spring-boot)
  - [Content Table](#content-table)
  - [Authors](#authors)
  - [Introduction](#introduction)
  - [Project Structure](#project-structure)
  - [Setup Instructions](#setup-instructions)
    - [Versions](#versions)
    - [Execution](#execution)
  - [Contact](#contact)


## Authors

- Juan Felipe Restrepo Buitrago

## Introduction

This folder contains the project in which the 09 A tutorial of the Special Topics in Software Engineering Course is developed. This tutorial is about Dependency Injection with Spring Boot. The project is a simple web application that allows the user to upload images and show them in the browser. The project is developed using Spring Boot, Thymeleaf, and Bootstrap. The project has the following functionalities:

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
│ │ │ │ │ ├── tutorial09b \
│ │ │ │ │ │ ├── config \
│ │ │ │ │ │ │ ├── ImageServiceProvider.java # Image service provider. \
│ │ │ │ │ │ │ └── StaticResourceConfiguration.java # Static resource configuration. \
│ │ │ │ │ │ ├── controllers \
│ │ │ │ │ │ │ ├── ImageController.java # Image controller. \
│ │ │ │ │ │ │ └── ImageNotDIController.java # Image not DI controller. \
│ │ │ │ │ │ ├── interfaces \
│ │ │ │ │ │ │ └── ImageStorage.java # Image storage interface. \
│ │ │ │ │ │ ├── utils \
│ │ │ │ │ │ │ └── ImageLocalStorage.java # Image local storage. \
│ │ │ │ │ │ └── Tutorial09bApplication.java # Application main class. \
│ │ ├── resources \
│ │ │ ├── static \
│ │ │ │ ├── css \
│ │ │ │ │ └── app.css # CSS file. \
│ │ │ ├── templates \
│ │ │ │ ├── fragments \
│ │ │ │ │ ├── footer.html # Footer fragment. \
│ │ │ │ │ ├── head.html # head fragment. \
│ │ │ │ │ └── header.html # Header fragment. \
│ │ │ │ ├── image \
│ │ │ │ │ └── index.html # Image with DI page. \
│ │ │ │ ├── imagenotdi \
│ │ │ │ │ └── index.html # Image without DI page. \
│ │ │ └── application.properties # Application properties. \
│ ├── test \
│ │ ├── java \
│ │ │ ├── com \
│ │ │ │ ├── eafit \
│ │ │ │ │ ├── tutorial09b \
│ │ │ │ │ │ └── Tutorial09bApplicationTests.java # Application tests. \
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
cd $PROJECT_PATH/tutorials/tutorial09b
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

5. Open the browser and go to http://localhost:8080/image to see the image with DI page or http://localhost:8080/image-not-di to see the image without DI page.

## Activities
 
### Tutorial Evidence

The evidence of the tutorial can be found in the `evidence` folder. I completed all the tutorial and the following evidence is presented as proof:

![Evidence 1](evidence/evidence_1.png)

## Contact

For any questions or issues, feel free to reach out to:
- Juan Felipe Restrepo Buitrago: [jfrestrepb@eafit.edu.co](jfrestrepb@eafit.edu.co)