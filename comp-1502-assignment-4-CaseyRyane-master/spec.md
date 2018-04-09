# COMP 1502 Assignment 3

Date Given: **March 9, 2018**
Date Due: 
* Class Diagram : **March 14, 2018** - Noon - Uploaded to your Assignment 3 GitHub Repository (that's this one!)
* Full Solution : **March 23, 2018** - Midnight - Uploaded to your Assignment 3 GitHub Repository  (that's also this one!)

## Overview

A company wants a program that allows personnel in HR perform simple operations (e.g. add a new employee, get information on an existing employee). 

## Outcomes
After completing this assignment you will be able to
* design classes to encapsulate data and algorithms using inheritance
* communicate regarding design and design decisions you have made
* implement your design to create a usable program

## Requirements

You will produce a simple program for a Human Resources Department to use to keep track of employees. This department must deal with three different types of employees, Hourly Employees, Saleried Employees and Commissioned Employees. These share some common aspects as employees, but also have some differences.

Your program must be able add a new employee, delete an exsisting employee, print a table of the weekly paycheques, handle information updates such as hours worked or sales made and be able to load and save all of the employee data from a file.

### Employee Information and Behaviour

Each employee should be of one of the following types, for each type you must track the following data:

| Hourly | Salaried | Comission |
| --- | --- | --- |
| Name : String | Name : String | Name : String |
| ID # : String | ID # : String | ID # : String |
| Department : Enum | Department : Enum | Department : Enum |
| Hourly Pay : double | Annual Salary : double | Base Weekly Salary : double |
| Hours Worked : double |  | Number of Weeks Worked : int |
| Number of Weeks Worked : int | | Sales This Week : double |
| | | Commission Rate : double |
| | | Total Sales this Year : double |

**Note:** For comissioned employees Number of Weeks Worked tracks how many weeks since the employee was hired or since the begining of the year.

Each employee type must also be able to do the following things:

| Hourly | Salaried | Comission |
| --- | --- | --- |
| Default Constructor | Default Constructor | Default Constructor |
| Specific Constructor | Specific Constructor | Specific Constructor |
| Copy Constructor | Copy Constructor | Copy Constructor | 
| Calculate Weekly Salary : double | Calculate Weekly Salary : double | Calculate Weekly Salary : double | 
| Equals : boolean | Equals : boolean | Equals : boolean | 
| toString : String | toString : String | toString : String | 
| getSaveString : String | getSaveString : String | getSaveString : String |

Each type should also have getters and setters as necessary.

**Notes**
* Hourly Employees' Weekly Salary is their hourly pay * the number of hours worked.
* Salaried Employees' Weekly Salary is 1 / 52 of their annual salary.
* Comissioned Employees' Weekly Salary is their base salary + their total weekly sales * the comission rate.
* Equals should return true if the employees name and id number are the same and they are the same type of employee.
* toString should present readable information about the employee including their name, id, type and weekly pay.
* toSaveString must include each instance variable in the employee's information sperated by a comma

**Really Important Note**
Some of the data and the behaviours are shared between the different employee types. You should create a superclass Employee and gather all of the important shared information there.

### Processor Class

Your processor must contain a `List` of employees. You should be able to: 
* read employees in from a file and populate the `List`
* write the save string for each employee into a file
* add a new employee
* remove an employee
* print the details of an employee
* print a table showing the details of all employees
* take an employee number and set their number of hours worked for the week, if appropriate
* take an employee number and set their weekly sales, if appropriate
* take a number and return the top number comissioned employees by sales
* do a "weekly update" which will update the number of weeks and employee has worked (if appropriate), their total sales (if appropriate) and reset their weekly hours worked and sales to zero (as appropriate).

### User Interface Class

Your UI should present a menu to the HR staffer and allow them to do the following (each of these should involve a call to the processor):
* add a new employee - prompt for each of piece of information, this will vary with the type of employee (ask that first)
* enter weekly hours - should prompt for employee id and the for the number of hours worked (if there is such an employee and they are hourly)
* enter weekly sales - should prompt for employee id and the for the number of sales (if there is such an employee and they are comissioned)
* delete an employee - this should prompt for employee id, show that employees information (if there is such an employee) and then as the user if they're sure they want to delete the data. If the user enters "Yes" (or "yes") then the employee should be removed any other answer should result in returning to the menu.
* print all employee data - print data (including weekly pay) for all employees
* print employee data - should prompt for employee id and then show the data for that employee (if there is such an employee).
* print the top 3 comissioned employees by their total sales
* do the weekly update

When you UI starts running it should load the employee data from a file and then it quits it should write the employee data to a file.

## Class Diagram

You must provide a 1 page (8 1/2 by 11) inheritance class diagram that shows the relationship between the three employee subclasses and their superclass. Include not only the relation, but also which fields and methods should be in the super class and which should be in a subclass.

There are several tools you could use to create the class diagram, but sketching on paper and taking a photo is a very simple way to get this protion of the design done.

## Programming Style / Documentation Requirements
Your code should be stylish, consistant, and easy to read. Your classes and methods should be coherent (focused on one thing). Your names should be descriptive. Use class members and instance members appropriately. Use whitespace liberally and to good effect.

Your code should be documented well. Documentation should describe the purpose and function of each class and method, how it should be used and any caviates. Method documentation should include what input is required and what values will be returned.

## Testing 

Although we have not formally discussed testing, you should still attempt to thoroughly test your code. This should not include inputs that will result in a run time error such as entering a String when a double is requested, but this should ensure that all correct inputs produce the correct behaviours in your program.

You are not required to submit your test plan. Nonetheless, I will be using a formal test plan to test your program so it might be a good idea to create an informal one based on your handwritten submission in order to anticipate what I might be testing. 

## Development

As before, this is not a trivial programming assignment. Do not expect to do this assignment the
day prior to the due date. You will need to develop an informal test plan prior to developing the
program so that it can help guide the development.

It will also be helpful if you identify all the methods and simply stub those that you are not
currently developing and testing.

A suggestion:
* One of the more complex methods is the loading of the data from the input file. You do not want to get hung up on this part and not be able to do the rest of the program. I suggest that, initially, hard code the data and load it into the ArrayList. By doing this, you can complete the development of the rest of the program. Even if you are not able to complete the loading
program using an input file, you can still get credit for the rest of the functionality. Once the program is working as expected, you can now concentrate in developing the loading program using an input file.
* For the hard coded data, you may use the following data (identical to the data in the sample input data file) or one of your own:
   * "Sally", "333-333- 333", "Finance", 15.75, 0.0, 10
   * "Arnie", "222-222- 222", "Human Resources", 52000
   * "Bobby", "111-111- 111", "Appliances", 300, 0.0, 10000, .025, 10

## Submission

Upload your class diagram to your GitHub by noon on the day it is due.

Upload your Java code in your src/ directory to your GitHub repository by midnight on the day it's due. You should actually do this as you complete each processing method, so that you always have a working backup copy of your code in case something **disasterous** happens.
