# Hackathon Test
Project for "Saló de l'ocupació Hackathon, October 2024".

## Description

This project is a basic api developed with Spring Boot, that manage users and activities.

## Features

- Import and Export Activities lists in JSON
- CRUD operations for users and activities.
- Integration with MySQL database.

## Prerequisites

- Java 17 or higher.
- Maven.
- MySQL.

## Usage
### Endpoints
- POST /activityApp/user: Create new user.
- PUT /activityApp/user/{id}: Update user.
- DELETE /activityApp/user/{id}: Delete user.
- GET /activityApp/user/{id}: Get user.
- PUT /activityApp/user/signup/{idUser}/{idActivity}: Sign un a user to an activity
- POST /activityApp/activity: Create new activity
- PUT /activityApp/activity/{id}: Update activity
- DELETE /activityApp/activity/{id}: Delete activity
- GET /activityApp/activity/export: Get all activities in JSON format
- POST /activityApp/activity/import: Save activities from JSON


## Contact
David Carcelen - davidcarcelengenova@gmail.com

Project Link: https://github.com/DavidCarcelen/Test/tree/main/hackathonTest
