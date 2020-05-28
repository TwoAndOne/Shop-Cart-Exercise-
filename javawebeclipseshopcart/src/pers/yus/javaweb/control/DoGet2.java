package pers.yus.javaweb.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pers.yus.javaweb.beans.Book;
import pers.yus.javaweb.dao.DBUtils;

/**
 * Servlet implementation class DoGet
 */
@WebServlet("/DoGet2")
public class DoGet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DBUtils dbUtils = new DBUtils();
		HashMap<String, Book> list2 = dbUtils.getAllBook();
			request.getSession().setAttribute("list2", list2);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
