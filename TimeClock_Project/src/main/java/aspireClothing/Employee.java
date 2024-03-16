package aspireClothing;

public class Employee {
	private String employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	
	public Employee(String employeeId, String employeeFirstName, String employeeLastName) {
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

}
