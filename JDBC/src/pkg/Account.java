package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Account 
{
	
public static void main(String[] args) throws SQLException {
		 
Connection connection=DriverManager.getConnection
("jdbc:mysql://localhost:3306/mydb1?useTimezone=true&serverTimezone=UTC", "root", "password@123");
		System.out.println(connection);
	}

}
