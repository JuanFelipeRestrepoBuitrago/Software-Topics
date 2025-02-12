# Tutorial 1: Spring Boot

## Content Table
- [Tutorial 1: Spring Boot](#tutorial-1-spring-boot)
  - [Content Table](#content-table)
  - [Authors](#authors)
  - [Introduction](#introduction)
  - [Project Structure](#project-structure)
  - [Setup Instructions](#setup-instructions)
    - [Versions](#versions)
    - [Execution](#execution)
  - [Activities](#activities)
    - [Activity 1](#activity-1)
    - [Activity 2](#activity-2)
    - [Activity 3](#activity-3)
    - [Activity 4](#activity-4)
  - [Contact](#contact)


## Authors

- Juan Felipe Restrepo Buitrago

## Introduction

This folder contains the project in which the first tutorial of the Special Topics in Software Engineering Course is developed. This tutorial is about the creation of a Spring Boot project. This is the first approach to the development of a web application using Spring Boot.

## Project Structure

. \
├── .mvn \
│ ├── wrapper \
│ │ └── maven-wrapper.properties # Maven wrapper properties. \
├── src \
│ ├── main \
│ │ ├── java \
│ │ │ ├── com \
│ │ │ │ ├── example \
│ │ │ │ │ ├── tutorial1 \
│ │ │ │ │ │ ├── controllers \
│ │ │ │ │ │ │ ├── HomeController.java # Home controller. \
│ │ │ │ │ │ │ └── ProductController.java # Product controller. \
│ │ ├── resources \
│ │ │ ├── static \
│ │ │ │ ├── css \
│ │ │ │ │ └── app.css # CSS file. \
│ │ │ ├── templates \
│ │ │ │ ├── fragments \
│ │ │ │ │ ├── footer.html # Footer fragment. \
│ │ │ │ │ └── header.html # Header fragment. \
│ │ │ │ ├── home \
│ │ │ │ │ ├── about.html # About page. \
│ │ │ │ │ └── index.html # Home page. \
│ │ │ │ ├── product \
│ │ │ │ │ ├── index.html # Products page. \
│ │ │ │ │ └── show.html # Product page. \
│ │ │ └── application.properties # Application properties. \
│ ├── test \
│ │ ├── java \
│ │ │ ├── com \
│ │ │ │ ├── example \
│ │ │ │ │ ├── tutorial1 \
│ │ │ │ │ │ └── Tutorial1ApplicationTests.java # Application tests. \
├── .gitignore # Git ignore file. \
├── HELP.md # Help file. \
├── mvnw # Maven wrapper. \
├── mvnw.cmd # Maven wrapper. \
├── pom.xml # Maven dependencies. \
└── README.md # Readme file. \

## Setup Instructions

### Versions

This were the versions used to develop the project:

- Java 21
- Maven 3.9.9 (Optional)
- Spring Boot 3.4.2 (Optional)

### Execution

To run follow these steps:

1. Clone the repository:

```bash
git clone git@github.com:JuanFelipeRestrepoBuitrago/Software-Topics.git
```
or

```bash
git clone https://github.com/JuanFelipeRestrepoBuitrago/Software-Topics.git
```

2. Go to the tutorial 1 folder:

```bash
cd $PROJECT_PATH/tutorials/tutorial1
```

3. Run the project:

```bash
mvn spring-boot:run
```
or in case you don't have maven installed:

```bash
./mvnw spring-boot:run
```

## Activities

### Activity 1

Take a look of the previous routes. Do you have any comment? We will discuss it the next class.

#### Answer

The routes are defined in the controllers. The HomeController has the routes for the home and about pages. Controllers help me to define the routes and the logic that will be executed when a request is made to that route. They will even define the view that will be rendered.

### Activity 2

Create a “/contact” section in which you display the application email, address, and phone number. Use fake information.

## Contact

For any questions or issues, feel free to reach out to:
- Juan Felipe Restrepo Buitrago: [jfrestrepb@eafit.edu.co](jfrestrepb@eafit.edu.co)