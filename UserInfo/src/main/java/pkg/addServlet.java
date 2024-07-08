package pkg;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class addServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	Connection connection;
	
	public void init() 
	{
		
		try {
			 connection = DriverManager.getConnection("\"jdbc:mysql://localhost/mydb?useTimezone=true&serverTimezone=UTC\",\"root\",\"password@123\"");
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();	
		int result = statement.executeUpdate("insert into user values('"+firstName+"','"+lastName+"','"+email+"','"+password+"')");
		
		PrintWriter out=response.getWriter(); 
		if(result>0)
		{
		out.println("<h1> USER CREATED !!!</h1>");
		}
		else {
		out.println("<h1> ERROR CREATING USER  !!!</h1>");

		}
		
		}
		catch (SQLException e) 
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


