package aspireClothing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aspireClothing.beans.User;

public class StoreDAO {
	private Connection connection;
	
	public StoreDAO() {
		connection = DBConnection.getInstance().getConnection();
	}
	
	public boolean validateStoreCredentials(int storeNumber, String storePassword) throws ClassNotFoundException, SQLException {
		
			String query = "SELECT * FROM stores WHERE storeNumber = ? AND storePassword = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, storeNumber);
				statement.setString(2, storePassword);
				
				try (ResultSet resultSet = statement.executeQuery()) {
					return resultSet.next();
				}
			}
	}
	
	public boolean validateEmployeeCredentials(int employeeId, String emPassword) throws SQLException {
		
			String query = "SELECT * FROM employees WHERE employeeId = ? AND emPassword = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, employeeId);
				statement.setString(2, emPassword);
				
				try (ResultSet resultSet = statement.executeQuery()) {
					return resultSet.next();
				}
			}	
	}	
	
	public List<User> getEmployeeList(int storeNumber) throws SQLException {
		List<User> employeeList = new ArrayList<>();
			String query = "SELECT * FROM employees WHERE storeNumber = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, storeNumber);
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
					int employeeId = resultSet.getInt("employeeId");
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					String jobTitle = resultSet.getString("jobTitle");
					String emPassword = resultSet.getString("emPassword");
					int phoneNumber = resultSet.getInt("phoneNumber");
					employeeList.add(new User(employeeId, firstName, lastName, jobTitle, emPassword, storeNumber, phoneNumber));
				}
			}
		}
	return employeeList;

	}
	
	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
