# JavaFX and Database Management 

Author: Muhamed Husić

---

This repository contains a series of JavaFX and database management tutorials. Each tutorial is implemented in a separate branch, with some branches containing multiple tasks when one task is a prerequisite for another. Below is an overview of each tutorial and the corresponding branches where their implementations can be found.

#### **Note: Each tutorial is implemented in a separate branch**

# Tutorials Overview

## Tutorial 1
**Branch:** `lv1-z2`, `lv1-z3`
- **Zadatak 2:** 
  - **Description:** Create a project named "rpr-t1-z2" using IntelliJ IDEA. The program should print all numbers between 1 and `n` that are divisible by the sum of their digits. The value `n` is input from the keyboard. The program must include a function `sumaCifara`.
  - **Additional Requirements:** Convert the project to a Maven project and run it from Command Prompt.
- **Zadatak 3:** 
  - **Description:** Convert a C++ program to Java and create a project named "rpr-t1-z3". The C++ program features a `Sat` class with methods for setting time, incrementing/decrementing time, and displaying time.
  - **Additional Requirements:** Follow Java code organization and naming conventions, and push the task to GitHub.

## Getting Started

To view and work with the implementations of the tutorials, switch to the respective branch.

---

## Tutorial 2
**Branches:** `lv2-z1`, `lv2-z2`, `lv2-z3`
- **Zadatak 1:** 
  - **Description:** Create a Maven console application that calculates the sine and factorial of a given number. The application should accept input from the command line using the `args` parameter in the `main` function. A class for these calculations must be created.
  - **Branch:** `lv2-z1`
- **Zadatak 2:** 
  - **Description:** Create a program following the structure shown in the provided diagram, utilizing inheritance concepts. Discuss the task with the responsible assistant. The project should be of Maven type.
  - **Branch:** `lv2-z2`
- **Zadatak 3:** 
  - **Description:** Create a program that inputs numbers and stores them in a list. If "stop" is entered, the program stops. For any other word/letter, the input repeats. Otherwise, the program calculates min, max, mean, and standard deviation using the `java.util.List` class. The project should be of Maven type.
  - **Branch:** `lv2-z3`

## Getting Started

To view and work with the implementations of the tutorials, switch to the respective branch

---

## Tutorial 3: ETF Phone Directory

This project implements an ETF Phone Directory application as part of tutorials for RPR-Vjezbe.

**Branch:** `lv3`

### Task 1

The goal of this exercise is to create an application "ETF Phone Directory"...

### Task 2

Unit Tests:

- Includes a minimum of 3 JUnit tests.
- Tests include handling a custom exception type.

### Task 3

Mocking Test:

- Uses a Map with String keys and values.
- Implements a test involving a base and derived class structure, where the base class holds a private attribute of the derived class type, and tests a method from the derived class via the base class method.

---

## Tutorial 4: File Handling and Data Persistence for a Laptop Management 

This tutorial serves to teach me how to implement robust **file handling techniques, including serialization, JSON, and XML parsing** in Java, to enable persistent storage and retrieval of laptop data within a management system.

**Branch:** `lab4-z1` (both tasks are implemented in this branch)

### Prerequisite

To begin, create a Maven project named `lv4-z1` using Command Prompt. Within the `ba.unsa.etf.rpr` package, create the following:

#### Laptop Class

Create a `Laptop` class adhering to the JavaBeans specification, with attributes:
- brand (String)
- model (String)
- price (double)
- ram (int)
- hdd (int)
- ssd (int)
- processor (String)
- graphicsCard (String)
- screen size (double)

#### LaptopDao Interface

Define an interface `LaptopDao` with the following methods:
- `addLaptopToList(Laptop laptop)`
- `addLaptopToFile(Laptop laptop)`
- `getLaptop(String processor)`
- `populateList(ArrayList<Laptop> laptops)`
- `retrieveDataFromFile()`

## Task 1

Implement the following classes: `LaptopDaoSerializableFile`, `LaptopDaoJSONFile`, `LaptopDaoXMLFile`. Each class should implement the `LaptopDao` interface and have attributes: `file` (File) and `laptops` (ArrayList<Laptop>).

- `LaptopDaoSerializableFile`: Implements storing laptops in a .txt file using classes for binary file operations.
- `LaptopDaoJSONFile`: Stores laptops in a .json file using the ObjectMapper class.
- `LaptopDaoXMLFile`: Stores laptops in a .xml file using the XMLMapper class.

Ensure to add the appropriate dependencies in the `pom.xml` file for handling .json and .xml files. The method `addLaptopToFile(Laptop laptop)` should append the laptop parameter to the file without overwriting existing objects of type Laptop already present in the file upon program execution.

The method `getLaptop(String processor)` should return a Laptop object with the specified processor. If no such object exists, it should throw a `NoSuchProcessorException`.

The method `populateList(ArrayList<Laptop> laptops)` assigns the value to the laptops attribute.

The method `retrieveDataFromFile()` should return a list of Laptop objects read from the file.

Include a small test program for each of these file handling classes.

### Task 2

Write JUnit 5 tests for Task 1. Ensure to use Mocking at least once and provide a brief comment explaining the use of Mocking in that particular case.

### Note

- Ensure commits are atomic.
- Provide explanations for the use of Mocking in your comments.
- Push the exercise to GitHub upon completion.

---

## Tutorial 5: LMS - Learning Management System

### Summary
This tutorial serves to teach me how to implement inheritance and interfaces in Java to develop a Learning Management System (LMS). Key features include classes for personal information, student and teacher details, subjects, message collections, and grading functionalities. It also explores strategies for accommodating future extensions using flexible collection classes.

**Branches:** `lv5-z1`, `lv5-z2`, `lv5-z3`

**Zadatak 1:**
- **Description:** Implement classes for managing personal information, student and teacher details, and subjects. Use inheritance to structure classes efficiently. Create a Main class to demonstrate usage of these classes.
- **Additional Requirements:** Ensure JavaBeans specification compliance for all 

**Zadatak 2:**
- **Description:** Extend the project from Zadatak 1 to include grading functionality. Implement an interface for grading and create a class to store grades alongside subjects and teachers. Modify the Main class to allow input and display of grades.
- **Additional Requirements:** Use JUnit 5 for testing. Explain the use of mocking in your tests in comments.

**Zadatak 3:**
- **Description:** Implement additional utility classes for managing collections of names and integrating them with existing classes. Introduce methods to find the longest name and concatenate names and surnames. Modify the Main class to demonstrate usage of these new classes alongside existing ones.
- **Additional Requirements:** Ensure flexibility for future extension of collection classes.
---

## Tutorial 6: JavaFX Calculator

### Summary
This tutorial focuses on creating a JavaFX calculator application that meets specified functional requirements and passes existing and newly added tests. Key aspects include implementing property binding, CSS styling for layout, and ensuring responsiveness to window resizing.

**Branch:** `lv6-z1` (everything is implemented here)

**How it looks:**
<p align="center">
  <img src="https://github.com/HMByteSensei/Software-Engineering/blob/main/Images/Task6.png?raw=true" alt="Calculator">
</p>

**Zadatak 1:**
- **Description:** Create a calculator program using JavaFX that fulfills the functional requirements outlined in the project rpr21-tutorijal6. The calculator should pass provided tests and match the visual design as shown in the images.
- **Additional Requirements:** Utilize property binding and CSS for styling. Ensure proper spacing between buttons and edges of the window (5px). The UI components should resize proportionally with window dimensions.

**Zadatak 2:**
- **Description:** Enhance the project from Zadatak 1 by adding missing tests that cover all required functionalities. Modify the project as necessary to ensure that it passes the newly defined tests.
- **Additional Requirements:** Ensure comprehensive test coverage for all calculator functionalities specified.

---

## Tutorial 7 and 8: JavaFX User Management Application

### Summary
These tutorials focus on developing a JavaFX application for user management, utilizing JavaFX Beans, properties, and models. The application includes features for adding, editing, and displaying user information in a responsive UI.

**Branches:** `lv7-z1`, `lv7-z2`, `lv7i8-z3`, `lv7i8-z4`

**How it looks:**
<div style="display: inline-block">
    <img src="https://github.com/HMByteSensei/Software-Engineering/blob/main/Images/Task7i8.png?raw=true" alt="Image 1" style="width: 30%;">
</div>

<div style="display: inline-block">
    <img src="https://github.com/HMByteSensei/Software-Engineering/blob/main/Images/New%20user%20added.png?raw=true" alt="Image 2" style="width: 30%;">
</div>

**Task 1:**
- **Description:** Create a new JavaFX project with a user interface for adding and editing users as depicted in the provided image. The left side contains a ListView of users, and the right side has fields for name, surname, email, username, and password. Selecting a user in the list should populate the form fields automatically. Add functionality to add a new user with empty fields and close the program when finished.
- **Additional Requirements:** Use property binding and CSS for layout styling. Ensure proper spacing and responsiveness to window resizing.

**Task 2:**
- **Description:** Implement a class named `Korisnik` as a JavaFX Bean, containing all necessary fields for the application from Zadatak 1. Use Property types (e.g., SimpleStringProperty instead of String) and provide getter and setter methods.

**Task 3:**
- **Description:** Create a `KorisniciModel` class representing the model component for the application. The class should include an ObservableArrayList for users and a SimpleObjectProperty for the currently selected user. Implement a method `napuni` to populate the user list with specified data. Add a constructor to `Korisnik` that takes String parameters instead of SimpleStringProperty parameters for ease of use.

**Zadatak 4:**
- **Description:** Add a method in the `Controller` class with the following definition:
  ```java
  @FXML
  public void initialize() {
  }
- In this method, perform two-way binding for each form field with the corresponding user's property as shown in the example:
  ```java
  listKorisnici.setItems(model.getKorisnici());
 - Bind the ListView control to the list of users:
   ```java
   listKorisnici.setItems(model.getKorisnici());
  - Verify the contents of the user list after running the program. If the list content is unexpected, override the toString method in the Korisnik class as defined in the example.

**Task 5:**

Description: Implement functionality for the "Dodaj" button. When clicked, add a new user with empty fields using the KorisniciModel class method. Set this new user as the current user, triggering all previously implemented changes. Add JUnit 5 tests to test the model class and TestFX tests to test the user interface.

---

## Tutorial 9: Java Database Connectivity (JDBC) with DAO Pattern

### Summary
This tutorial focuses on creating a Java application with Maven that interacts with a database using JDBC and the DAO (Data Access Object) pattern. The application manages cities and countries data, including CRUD operations and database initialization.

**Branch:** `lab9`

**Prerequisites:**
- Create a new Maven project containing a blank console application.
- Set up a database with two tables:
  - Table `city` with columns: id (int, primary key), name (text), population (int), country_id (int, foreign key).
  - Table `country` with columns: id (int, primary key), name (text), capital_id (int, foreign key).
- Use any preferred database (e.g., SQLite, MySQL, Oracle) and an environment of choice for database creation (e.g., DBBrowser for SQLite, MySQL Workbench, SQLTools). Export the database to a file `database.db` and include this file in your IntelliJ project.

**Task 1:**
- **Description:** Implement the `GeographyDAO` class with corresponding DTO classes `City` and `Country`. `GeographyDAO` should be a singleton class. Its constructor should establish a connection and prepare all necessary queries.
- **Method:** Implement the `getCities()` method in `GeographyDAO` to return an `ArrayList<City>` of all cities in the database, sorted by population in descending order.

**Task 2:**
- **Description:** Modify `GeographyDAO` to populate the database with data for cities: Paris, London, Vienna, Manchester, and Graz, and their respective countries if the `database.db` file does not exist.

**Task 3:**
- **Description:** Enhance `GeographyDAO` with CRUD operations:
  - `City getCapital(String country)` - returns null if the country does not exist, otherwise returns the capital city of that country from the database.
  - `void deleteCountry(String country)` - deletes the country from the database, including all cities in that country.
  - `ArrayList<City> getCities()` - returns a list of cities from the database, sorted by population in descending order.
  - `void addCity(City city)` - adds a new city to the database.
  - `void addCountry(Country country)` - adds a new country to the database.
  - `void updateCity(City city)` - updates the corresponding row in the database for the given city.
  - `Country findCountry(String country)` - returns null if the country does not exist, otherwise returns the country from the database.

**Task 4:**
- **Description:** Implement program logic to use the above classes and interact with the database within a console application.
- **Main Class:** Include the following static methods:
  - `String printCities()` - calls the `getCities()` method and returns a string with data in the format: "City Name (Country Name) - Population".
  - `void mainCity()` - allows the user to enter the name of a country via keyboard input and then prints a message in the format: "The capital of country Country Name is City Name". If the country does not exist in the database, print: "Non-existent country".

---

## Tutorials 10 and 11: JavaFX Application with Database Interaction

### Summary
These tutorials focus on creating a JavaFX application that interacts with a database using JDBC and implements CRUD operations. The application manages cities and countries data through a graphical user interface (GUI) with forms for adding, editing, and deleting data.

**Branches:** `lab10-z1i2`, `lab10-z3`, `lab10-z4NITI`, `lab10-z5testovi`

**How it looks:**
<div style="display: inline-block">
    <img src="https://github.com/HMByteSensei/Software-Engineering/blob/main/Images/Task10%20and%2011.png?raw=true" alt="Image 1" style="width: 30%;">
</div>

<div style="display: inline-block">
    <img src="https://github.com/HMByteSensei/Software-Engineering/blob/main/Images/City%20input%20window.png?raw=true" alt="Image 2" style="width: 30%;">
</div>

<div style="display: inline-block">
    <img src="https://github.com/HMByteSensei/Software-Engineering/blob/main/Images/Country%20input%20window.png?raw=true" alt="Image 3" style="width: 30%;">
</div>


### Prerequisites
- Create a new JavaFX project and copy the classes `City`, `Country`, and `GeographyDAO` from Lab Exercise 9, which were previously validated within the `main` function. These classes will be used for database access in Labs 10 and 11.

### Task 1: Design Forms for Database Interaction
1. **glavna.fxml Form:**
   - This form should open when the program starts.
   - Contains a TableView (fx:id "tableViewGradovi") with columns: ID (colGradId), Name (colGradNaziv), Population (colGradStanovnika), Country (colGradDrzava).
   - On the right side, a vertical row of buttons: "Add City" (btnDodajGrad), "Add Country" (btnDodajDrzavu), "Edit City" (btnIzmijeniGrad), "Delete City" (btnObrisiGrad).

2. **drzava.fxml Form:**
   - Opens upon clicking the "Add Country" button.
   - Contains a standard data entry form for adding country data:
     - TextField "Name" (fx:id fieldNaziv)
     - ChoiceBox "Capital City" (fx:id choiceGrad)
     - ButtonBar with "Ok" and "Cancel" buttons (btnOk and btnCancel).
     - The Cancel button closes the window without any changes, while the Ok button validates the fieldNaziv.

3. **grad.fxml Form:**
   - Opens upon clicking the "Add City" or "Edit City" button.
   - Contains a standard data entry form with fields:
     - TextField "Name" (fx:id fieldNaziv)
     - TextField "Population" (fx:id fieldBrojStanovnika)
     - ChoiceBox "Country" (fx:id choiceDrzava)
     - ButtonBar with "Ok" and "Cancel" buttons (btnOk and btnCancel).
     - Optionally, add validation for the "Name" field to ensure it is not empty, and for the "Population" field to require a positive integer (changing color as shown in the image).

### Task 2: Create Controllers and MVC Pattern
- Implement `GlavnaController`, `DrzavaController`, and `GradController`.
- Instead of using the `GeografijaDAO` class, create static lists for cities and countries to store data (do not use the Model class).
- Refactor `City` and `Country` to follow the JavaFX Beans specification.
- Implement bidirectional control linking (MVC) as in Labs 7 and 8 to enable adding new cities/countries, editing existing ones, deleting cities/countries, and displaying all cities within the three previously created forms.

### Task 3: Data Persistence with GeografijaDAO
- Replace static lists of cities and countries with instances of the `GeografijaDAO` class.
- If `GeografijaDAO` does not have methods needed for application functionality (e.g., updating city, deleting country), add appropriate database interaction methods.

### Task 4: Database Initialization
- Clear all existing entries in the `city` and `country` tables at the beginning of the program.
- Populate both tables with predefined cities and countries.
- Use two methods running synchronously in separate threads to delete all entries from both tables concurrently. Ensure proper synchronization to avoid deadlocks.

### Task 5: Unit Testing with JUnit
- Create JUnit tests for `GeografijaDAO` functionalities.
- Implement two types of tests:
  1. Tests that consider the order of execution and the current state of the database.
  2. Tests that reset the database state, ensuring they can run independently of other tests.

### Task 6: Adding Database Constraints
- Apply appropriate constraints to columns in the `city` and `country` database tables (e.g., name and population fields, primary and foreign keys).
- Implement try-catch blocks in the `GeografijaDAO` class to prevent data entry violations without causing unhandled exceptions.
- Communicate errors to the user through UI elements such as TextField control messages, Alert dialogs (help link: [JavaFX Alerts and Dialogs](https://thecodinginterface.com/blog/javafx-alerts-and-dialogs/)), or other suitable methods.


