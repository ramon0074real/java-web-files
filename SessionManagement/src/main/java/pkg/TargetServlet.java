package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/targetServlet")

public class TargetServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	//Cookies

	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i<cookies.length;i++)
	{
		System.out.println(cookies[i].getName());
		System.out.println(cookies[i].getValue());
	}
	
		response.addCookie(new Cookie("securityToken","123456"));
		
		
		// HttpSession
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("user");
		
		
		response.setContentType("Text/Html");
		PrintWriter out = response.getWriter();
		out.println("<H1>Username is " +  userName +"</H1>");
}
}