package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
			String userName = request.getParameter("username");
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			 
			response.setContentType("Text/Html");
			PrintWriter out = response.getWriter();
			out.println("<a href='targetServlet'>Click here to "
					+ "view your Username</a>");
	}
		
}


