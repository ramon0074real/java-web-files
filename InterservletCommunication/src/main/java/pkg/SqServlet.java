package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws
	IOException
	{
		int k=(int) request.getAttribute("k");
		 k=k*k;
		
		PrintWriter out = response.getWriter();
		out.println("The square root is = "+ k);
		
		
		
	
}
	
	

}
