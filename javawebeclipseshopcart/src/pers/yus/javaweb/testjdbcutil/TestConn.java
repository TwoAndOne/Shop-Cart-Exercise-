package pers.yus.javaweb.testjdbcutil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.yus.javaweb.datasource.DataSourceUtil;

/**
 * Servlet implementation class TestConn
 */
@WebServlet("/TestConn")
public class TestConn extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSourceUtil.initConn();
		DataSourceUtil.closeConn();
	}

}
