# Comp 1502 – Winter 2018 - Assignment #4

**Date Given:***	March 23, 2018

**Date Due:**
* **Test Document:**	March 28, 2018 at noon uploaded to this GitHub
* **Full Solution:** April 9, 2018 at midnight uploaded to this GitHub

## Overview

In past assignments, it was always assumed that the data provided are valid, that is, they are the proper data and they are within the acceptable range.  However, data is often incorrect and these data cause a program to end abnormally (“crash”).  This situation is not acceptable as it can be very costly (and frustrating).  Thus, it is necessary to ensure that the problematic data are handled properly in order that the system will continue to function.

## Outcomes

After completing this assignment you will be able to:

* Develop a test plan for a piece of software 
* Use data validation and exception handling techniques to produce robust software

## Description

You are responsible for taking the software you produced in Assignment 3 (or using the solution we will provide you) and making your software as robust. You will do this in two ways, one by implementing excpetion handling so that your system can recover from unusual events, and by implementing data validation handling to ensure that the data your system is working with is correct and usable.

You are also responsible for generating a test document describing how to ensure that your software is functioning as expected, although you are **not** responsible for rendering the plan into automatic tests.

## Details and Test cases

There are two types of problems that you are expected to handle: Program Exceptions and Data Errors. Program Exceptions occur when something happens outside of the control of your program, but that your program can mitigate, or at least fail gracefully on. Data Errors occur when data is presented to your program which is invalid for the purpose your business logic will execute.

### Valid Data

* **Salaried Employees** must have a salary between $24,000 and $480,000.
* **Hourly Employees** must have a number of hours worked between 0 and 70 and cannot have a pay less that $15
* **Commissioned Employees** must have a minimum base pay of $400 and their commission rate must be between 0% and 20%.

### Functional Behaviour

* Your system must be able to do all of the things required by Assignment 3.
* Your system must accept a file name from the user. If the file cannot be found then your system must offer the user a chance to enter the file name again or return to the menu.
* Your system must validate all terminal input and if there is, present a meaningful error message to the user. This includes general errors such as the wrong type of data typed in and validation errors such as a salaried employee receiving a salary of $0 (as above).
* Your system must be able to read in data from the file provided:
   * Each line will contain information regarding one employee, but the format of the employee information may be wrong or the data may be invalid.
   * If the data on one line cannot be processed your program should present a meaningful error message to the user (see below) and then attempt to process the employee on the next line.
   * Duplicate Employees (according to name and ID#) should not be added to the processor a meaningful error message should be produced.   
   * If the data can be processesed it should be processed (the employee should be added to the processor) and no message should be produced.
 
 A meaningful error message must be specific, it must include:
 * The line of the file on which the problem occured (if you are processing the file)
 * The type of problem that occured
 * An explanation of the meaning of the error if applicable
 
 For Example
 * `Line 2: Not able to parse employee Data from Sally, "333-333- 333, 15.75, 0.0, 10".`
 * `Line 5: Employee Bob, 222-222-222 is a duplicate entry to Employee Bob on Line 1.`
 * `Line 7: Hourly employee Stan cannot work more than 70 hours. Hours worked was 168.`
 
## Test Plan Development

Taking the specification for Assignment 3 and the additions above. You must build a test plan that covers the behaviours that the system is expected to do. This should include the Employee class and its sub-classes and the processor class. 

Do not include getter, equals or toString methods in the Employee Class. 

Remember that test cases should be specific. If a saleried employee is paid $52,000 a year, the expected output should be $1,000. 

If a test should produce a specific output state "Should print:" and the message you would expect the program to produce. If a test expects a method to return a value state what value should be returned.

## Programming Style / Documentation Requirements
Your code should be stylish, consistant, and easy to read. Your classes and methods should be coherent (focused on one thing). Your names should be descriptive. Use class members and instance members appropriately. Use whitespace liberally and to good effect.

Your code should be documented well. Documentation should describe the purpose and function of each class and method, how it should be used and any caviates. Method documentation should include what input is required and what values will be returned.

## Development Strategy

This is a fairly complex assignment since you will be working with both the code and the data files.  The best way to deal with this is to develop in segments, both the program and the data file contents.  It might be a good idea to start off with valid data that cover all possibilities.  Once this is done, then you can create the invalid data one at a time to deal with a specific error/exception, which you deal with in your program.



