<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>도서목록</h1>
<hr>

<table border="1">
	<tr>	
		<th>책번호</th>
		<th>책이름</th>
		<th>가격</th>
		<th>출판사</th>
	</tr>
	<c:forEach var="list" items="${list }">
	<tr> 
		<td style="background : red">${list.bookid }</td>
		<td style="background : orange">${list.bookname }</td>
		<td style="background : yellow">${list.price }</td>
		<td style="background : green">${list.publisher }</td>
	</tr>
	
	</c:forEach>
</table>
</body>
</html>