
public class SalaryDataException extends EmployeeDataException {

	private double salary;

	public SalaryDataException(double salary) {
		super("Invalid Salary: " + salary + " ");
		this.salary = salary;

	}

	public double getSalary() {
		return salary;
	}
}
