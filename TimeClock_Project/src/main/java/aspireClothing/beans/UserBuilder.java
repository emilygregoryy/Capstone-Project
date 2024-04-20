package aspireClothing.beans;

public class UserBuilder {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String emPassword;
    private int storeNumber;
    private String phoneNumber;

    public UserBuilder(int employeeId, String firstName, String lastName, String emPassword) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emPassword = emPassword;
    }

    public UserBuilder jobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public UserBuilder storeNumber(int storeNumber) {
        this.storeNumber = storeNumber;
        return this;
    }

    public UserBuilder phoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User createUser() {
        return new User(employeeId, firstName, lastName, jobTitle, null, storeNumber, null); 
    }

}