## Validation. Exception handling. ORM.

###### This is a project with database hosted on heroku.

- Learned how to set up an environment typical of java spring boot backend development
  
- Developed a basic REST API for a web application deployment settings

- Determined ORM models for application

- Handled common exceptions during API invocation with bad requests

- Validated models

- Used remote mySQL database

- Used database flyway migrations

- Tested the REST API using postman and swagger

- [Deployed project here](https://shielded-river-50278.herokuapp.com/)

## All endpoints:

#### Categories:

`[POST] /categories`

`[GET] /categories`

`[GET] /categories/{categoryId}`

`[PUT] /categories/{categoryId}`

`[DELETE] /categories/{categoryId}`

#### Records:

`[POST] /records`

`[GET] /records`

`[GET] /records/{recordId}`

`[PUT] /records/{recordId}`

`[DELETE] /records/{recordId}`

#### Accounting (3 variant)

`[POST] /accounting`

`[GET] /accounting`

`[GET] /accounting/{accountingId}`

`[PATCH] /accounting/{accountingId}`

`[DELETE] /accounting/{accountingId}`

#### Users

`[POST] /users`

`[GET] /users`

`[GET] /users/{userId}`

`[UPDATE] /users/{userId}`

`[DELETE] /users/{userId}`

## To run project locally:

Required:
* Apache Maven 
* Java 11

`mvn package`

`java -jar target/demo-0.0.1-SNAPSHOT.jar`


