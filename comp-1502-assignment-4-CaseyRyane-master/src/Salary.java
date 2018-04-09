/**
 * Expands the employee class for employees that are payed based on a salary position
 * 
 * @author: Casey Ryane
 *
 */

public class Salary extends Employee {

	private double annualSalary;
	private final int WEEKS_IN_YEAR = 52;

	/**
	 * Default constructor
	 */
	public Salary() {
		annualSalary = 0.0;
	}

	/**
	 * Specific constructor for all variables
	 * 
	 * @param newName
	 * @param newIdNumber
	 * @param newDepartment
	 * @param annualSalary
	 */
	public Salary(String newName, String newIdNumber, String newDepartment, double annualSalary) {
		name = newName;
		idNumber = newIdNumber;
		department = newDepartment;
		this.annualSalary = annualSalary;
	}
	
	/**
	 * copy constructor that takes in a Salary employee object
	 * @param oldCommission
	 */
	public Salary(Salary oldSalary){
		annualSalary = oldSalary.getAnuualSalary();
	}

	/**
	 * Getter for the annual salary of an employee
	 * @return annual salary
	 */
	public double getAnuualSalary() {
		return annualSalary;
	}

	/**
	 * Calculates the weekly salary
	 * @return the weekly salary
	 */
	public double calculateWeeklySalary() {
		return (annualSalary / WEEKS_IN_YEAR);
	}
	
	/**
	 * Formats values to be printed to a file
	 * 
	 * @return formatted string of instance variables 
	 */
	public String saveString(){
		return String.format("%s, %s, %s, S, %.2f " , name, idNumber, department, annualSalary); 
		
		}

	/**
	 * Formats values to be displayed in a readable manner
	 * 
	 * @return formatted string of all variables
	 */
	public String toString() {
		double weeklyPay = calculateWeeklySalary();
		return String.format("Name: %s  ID: %-12s Department: %-16s Annual Salary: %-10s Weekly pay: %-12.2f" , name, idNumber, department, annualSalary, weeklyPay); 
		
	}

	/**
	 * Checks if an employee is equal to another
	 * @param otherEmployee
	 * @return
	 */
	public boolean equals(Employee otherEmployee){
		if((otherEmployee.getName() == this.name) && (otherEmployee.getIdNumber() == this.idNumber) &&
		(otherEmployee instanceof Salary)){
			return true;
		}else{
		return false;	
		}
}
	
}
