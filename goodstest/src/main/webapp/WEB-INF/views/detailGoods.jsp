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
			<th>상품번호</th>
			<th>${list.no }</th>
		</tr>
		<tr>
			<th>상품명</th>
			<th>${list.name }</th>
		</tr>
		<tr>
			<th>상품가격</th>
			<th>${list.price }</th>
		</tr>
		<tr>
			<th>상품수량</th>
			<th>${list.qty}</th>
		</tr>
		<tr>
			<th>상품사진</th>
			<th><img src="./images/${list.fname }" width="150" height="150"></th>
		</tr>
	</table>
	<a href = "listGoods"> 목록으로</a>
	<a href = "updateGoods?no=${list.no }">상품수정</a>
	
</body>
</html>