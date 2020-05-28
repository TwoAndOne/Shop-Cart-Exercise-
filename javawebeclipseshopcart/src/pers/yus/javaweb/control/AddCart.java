package pers.yus.javaweb.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.yus.javaweb.beans.Book;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String[] checked = request.getParameterValues("check");
		String paramNum = request.getParameter("num");
		int num = 1;
		if(paramNum!=null) {
			num = Integer.valueOf(paramNum);
		}
		if (checked == null)
		{
			response.sendRedirect("/javawebeclipseshopcart/showBook.jsp");
		}

		HttpSession session = request.getSession();
		ArrayList<Book> cart = (ArrayList<Book>) session.getAttribute("cart");
		Double totalPrice = (Double) session.getAttribute("totalPrice");
		if (cart == null)
		{
			cart = new ArrayList<>();
		}
		if(totalPrice == null)
		{
			totalPrice = (double) 0;
		}
//		ArrayList<Book> list2 = (ArrayList<Book>) session.getAttribute("list2");
		Map<String, Book> list2 = (HashMap<String, Book>) session.getAttribute("list2");
		for (String i : checked)
		{
			//判断库存是否充足,如果库存少于想要购买的数量，则不进行加入购物车的动作
			Book oldBook = list2.get(i);
			if(oldBook.getBookCount() < num) {
				continue;
			}
			//判断准备加入购物车的书籍是否已经存在与购物车中
			System.out.println(totalPrice);
			boolean flag = false;
			for(Book checkedBook:cart)
			{
				//如果已经存在，那么只需要把购物车中该书籍的数量增加即可
				if(Integer.valueOf(i).equals(checkedBook.getId())) {
//					System.out.println(checkedBook.getName()+" id:"+checkedBook.getId()+" i:"+ i);
					checkedBook.setBookCount(checkedBook.getBookCount()+num);
					flag = true;
					totalPrice += checkedBook.getPrice() * num;
					break;
				}	
			}
			if(flag)
				continue;
			//如果不存在，在库存中找到该书籍并克隆进购物车，设置正确的数量
			Book book = (Book) oldBook.clone(); // 浅克隆
			book.setBookCount(num); // 获取书籍的数量，现在是1，以后再改
			cart.add(book);
			totalPrice += book.getPrice() * num;
			System.out.println(book.getName());
		}
		session.setAttribute("cart", cart);
		session.setAttribute("totalPrice", totalPrice);
		request.getRequestDispatcher("searchShopCart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
