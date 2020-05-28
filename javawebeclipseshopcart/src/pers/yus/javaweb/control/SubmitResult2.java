package pers.yus.javaweb.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitResult2
 */
@WebServlet("/SubmitResult2")
public class SubmitResult2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc = "123456";
		String pwd = "654321";
		String racc = request.getParameter("phone");
		String rpwd = request.getParameter("pwd");
		System.out.println("phone:"+racc);
		System.out.println("pwd:"+rpwd);
		
		if(acc.equals(racc) && pwd.equals(rpwd)){
			response.getWriter().print("<p>Signing in</p>");
			response.setHeader("refresh", "1,url=/javawebeclipseshopcart/DoGet");
		}
		else
		{
			response.getWriter().print(racc);
			response.getWriter().print(rpwd);
			
			response.getWriter().print("<p>账号或密码错误</p>");
			response.setHeader("refresh", "1,url=/javawebeclipseshopcart/Submit.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
