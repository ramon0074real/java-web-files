package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static java.sql.Connection connection;

	public void init() {
		try {
			System.out.println("init()");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection
		("jdbc:mysql:///mydb?useTimezone=true&serverTimezone=UTC","root","password@123");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} }
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException,
			IOException {
		//System.out.println("doPost()");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			java.sql.Statement statement = connection.createStatement();
			int result =  statement.executeUpdate("update user1 set "
					+ "password='"+password+"' where email='"+email+"'");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.print("<H1>Password Updated</H1");
			} else {
				out.print("<H1>Error Creating the User</H1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void destroy() {
		try {
			System.out.println("destroy()");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
