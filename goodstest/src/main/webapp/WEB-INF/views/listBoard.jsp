<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>게시판목록</h1>
<hr>
<body>
	<table border="1" width="80%">
		<tr >
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${list}" var="list">
		
		<tr style="text-align:center">
			<td>${list.no }</td>
			<td><a href="detailBoard?no=${list.no}">${list.title }</a></td>
			<td>${list.writer }</td>
			<td><f:formatDate pattern="yyyy-MM-dd" value="${list.regdate }"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>