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
	<table>
		

		<tr>
			<th>부서명</th>
			<th><input type="text" name="dname" value="${list.dname }"></th>
		</tr>	
		<tr>
			<th>부서위치</th>
			<th><input type="text" name="dloc" value="${list.dloc }"></th>
		</tr>	
	
	</table>
	<input type="submit" value="수정">
	</form>
</body>
</html>