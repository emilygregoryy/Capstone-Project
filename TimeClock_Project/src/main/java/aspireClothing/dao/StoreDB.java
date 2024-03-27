package aspireClothing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aspireClothing.Employee;

public class StoreDB {
	private final String url = "jdbc:mysql://localhost:3306/aspireclothing?user=root&password=Aspire";
	
	public boolean validateStoreCredentials(String storeNumber, String storePassword) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection(url)) {
			String query = "SELECT * FROM stores WHERE storeNumber = ? AND storePassword = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, storeNumber);
				statement.setString(2, storePassword);
				
				try (ResultSet resultSet = statement.executeQuery()) {
					return resultSet.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean validateEmployeeCredentials(int employeeId, String emPassword) throws SQLException {
		
		try (Connection connection = DriverManager.getConnection(url)) {
			String query = "SELECT * FROM employees WHERE employeeId = ? AND emPassword = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, employeeId);
				statement.setString(2, emPassword);
				
				try (ResultSet resultSet = statement.executeQuery()) {
					return resultSet.next();
				}
			}
			
		}	
	}
	
	public List<Employee> getEmployeeList(String storeNumber) {
		List<Employee> employeeList = new ArrayList<>();
		
		try (Connection connection = DriverManager.getConnection(url)) {
			String query = "SELECT * FROM employees WHERE storeNumber = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, storeNumber);
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
					int employeeId = resultSet.getInt("employeeId");
					String employeeFirstName = resultSet.getString("firstName");
					String employeeLastName = resultSet.getString("lastname");
					employeeList.add(new Employee(employeeId, employeeFirstName, employeeLastName));
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return employeeList;

	}
}
