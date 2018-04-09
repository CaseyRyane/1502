import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Expands the employee class for employees that are payed based on hours worked 
 * 
 * @author: Casey Ryane
 *
 */

public class Hourly extends Employee {

	private double hourlyPay;
	private double hoursWorked;
	private int numWeeksWorked;

	/**
	 * Default constructor 
	 */
	public Hourly() {
		hourlyPay = 0.0;
		hoursWorked = 0.0;
		numWeeksWorked = 0;
	}

	/**
	 * Constructor that takes in all instance variable values
	 * 
	 * @param newName
	 * @param newIdNumber
	 * @param newDepartment
	 * @param hourlyPay
	 * @param hoursWorked
	 * @param numWeeksWorked
	 */
	public Hourly(String newName, String newIdNumber, String newDepartment, double hourlyPay, double hoursWorked,
			int numWeeksWorked) {
		name = newName;
		idNumber = newIdNumber;
		department = newDepartment;
		this.hourlyPay = hourlyPay;
		this.hoursWorked = hoursWorked;
		this.numWeeksWorked = numWeeksWorked;
	}
	
	/**
	 * copy constructor that takes in a hourly employee object
	 * @param oldCommission
	 */
	public Hourly(Hourly oldHourly){
		hourlyPay = oldHourly.getHourlyPay();
		hoursWorked = oldHourly.getHourlyPay();
		numWeeksWorked = oldHourly.getNumWeeksWorked();
	}

	/**
	 * Getter for hourly pay of the employee
	 * @return hourly pay
	 */
	public double getHourlyPay() {
		return hourlyPay;
	}

	/**
	 * Getter for hours worked by the employee
	 * @return hours worked 
	 */
	public double getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * Getter for the number of weeks worked 
	 * @return number of weeks worked 
	 */
	public int getNumWeeksWorked() {
		return numWeeksWorked;

	}
	
	/**
	 * Setter for the number of hours worked
	 * @param hoursWorked
	 */
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	/**
	 * Calculates the weekly salary for the employee
	 * @return The weekly salary
	 */
	public double calculateWeeklySalary() {
		return (hourlyPay * hoursWorked);
	}

	/**
	 * setter for the number for weeks worked
	 * @param numWeeksWorked
	 */
	public void setNumWeeksWorked(int numWeeksWorked) {
		this.numWeeksWorked = numWeeksWorked;
	}

	/**
	 * Formats values to be printed to a file
	 * 
	 * @return formatted string of instance variables 
	 */
	public String saveString() {
		return String.format("%s, %s, %s, H, %.2f, %.1f, %d", name, idNumber, department, hourlyPay, hoursWorked,
				numWeeksWorked);
	}

	/**
	 * Formats values to be displayed in a readable manner
	 * 
	 * @return formatted string of all variables
	 */
	public String toString() {
		double weeklyPay = calculateWeeklySalary();
		return String.format("Name: %s  ID: %-12s Department: %-16s Hourly pay: %-8.2f Hours worked: %-8.2f Weeks Worked: %-3d Week pay:%-8.2f" , name, idNumber, department, hourlyPay, hoursWorked, numWeeksWorked, weeklyPay); 
		
	}

	/**
	 * Checks if an employee is equal to another
	 * @param otherEmployee
	 * @return
	 */
	public boolean equals(Employee otherEmployee){
		if((otherEmployee.getName() == this.name) && (otherEmployee.getIdNumber() == this.idNumber) &&
		(otherEmployee instanceof Hourly)){
			return true;
		}else{
		return false;	
		}
			
			
	}

}
