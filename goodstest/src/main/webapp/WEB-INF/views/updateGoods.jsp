<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품등록</h2>
	<hr>
	<form action="updateGoods" method="post" enctype="multipart/form-data">
		상품번호 : <input type="number" name="no" value="${list.no}" readonly> <br>
		상품명 : <input type="text" name="name" value="${list.name }"><br>
		상품가격 : <input type="number" name="price" value="${list.price }"><br>
		상품수량 : <input type="number" name="qty" value=${list.qty }><br>
		<input type="hidden" name="fname" value=${list.fname }>
		<img src="images/${list.fname }" width="50" height="50"><br>
		상품사진 : <input type="file" name="uploadFile"><br> 
		
		<input type="submit" value="수정">
		<input type="reset" value="다시입력">
		 
	</form>
</body>
</html>