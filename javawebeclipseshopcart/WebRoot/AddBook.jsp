<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddBook.jsp</title>
</head>
<body>
	<!--	通过jsp:useBean 实例化JavaBean对象Book
		通过jsp:setProperty为Book对象中的属性赋值
		在构建book对象后通过JDBC将图书信息写入数据库中
 -->

	<jsp:useBean id="book" class="pers.yus.javaweb.beans.Book" scope="request"></jsp:useBean>
	<!--	property属性中的值设置为"*"的作用
		将与表单中同名的属性值给JavaBean对象中的同名属性
-->
	<jsp:setProperty property="*" name="book" />
	including<br/>

<div align="center">
<p>图书名称：<jsp:getProperty property="name" name="book"/></p>
<p>价格：<jsp:getProperty property="price" name="book"/></p>
<p>数量：<jsp:getProperty property="bookCount" name="book"/></p>
<p>作者：<jsp:getProperty property="author" name="book"/></p>
</div>

	<br>
	<a href="index.jsp">返回</a>
</body>
</html>