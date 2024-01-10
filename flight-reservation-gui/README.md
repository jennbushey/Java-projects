# Flight Reservation GUI

[![Java](https://img.shields.io/badge/language-Java-orange.svg)](https://www.java.com/)
[![Java Swing](https://img.shields.io/badge/library-Java%20Swing-yellow.svg)](https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html)
[![MySQL](https://img.shields.io/badge/database-MySQL-blue.svg)](https://www.mysql.com/)

A team project to practice a complete process of design and development of a software project, using a systematic design methodology.

## Requirements

In this project your task is to analyze, design, and develop a web-based system that can be used by different type of users, tourism agents, airline agents, and system admin(s).

Some of the major requirements of the system for users and airline agents is to be able to:

1. Browse the available flights to a specific destination.
2. Select their desired flight.
3. Browse the seat map graphically.
4. Select their desired seat (regular, or business-class)
5. Select the desired ticket cancellation insurance, if interested.
6. Make payment, using a credit card.
7. Receive ticket via email.
8. Receive receipt for their payments via email.
9. Cancel their flight.

Airline agents and flight attendants should be able to:

1. Browse the list passengers in a flight.

System admins should be able to manage flight information and other information on the database. For example:

1. Browse the list fights, their origin and destination in a specific date.
1. Browse the list crews in a specific flight (for example flight number AB123 to New
   York).
1. Browse the list Aircrafts that company owns
1. Add/remove a crew.
1. Add/remove an aircraft.
1. Add/remove flight destinations.
1. Add/remove/modify flights information.
1. Print list of users who have registered with the airline company. For more details see the
   additional information, below.

The application should be considered a single airline company. Aircrafts in this company,
have options of different type of seats: Ordinary, Comfort, and Business-Class. The price
of different seats can be managed by the company, to give you a rough idea, comfort seat
is almost 40% more than ordinary seats, and business class seat is more than double.

Some users called “registered users”, can register for the membership, and apply for
company’s credit card, and take advantages such as:

-   Receiving monthly promotion news (first day of each month)
-   Use airport lounges with a discount price.
-   Receive a free companion ticket once a year.
-   Etc.

Note: the registered users information: name, address, etc. will be saved on the
company’s database.

## Design Document

Our [design document](https://github.com/jennbushey/Java-projects/blob/main/flight-reservation-gui/Design%20Document.pdf) includes the following:

### Part One – System Analysis:

1. System’s description
2. System’s Use-case diagram
3. System’s Scenarios for each Use-Case, having all candidate objects underlined.
4. System’s Conceptual Model

### Part Two – Domain Diagrams:

1. Highlights of the system’s architecture.
1. Updated use case diagram
1. Systems activity diagram
1. Sequence diagram for at least four or five use cases (one per each member of the group)
1. State transition diagram for at least four or five GUI objects or domain objects such as
   ticket, payment, (one per each member of the group)
1. System’s Domain class diagram: without attributes and functionalities (only relationships
   and multiplicities). In one page
1. System’s Domain class diagram: with attributes, functionalities, and
   relationships/multiplicities. Can be in multiple pages. Please try to keep them well
   organized, clear, and easy to read. Marks will be deducted for disorganized of difficult to
   read diagrams of texts.

Important Notes about Domain class diagram:

-   You class diagram should be traceable in your use-case scenarios. Mark will be
    deducted for class that are not traceable in the use-case diagram.
-   In your class diagram you don’t need to show Java library classes such as Exceptions,
    Buttons, String, ArrayList, etc.
-   Make sure the multiplicity/cardinality is properly indicated.
-   You don’t need to show constructor/destructor, getters/setters.
-   In this stage you need to apply all possible design strategies and techniques to make the architecture of the system more: reusable, scalable, maintainable, reliable, and using necessary concepts such as modular design, inheritance, realization, aggregation, composition, polymorphism, and appropriate design patterns as needed. A minimum of 2 design patterns must be implemented.

### Part Three – System’s Detailed Design-Class Diagram:

In this section you need provide the final detailed design class diagram that includes:

1. Domain classes
1. Boundary classes
1. Controller classes

### Part Four – High-Level System’s Architecture:

1. A Package Diagram
1. A Deployment Diagram

## Notes

-   Given the time constraints associated with the project, the GUI may not fully reflect an optimal level of aesthetic refinement.
-   Diagrams were created using a combination of [draw.io](https://app.diagrams.net) and Unified Modeling Language (UML)
-   Database must be created in MySQL prior to running the java code. GUI requires you to input your root username and password.
-   program sent emails using The JavaMailTM API. Email and password have been removed for security purposes.
