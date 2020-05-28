package pers.yus.javaweb.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.yus.javaweb.beans.Book;
import pers.yus.javaweb.dao.DBUtils;

/**
 * Servlet implementation class AddBook
 */
@WebServlet(urlPatterns = {"/AddBook"})
public class AddBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddBook.java");
		
		Book book = new Book();
		String name = request.getParameter("name");
		Double price = Double.valueOf(request.getParameter("price"));
		int bookCount = Integer.valueOf(request.getParameter("bookCount"));
		String author = request.getParameter("author");
		book.setName(name);
		book.setPrice(price);
		book.setBookCount(bookCount);
		book.setAuthor(author);
		String sql = "insert into tb_books(name,price,bookCount,author) values(?,?,?,?)";
		DBUtils dUtils = new DBUtils();
		dUtils.insertRecord(book, sql);
		response.getWriter().print("<script> alert(\"添加成功! \");</script>");
		response.setHeader("refresh", "1,url=/javawebeclipseshopcart/index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
