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

@WebServlet("/add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String IQ="INSERT INTO USER1(NAME,ADDRESS,EMAIL,PHONE,DOB,PASSWORD) VALUES(?,?,?,?,?,?)";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		
		String name= req.getParameter("name");
		String address= req.getParameter("address");
		String email= req.getParameter("email");
		String phone= req.getParameter("phone");
		String dob= req.getParameter("dob");
		String password= req.getParameter("password");
		
		//System.out.println(name +address+email + phone+ dob +password);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///mydb"
				+ "?useTimezone=true&serverTimezone=UTC","root","password@123"); 
				PreparedStatement ps=con.prepareStatement(IQ);)
					
		{
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, dob);
			ps.setString(6, password);
			
			int result= ps.executeUpdate();
			
			if(result==0) {
				out.println("Record not Stored into Database ");
			}else {
				out.println("Record Stored into Database ");
			}
			
		} 
		
		catch (SQLException se) {
			out.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
