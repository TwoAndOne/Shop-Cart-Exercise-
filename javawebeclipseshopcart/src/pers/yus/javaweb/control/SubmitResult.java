package pers.yus.javaweb.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SubmitResult")
public class SubmitResult extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String randStr = (String)session.getAttribute("randStr");
		PrintWriter out = response.getWriter();
		if(!code.equals(randStr)) {
			System.out.println("code.equals(randStr)");
			out.print("<script> alert(\"验证码错误! \");</script>");
			response.setHeader("refresh", "2,url=/javawebeclipseshopcart/Submit.jsp");
		}
		else {
			String acc = "123456";
			String pwd = "654321";
			String admin = "admin";
			String adminPwd = "admin";
			String racc = request.getParameter("account");
			String rpwd = request.getParameter("password");
			System.out.println("phone:"+racc);
			System.out.println("pwd:"+rpwd);
			System.out.println("admin:"+admin);
			System.out.println("adminPwd:"+adminPwd);
			
			if(acc.equals(racc) && pwd.equals(rpwd)){
				response.getWriter().print("<p>Signing in</p>");
				response.setHeader("refresh", "1,url=/javawebeclipseshopcart/DoGet");
			}
			else if (admin.equals(racc) && adminPwd.equals(rpwd)) {
				
				response.setHeader("refresh", "1,url=/javawebeclipseshopcart/bookStorage.jsp");
			}
			else
			{
				response.getWriter().print("<script> alert(\"账号或密码错误! \");</script>");
				response.setHeader("refresh", "1,url=/javawebeclipseshopcart/Submit.jsp");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
