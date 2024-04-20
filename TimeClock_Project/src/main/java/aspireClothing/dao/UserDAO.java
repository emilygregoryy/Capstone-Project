package aspireClothing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aspireClothing.beans.User;

public class UserDAO {
	private Connection connection;
	
	public UserDAO() {
		connection = DBConnection.getInstance().getConnection();
	}
	
	public User getUserById(int userId) throws SQLException {
		User user = null;
		String query = "SELECT * FROM employees WHERE employeeId = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int employeeId = resultSet.getInt("employeeId");
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					String jobTitle = resultSet.getString("jobTitle");
					String emPassword = resultSet.getString("emPassword");
					int storeNumber = resultSet.getInt("storeNumber");
					String phoneNumber = resultSet.getString("phoneNumber");
					
					user = new User(employeeId, firstName, lastName, jobTitle, emPassword, storeNumber, phoneNumber);
					
				}
			}
		}
		return user;
	}
	
	public boolean validateEmployeesManager(int employeeId, String managerPassword) throws SQLException {
		String query = "SELECT storeNumber FROM employees WHERE employeeId = ?";
		int employeeStoreNumber = -1;
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, employeeId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					employeeStoreNumber = resultSet.getInt("storeNumber");
				}
			}
		}
		query = "SELECT storeNumber FROM employees WHERE emPassword = ? AND jobTitle = 'Manager' ";
		int managerStoreNumber = -1;
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, managerPassword);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					managerStoreNumber = resultSet.getInt("storeNumber");
				}
			}
		}
		return employeeStoreNumber == managerStoreNumber && employeeStoreNumber != -1;
	}
	
	public void updateFirstName(int employeeId, String firstName) throws SQLException {
		String query = "UPDATE employees SET firstName = ? WHERE employeeId = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, firstName);
			statement.setInt(2, employeeId);
			statement.executeUpdate();
		}
	}
	
	public void updateLastName(int employeeId, String lastName) throws SQLException {
		String query = "UPDATE employees SET lastName = ? WHERE employeeId = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, lastName);
			statement.setInt(2, employeeId);
			statement.executeUpdate();
		}
	}
	
	public void updatePassword(int employeeId, String emPassword) throws SQLException {
		String query = "UPDATE employees SET emPassword = ? WHERE employeeId = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, emPassword);
			statement.setInt(2, employeeId);
			statement.executeUpdate();
		}
	}
	
	public void updatePhoneNumber(int employeeId, String phoneNumber) throws SQLException {
		String query = "UPDATE employees SET phoneNumber = ? WHERE employeeId = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, phoneNumber);
			statement.setInt(2, employeeId);
			statement.executeUpdate();
		}
	}
	
	/*
	 * public void close() { try { if (connection != null) { connection.close(); } }
	 * catch (SQLException e) { e.printStackTrace(); } }
	 */

}
