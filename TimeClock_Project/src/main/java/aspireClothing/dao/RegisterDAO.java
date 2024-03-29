package aspireClothing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import aspireClothing.beans.User;

public class RegisterDAO {
	
	public boolean registerUser(User employee) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DBConnection.getInstance().getConnection();

            String insertQuery = "insert into employees values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
			
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getLastName());
			statement.setString(4, employee.getJobTitle());
			statement.setString(5, employee.getEmPassword());
			statement.setInt(6, employee.getStoreNumber());
			statement.setInt(7, employee.getPhoneNumber());
			
			int rowsAffected = statement.executeUpdate();
			return rowsAffected > 0;
			
		} catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
            
            return false;
		}
	    
	}

}
