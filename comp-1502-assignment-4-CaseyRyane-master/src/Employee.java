/**
 * Employee class, provides basic values and methods that are used or overwritten by all employee types 
 * 
 * @author: Casey Ryane
 *
 */

public abstract class Employee implements Comparable<Employee>{
	protected String name;
	protected String idNumber;
	protected String department;

	/*
	 * Default constructor for a base employee.
	 */
	public Employee() {
		name = null;
		idNumber = null;
		department = null;
	}

	/**
	 * Constructor that takes in all values for a base employee that 
	 * 
	 * @param name of employee 
	 * @param idNumber of employee 
	 * @param department for employee 
	 */
	public Employee(String name, String idNumber, String department) {
		this.name = name;
		this.idNumber = idNumber;
		this.department = department;
	}

	/**
	 * Copy constructor that takes in an employee and creates a new employee with the same values 
	 * 
	 * @param newEmployee
	 */
	public Employee(Employee newEmployee){
		name = newEmployee.getName();
		idNumber = newEmployee.getIdNumber();
		department = newEmployee.getDepartment();
	}
	
	/**
	 * getter for all employee names
	 * @return name for employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter for all employee ID's
	 * @return id for employee
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * Getter for all employee departments
	 * @return employees department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * Abstract for the weekly salary used in all classes
	 * @return weekly salary
	 */
	public abstract double calculateWeeklySalary();
	
	/**
	 * Hours worked overridedn by hourly class
	 * @param hoursWorked
	 */
	public void setHoursWorked(double hoursWorked){};
	
	/**
	 * Setter for weekly sales overwritten by commission class
	 * @param salesThisWeek
	 */
	public void setSalesThisWeek(double salesThisWeek){};
	
	/**
	 * Setter for total sales overwritten by commission class
	 * @param totalSales
	 */
	public void setTotalSales(double totalSales){};
	
	/**
	 * setter for num weeks worked, overwritten by commission and hourly class
	 * @param numWeeks
	 */
	public void setNumWeeksWorked(int numWeeks){};
	
	/**
	 * Getter for weeks worked, overwritten for commission and hourly
	 * @return
	 */
	public int getNumWeeksWorked(){
	return 0;	
	}
	
	/**
	 * Save string for all classes to format data to be printed to a file.
	 * @return
	 */
	public abstract String saveString();
	
	/**
	 * Getter for sales overridden by commission class
	 * @return
	 */
	public double getSalesThisWeek() {
		return 0.0;
	}
	
	/**
	 * Getter for total sales, overridden by commission class
	 * @return
	 */
	public double getTotalSalesThisYear() {
	return 0.0;	
	}
	
	/**
	 * Compares employees and sorts by name.
	 */
	public int compareTo(Employee a){
		return this.getName().compareTo(a.getName());
	}

	
}
