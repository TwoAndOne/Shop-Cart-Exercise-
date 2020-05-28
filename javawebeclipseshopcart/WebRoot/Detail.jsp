<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail.jsp</title>
<style>
body{
color:#656667;
font-family: "Akzidenz-Grotesk BQ Light";  
}
h1{
    line-height:1.25;
    font-size: 4.5em;
    font-weight: 300;
}
p{font-weight:normal;font-size:1.5em;}
.paid,.back{
    background: #32bd40;
    color: #fff;
    font-size: 1.25em;
    width:50%;
    line-height:1.5em;
    outline: none;border: none;
}
.num{
	width:4%
}
</style>
</head>
<body align="center">
	<br />
	<br />
	<h1 style="color:#006633 ">Detail</h1>
	<p>书名：${param.name }</p>
	<p>价格： ${param.price }</p>
	<p>作者： ${param.author }</p>
	<form action="AddCart" method="post">
	<p>
		库存： ${param.bookCount } 
	</p>
	<p>
		<input type="hidden" name="check" value=${param.id }>
		购买数量：
		<input type="text" class="num" name="num">
	</p>
	<input type="submit" class="paid" value="Add cart" >
	</form>
	<br/>
	<br/>
	<form action="showBook.jsp" method="post" onsubmit="return check(this)">
	<input type="hidden" name="start" value="1">
	<input type="submit" class="back" value="Back">
	</form>
</body>
</html>