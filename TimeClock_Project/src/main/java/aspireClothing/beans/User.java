package aspireClothing.beans;

public class User {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String jobTitle;
	private String emPassword;
	private int storeNumber;
	private int phoneNumber;
	
	public User(int employeeId, String firstName, String lastName, String jobTitle,
						String emPassword, int storeNumber, int phoneNumber) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.emPassword = emPassword;
		this.storeNumber = storeNumber;
		this.phoneNumber = phoneNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmPassword() {
		return emPassword;
	}

	public void setEmPassword(String emPassword) {
		this.emPassword = emPassword;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
	

