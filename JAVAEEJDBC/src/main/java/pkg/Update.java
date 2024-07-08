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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String IQ1=("UPDATE USER SET PASSWORD=? WHERE EMAIL=?");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//final String IQ="UPDATE USER SET PASSWORD= '"+password+"' WHERE EMAIL= '"+email+"'";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con=DriverManager.getConnection("jdbc:mysql:///info?useTimezone=true&serverTimezone=UTC","root","password@123");
				PreparedStatement ps=con.prepareStatement(IQ1);
				Statement statement = con.createStatement();)
		{
			ps.setString(2, email);
			ps.setString(1, password);
			int result=ps.executeUpdate();
//			Statement statement = con.createStatement();
			//int result = statement.executeUpdate("UPDATE USER SET PASSWORD= '"+password+"' WHERE EMAIL= '"+email+"' ");
		
			
			if(result>0)
			{
			out.println("<h1> PASSWORD UPDATED !!!");
			}
			else {
				out.println("<h1> ERROR UPDATING PASSWORD  !!!</h1>");

			}
			
			
		} 
		catch (SQLException se) {
			out.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
			
		}
		out.close();
			

}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
