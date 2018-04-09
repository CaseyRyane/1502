
public class CommissionDataException extends EmployeeDataException {

	private double baseWeekSalary;
	private double commissionRate;

	public CommissionDataException(double baseWeekSalary, double commissionRate) {
		super("Invalid Commission Employe with base Salary: " + baseWeekSalary + " and commission rate of: "
				+ commissionRate);
		this.baseWeekSalary = baseWeekSalary;
		this.commissionRate = commissionRate;
	}

	public double getBaseWeekSalary() {
		return baseWeekSalary;
	}

	public double getCommissionRate() {
		return commissionRate;
	}
}
