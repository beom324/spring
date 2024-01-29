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

<table>
	<tr>
		<th>부서번호</th>
		<th>부서명</th>
		<th>부서위치</th>
	</tr>
	<c:forEach var="list" items="${list}">
		<tr>
			<th>${list.dno}</th>
			<th>${list.dname}</th>
			<th>${list.dloc}</th>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>