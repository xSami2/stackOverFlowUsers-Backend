# Description 

This application enables users to interact with StackOverflow (SOF) data by fetching, viewing, and storing a list of SOF users. Users can view details such as name, userId, reputation, and last access date. Additionally, users can bookmark and unbookmark their favorite SOF users, view only bookmarked users, and manage their bookmark list. Users can also export data stored in a custom .sofusers file format

# Architecture.

The application is divided into two main components:


> Backend : 
 - SpringBoot
 - OpenFegin
 - Hibernate
 - H2 Database
 - Lombok
 - Spring Web
> Frontend
- SpringBoot
- JavaFX
 - OpenFegin

# Database Schema

![image](https://github.com/user-attachments/assets/1df8e961-5f11-4d9e-ba49-97b6165d179a)



# Personal reasoning why choosing a third-party library.
1. OpenFegin
     -  Simplifies sending HTTP requests to the SOF API.
      - Enhances code readability.
      - Provides easy serialization of API responses into Java objects.
2. Hibernate
     - Database ORM
3. H2 Database
     - in-memory Database
    - Offers an in-memory database for easier and faster development. 
4. Lombok 
    - Reduces boilerplate code and improves code readability.

5. Spring Web
   - Development of RESTful APIs.

6. Java FX
   - Developing User Interface
   - Intgerted with SecenBuilider to Drag and Drop UI elements 
     
      



    



 
 


## Installation

Pleses Git clone theses two Project 


```git
git clone https://github.com/xSami2/stackOverFlowUsers-Backend

git clone https://github.com/xSami2/stackOverFlowUsers-Frontend
```

## Running the Application


__1__ - Open both the backend and frontend projects in your IDE at the Same time.

__2__ - Download the required Maven dependencies for both projects.

__3__ - Run the backend application first.

__4__ - After the backend is running, start the frontend application.



# Test Cases

__Test Case 1: Fetch SOF Users__

Input: Run the Application to fetch users.
Expected Result: The application displays a list of users with fields: name, userId, reputation, lastAccessDate.

__Test Case 2: Save Users to File__

Input: Save the fetched users to a .sofusers file.
Expected Result: The file is created and contains the user data in the correct format.

__Test Case 3: Sort Users Ascending__

Input: Sort users by userId in ascending order.
Expected Result: The users are displayed in ascending order by userId.

__Test Case 4: Sort Users Descending__

Input: Sort users by userId in descending order.
Expected Result: The users are displayed in descending order by userId.

__Test Case 5: Sort Users Normal__

Input: Export users with normal order.
Expected Result: The users are displayed in normal order.

__Test Case 6: Bookmark a User__

Input: Bookmark a user.
Expected Result: The user is added to the bookmark list.

__Test Case 7: Unbookmark a User__

Input: Unbookmark a user.
Expected Result: The user is removed from the bookmark list.

__Test Case 8: Save Bookmarked Users to File__

Input: Save bookmarked users to a .sofusers file.
Expected Result: The file is created and contains the bookmarked users.

__Test Case 9: Fetch Bookmarked Users__
Input: Click Checkbox to fetch bookmarked users.
Expected Result: Only bookmarked users are displayed.

__Test Case 10: View User Details__
Input: Select a user to view details.
Expected Result: The detailed information of the selected user is displayed, same as the __.sofusers file__ .

# Note

the __.sofusers__ file will be Saved in the Backend Application in resource folder
