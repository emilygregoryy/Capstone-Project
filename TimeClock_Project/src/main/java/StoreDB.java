
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDB {
	private final String url = "jdbc:mysql://localhost:3306/aspireclothing?useSSL=false&serverTimezone=UTC";
	private final String dbUsername = "root";
	private final String dbPassword = "Aspire";
	
	public boolean validateStoreCredentials(String storeNumber, String storePassword) {
		try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)){
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
			return false;
		}
	}
	
	public List<Employee> getEmployeeList(String storeNumber) {
		List<Employee> employeeList = new ArrayList<>();
		
		try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			String query = "SELECT * FROM employees WHERE storeNumber = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, storeNumber);
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
					String employeeId = resultSet.getString("employeeId");
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
