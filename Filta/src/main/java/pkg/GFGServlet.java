package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet implementation class GFGServlet
@WebServlet("/GFGServlet")
public class GFGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @see HttpServlet#HttpServlet()
	public GFGServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	// @see HttpServlet#doGet(HttpServletRequest request,
	// HttpServletResponse response)
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome to the Servlet.");
		// This will print output on console
		System.out.println("GFGServlet is running");
	}

	// @see HttpServlet#doPost(HttpServletRequest request,
	// HttpServletResponse response)
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
