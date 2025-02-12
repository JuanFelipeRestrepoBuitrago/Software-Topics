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
    - [Activity 5](#activity-5)
    - [Activity 6](#activity-6)
    - [Activity 7](#activity-7)
    - [Activity 8](#activity-8)
    - [Activity 9](#activity-9)
    - [Activity 10](#activity-10)
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
│ │ │ │ │ │ │ ├── ProductForm.java # Product form. \
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
│ │ │ │ │ ├── contact.html # Contact page. \
│ │ │ │ │ ├── about.html # About page. \
│ │ │ │ │ └── index.html # Home page. \
│ │ │ │ ├── product \
│ │ │ │ │ ├── create.html # Create product page. \
│ │ │ │ │ ├── confirmation.html # Confirmation page. \
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

#### Answer

![Contact Page](./evidence/activity%202.png)

### Activity 3

Add the (“/products”) route as a new menu option (in the header navbar).

#### Answer

![Products Page](./evidence/activity%203.png)

### Activity 4

Add prices for each product and display the information in the product.show view.

#### Answer

![Product Page](./evidence/activity%204.png)

### Activity 5

Modify the show method. If the product number entered by the URL is not valid, redirect the user to the home page (“home.index”) route.

#### Answer

The code for this activity is in the ProductController.java file. The show method was modified to check if the product exists. If it doesn't exist, the user is redirected to the home page.

```java
int productId = Integer.parseInt(id) - 1;
if (productId < 0 || productId >= products.size()) {
  return "redirect:/";
}
```

## Activity 6

Add a conditional in the “product.show” view. If the price of a product is greater than 100, display the product name in red

#### Answer

The code for this activity is in the show.html file. A conditional was added to check if the price of the product is greater than 100. If it is, the product name is displayed in red.

```html

<h5 class="card-title" th:text="${product.name}" th:classappend="${product.price > 100 ? 'text-danger' : ''}"></h5>
```

![Product Page](./evidence/activity%206.png)

### Activity 7

Try to understand the previous code. Add a new product but leave the name empty (and click send). Then, leave the price empty. Then, enter the two fields.

### Answer

The code for this activity is in the ProductForm.java file. The ProductForm class is used to validate the product form. The name and price fields are annotated with the @NotEmpty and @NotNull annotations, respectively. This way, the form will not be submitted if the fields are empty. Furthermore, I searched for the difference between the @NotEmpty and @NotNull annotations. The @NotEmpty annotation checks if the field is not null and not empty. The @NotNull annotation checks if the field is not null. So the @NotEmpty annotation is more restrictive than the @NotNull annotation, because if a string is '' or length 0, the @NotEmpty annotation will return false, while the @NotNull annotation will return true.

```java
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
```

![Product Page Name Empty](./evidence/activity%207%201.png)
![Product Page Price Empty](./evidence/activity%207%202.png)
![Product Page Name and Price Empty](./evidence/activity%207%203.png)

## Activity 8

Modify the previous code to only allow numbers greater than zero for the prices.

### Answer

The code for this activity is in the ProductForm.java file. The price field is annotated with the @Min annotation. This way, the form will not be submitted if the price is less than or equal to zero.

```java
import jakarta.validation.constraints.Min;
```

![Product Page Price Less Than Zero](./evidence/activity%208.png)

## Activity 9

If the info entered by the form is valid. Then display a message saying, “Product created”. Note: create a new view (which uses the layout system).

### Answer

The code for this activity is in the ProductController.java file. The save method was modified and when there is no error and a product is created, the confirmation view is redirected.

```java
products.add(product);

return "redirect:/products/confirmation";
```
![Product Page Confirmation](./evidence/activity%209.png)

## Activity 10

Add a new menu option in the header (app layout), that links to the “/products/create” page.

### Answer

The code for this activity is in the header.html file. A new menu option was added to the header that links to the /products/create page.

```html
<a class="nav-link active" th:href="@{/products/create}">Create Products</a>
```

![Product Page Create](./evidence/activity%2010.png)

## Contact

For any questions or issues, feel free to reach out to:
- Juan Felipe Restrepo Buitrago: [jfrestrepb@eafit.edu.co](jfrestrepb@eafit.edu.co)