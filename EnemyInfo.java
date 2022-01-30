import java.sql.*;
public class EnemyInfo {
	public static void main(String[] args) throws SQLException {
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();	
		){
			String sql = "CREATE DATABASE ENEMIES";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
