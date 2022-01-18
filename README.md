# Welcome to simple cinema service application!
![drawing](https://images.unsplash.com/photo-1627133805103-ce2d34ccdd37?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80)

## The goal of this project is:
* Create a Java application using Spring and Hibernate
* Simulate simple cinema-shop functionality

Basic implementation of a cinema service with such functions as authorization and authentication for user and so on.
To exchange data with client JSON format was used, to handle exceptions from controllers 
and pass an answer as JSON object also implemented global exception handler.

## Technologies that were used to create the service:
* Java 11
* MySQL
* Hibernate
* Spring (Core, WEB, Security)
* Apache Tomcat (to run app locally)
* Maven Checkstyle Plugin

## Overview
#### Project has multiple endpoints with user and admin access
POST: `/register` (to create a user) - ALL <br/>
POST: `/cinema-halls` (to create a cinema hall) - ADMIN <br/>
POST: `/movies` (to create a movie) - ADMIN <br/>
POST: `/movie-sessions` (to create a movie sessions) - ADMIN <br/>
POST: `/orders/complete` (to create an order for current user) - USER <br/>
PUT: `/movie-sessions/{id}` (to update a movie session) - ADMIN <br/>
PUT: `/shopping-carts/movie-sessions` (to add movie session to shopping cart) - USER <br/>
DELETE: `/movie-sessions/{id}` (to delete a movie session) - ADMIN <br/>
GET: `/orders` (to get order history for current user) - USER <br/>
GET: `/shopping-carts/by-user` (to get a shopping cart for current user) - USER <br/>
GET: `/cinema-halls ` (to get all cinema halls) - USER or ADMIN <br/>
GET: `/movies` (to get all movies) - USER or ADMIN <br/>
GET: `/movie-sessions/available` (to get all available movie by date) - USER or ADMIN <br/>
GET: `/users/by-email` (to find user by email) - ADMIN <br/>
#### Example how to add data into the application (using for example Postman)
{"email":"bob", "password":"qwerty", "repeatPassword":"qwerty"}  POST: /register <br/>
{"capacity":100, "description":"Old hall"}  POST: /cinema-halls <br/>
{"title":"Toy story", "description":"A funny cartoon"}  POST: /movies <br/>
{"movieId":1, "cinemaHallId":1, "showTime":"08.02.202 15:15"}  POST: /movie-sessions <br/>
{"movieId":1, "cinemaHallId":1, "showTime":"08.02.2022 15:15"}  PUT: /movie-sessions/{id} <br/>

/movie-sessions/available?movieId={id}&date=dd.MM.yyyy  GET <br/>
/shopping-carts/movie-sessions?movieSessionId=1  PUT <br/>
/users/by-email?email=your email  GET <br/>

## How to start taxi service locally:
1. Install and configure Apache Tomcat
2. Install and configure and create a schema in MySQL
3. Fork and clone this project
4. To connect to database in application you need change configuration information
    in the file from `/resources/db.properties` to the ones you specified when installing MySQL
5. Finally, you can start the application
6. After running the application you will be redirected to login page. You can use:
   * username `admin@i.ua` with password `admin123` to login as admin 
   * username `user@i.ua` with password `user1234` to login as user