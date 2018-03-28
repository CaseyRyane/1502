# Assignemnt 04 Test plan



## Employee Class
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create no argument Employee (no arg constructor)| No input into Employee() | Employee Created with empty String values for Name, ID and Department variables
Create an Employee with valid params | Input "bob", "11a","labour" into Employee()| Employee created with name = "bob", id = "11a", department = "labour"
Create an Employee with invalid params | Input "bob", "11a",1234 into Employee() | No employee created
Create an Employee with copy constructor |Input Employee oldEmployee into Employee() oldEmployee values: name = "james, id = "aaa" department = "finance" | Employee created with values name = "james, id = "aaa" department = "finance"

## Employee Subclasses

## Salary Employee
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create a no argument Salary Employee| No input into Salary()| employee created with empty String vales for Name, ID and department and annualSlary = 0.0
Create a Salary Employee with valid params| Input "bob", "11a", "labour", 52000 into Salary()| Employee created with name = "bob", id = "11a", department = "labour" annualSalary = 52,000.00
Create an Employee with invalid params | Input "bob", "11a", "labour", fifty into Salary()  | No employee created
Create an Employee with copy constructor | Input Employee oldSalary into Salary() old Salary values name = "james, id = "aaa" department = "finance" annual salary = 65000 | Employee created with values name = "james, id = "aaa" department = "finance" salary = 65,000.00

## Hourly Employee
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create a no argument Hourly employee | No input into Hourly()| employee created with empty String vales for Name, ID and department and hourlyPay = 0.0, hoursWorked = 0.0, numWeeksWorked = 0
Create an Hourly Employee with valid params | Input "bob", "11a" , "labour", 15.75 , 25 , 10 into Hourly() | Employee created with name = "bob", id = "11a", department = "labour" hourly pay = 15.75, hoursWorked = 25, numWeeksWorked = 10;
Create a Hourly Employee with invalid params | Input "bob", "11a" , "labour", fifteen , 25 , 10 into Hourly() | no Employee Created 
Create a Salary Employee with copy constructor | Input Employee oldHourly into into Hourly() oldHourly name = "bob", id= "11a", department = "labour", hourlyPay = 15.75 , hours worked = 25 , numWeeksWorked = 10 | Employee Created with values name = "bob", id= "11a", department = "labour", hourlyPay = 15.75 , hours worked = 25 , numWeeksWorked = 10

## Commission Employee
Test Case | Input | Expected Output
------------ | ------------- | -------------
Create a no argument Commission employee | No input into Commission()| employee created with empty String vales for Name, ID and department and baseWeekSalary = 0.0, numWeeksWorked = 0, salesThisWeek = 0.0, commissionRate = 0.0, totalSalesThisYear = 0.0;
Create a Commissino Employeewith valid params | Input  "bob", "11a" , "labour", 200, 10, 15000, 0.25, 100000 into Commission()| Commission employee created with values: name = "bob", id =" 11a", department = "labour", baseWeekSalary = 200.0, numWeeksWorked = 10, salesThisWeek = 15000.00, commissionRate = 0.25, totalSalesThisYear = 100000.00;
Create a Commissino Employeewith invalid params | Input  "bob", "11a" , "labour", 200, 10, "ten thousand 0.25, 100000 into Commission() | no Employee created
Create a Commission Employee with copy constructor| Input Employee oldCommission into into Hourly() oldCommission  name = "bob", id =" 11a", department = "labour", baseWeekSalary = 200.0, numWeeksWorked = 10, salesThisWeek = 15000.00, commissionRate = 0.25, totalSalesThisYear = 100000.00; | Commission Employee created with values  name = "bob", id =" 11a", department = "labour", baseWeekSalary = 200.0, numWeeksWorked = 10, salesThisWeek = 15000.00, commissionRate = 0.25, totalSalesThisYear = 100000.00;



## Processor
Test Case | Input | Expected Output
------------ | ------------- | -------------
Test one | input some stuff | output stuffs
