/**
 * Expands the employee class for employees that are payed based on commission rates. 
 * 
 * @author: Casey Ryane
 *
 */

public class Commission extends Employee {

	private double baseWeekSalary;
	private int numWeeksWorked;
	private double salesThisWeek;
	private double commissionRate;
	private double totalSalesThisYear;

	/**
	 * Default constructor
	 */
	public Commission() {
		baseWeekSalary = 0.0;
		numWeeksWorked = 0;
		salesThisWeek = 0.0;
		commissionRate = 0.0;
		totalSalesThisYear = 0.0;
	}

	/**
	 * Specific constructor that takes in all values
	 * 
	 * @param newName
	 * @param newIdNumber
	 * @param newDepartment
	 * @param baseWeekSalary
	 * @param numWeeksWorked
	 * @param salesThisWeek
	 * @param commissionRate
	 * @param totalSalesThisYear
	 */
	public Commission(String newName, String newIdNumber, String newDepartment, double baseWeekSalary, int numWeeksWorked, 
			double salesThisWeek, double commissionRate, double totalSalesThisYear) {
		name = newName;
		idNumber = newIdNumber;
		department = newDepartment;
		this.baseWeekSalary = baseWeekSalary;
		this.numWeeksWorked = numWeeksWorked;
		this.salesThisWeek = salesThisWeek;
		this.commissionRate = commissionRate;
		this.totalSalesThisYear = totalSalesThisYear;
	}
	
	/**
	 * copy constructor that takes in a commission employee object
	 * @param oldCommission
	 */
	public Commission(Commission oldCommission){
		baseWeekSalary = oldCommission.getBaseWeekSalary();
		numWeeksWorked = oldCommission.getNumWeeksWorked();
		salesThisWeek = oldCommission.getSalesThisWeek();
		commissionRate = oldCommission.getCommissionRate();
		totalSalesThisYear = oldCommission.getTotalSalesThisYear();
	}

	/**
	 * getter for base weekly salary
	 * @return base weekly salary
	 */
	public double getBaseWeekSalary() {
		return baseWeekSalary;
	}

	/**
	 * getter for the number of weeks worked 
	 * @return the number of weeks worked
	 */
	public int getNumWeeksWorked() {
		return numWeeksWorked;
	}


	/**
	 * getter for the weekly sales 
	 * @return sales for this week
	 */
	public double getSalesThisWeek() {
		return salesThisWeek;
	}

	/**
	 * getter for the employees commission rate
	 * @return commission rate
	 */
	public double getCommissionRate() {
		return commissionRate;
	}

	/**
	 * getter for the total sales for a year
	 * @return total sales this year
	 */
	public double getTotalSalesThisYear() {
		return totalSalesThisYear;
	}
	
	/**
	 * setter for the weekly sales
	 * @param weekly sales
	 */
	public void setSalesThisWeek(double salesThisWeek){
		this.salesThisWeek = salesThisWeek;
	}
	
	/**
	 * calculates the weekly salary based on commission, sales and base salary
	 * @return weekly salary
	 */
	public double calculateWeeklySalary(){
	return (baseWeekSalary + (salesThisWeek * commissionRate));	
	}
	
	/**
	 * sets the number of weeks worked by the employee
	 * @param the number of weeks worked
	 */
	public void setNumWeeksWorked(int numWeeksWorked){
		this.numWeeksWorked = numWeeksWorked;
	}
	
	/**
	 * sets the total sales by the employee
	 * @param total sales
	 */
	public void setTotalSales(double totalSales){
	totalSalesThisYear = totalSales;	
	}
	
	/**
	 * Formats values to be printed to a file
	 * 
	 * @return formatted string of instance variables 
	 */
	public String saveString(){
	return String.format("%s, %s, %s, C, %.1f, %.1f, %.1f, %.3f, %d" , name, idNumber, department, baseWeekSalary,
			totalSalesThisYear, salesThisWeek, commissionRate, numWeeksWorked); 
	}
	
	/**
	 * Formats all values to be displayed in a readable manner
	 */
	public String toString(){
	double weeklyPay = calculateWeeklySalary();
	return String.format("Name: %s  ID: %-12s Department: %-16s Base Salary: %-7.2f Weeks worked: %-3d Week sales: %-10.2f Rate: %-5.3f Total year sales: %-8.2f Weekly pay: %.2f" , name, idNumber, department, baseWeekSalary, 
			numWeeksWorked, salesThisWeek, commissionRate, totalSalesThisYear, weeklyPay); 
	
	
	}
	
	/**
	 * Checks if an employee is equal to another
	 * @param otherEmployee
	 * @return
	 */
	public boolean equals(Employee otherEmployee){
		if((otherEmployee.getName() == this.name) && (otherEmployee.getIdNumber() == this.idNumber) &&
		(otherEmployee instanceof Commission)){
			return true;
		}else{
		return false;	
		}
	}
	
	/**
	 * Compares the sales of two employees 
	 */
	public int compareTo(Employee a) {
		if (a instanceof Commission) {
			Commission c = (Commission) a;
			return (int)(c.getSalesThisWeek() - this.getSalesThisWeek());
		}else{
		return super.compareTo(a);
		}
			
	}
}
