<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="login" method="post">
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"> <!-- 모든 폼태그 사용시 필요 -->
아이디 : <input type="text" name="username"><br>
비밀번호 : <input type="password" name="password"><br>
<input type="submit" value="로그인">
</form>
</body>
</html>