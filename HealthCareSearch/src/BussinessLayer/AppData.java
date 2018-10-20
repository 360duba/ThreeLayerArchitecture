package BussinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DataLayer.DatabaseConnection;
import Application.Person;

public class AppData {

	private static List<Person> people = new ArrayList<Person>();
	
	private static Connection conn = null;

	public AppData(String username,String password) {
		try {
			DatabaseConnection d = new DatabaseConnection();
			d.logIn(username, password);
			conn = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	public List<Person> getPerson() throws SQLException {
		Statement stmt = null;
		Person person = null;
		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			ResultSet result = stmt.executeQuery(
					"SELECT top 10 [Metal Level],[Plan ID (standard component)],[Plan Marketing Name]"
					+ "FROM Sheet1$");
			while (result.next()) {
				person = new Person(result.getString(1), result.getString(2), result.getString(3));
				people.add(person);
			}
			result.close();
			stmt.close();
			conn.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return people;
	}

	public void closeConnection() {
		try {
			if(conn!=null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}