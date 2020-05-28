<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pers.yus.javaweb.beans.Book"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchShopCart</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

body {
	color: #656667;
	font-family: "Akzidenz-Grotesk BQ Light";
}

h2 {
	line-height: 1.25;
	font-size: 3.125em;
	font-weight: 300;
	color: #006633;
}
.sub {
	background: #32bd40;
	color: #fff;
	font-size: 1.25em;
	width: 100%;
	line-height: 1.5em;
	outline: none;
	border: none;
}
</style>
</head>

<body>
<h2 align="center">Shoping Cart</h2>
	<table align="center" border="0" cellpadding="5">
		<tr align="center">
			<th>No.</th>
			<th>Book nmae</th>
			<th>Price</th>
			<th>Count</th>
			<%-- 以后可以增加删除的功能，或者减少数量 --%>
		</tr>
		<c:set value="1" var="coun"></c:set>
		<c:forEach items="${cart }" var="cartBook">
			<tr align="center">
				<td><c:out value="${coun }"></c:out></td>
				<c:set value="${coun+1 }" var="coun"></c:set>
				<td>《${cartBook.name }》</td>
				<td>${cartBook.price }</td>
				<td>${cartBook.bookCount }</td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="4">
			<p><c:out value="${coun-1 }" ></c:out> items in total, total price ：${sessionScope.totalPrice }</p>
			</td>
		</tr>
		<tr align="center">
		<tr align="center">
		<td colspan="2">
			<form action="showBook.jsp" method="get" onsubmit="return check(this)">
				<input type="hidden" value="1" name="start">
				<input class="sub" type="submit" value="Continue buy">
			</form>
		</td>
		<td colspan="2">
			<form action="AfterPaid" method="post" onsubmit="return check(this)">
				<input class="sub"  type="submit" value="Confirm payment">
			</form>
		</td>
		</tr>
	</table>
</body>
</html>