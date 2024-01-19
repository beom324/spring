<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border ="1">
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서위치</th>
			<th>수정/삭제</th>
		</tr>
		<c:forEach var="list" items="${list }">
		<tr>
			<td>${list.dno}</td>
			<td>${list.dname }</td>
			<td>${list.dloc }</td>
			<td>
				<a href="updateDept?dno=${list.dno }">수정</a>&nbsp;
				<a href="deleteDept?dno=${list.dno }">삭제</a>			
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href="insertDept">부서등록</a>
</body>
</html>