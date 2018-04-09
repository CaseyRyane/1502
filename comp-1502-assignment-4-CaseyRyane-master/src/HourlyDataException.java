
public class HourlyDataException extends EmployeeDataException {

	private double hourlyPay;
	private double hoursWorked;

	public HourlyDataException(double hourlyPay, double hoursWorked) {
		super("Invalid Hourly Employee with hourly pay: " + hourlyPay + " and hours worked: " + hoursWorked);
		this.hourlyPay = hourlyPay;
		this.hoursWorked = hoursWorked;
	}
	
	public HourlyDataException(double hoursWorked) {
		super("Invalid Hourly Employee with hours worked: " + hoursWorked);
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}
}
