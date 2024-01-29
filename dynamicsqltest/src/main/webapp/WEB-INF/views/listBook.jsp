<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="listBook">
	<select name="select">
		<option value="bookname">도서명</option>
		<option value="publisher">출판사</option>
	</select>
	<input type="search" name="search">
	<input type="submit" value="검색">
</form>
<table border="1" width="80%">
<c:choose>
	<c:when test="${search != null && sColumn!= null}">
		<th><a href="listBook?sColumn=bookid&&search=${search }">도서번호</a></th>
			<th><a href="listBook?sColumn=bookname&&search=${search }">도서명</a></th>
			<th><a href="listBook?sColumn=price&&search=${search }">가격</a></th>
			<th><a href="listBook?sColumn=publisher&&search=${search }">출판사</a></th>
	</c:when>
	<c:otherwise>
	<tr>
		<th><a href="listBook?sColumn=bookid">도서번호</a></th>
		<th><a href="listBook?sColumn=bookname">도서명</a></th>
		<th><a href="listBook?sColumn=price">가격</a></th>
		<th><a href="listBook?sColumn=publisher">출판사</a></th>
	</tr>
	</c:otherwise>
</c:choose>
	<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.bookid}</td>
			<td>${list.bookname}</td>
			<td>${list.price}</td>
			<td>${list.publisher}</td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>