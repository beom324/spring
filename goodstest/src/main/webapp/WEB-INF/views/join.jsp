<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="join" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="id"></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input type="password" name="pwd"></th>
			</tr>
			<tr>
				<th>이름</th>
				<th><input type="text" name="name"></th>
			</tr>
			<tr>
				<th>이메일</th>
				<th><input type="text" name="email"></th>
			</tr>
			<tr>
				<th>전화번호</th>
				<th>
					<select name="phone">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
					</select>
					-
					<input type="text" name="phone" maxlength="4" size="10">
					-
					<input type="text" name="phone" maxlength="4" size="10">
				</th>
			</tr>
							
		</table>
		<input type="submit" value="가입">
	</form>
</body>
</html>	