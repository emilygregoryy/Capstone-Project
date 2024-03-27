package aspireClothing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TimeClockDAO {
	private final String url = "jdbc:mysql://localhost:3306/aspireclothing?user=root&password=Aspire";
	
	public void clockIn(int employeeId) throws SQLException {
		try (Connection connection = DriverManager.getConnection(url)) {
			String query = "INSERT INTO time_records (employeeId, clock_in_time) VALUES (?, ?)";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, employeeId);
				statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clockOut(int employeeId) throws SQLException {
		try (Connection connection = DriverManager.getConnection(url)) {
			String query = "UPDATE time_records SET clock_out_time = ? WHERE employeeId = ? AND clock_out_time IS NULL";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
				statement.setInt(2, employeeId);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getClockInTime(int employeeId) throws SQLException {
		try (Connection connection = DriverManager.getConnection(url)) {
			String query = "SELECT clock_in_time FROM time_records WHERE employeeId = ? AND clock_out_time IS NULL";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, employeeId);
				
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						return resultSet.getTimestamp("clock_in_time").toString();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return " ";
	}
	
	public String getClockOutTime(int employeeId) throws SQLException {
		try (Connection connection = DriverManager.getConnection(url)) {
			String query = "SELECT clock_out_time FROM time_records WHERE employeeId = ? AND clock_out_time IS NOT NULL";
			
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, employeeId);
				
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						return resultSet.getTimestamp("clock_out_time").toString();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return " ";
	}
}

