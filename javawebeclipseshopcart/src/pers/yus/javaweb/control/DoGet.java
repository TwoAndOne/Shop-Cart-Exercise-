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
@WebServlet("/DoGet")
public class DoGet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		File file = new File(".");
//		File[] arrfile = file.listFiles();
//		for(File f:arrfile)
//		{
////			System.out.println(f.getName());
////			System.out.println(f.getPath());
//			System.out.println(f.getAbsolutePath());
//		}
		DBUtils dbUtils = new DBUtils();
		HashMap<String, Book> list2 = dbUtils.getAllBook();
//		ConnectDB cdb = new ConnectDB();
//		Connection conn = cdb.getConnection("F:/Program Files/apache-tomcat-9.0.31/webapps/javawebeclipseshopcart/WEB-INF/classes/jdbc.properties");
//		Statement stmt = null;
//		try
//		{
//			stmt = conn.createStatement();
//			String sql = "select * from tb_books";
//			ResultSet rs = stmt.executeQuery(sql);
////			ArrayList<Book> list = new ArrayList<Book>();
//			Map<String,Book> list2 = new HashMap<>();
//		
//			while(rs.next())
//			{
//				Book book = new Book();
//				book.setId(rs.getInt("id"));
//				book.setName(rs.getString("name"));
//				book.setPrice(rs.getDouble("price"));
//				book.setBookCount(rs.getInt("bookCount"));
//				book.setAuthor(rs.getString("author"));
//				list2.put(rs.getInt("id")+"", book);
////				list.add(book);
//				
//			}
//			request.getSession().setAttribute("list2", list);
			request.getSession().setAttribute("list2", list2);
//			rs.close();
			
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally {
//			cdb.closeResource();
//			try
//			{
//				if(stmt != null)
//					stmt.close();
//			}
//			catch (Exception e2)
//			{
//				System.err.println("[Exception]-"+e2.toString());
//			}
//		}
		int start = 1;
		request.getRequestDispatcher("showBook.jsp?start="+start).forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
