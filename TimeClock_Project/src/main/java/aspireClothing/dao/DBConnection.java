package aspireClothing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance;
	private Connection connection;
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/aspireclothing?user=root&password=";
			connection = DriverManager.getConnection(url);
				System.out.println("Database connection successful!");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Error establishing database connection: " + e.getMessage());
		}
	}
	
	public static synchronized DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
					System.out.println("Database connection closed.");
			} catch (SQLException e) {
				System.err.println("Error closing database connection: " + e.getMessage());
			}
		}
	}

}
