package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/targetServlet")
public class TargetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletResponse response, HttpServletRequest request)throws IOException {
			HttpSession session = request.getSession();
			String user=(String)session.getAttribute("user");
			response.setContentType("Text/Html");
			PrintWriter out =response.getWriter();
			out.println("Hello "+user);
		}
}
