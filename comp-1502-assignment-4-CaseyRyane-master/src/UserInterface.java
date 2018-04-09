import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * User Interface that allows access to the program. and presents users with
 * what the program is capable of.
 * 
 * @author: Casey Ryane
 *
 */

public class UserInterface {

	// keyboard used by all methods to take input from user
	private static Scanner keyboard = new Scanner(System.in);
	private static PayrollProcessor payrollProcessor;

	/**
	 * Main access point for the Payroll program
	 * 
	 * @param args
	 *            unused
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException {
		payrollProcessor = new PayrollProcessor();
		String menuChoice = "";
		String fileName = "";
		boolean fileOK = false;
		do {
			try {
				System.out.println("Please enter filename:         ( data/employee.data is the correct path btw)");
				fileName = keyboard.next();
				payrollProcessor.loadFile(fileName);
				fileOK = true;
			} catch (FileNotFoundException e) {
				if (fileName.equalsIgnoreCase("Q")) {
					break;
				}
				System.out.println("Not able to open file " + fileName);
				System.out.println("Please try again or enter \"Q\" to stop \n");
			}
		} while (!fileOK);
		do {
			showMenu();
			menuChoice = getMenuChoice();
			processMenuChoice(menuChoice);
		} while (userWantsToContinue(menuChoice));
		writeDataToFile();
	}

	// payroll menu that shows all options for the program
	private static void showMenu() {
		System.out.println("\nMENU:");
		System.out.println("A - Add a new employee");
		System.out.println("UH - Update hourly employee");
		System.out.println("UC - Update comissioned employee");
		System.out.println("D - Remove an employee from payroll");
		System.out.println("P - Print all employees report");
		System.out.println("I - Print individual employee information");
		System.out.println("T - Print the top comissioned employees by total sales");
		System.out.println();
		System.out.println("W - End of week processing");
		System.out.println();
		System.out.println("Q - Quit the system");
	}

	// retrieves menu choice from user
	private static String getMenuChoice() {
		String menuChoice = "";

		boolean validInput = false;
		do {
			if (keyboard.hasNextInt()) {
				keyboard.nextInt();
				invalidInputMessage();
			} else {
				menuChoice = keyboard.next();
				validInput = true;
			}
		} while (!validInput);
		return menuChoice;
	}

	// displays a message telling the user the input is invalid.
	private static void invalidInputMessage() {
		System.out.println("Invalid input, please make a valid menu selection");
	}

	// processes the choice made by the user
	private static void processMenuChoice(String choice) {
		if (choice.equals("A")) {
			addNewEmployee();
		} else if (choice.equals("UH")) {
			updateHourlyEmployee();
		} else if (choice.equals("UC")) {
			updateComissionedEmployee();
		} else if (choice.equals("D")) {
			removeEmployeeFromPayroll();
		} else if (choice.equals("P")) {
			printAllEmployeesReport();
		} else if (choice.equals("I")) {
			printIndividualInfo();
		} else if (choice.equals("T")) {
			topCommisionEmployees();
		} else if (choice.equals("W")) {
			endOfWeekProcessing();
		} else if (choice.equals("Q")) {
			System.out.println("Thank you for using the Payroll Processing System");
		} else {
			System.out.println("Invalid Input.");
		}

	}

	// determines of the user wants to continue using the program
	private static boolean userWantsToContinue(String userChoice) {
		if (userChoice.equals("Q")) {
			return false;
		} else {
			return true;
		}
	}

	// takes in input for what type of employy the user wants to add
	private static void addNewEmployee() {
		System.out.println("Choose - S for Salary - H for Hourly - C for Commission ");
		String userChoice = keyboard.next();
		if (userChoice.equals("S")) {
			newSalary();
		} else if (userChoice.equals("H")) {
			newHourly();
		} else if (userChoice.equals("C")) {
			newCommission();
		}
	}

	// prompts for and takes in input for new salary employees
	private static void newSalary() {
		try {
			System.out.println("Enter the employee name: ");
			String name = keyboard.next();
			System.out.println("Enter the employee ID number: ");
			String id = keyboard.next();
			System.out.println("Enter the employee department: ");
			String department = keyboard.next();
			System.out.println("Enter the employee annual salary: ");
			double salary = keyboard.nextDouble();
			String status = payrollProcessor.newSalary(name, id, department, salary);
			System.out.println(status);
		} catch (InputMismatchException e) {
			System.out.println("Employee was not created.");
			System.out.println("Expected a double for salary but did not find one.");

		}

	}

	// prompts for and takes in input for new hourly employees
	private static void newHourly() {
		String problem = "";
		String expected = "";
		try {
			System.out.println("Enter the employee name: ");
			String name = keyboard.next();
			System.out.println("Enter the employee ID number: ");
			String id = keyboard.next();
			System.out.println("Enter the employee department: ");
			String department = keyboard.next();
			System.out.println("Enter the employee hourly pay: ");
			problem = "hourly pay";
			expected = "double";
			double hourlyPay = keyboard.nextDouble();
			System.out.println("Enter the employee hours worked: ");
			problem = "hours worked";
			double hoursWorked = keyboard.nextDouble();
			System.out.println("Enter the employee number of weeks worked: ");
			problem = "number of weeks worked";
			expected = "int";
			int numWeeksWorked = keyboard.nextInt();
			String status = payrollProcessor.newHourly(name, id, department, hourlyPay, hoursWorked, numWeeksWorked);
			System.out.println(status);
		} catch (InputMismatchException e) {
			System.out.println("Employee was not created: Expected " + expected + " for " + problem);

		}
	}

	// prompts for and takes in input for new commission employees
	private static void newCommission() {
		String problem = "";
		String expected = "";
		try {
			System.out.println("Enter the employee name: ");
			String name = keyboard.next();
			System.out.println("Enter the employee ID number: ");
			String id = keyboard.next();
			System.out.println("Enter the employee department: ");
			String department = keyboard.next();
			System.out.println("Enter the employee base week salary: ");
			problem = "base week salary";
			expected = "double";
			double baseSalary = keyboard.nextDouble();
			System.out.println("Enter the number of weeks worked: ");
			problem = "number of weeks worked";
			expected = "int";
			int numWeeksWorked = keyboard.nextInt();
			System.out.println("Enter the sales for this week: ");
			problem = "Sales for this week";
			expected = "double";
			double salesThisWeek = keyboard.nextDouble();
			System.out.println("Enter the commission rate: ");
			problem = "commission rate";
			double commissionRate = keyboard.nextDouble();
			System.out.println("Enter the total sales this year: ");
			problem = "total yearly sales";
			double totalYearlySales = keyboard.nextDouble();
			String status = payrollProcessor.newCommission(name, id, department, baseSalary, numWeeksWorked,
					salesThisWeek, commissionRate, totalYearlySales);
			System.out.println(status);
		} catch (InputMismatchException e) {
			System.out.println("Employee was not created: Expected " + expected + " for " + problem);

		}
	}

	// takes in input for what employee to update and how many hours to add to said
	// employee
	private static void updateHourlyEmployee() {
		try {
			System.out.println("Enter the employee ID: ");
			String employeeId = keyboard.next();
			System.out.println("Enter the number of hours worked: ");
			double hoursWorked = keyboard.nextDouble();
			String status = payrollProcessor.updateHourlyEmployee(employeeId, hoursWorked);
			System.out.println(status);
		} catch (InputMismatchException e) {
			System.out.println(
					"Employee was not updated: Expected a double for the number of hours worked but could not find one");
		}
	}

	// takes in in out for what employee to update and sales for that employee
	private static void updateComissionedEmployee() {
		try {
			System.out.println("Enter the employee ID: ");
			String employeeId = keyboard.next();
			System.out.println("Enter the Sales for this week: ");
			double salesThisWeek = keyboard.nextDouble();
			String status = payrollProcessor.updateComissionedEmployee(employeeId, salesThisWeek);
			System.out.println(status);
		} catch (InputMismatchException e) {
			System.out.println("Employee was not updated: Expected a double for sales but could not find one");
		}
	}

	// takes in id for employee to be removed and confirms with user for choice
	private static void removeEmployeeFromPayroll() {
		System.out.println("Enter the employee number you would like to remove");
		String employeeID = keyboard.next();
		String employeeInfo = payrollProcessor.printIndividualInfo(employeeID);
		System.out.println(employeeInfo);
		System.out.println("Are you sure you want to remove this employee? (Yes/No)");
		String answer = keyboard.next();
		String status = "";
		if (answer.equalsIgnoreCase("Yes")) {
			status = payrollProcessor.removeEmployeeFromPayroll(employeeID);
		} else {
			status = "Employee will not be removed";
		}
		System.out.println(status);
	}

	// prints a detailed report for all the information on all employees
	private static void printAllEmployeesReport() {
		String employeeInfo = payrollProcessor.printAllEmployeesReport();
		System.out.println(employeeInfo);
	}

	// prints detailed report for a single employee
	private static void printIndividualInfo() {
		System.out.println("Enter the employee number you want info for: ");
		String employeeID = keyboard.next();
		String info = payrollProcessor.printIndividualInfo(employeeID);
		System.out.println(info);
	}

	// prints the top three commissioned employees based on the weekly earnings
	private static void topCommisionEmployees() {
		String topCommission = payrollProcessor.findTopCommissionEmployees(3);
		System.out.println("The top 3 commision employees are:");
		System.out.println(topCommission);
	}

	// performs end of week updates
	private static void endOfWeekProcessing() {
		String status = payrollProcessor.endOfWeekProcessing();
		System.out.println(status);
	}

	// writes employee data to file when user is finished with program in the format
	// the program can read in.
	private static void writeDataToFile() throws FileNotFoundException {
		payrollProcessor.writeDateToFile();
	}

}
