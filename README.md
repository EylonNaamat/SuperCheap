# SuperCheap

## About The Project
In this project we wanted to create an application for assisting the users to find the suitable supermarket for them. 
We will do it by using features ike rating supermarkets, writing comments, uploading sales, and by finding the cheapest supermarkets, 
by comparing prices of a grocery shopping list between various supermarkets. </br>
Our goals are to offer a solution for dealing with the cost of living and the increasing inflation around the world, helping the users
to find the suitable supermarket for them, and helping the supermarket managers to promote their supermarkets.</br>
Our target audience is almost every person in the world that has a smartphone and wanting to improve his supermarket shopping experience,
and also supermarket managers who want to promote their supermarkets.</br>

## Things you can find in our app
1. Registering the application
2. Insert grocery list and getting a list of the supermarkets in a certain city, sorted by the most suitable supermarket for you (price and matching)
3. Getting information about a supermarket - comments and sales
4. Add your comment
5. For supermarket managers, a platform for managing a supermarket - adding/removing/updating items and adding/removing sales.
6. Updating information </br>

## Technicality
### Structure
We used 3-Tier architecture:
1. Presentation Tier
2. Business Logic Tier
3. Data Access Tier

#### Presentation Tier
We used Android Studio Java for this Tier. We referred every activity as a separate model and split every activity
into the software design pattern - MVC. </br>
The View is the activity and the xml, we passes the information from the user to the controller. The controller can send the information
either to the model for easy calculation or data inspecting, or send it to the Business Logic Tier to deal with more heavy
calculations (by sending API requests), to communicate with the Data Access Tier for Database usage
(the BL sends API requests to the DA). </br>

#### Business Logic Tier
We used FastApi Python for this Tier and containerized it in a docker. This Tier is responsible for all the logic of an activity.
It is also uses as a bridge between the PL Tier and the DA Tier.
It responsible to return the PL controller the information it requested, can do it by sending API requests to the DA Tier.
It runs FastApi Python application in the main page, and split into microservices such that every service match
a service in the DA Tier. </br>
Link for Business Logic Tier github - https://github.com/EylonNaamat/SuperCheapBL.git

#### Data Access Tier
We used FastApi Python for running the server and firebase as the database (run in a web). This Tier and containerized 
it in a docker. This Tier is responsible for connecting to the database (firebase), sending database queries and deliver the answer
to the BL Tier.
Link for Data Access Tier github - https://github.com/EylonNaamat/SuperCheapDA.git


## How to run
In order to run this project you need to:
1. Run the BL Docker
2. Run the DA Docker
3. Run the app in Android Studio

You can find instructions of how to run the dockers in the BL and DA github.







