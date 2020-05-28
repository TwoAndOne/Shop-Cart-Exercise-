<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pers.yus.javaweb.beans.Book"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page='<%="/DoGet2"%>'></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showBook.jsp</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

body {
	color: #656667;
	font-family: "Akzidenz-Grotesk BQ Light";
}

caption {
	line-height: 1.25;
	font-size: 2.825em;
	font-weight: 300;
	color: #006633;
}

.sub {
	color: #32bd40;
	outline: none;
	background: #fff;
	border:0;
}
.add{
    background: #32bd40;
    color: #fff;
    font-size: 1.25em;
    width:50%;
    line-height:1.5em;
    outline: none;border: none;
}
</style>
</head>
<body align="center">
	<table align="center" border="0" cellpadding="5">
	<caption>
	Book Storage
	</caption>
		<tr align="center">
			<th>序号</th>
			<th>图书名称</th>
			<th>价格(元)</th>
			<th>数量</th>
			<th>作者</th>
			<th>修改数量</th>
			<th>删除</th>
		</tr>
		<c:set value="1" var="coun"></c:set>
		<c:forEach items="${list2 }" var="book">
			<tr align="center">
				<td><c:out value="${coun }"></c:out></td>
				<c:set value="${coun+1 }" var="coun"></c:set>
				<td>${book.value.name }</td>
				<td>${book.value.price }</td>
				<td>${book.value.bookCount }</td>
				<td>${book.value.author }</td>
				<td>
					<form action="Update" method="post" onsubmit="return check(this);">
						<input type="hidden" name="id" value="${book.key }"> <input
							type="text" name="bookCount" size="3"><input
							type="submit" value="Update" class="sub">
					</form>
				</td>
				<td>
				<form action="Delete" method="post" onsubmit="return check(this);">
						<input type="hidden" name="id" value="${book.key }"> <input
							type="submit" value="Delete" class="sub">
					</form></td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<form action="index.jsp" method="post" onsubmit="return check(this);">
		<input type="submit" value="Add Book" class="add">
	</form>
</body>
</html>