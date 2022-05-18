## README
![image](https://user-images.githubusercontent.com/73340081/169135978-096a5225-41e4-4e71-981e-3e3ce2d2e67c.png)


# Hotel_SWE
Abstract: This document describes the high-level requirements for the joint term project in the Software Engineering and Database courses. The software engineering component of the project consists in designing a web application that delivers role-based functionality and access. The database component consists in producing a database design that enables effective querying in a complex domain problem. To keep things uniform, we propose the topic which is hotel chain system management. Teams must implement the proposed projects.
# CSCI 361 General Requirements
• "Full stack" development meaning the implementation of both a browser based front-end and a Java server-side back-end
• The server-side component must be a Java enterprise/container application, meaning it should be deployable, as a war file, to a standard Java EE server such as Apache Tomcat, TomEE, Jetty, Glassfish, WebLogic, etc.
• The web application should interface to a relational database management system such as MySQL or PostgreSQL. An embedded database such as SQLite is not acceptable
• The web application should enable login and user profiles and take reasonable steps to main security and data integrity
• The application should make data available through both the web front-end and through a RESTful API
• The web front-end should also be (partially at least) dynamic, meaning that some information between the client and server should be sent through AJAX requests
# CSCI 341 General Requirements
You are developing a system for a hotel chain. This hotel chain has hotels all over the world.
Each individual hotel has a unique id, a name, an address and multiple phone numbers
Each hotel has its own set of room types: e.g., single, double. A room type has a size (in sq. meters), a capacity (max # of people). Room types are specific to a single hotel – even if 2 hotels have “single” rooms – those “single” rooms are different in each hotel (differ in size, view, furnishings, etc.)
Each individual room in a hotel has a room number, a floor (even if the floor is part of the room number, because people sometimes want or do not want a specific floor) and belongs to a single room type.
The hotel chain keeps track of guests. Each guest has a unique guest id, also an identification type and number (e.g. US passport & number or driving license & number), an address and a home phone number and a mobile phone number.
A guest may hold one or more reservations for specific room type(s) in a specific hotel from a check-in to check-out date. A guest may be currently occupying one or more specific rooms. A guest is the person who pays, but their family members or friends may be occupying the room(s) that are assigned to the one guest.
Assume the price of a room is not fixed, but instead it depends on the day of the week.
A bill should be able to be generated for a guest on the day that they check out of the hotel. The guest’s billing history should be saved in the database, so that advertising can be sent to guests based on how much money they have spent at a hotel, and the whole chain.
The hotel has employees who have EmployeeIDs along with other standard employee attributes. The manager can supervise all other employees of the hotel. The cleaning schedule is important – rooms should be cleaned daily while occupied and on the day that a new guest is supposed to arrive to stay in the room. When a guest arrives to check in, the desk clerk must be able to find out if the guest’s room is empty and has been cleaned, or a similar empty, clean room is available.
# Specific Requirements
In this section, we list specific requirements for each of the proposed projects. The requirements are written as user stories which Mike Cohn (https://www.mountaingoatsoftware.com/agile/user-stories) describes as "short, simple descriptions of a feature told from the perspective of the person who desires the new capability."
Note that this list of requirements is not exhaustive or fully detailed. In the course of the semester, we will develop the complete picture of the required functionality and behavior. The requirements will change and be updated to simulate real-world contingencies.
Hotel Chain System Management
In this project, teams will implement a system to manage operations for an international hotel chain.
• As a user, I want to access a home page that provides general information about the hotel chain, provides links to services offered by hotel web application, and give users the ability to log in
• As a guest, I want to query the system so that I can find available rooms (by date, destination, occupancy) and create a booking
• As a guest, I want to create a profile so that I can manage my past and upcoming bookings
• As a desk clerk, I want to cancel, create, and change, bookings so that I can fulfill guest requests
• As a manager, I want to review the schedules of all hotel employees so that I can make payroll and adjust hours
