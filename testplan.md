# Assignemnt 04 Test plan

&nbsp;

Test plan for Employee class (and subclasses) and for the main payroll processing class. 

Test Cases for Employee classes = 16.

Test Cases for Processer class = 33.

Tests "return" strings rather than printing them as the UI class does all the printing to screen and gathering of info.
&nbsp;

## Employee Class
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create no argument Employee (no arg constructor)| No input into Employee() | Employee Created with empty String values for Name, ID and Department variables
Create an Employee with valid params | Input "bob", "11a","labour" into Employee()| Employee created with name = "bob", id = "11a", department = "labour"
Create an Employee with invalid params | Input "bob", "11a",1234 into Employee() | No employee created
Create an Employee with copy constructor |Input Employee oldEmployee into Employee() oldEmployee values: name = "james, id = "aaa" department = "finance" | Employee created with values name = "james, id = "aaa" department = "finance"\

&nbsp;
## Employee Subclasses
&nbsp;

## Salary Employee
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create a no argument Salary Employee| No input into Salary()| employee created with empty String vales for Name, ID and department and annualSlary = 0.0
Create a Salary Employee with valid params| Input "bob", "11a", "labour", 52000 into Salary()| Employee created with name = "bob", id = "11a", department = "labour" annualSalary = 52,000.00
Create an Employee with invalid params | Input "bob", "11a", "labour", fifty into Salary()  | No employee created
Create an Employee with copy constructor | Input Employee oldSalary into Salary() old Salary values name = "james, id = "aaa" department = "finance" annual salary = 65000 | Employee created with values name = "james, id = "aaa" department = "finance" salary = 65,000.00

&nbsp;

## Hourly Employee
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create a no argument Hourly employee | No input into Hourly()| employee created with empty String vales for Name, ID and department and hourlyPay = 0.0, hoursWorked = 0.0, numWeeksWorked = 0
Create an Hourly Employee with valid params | Input "bob", "11a" , "labour", 15.75 , 25 , 10 into Hourly() | Employee created with name = "bob", id = "11a", department = "labour" hourly pay = 15.75, hoursWorked = 25, numWeeksWorked = 10;
Create a Hourly Employee with invalid params | Input "bob", "11a" , "labour", fifteen , 25 , 10 into Hourly() | no Employee Created 
Create a Salary Employee with copy constructor | Input Employee oldHourly into into Hourly() oldHourly name = "bob", id= "11a", department = "labour", hourlyPay = 15.75 , hours worked = 25 , numWeeksWorked = 10 | Employee Created with values name = "bob", id= "11a", department = "labour", hourlyPay = 15.75 , hours worked = 25 , numWeeksWorked = 10

&nbsp;

## Commission Employee
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create a no argument Commission employee | No input into Commission()| employee created with empty String vales for Name, ID and department and baseWeekSalary = 0.0, numWeeksWorked = 0, salesThisWeek = 0.0, commissionRate = 0.0, totalSalesThisYear = 0.0;
Create a Commissino Employeewith valid params | Input  "bob", "11a" , "labour", 200, 10, 15000, 0.25, 100000 into Commission()| Commission employee created with values: name = "bob", id =" 11a", department = "labour", baseWeekSalary = 200.0, numWeeksWorked = 10, salesThisWeek = 15000.00, commissionRate = 0.25, totalSalesThisYear = 100000.00;
Create a Commissino Employeewith invalid params | Input  "bob", "11a" , "labour", 200, 10, "ten thousand 0.25, 100000 into Commission() | no Employee created
Create a Commission Employee with copy constructor| Input Employee oldCommission into into Hourly() oldCommission  name = "bob", id =" 11a", department = "labour", baseWeekSalary = 200.0, numWeeksWorked = 10, salesThisWeek = 15000.00, commissionRate = 0.25, totalSalesThisYear = 100000.00; | Commission Employee created with values  name = "bob", id =" 11a", department = "labour", baseWeekSalary = 200.0, numWeeksWorked = 10, salesThisWeek = 15000.00, commissionRate = 0.25, totalSalesThisYear = 100000.00;

&nbsp;

## PayrollProcessor Individual Method Tests 

&nbsp;

## Adding New Employees
Test Case | Input | Expected Output
------------ | ------------- | -------------
Add new Salary Employee with valid input | Input "James", "11B", "IT", "52,000" into newSalary() | Should return "Employee Added", employeeList should contain employee "11B"
Add new Salary Employee with invalid input |  Input "James", "11B", "IT", "fity" into newSalary() | Should return, "Invalid input for salary employee type" employeeList should not contain employee "11B"
Add new Salary Employee with invalid salary| Input "James", "11B", "IT", "520,000" into newSalary() | Should return: "Invalid Input: Salary must be between $24,000 and $480,000"
Add new Hourly Employee with valid input | Input "James", "11B", "IT", 15.25, 10 into newHourly() | Should return "Employee Added", employeeList should contain employee "11B"
Add new Hourly Employee with invalid input | Input "James", "11B", "IT", fifteen, 10 into newHourly() | Should return, "Invalid input for Hourly employee type" employeeList should not contain employee "11B"
Add new Hourly Employee with invalid hours worked| Input "James", "11B", "IT", 15.25, 90 into newHourly() | Should return, "Invalid input: Hours worked must be between 0 and 70"
Add new Hourly Employee with invalid pay| Input "James", "11B", "IT", 9.25, 10 into newHourly() | Should return, "Invalid input: Hourly pay must a minimum of %15
Add new Commission Employee with valid input | Input "James", "11B", "IT", 400, 10, 15000, 0.20, 100000 into newCommission() | Should return "Employee added", employeeList should contain employee "11B"
Add new Commission Employee with invalid input | Input "James", "11B", "IT", 400, 10, 15000, 0.20, "ten gs" into newCommission() | Should return, "Invalid input for Commission employee type" employeeList should not contain employee "11B"
Add new Commission Employee with invalid base pay | Input "James", "11B", "IT", 200, 10, 15000, 0.20, 100000 into newCommission() | Should return, "Invalid input: Base pay under $400"
Add new Commission Employee with invalid commission rate | Input "James", "11B", "IT", 400, 10, 15000, 0.90, 100000 into newCommission() | Should return, "Invalid input: Commission arte must be between 0% and 20%"

&nbsp;

## Update Employee Data
Test Case | Input | Expected Output
------------ | ------------- | -------------
Update Hourly employee with valid employee ID and valid hours | Input "333-333-333", 40 into updateHourly() | Should return: "Hours worked updated"|
Update Hourly employee with invalid employee ID and valid hours | Input "333-332-333", 40 into updateHourly() | Should return: "Invalid ID number"
Update Hourly employee with valid employee ID, but not hourly employee and invalid hours | Input "222-222-222",  into updateHourly() | Should return: "Invalid ID: employee is not paid hourly"
Update Hourly employee with valid employee ID and invalid hours | Input "333-333-333", -10 into updateHourly() | Should return: "invalid number of hours worked"
Update Commission employee with valid employee ID and valid Sales | Input "111-111-111", 17000 into updateComissionedEmployee() | Should return: "Commisioned employee updated" 
Update Commission employee with invalid employee ID and valid sales | Input "123-321-123", 17000 int updateComissionedEmployee() | Should return: "Invalid ID number"
Update Commission employee with valid employee ID but not commisioned pay employee | Input "333-333-333", 17000 into updateCommissioneEmployee() | Should return: "Invalid Id, employee not paid on commission" 

&nbsp;

## Remove Employee from Payroll
Test Case | Input | Expected Output
------------ | ------------- | -------------
Remove valid employee ID | Input "111-111-111" into removeEmployeeFromPayroll() | return: "Employee removed from payroll"
Remove invalid employee ID | Input "123-123-123" into removeEmployeeFromPayroll() | return: "Employee does not exist:

&nbsp;

## Print Employee Report
Test Case | Input | Expected Output
------------ | ------------- | -------------
Print info with valid employee ID | Input "222-222-222" into printIndividualInfo() | return "Name: Arnie" \n Department "Human Resources" \n Salary: 52000.00 \n Weekly pay: 1000.00.
Print info with invali employee ID | Input "123-30721-sadv" into print IndividualInfo() | return: "No Employee exists with that ID"

&nbsp;

## Find Top Commission Employees
Test Case | Input | Expected Output
------------ | ------------- | -------------
Get top three employees | Input 3 into findTopComissionEmployees() | Return string with names of top three commissioned employees
Get top employees greater than number in list | Input 912929 into findTopComissionEmployees() | return "Number of employees exceeds number of employees on payroll

&nbsp;

## End of Week Processsing
Test Case | Input | Expected Output
------------ | ------------- | -------------
Run end of week processing | No input into endOfWeekProcessing() |Return "Weekly update executed"  
Process end of week for commission | Input  "111-111-111" into commissionedEndOfWeek() | YearlySales should += previous weeklySales, WeeklySales should = 0, weeksWorked should == + 1
Process end of week forhourly | Input "333-333-333" into hourlyEndOfWeek() | WeeksWorked should == + 1 Hours worked should == 0

&nbsp;

## General helper methods 
Test Case | Input | Expected Output
------------ | ------------- | -------------
Check employee is in employee list with valid employee | Input "111-111-111" into validateID()| Should return: true.
Check employee is in employee list with invalid employee | Input "1s1-111-111" into validateID()| Should return: false.
Find index of employee in list| Input "111-111-111" into findIndexOfId() | Should return: 0
Find index of employee not in list | Input "123-123-123" into findIndexOfId() | should return: -1

&nbsp;

