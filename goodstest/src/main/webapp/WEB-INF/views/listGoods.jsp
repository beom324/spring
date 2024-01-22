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

<table border="1">
	<tr>
		<th>상품번호</th>
		<th>상품명</th>
		<th>수량</th>
		<th>가격</th>
		<th>사진</th>
	</tr>
	<c:forEach var="g" items="${list}">
	<tr>
		<td>${g.no}</td>
		<td>${g.name }</td>
		<td>${g.qty }</td>
		<td>${g.price }</td>
		<td>${g.fname }</td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>