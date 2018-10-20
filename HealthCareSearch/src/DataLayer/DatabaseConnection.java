package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConnection {

	private static Connection conn;
	private static String username;
	private static String password;
	public static Connection getConnection() throws SQLException {

		if (conn == null || conn.isClosed()) {
			conn = CreateNewConnection();
		}
		return conn;
	}
	public void logIn(String username,String password) {
		DatabaseConnection.username=username;
		DatabaseConnection.password=password;
	}
	private static Connection CreateNewConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=HealthCare", username, password);
		} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "账号密码错误","消息提示",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
			System.exit(0);
		}
		return conn;
	}

}