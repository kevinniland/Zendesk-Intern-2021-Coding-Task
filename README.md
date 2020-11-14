# Zendesk Intern 2021 Coding Task 
__Developer:__ Kevin Niland

---

## Overview
_Zendesk Ticket Viewer. Zendesk 2021 intern coding challenge that uses the Zendesk API to allow users to view tickets associated with their Zendesk account._

---

## Project Statement
_Zendesk is a customer service tool that allows the creation and management of support tickets. Your company needs you to build a Ticket Viewer that will:_
*	_Connect to the Zendesk API_
* _Request all the tickets for your account_
*	_Display them in a list_
*	_Display individual ticket details_
* _Page through tickets when more than 25 are returned_

---

## Introduction
This section provides an introduction to the repository, code, and the system requirements.
 
### Repository
This repository contains the following directories and files:
* [src/zendesk/intern](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/tree/main/src/zendesk/intern) - Contains the source code for the application.
* [images](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/tree/main/images) - Contains images used to help aid in the explanation of certain parts of the application and the accompanying code.
<br>
A short screencast of the application being demoed is available [here]().
<br>

### Requirements
* Java 1.8+
* JUnit 5
* java-json.jar - Download [here](http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm)

---

## Running the program
This section details how to download, compile, and run the code contained in this repository.

### How to run
* Download the project or clone the repository using `git clone https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task`.
* Once downloaded/cloned, either open the project folder in your preferred IDE or run the JAR (included) using: `java -jar zendesk.jar`.
   * If running the project within an IDE, please ensure you include the __java-json.jar__ in your build path.
* The user will first be prompted for their subdomain, email, and password.
* Once successfully logged in, the user will be presented with a menu. They have the option of viewing all tickets and viewing a ticket by specifying its ID.
   1. To view all tickets, choose option 1. This will display a max of 25 tickets. The user can then 'page' through the remaining tickets or exit to the main menu.
   2. To view a single ticket, choose option 2. The user will be prompted for a ticket ID. If a ticket with this ID exists, the ticker will be displayed.
   3. To exit the application, choose option -1.

---

## Project Requirements: Discussed
The coding challenge set to us had the following requirements:
* Connect to the Zendesk API
* Request all the tickets for your account
* Display them in a list
* Display individual ticket details
* Page through tickets when more than 25 are returned

This section will give a brief description of how I accomplished each of the above tasks.

### Connect to the Zendesk API
To connect to the Zendesk API, I used the [java.net](https://docs.oracle.com/javase/7/docs/api/java/net/package-summary.html) library, specifically the HttpURLConnection and URL classes. I first specified the URL I needed to connect to. Since I wanted to make this application usable by anyone, I allowed the user to specifiy their subdomain and passed that in, as that is the only part of the URL that differs for viewing tickets associated with an account. Next, using the email and password the user entered, I encoded them using Base64, which would then allow the user to connect to the API. I next needed to check the HTTP status code returned. I created an enum class that has a range of possible HTTP status codes. Using this, I then created a util class for defining the ranges of a successful response, client-side error response, server-side error response, or an unknown response. I could then perform a switch on the response code, which would then notify the user if they have successfully logged in and connected to the API, or if there was an error. 
![login](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/blob/main/images/login_code.PNG)

### Request all the tickets for your account
Following on from the previous section, if the user has successfully connected to the API, the InputStream is passed to the ParserImpl class. Here, the InputStream is parsed and tickets are saved. Each ticket is then converted to a ticket object.
![parse](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/blob/main/images/parse_code.PNG)
![save_tickets](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/blob/main/images/saveTickets_code.PNG)
![convert_to_obj](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/blob/main/images/convertObj_code.PNG)

### Display them in a list/Page through tickets when more than 25 are returned
To display all tickets in a list, I first check if the ticketsList (containing all tickets retrieved from the user's account) is less than 25. This means there is no need to execute the pagination code. Else, while a `counter` is less than the size of the tickets list and `input` (set by the user) is 1, display the current page of tickets. `counter` is used to keep track of the number of tickets displayed. If the size of the tickets list minus the counter is 0, this means there is no more tickets to display/user is on the last page of tickets.
![display_ticket](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/blob/main/images/display.PNG)
![display_all](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/blob/main/images/displayAll_code.PNG)

### Display individual ticket details
To display a single ticket, I simply pass in the tickets map and the ticket ID entered by the user. If the tickets map contains the ticket ID, display this ticket.

![display_one](https://github.com/kevinniland/Zendesk-Intern-2021-Coding-Task/blob/main/images/displaySingle_code.PNG)
