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
<a href="insertBoard" >등록</a>
<body>
	<table border="1" width="80%">
		<tr >
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>

		<c:forEach var="b"  items="${list}">
			<tr>
				<td>${b.no }</td>
				<td>
					
					<c:if test="${b.b_level > 0 }">
						<c:forEach var="i" begin="1" end="${b.b_level }">
							&nbsp;&nbsp;
						</c:forEach>
						<img src="re.png" width="20" height="20">
					</c:if>
					<a href="detailBoard?no=${b.no }">${b.title }</a>
					
					
				</td>
				<td>${b.writer }</td>
				<td>${b.regdate }</td>
			</tr>			
		</c:forEach>
	</table>
	<a href="insertBoard"> 게시물 등록</a><br>
		<c:forEach var="i" begin="1" end="${totalPage}">
			<a href="listBoard?pageNum=${i}">${i}</a>
		</c:forEach>
</body>
</html>