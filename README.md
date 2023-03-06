# Springboot Application
## Capstone-Project
 BookStore is a simple web application where a user can store and retrieve books information. The admin can add new books and see all users

### Technologies
* SpringBoot
* Maven
* Java Corretto 17
* Spring JPA
* MySQL
* Spring Security
* Thymeleaf
* Lombok
* BootStrap
* HTML
* CSS



### Business Requirement
To create a basic personal library web application where users can sign up and store, retrieve and view their books and the price for the book. and Admin can add new books to the store.

### Work-Flow
Website with links to each service

* homepage
* registration
* available books 
* my book list
* book edit
* see users


### models requires:
* no args constructor
* all args constructor
* required args constructor
* setters and getter
* toString (exclude collections to avoid infinite loops)
* override equals and hashcode methods (don't use lombok here)
* helper methods


@Table(name="MyBook")

| Field | Type    | Description                  |
|-------|---------|------------------------------|
| id    | int     | The unique identifier for the book |
| name  | varchar | The name of the book          |
| author| varchar | The author of the book        |
| price | varchar | The price of the book         |

@Table(name="book")

| Field  | Type    | Description                |
|--------|---------|----------------------------|
| id     | int     | The unique identifier for the book |
| name   | varchar | The name of the book        |
| author | varchar | The author of the book      |
| price  | varchar | The price of the book       |

@Table(name="user_role")

| Field         | Type                 | Description                                   |
|---------------|----------------------|-----------------------------------------------|
| name          | String               | The name of the role                          |
| authority     | String               | The authority of the role (e.g., ROLE_ADMIN)  |


@Table(name="user_table")

| Field            | Type           | Description                           |
|------------------|----------------|----------------------------------------|
| id               | Long           | The unique identifier for the user     |
| firstName        | String         | The first name of the user             |
| lastName         | String         | The last name of the user              |
| email            | String         | The email address of the user           |
| password         | String         | The password of the user               |
| roles            | Collection<Role> | The roles assigned to the user          |



## Reguirment 2 - service layer

* BookServices
* MyBookListServices
* UserService


## Requirement 3 - Controllers

* MainController mapping for services
* MyBookController mapping for services
* UsersController mapping for services
* UsersRegistrationController mapping for services


## Requirment 4 

* view using Thymeleaf
* build a template using thymeleaf fragments

