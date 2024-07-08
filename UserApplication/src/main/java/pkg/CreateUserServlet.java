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
@WebServlet("/addServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	Statement statement;   
		  public void init() 
		  {
			  try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useTimezone=true&serverTimezone=UTC","root","password@123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println("doPost()");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC", "root","password@123");

			statement = connection.createStatement();
			int result = statement.executeUpdate("insert into user values('"+firstName+"','"+lastName+"','"+email+"','"+password+"')");
		
			PrintWriter out=response.getWriter(); 
			if(result>0)
			{
			out.println("<h1> USER CREATED !!!");
			}
			else {
				out.println("<h1> ERROR CREATING USER  !!!</h1>");

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
