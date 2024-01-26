<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="insertBoard" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${no}">
	제목 : <input type="text" name="title"><br>
	작성자 : <input type="text" name="writer"><br>
	비밀번호 <input type="password" name="pwd"><br>
	첨부파일<input type="file" name="uploadFile"><br>
	내용	<textarea rows="30" cols="30" name="content"></textarea><br>
	
	<input type="submit" value="작성">
	
</form>
</body>
</html>