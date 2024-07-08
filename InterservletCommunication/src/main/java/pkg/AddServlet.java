package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws
	IOException, ServletException
	{
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int k = num1 + num2;
		
		
		request.setAttribute("k",k);
		
		RequestDispatcher rd= request.getRequestDispatcher("sq");
		rd.forward(request, response);
		//PrintWriter output = response.getWriter();
		//output.println("The Answer :"+sum);
		
		
		
	
}
}
