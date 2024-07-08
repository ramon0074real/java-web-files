package pkg;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/updateServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
       
		  public void init() 
		  {
			  try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC", "root","password@123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("doPost()");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC", "root","password@123");
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("update user set password= '"+password+"' where email= '"+email+"' ");
		
			PrintWriter out=response.getWriter(); 
			if(result>0)
			{
			out.println("<h1> PASSWORD UPDATED !!!");
			}
			else {
				out.println("<h1> ERROR UPDATING PASSWORD  !!!</h1>");

			}
			
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		
	}
	
			public void destroy() 
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

}
