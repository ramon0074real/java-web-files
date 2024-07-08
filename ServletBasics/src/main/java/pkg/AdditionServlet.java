package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException 
	{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		if(req.getParameter("number1")!=null && req.getParameter("number2")!= null) 
		{
			int num1 = Integer.parseInt(req.getParameter("number1"));
			int num2 = Integer.parseInt(req.getParameter("number2"));
			
			
			out.println("Addition of the two numbers = " + (num1+num2));
			
		}
		else {
			out.println("Input some numbers please");
		}
	}

}
