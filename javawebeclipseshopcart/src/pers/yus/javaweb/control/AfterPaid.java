package pers.yus.javaweb.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.yus.javaweb.beans.Book;
import pers.yus.javaweb.dao.DBUtils;

/**
 * Servlet implementation class AfterPaid
 */
@WebServlet("/AfterPaid")
public class AfterPaid extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.removeAttribute("cart");
//		session.removeAttribute("totalPrice");
//		session.removeAttribute("list2");
		//更新数据库，如果有商品被购买完，那么在数据库进行删除
		//如果仍有存货，那么更新商品数量
		ArrayList<Book> cart = (ArrayList<Book>) request.getSession().getAttribute("cart");
		HashMap<String, Book> list2 = (HashMap<String, Book>) request.getSession().getAttribute("list2");
		DBUtils dbUtils = new DBUtils();
		for(Book book:cart) {
			Book oldBook  = list2.get(book.getId()+"");
			int count = oldBook.getBookCount();
			String id = book.getId()+"";
			if(book.getBookCount()==count) {
				dbUtils.deleteId(id);
			}
			oldBook.setBookCount(count-book.getBookCount());
			dbUtils.updateAndDelete("update tb_books set bookCount="+oldBook.getBookCount()+" where id="+id);
		}
		session.invalidate(); //我猜失效之后，那些属性一定也被失效了
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		response.sendRedirect("/javawebeclipseshopcart/Paid.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
