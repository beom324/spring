<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품상세</h1>
	<hr>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>${list.no }</th>
		</tr>
		<tr>
			<th>글제목</th>
			<th>${list.title }</th>
		</tr>
		<tr>
			<th>작성자</th>
			<th>${list.writer }</th>
		</tr>
		<tr>
			<th>등록일</th>
			<th>${list.regdate}</th>
		</tr>
		<tr>
			<th>ip주소</th>
			<th>${list.ip}</th>
		</tr>
		<tr>
			<th>첨부파일</th>
			<th>${list.fname}</th>
		</tr>
		<tr>
			<th>조회수</th>
			<th>${list.hit}</th>
		</tr>
		
	</table>
	<textarea rows="20" cols="50" readonly>${list.content }</textarea><br>
	<a href="listBoard">목록으로</a>
	
	
</body>
</html>