<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pers.yus.javaweb.beans.Book"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h2 align="center">Welcome to buy books</h2>
	<table align="center" border="0" cellpadding="5">
		<tr align="center" style="color: #006633">
			<th>No. &nbsp&nbsp&nbsp&nbsp </th>
			<th>&nbsp Name &nbsp&nbsp&nbsp&nbsp</th>
			<th >Price&nbsp&nbsp</th>
			<!-- 
			<th>数量</th>
			<th>作者</th>
			 -->
			<th>Buy&nbsp</th>
		</tr>
		<c:set value="${param.start }" var="start"></c:set>
		<c:set value="${start*10-9 }" var="begin"></c:set>
		<c:set value="${start*10 }" var="end"></c:set>

		<c:if test="${end > fn:length(list2) }">
			<c:set value="${fn:length(list2) }" var="end"></c:set>
		</c:if>
		<c:set value="${begin }" var="coun"></c:set>

		<form action="AddCart" method="post" onsubmit="return check(this);">

			<c:forEach items="${sessionScope.list2 }" var="book" begin="${begin }"
				end="${end }">
				<tr align="center">
					<td><c:out value="${coun }"></c:out></td>
					<c:set value="${coun+1 }" var="coun"></c:set>
					<td style="color: #116149">&nbsp《${book.value.name }》 <sub> <a
							href="Detail.jsp?id=${book.key }&name=${book.value.name }&price=${book.value.price}&bookCount=${book.value.bookCount}&author=${book.value.author}">more</a>
					</sub>&nbsp&nbsp&nbsp&nbsp
					</td>
					<td>${book.value.price }&nbsp&nbsp&nbsp</td>
					<!-- 
		<td>${book.value.bookCount }</td>s
		<td>${book.value.author }</td>
		 -->
					<td>
						<!-- <input type="hidden" name="id" value="${book.value.id }">  -->

						<!-- <input type="text" name="bookCount"  placeholder="1"> --> <input
						name="check" type="checkbox" value="${book.key }">
					</td>
				</tr>
			</c:forEach>
		<tr align="center">
			<td colspan="6"><c:set value="${fn:length(list2)/10+1 }"
					var="pageCount"></c:set> <c:set value="1" var="i"></c:set> <c:forEach
					begin="1" end="${pageCount }">
					<c:if test="${i==start }">
						<c:out value="${i }"></c:out>
					</c:if>
					<c:if test="${i!=start }">
						<a href='showBook.jsp?start=${i }'><c:out value="${i }"></c:out></a>
					</c:if>
					<c:set value="${i+1 }" var="i"></c:set>
				</c:forEach></td>
		</tr>
		<tr align="center">
			<td colspan="6"><input class="sub" type="submit"
				value="Add Cart"></td>
		</tr>
		</form>
	</table>
</body>
</html>