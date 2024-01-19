<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/insertDept">
	<table>
		<tr>		
		<th>부서번호</th>
		<th><input type="text" name="dno"></th>
		</tr>
		<tr>
			<th>부서명</th>
			<th><input type="text" name="dname"></th>
		</tr>	
		<tr>
			<th>부서위치</th>
			<th><input type="text" name="dloc"></th>
		</tr>	
	
	</table>
	<input type="submit" value="등록">
	</form>
	
</body>
</html>