package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


@SuppressWarnings("serial")
public class HelloWorldServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, 
	IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<Html>");
		out.println("<Body>");
		out.println("<h1> Hello world........</h1>");
		out.println("</Body>");
		out.println("</Html>");
	}

}
