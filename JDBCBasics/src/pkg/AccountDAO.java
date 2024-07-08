package pkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class AccountDAO
{
	public static void main(String[] args) 
	{
		try {
Connection connection = DriverManager.getConnection
("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC","root","password@123");
			System.out.println(connection);
			Statement statement = connection.createStatement();
//			int update = statement.executeUpdate("insert into account values(1,'Ade','Bayo',70000)");
//		System.out.println(update + " inserted successfully");
			int update = statement.executeUpdate("update account set bal=1000000 where accno=1");
			System.out.println(update + " roles Updated successfully");
			int update = statement.executeUpdate("delete from account where accno=1");
			System.out.println(update + " roles Deleted successfully");
			ResultSet rs = statement.executeQuery("select * from account");
			while(rs.next())
			{
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getString(3) + " ");
				System.out.println(rs.getInt(4));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
}
