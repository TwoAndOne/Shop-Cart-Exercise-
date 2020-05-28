package pers.yus.javaweb.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceUtil
{
	private static Connection conn = null;
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;

	static
	{
		ResourceBundle resource = ResourceBundle.getBundle("jdbc");
		driverClassName = resource.getString("dirveClassName");
		url = resource.getString("url");
		username = resource.getString("username");
		password = resource.getString("password");
		
	}

	public static Connection initConn()
	{
		try
		{
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
			if(conn!=null)
				System.out.println("数据库连接成功！");
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return conn;
	}

	public static void closeConn()
	{
		try
		{
			if (conn != null)
				conn.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
