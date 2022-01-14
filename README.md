# Welcome to simple cinema service application!
![drawing](https://images.unsplash.com/photo-1627133805103-ce2d34ccdd37?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80)

## The goal of this project is:
* Creating Java-applications using Spring and Hibernate
* Simulate simple cinema-shop functionality

Basic implementation of a cinema service with such functions as authorization and authentication for user and so on. 
To exchange data with client were used JSON format, to handle exceptions from controllers 
and pass an answer as JSON object also implemented global exception handler.

## Technologies that were used to create the service:
* Java 11
* MySQL
* Hibernate
* Spring (WEB, Security, ORM)
* Apache Tomcat (to run app locally)
* Maven Checkstyle Plugin

## Overview
#### Project have multiple endpoints with user and admin access
POST: `/register` - ALL <br/>
POST: `/cinema-halls`, `/movies`, `/movie-sessions` - ADMIN <br/>
POST: `/orders/complete` - USER <br/>
PUT: `/movie-sessions/{id}` - ADMIN <br/>
PUT: `/shopping-carts/movie-sessions` - USER <br/>
DELETE: `/movie-sessions/{id}` - ADMIN <br/>
GET: `/orders` - USER <br/>
GET: `/shopping-carts/by-user` - USER <br/>
GET: `/cinema-halls `, `/movies`, `/movie-sessions/available`  - USER or ADMIN <br/>
GET: `/users/by-email` - ADMIN <br/>
#### Example how to add data into the application (using for example Postman)
{"email":"bob", "password":"qwerty", "repeatPassword":"qwerty"}  POST: /register <br/>
{"capacity":100, "description":"Old hall"}  POST: /cinema-halls <br/>
{"title":"Toy story", "description":"A funny cartoon"}  POST: /movies <br/>
{"movieId":1, "cinemaHallId":1, "showTime":"08.02.202 15:15"}  POST: /movie-sessions <br/>
{"movieId":1, "cinemaHallId":1, "showTime":"08.02.2022 15:15"}  PUT: /movie-sessions/{id} <br/>

/movie-sessions/available ?movieId={id}&date=dd.MM.yyyy  GET <br/>
/shopping-carts/movie-sessions?movieSessionId=1  PUT <br/>
/users/by-email?email=your email  GET <br/>

## How to start taxi service locally:
1. Install and configure Apache Tomcat
2. Install and configure MySQL
3. Fork and clone this project
4. To connect to database in application you need change configuration information
    in the file from `/resources/db.properties` to the ones you specified when installing MySQL
5. Finally, you can start the application
6. After running the application you will be redirected to login page. You can use:
   * username `admin@i.ua` with password `admin123` to login as admin 
   * username `user@i.ua` with password `user1234` to login as user