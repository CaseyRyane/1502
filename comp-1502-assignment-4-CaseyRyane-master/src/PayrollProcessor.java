import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Processor that handles care of user requested actions.
 * 
 * @author: Casey Ryane
 *
 */

public class PayrollProcessor {
	private static final int MIN_HOURLY_PAY = 15;
	private static final int MAX_HOURS_WORKED = 70;
	private static final int MIN_HOURS_WORKED = 0;
	private static final int MAX_SALARY = 480000;
	private static final int MIN_SALARY = 24000;
	private static final int MIN_BASE_PAY = 400;
	private static final double MAX_COMMISSION_RATE = 0.20;
	private static final double MIN_COMMISSION_RATE = 0.000;

	// list that contains all employees regardless of type
	private static ArrayList<Employee> employeeList;

	/**
	 * Instantiates employee list
	 * 
	 * @throws FileNotFoundException
	 */
	public PayrollProcessor() throws FileNotFoundException {
		employeeList = new ArrayList<>();

	}

	public static void loadFile(String fileName) throws FileNotFoundException {
		File employeeFile = new File(fileName);
		Scanner fileReader = new Scanner(employeeFile);

		// continues until all employees are loaded
		int lineNumber = 1;
		while (fileReader.hasNextLine()) {

			String employee = fileReader.nextLine();
			// fills array with elements taken in, separated by commas
			String[] employeeData = employee.split(", ");

			// takes elements from the array to fill employee variables
			String employeeType = "";
			try {
				String name = employeeData[0];
				String idNumber = employeeData[1];
				String department = employeeData[2];
				employeeType = employeeData[3];
				for (Employee employeeInList : employeeList) {
					if (idNumber.equals(employeeInList.getIdNumber())) {
						throw new DuplicateEmployeeException(idNumber);
					}
				}

				if (employeeType.equals("H")) {
					
					if(employeeData.length != 7){
					throw new EmployeeDataException(idNumber);	
					}
					// continues to fill employee variables from array for hourly employees and
					// creates new employee before adding to list
					double hourlyPay = Double.parseDouble(employeeData[4]);
					double hoursWorked = Double.parseDouble(employeeData[5]);
					int numWeeksWorked = Integer.parseInt(employeeData[6]);
					if (hourlyPay < MIN_HOURLY_PAY || hoursWorked > MAX_HOURS_WORKED
							|| hoursWorked < MIN_HOURS_WORKED) {
						throw new HourlyDataException(hourlyPay, hoursWorked);
					}

					Employee newEmployee = new Hourly(name, idNumber, department, hourlyPay, hoursWorked,
							numWeeksWorked);
					employeeList.add(newEmployee);

				} else if (employeeType.equals("S")) {
					if(employeeData.length != 5){
						throw new EmployeeDataException(idNumber);	
						}
					// continues to fill employee variables from array for Salary employees and
					// creates new employee before adding to list
					double annualSalary = Double.parseDouble(employeeData[4]);
					if (annualSalary > MAX_SALARY || annualSalary < MIN_SALARY) {
						throw new SalaryDataException(annualSalary);
					}
					Employee newEmployee = new Salary(name, idNumber, department, annualSalary);
					employeeList.add(newEmployee);

				} else if (employeeType.equals("C")) {
					if(employeeData.length != 9){
						throw new EmployeeDataException(idNumber);	
						}
					// continues to fill employee variables from array for commission employees and
					// creates new employee before adding to list
					double baseWeekSalary = Double.parseDouble(employeeData[4]);
					double totalSalesThisYear = Double.parseDouble(employeeData[5]);
					double salesThisWeek = Double.parseDouble(employeeData[6]);
					double commissionRate = Double.parseDouble(employeeData[7]);
					int numWeeksWorked = Integer.parseInt(employeeData[8]);
					if (baseWeekSalary < MIN_BASE_PAY || commissionRate > MAX_COMMISSION_RATE
							|| commissionRate < MIN_COMMISSION_RATE) {
						throw new CommissionDataException(baseWeekSalary, commissionRate);
					}

					Employee newEmployee = new Commission(name, idNumber, department, baseWeekSalary, numWeeksWorked,
							salesThisWeek, commissionRate, totalSalesThisYear);
					employeeList.add(newEmployee);
				}
			} catch (NumberFormatException e) {
				String line = "";
				for (String lineItem : employeeData) {
					line += lineItem + ", ";
				}
				System.out.println("Line " + lineNumber + ": Unable to parse line containing: " + line);
			} catch (SalaryDataException e) {
				System.out.print("Line " + lineNumber + ": ");
				System.out.print(e.getMessage());
				if (e.getSalary() > MAX_SALARY) {
					System.out.println("Salary is above the $480,000 maximum");
				} else if (e.getSalary() < MIN_SALARY) {
					System.out.println("Salary is below the $24,000 minimum");
				}
			} catch (HourlyDataException e) {
				System.out.print("Line " + lineNumber + ": ");
				System.out.print(e.getMessage());
				if (e.getHourlyPay() < MIN_HOURLY_PAY) {
					System.out.println("Hourly pay is below the $15 minimum");
				} else if (e.getHoursWorked() > MAX_HOURS_WORKED) {
					System.out.println("Hours worked exceeds the 70 hours maximum");
				} else if (e.getHoursWorked() < MIN_HOURS_WORKED) {
					System.out.println("Hours worked is below zero");
				}
			} catch (CommissionDataException e) {
				System.out.print("Line " + lineNumber + ": ");
				System.out.print(e.getMessage());
				if (e.getBaseWeekSalary() < MIN_BASE_PAY) {
					System.out.println("Base week salary is below the $400 minimum ");
				} else if (e.getCommissionRate() > MAX_COMMISSION_RATE) {
					System.out.println("Commission rate is above the maximum 20%");
				} else if (e.getCommissionRate() < MIN_COMMISSION_RATE) {
					System.out.println("Commission rate is below 0%");
				}

			} catch (EmployeeDataException e) {
				System.out.print("Line " + lineNumber + ": ");
				System.out.print(e.getMessage());
				System.out.println(" The data provided does not match with the employe type provided:" + employeeType);
				
			} catch(ArrayIndexOutOfBoundsException e){
				System.out.print("Line " + lineNumber + ": ");
				System.out.println("The information provided is not within valid paramaters: possibly white space");
			} catch(DuplicateEmployeeException e){
				System.out.print("Line " + lineNumber + ": ");
				System.out.print(e.getMessage());
			}finally {
				lineNumber++;
			}
		}

		fileReader.close();
	}

	/**
	 * Creates a new salary employee based on parameters given by user in the
	 * interface and adds to the employee list
	 * 
	 * @param name
	 *            for new employee
	 * @param id
	 *            for new employee
	 * @param department
	 *            of new employee
	 * @param salary
	 *            for new employee
	 * @return a string confirming the employee has been added
	 */
	public static String newSalary(String name, String id, String department, double salary) {
		String message = "";
		try {
			for (Employee employeeInList : employeeList) {
				if (id.equals(employeeInList.getIdNumber())) {
					throw new DuplicateEmployeeException(id);
				}
			}
			if (salary > MAX_SALARY || salary < MIN_SALARY) {
				throw new SalaryDataException(salary);
			}
			Salary salaryEmployee = new Salary(name, id, department, salary);
			employeeList.add(salaryEmployee);
			message = "Employee added";
		} catch (SalaryDataException e) {
			message = e.getMessage();
			if (e.getSalary() > MAX_SALARY) {
				message += "Salary is above the $480,000 maximum";
			} else if (e.getSalary() < MIN_SALARY) {
				message += "Salary is below the $24,000 minimum";
			}
		} catch(DuplicateEmployeeException e){
			message = e.getMessage();
		
		}
		return message;
	}

	/**
	 * Creates a new Hourly employee based on parameters given by user in the
	 * interface and adds to the employee list
	 * 
	 * @param name
	 *            for new employee
	 * @param id
	 *            for new employee
	 * @param department
	 *            of new employee
	 * @param hourlyPay
	 *            of new employee
	 * @param hoursWorked
	 *            of new employee
	 * @param numWeeksWorked
	 *            of new employee
	 * @return a string confirming the employee has been added
	 */
	public static String newHourly(String name, String id, String department, double hourlyPay, double hoursWorked,
			int numWeeksWorked) {
		String message = "";
		try {
			for (Employee employeeInList : employeeList) {
				if (id.equals(employeeInList.getIdNumber())) {
					throw new DuplicateEmployeeException(id);
				}
			}
			if (hourlyPay < MIN_HOURLY_PAY || hoursWorked > MAX_HOURS_WORKED || hoursWorked < MIN_HOURS_WORKED) {
				throw new HourlyDataException(hourlyPay, hoursWorked);
			}
			Hourly hourlyEmployee = new Hourly(name, id, department, hourlyPay, hoursWorked, numWeeksWorked);
			employeeList.add(hourlyEmployee);
		} catch (HourlyDataException e) {
			message = e.getMessage();
			if (e.getHourlyPay() < MIN_HOURLY_PAY) {
				message += "Hourly pay is below the $15 minimum";
			} else if (e.getHoursWorked() > MAX_HOURS_WORKED) {
				message += "Hours worked exceeds the 70 hours maximum";
			} else if (e.getHoursWorked() < MIN_HOURS_WORKED) {
				message += "Hours worked is below zero";
			}
		} catch(DuplicateEmployeeException e){
			message = e.getMessage();
		}
		return message;
	}

	/**
	 * Creates a new Commission employee based on parameters given by user in the
	 * interface and adds to the employee list
	 * 
	 * @param name
	 *            of new employee
	 * @param id
	 *            of new employee
	 * @param department
	 *            of new employee
	 * @param baseSalary
	 *            of new employee
	 * @param numWeeksWorked
	 *            for new employee
	 * @param salesThisWeek
	 *            for new employee
	 * @param commissionRate
	 *            for new employee
	 * @param totalYearlySales
	 *            for new employee
	 * @return a string confirming the employee has been added
	 */
	public static String newCommission(String name, String id, String department, double baseSalary, int numWeeksWorked,
			double salesThisWeek, double commissionRate, double totalYearlySales) {
		String message = "";
		try {
			for (Employee employeeInList : employeeList) {
				if (id.equals(employeeInList.getIdNumber())) {
					throw new DuplicateEmployeeException(id);
				}
			}
			if (baseSalary < MIN_BASE_PAY || commissionRate > MAX_COMMISSION_RATE
					|| commissionRate < MIN_COMMISSION_RATE) {
				throw new CommissionDataException(baseSalary, commissionRate);
			}
			Commission commissionEmployee = new Commission(name, id, department, baseSalary, numWeeksWorked,
					salesThisWeek, commissionRate, totalYearlySales);
			employeeList.add(commissionEmployee);

		} catch (CommissionDataException e) {
			message = e.getMessage();
			if (e.getBaseWeekSalary() < MIN_BASE_PAY) {
				message += "Commissioned employee base week salary is below the $400 minimum ";
			} else if (e.getCommissionRate() > MAX_COMMISSION_RATE) {
				message += "Commission rate is above the maximum 20%";
			} else if (e.getCommissionRate() < MIN_COMMISSION_RATE) {
				message += "Commission rate is below 0%";
			}
		}  catch(DuplicateEmployeeException e){
			message = e.getMessage();
		}
		return message;
	}

	/**
	 * Updates the hours worked by an hourly pay employee if employee exists and is
	 * valid
	 * 
	 * @param employeeID
	 *            that hours should be updated for
	 * @param hoursWorked
	 * @return confirmation message or declination message
	 */
	public static String updateHourlyEmployee(String employeeID, double hoursWorked) {
		String status = "";
		try {
			boolean idExists = validateID(employeeID);
			if (hoursWorked > MAX_HOURS_WORKED || hoursWorked < MIN_HOURS_WORKED) {
				throw new HourlyDataException(hoursWorked);
			}
			if (idExists) {
				int index = findIndexOfId(employeeID);
				Employee employee = employeeList.get(index);
				if (employee instanceof Hourly) {
					employee.setHoursWorked(hoursWorked);
					status = "Hours Worked Updated";
				} else {
					status = "Invalid ID, Employee is not paid hourly.";
				}

			} else {
				status = "Invalid ID number";
			}

		} catch (HourlyDataException e) {
			status = e.getMessage();
			if (e.getHoursWorked() > MAX_HOURS_WORKED) {
				status += "Hours worked exceeds the 70 hours maximum";
			} else if (e.getHoursWorked() < MIN_HOURS_WORKED) {
				status += "Hours worked is below zero";
			}
		}
		return status;
	}

	// checks to make sure employee id exists within the employee list
	private static boolean validateID(String employeeID) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeID.equals(employeeList.get(i).getIdNumber())) {
				return true;
			}
		}
		return false;
	}

	// finds the index within the employee list for a given employee id
	private static int findIndexOfId(String id) {
		int idIndex = 0;
		for (int i = 0; i < employeeList.size(); i++) {
			Employee currentEmployee = employeeList.get(i);
			String currentEmployeeID = currentEmployee.getIdNumber();
			if (currentEmployeeID.equals(id)) {
				idIndex = i;
			}
		}
		return idIndex;
	}

	/**
	 * Updates the sales made for a commission employee if employee exists and is
	 * valid
	 * 
	 * @param employeeID
	 *            that sales should be updated for
	 * @param salesThisWeek
	 *            volume of sales made
	 * @return
	 */
	public static String updateComissionedEmployee(String employeeID, double salesThisWeek) {
		String status = "";
		boolean idExists = validateID(employeeID);

		if (idExists) {
			int index = findIndexOfId(employeeID);
			Employee employee = employeeList.get(index);
			if (employee instanceof Commission) {
				employee.setSalesThisWeek(salesThisWeek);
				status = "Weekly Sales Updated";
			} else {
				status = "Invalid ID, employee not paid on comission";
			}

		} else {
			status = "Invalid ID number";
		}
		return status;
	}

	/**
	 * Removes and employee from the payroll list
	 * 
	 * @param employeeID
	 *            for employee that should be removed
	 * @return confirmation employee was removed
	 */
	public static String removeEmployeeFromPayroll(String employeeID) {
		int index = findIndexOfId(employeeID);
		employeeList.remove(index);
		return "Employee removed from payroll";
	}

	/**
	 * Prints all detailed information for every employee
	 */
	public static String printAllEmployeesReport() {
		String employeeInfo = "";
		for (Employee employee : employeeList) {
			employeeInfo += employee.toString() + "\n";
		}
		return employeeInfo;
	}

	/**
	 * Prints detailed information for a single employee
	 * 
	 * @param employeeID
	 *            id of employee for requested information
	 * @return information to be printed.
	 */
	public static String printIndividualInfo(String employeeID) {
		boolean validID = validateID(employeeID);
		if (validID) {
			int index = findIndexOfId(employeeID);
			Employee employee = employeeList.get(index);
			return employee.toString();
		} else {
			return "No employee Exists";
		}
	}

	/**
	 * Sorts list into the top commissioned employees based on their weekly sales.
	 * 
	 * @param numTopEmployeesToFind
	 *            the number of top employees to display
	 * @return the top three employees by name
	 */
	public static String findTopCommissionEmployees(int numTopEmployeesToFind) {
		Collections.sort(employeeList);
		String topEmployees = "";
		int numTopEmployees = 0;
		int i = 0;
		do {
			Employee employee = employeeList.get(i);
			if (employee instanceof Commission) {
				topEmployees += employee.getName() + "\n";
				numTopEmployees++;
			}
			i++;

		} while (numTopEmployees < numTopEmployeesToFind);
		return topEmployees;
	}

	/**
	 * Resets hours worked and sales made for the week and bumps up the number of
	 * weeks worked by one.
	 * 
	 * @return confirmation action was performed
	 */
	public static String endOfWeekProcessing() {

		for (Employee employee : employeeList) {
			String employeeID = employee.getIdNumber();
			if (employee instanceof Commission) {
				commissionEndOfWeek(employeeID);

			} else if (employee instanceof Hourly) {

				hourlyEndOfWeek(employeeID);
			}
		}
		return "Weekly update executed.";
	}

	// resets necessary values for commissioned employees and bumps up the number of
	// weeks worked
	private static void commissionEndOfWeek(String employeeID) {
		int index = findIndexOfId(employeeID);
		Employee employee = employeeList.get(index);
		double salesThisWeek = employee.getSalesThisWeek();
		double totalSales = employee.getTotalSalesThisYear();
		employee.setTotalSales((totalSales + salesThisWeek));
		employee.setSalesThisWeek(0);

		int numWeeksWorked = employee.getNumWeeksWorked();
		employee.setNumWeeksWorked((numWeeksWorked + 1));
	}

	// resets necessary values for hourly employees and bumps up the number of weeks
	// worked
	private static void hourlyEndOfWeek(String employeeID) {
		int index = findIndexOfId(employeeID);
		Employee employee = employeeList.get(index);

		int numWeeksWorked = employee.getNumWeeksWorked();
		employee.setNumWeeksWorked((numWeeksWorked + 1));
		employee.setHoursWorked(0);
	}

	/**
	 * Prints the information for each employee into a file in the format that the
	 * program can read.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void writeDateToFile() throws FileNotFoundException {
		PrintWriter fileWriter = new PrintWriter("data/updatedEmployee.txt");
		for (Employee employee : employeeList) {
			fileWriter.println(employee.saveString());
		}
		fileWriter.close();
	}
}
