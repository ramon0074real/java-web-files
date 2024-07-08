package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("Text/Html");
		PrintWriter out = response.getWriter();
		//Cookies

		
		//HttpSession
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("user",userName);
		
		out.println("<a href='targetServlet'>Click here to get User Name</a> ");

		
		Cookie [] cookies = request.getCookies();
		
		if(cookies!=null)
		{
			for(int x=0; x<cookies.length; x++)
			{
			System.out.println(cookies[x].getName());
			System.out.println(cookies[x].getValue());
			out.println(cookies[x].getName());
			out.println(cookies[x].getValue());
			
		    }
		}
		
				//URL re-writing
		String url="targetServlet?seesionID=123";
		out.println("<a href='"+url+"'>Click here to get User "
				+ "Name</a> ");
		
	}

}
