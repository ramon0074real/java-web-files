package pkg;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;
import java.io.PrintWriter;



public class Filterz extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, 
			Filter chain) throws IOException, ServletException {
			PrintWriter out = response.getWriter();	
			
			out.println("Before Servlet");
			chain.doFilter(request, response, null);
			out.println("After Servlet");
	}

	
}
