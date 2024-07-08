package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/FiltersServlet")

public class filterClass implements Filter{

public void init(FilterConfig filterConfig)throws ServletException
	    {
	    }
@Override
public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
	        throws IOException, ServletException
	    {
	 
	        PrintWriter out = response.getWriter();
	 
	        // This will print output on console
	   System.out.println("Before filter - Preprocessing before servlet");
	 
	        // some authentication if required
	        chain.doFilter(request, response);
	       
	        // This will print output on console
System.out.println("After servlet - "
		+ "Following code will execute after running the servlet - PostProcessing");
	    }
	 
	    public void destroy() {}
	}