
public class DuplicateEmployeeException extends Exception{

	private String idNumber;

	public DuplicateEmployeeException() {
		idNumber = null;
	}

	public DuplicateEmployeeException(String idNumber) {
		super("Invalid Employee: " + idNumber + "An employee already exists with that ID number\n");
		this.idNumber = idNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

}

