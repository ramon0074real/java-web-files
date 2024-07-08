package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
 

@WebServlet("/GFGServlet")

public class GFGFilter implements Filter {
 
    public void init(FilterConfig filterConfig)
        throws ServletException
    {
    }
 
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
        throws IOException, ServletException
    {
 
        PrintWriter out = response.getWriter();
 
        // This will print output on console
        System.out.println(
            "Before filter - Preprocessing before servlet");
 
        // some authentication if required
        chain.doFilter(request, response);
       
        // This will print output on console
        System.out.println(
            "After servlet - Following code will execute after running the servlet - PostProcessing");
    }
 
    public void destroy() {}
}