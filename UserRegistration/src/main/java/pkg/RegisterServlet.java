package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
private static final String IQ="INSERT INTO USER(FIRSTNAME,LASTNAME,EMAIL,PASSWORD) VALUES(?,?,?,?)";
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{ 
		 PrintWriter out = res.getWriter();
         res.setContentType("text/html");
		String fname=req.getParameter("firstName");
		String lname=req.getParameter("lastName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
	try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///mydb?useTimezone=true&serverTimezone=UTC",
		"root","password@123");PreparedStatement ps=con.prepareStatement(IQ);)
		{
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			
			int count=ps.executeUpdate();
			if(count==0) {
				out.print("Failed to store values in the database");
			}else {
				out.print("Success");
			}
			
		} catch (SQLException se) 
		{
			out.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e) 
		{
			out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		doGet(req, res);
	}
}