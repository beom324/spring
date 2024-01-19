<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="updateDept">
<input type="hidden" name="dno" value="${list.dno }">
부서명:<input type="text" name="dname" value="${list.dname }">
부서위치:<input type="text" name="dloc" value="${list.dloc }">
<input type="submit" value="등록하기">
</form>

</body>
</html>