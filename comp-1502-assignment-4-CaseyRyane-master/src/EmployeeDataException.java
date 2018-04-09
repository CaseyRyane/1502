
public class EmployeeDataException extends Exception {

	private String idNumber;

	public EmployeeDataException() {
		idNumber = null;
	}

	public EmployeeDataException(String idNumber) {
		super("Invalid Employee: " + idNumber + ": ");
		this.idNumber = idNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

}
