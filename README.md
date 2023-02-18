# GroupCapstone

We created a back of office application for a manager of a Music Store that sells instruments and also offers lessons to their patrons.

The application allows the user to add a new patron, add a new instructor, and add inventory. Once our database is populated then you can create a new lesson which will be displayed on the main home page. By keeping everything on one page we improve the user experience and make sure that everything they need is visible right there.


![lessoncards](src/main/resources/static/img/lessoncards.png "lessoncards")

**CONTENTS**

- [Tech Stack](#tech-stack)
- [Features](#features)
- [Future Features](#future-features)
- [Installation](#installation)
- [About the Developers](#about-the-developers)

## Tech Stack

**Backend:** Java 7, Spring Boot\
**Frontend:** JavaScript, HTML5, CSS3, Bootstrap\
**Database:** PostgreSQL

## Features

![homepage](src/main/resources/static/img/homepage.png "homepage")

#### ADD PATRON

Users can create a new patron and save them to the database.

#### ADD INSTRUCTOR

Users can create a new instructor and save them to the database. 

#### ADD INSTRUMENT

Users can create a new instrument or update inventory and save it to the database.

#### ADD LESSON

Users can create a new lesson using drop down menus populated by the database and save each lesson in the database.

#### CREATE LESSON CARDS

Once a user creates a new lesson, the lesson will automatically be displayed on the home page listed in calendar order.

#### DELETE LESSON

Once a lesson has been completed or the lesson is cancelled, the user can delete the lesson from the homepage and database.


## Future Features

- Displaying all inventory
- Emailing patron and instructor when lesson has been created


## Installation

#### Requirements:

- Java 7.0
- Spring Boot

To have this app running on your local computer, please follow the below steps:

Clone repository:

```
$ git clone https://github.com/ckyle121/GroupCapstone.git
```

Create new backend server:

Create a free database server with AWS


Update application properties file:

Get URI from AWS


Run the file in IntelliJ (or your IDE of choice)


Navigate to `localhost:8080/home.html`


## About the Developers

Jessica Faylor is a software engineer in California, and previously worked in various fields, including finance, accounting and administration. A combination of her love for family time, learning new things, and less screaming children, led to the creation of FamTrip, her capstone project for Walmart's Java Fellowship program.

Connect with Jessica: 

<p><a href="https://www.linkedin.com/in/jessica-faylor-0377b35/">
  <img
    alt="LinkedIn"
    src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white"
  />
</a>
</p>

Caroline Kyle lives in Bentonville, AR. With nearly two years of expereince developing user friendly applications, Caroline also has experience in teaching software engineering courses in Java and JavaScript and mentoring junior engineers. Caroline is committed to continuously improving her skills as an engineer to make valuable contributions to both the tech community and future generations of engineers. In addition to software development, Caroline enjoys riding her bike and spending time with her cat, Rhino.

Connect with Caroline: 
<p><a href="https://www.linkedin.com/in/ckyle121">
  <img
    alt="LinkedIn"
    src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white"
  />
</a>
</p>

