

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int num1 = Integer.parseInt(req.getParameter("number1"));
		int num2 = Integer.parseInt(req.getParameter("number2"));
		
		int sum=num1+ num2;
		
		out.println("Addition of the two numbers = " +sum);
		
	}

}
