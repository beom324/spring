<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#box_check,#f{
		display:none;
	}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	$(function(){
		var code;
		var email;
		$("#btnSendEmail").click(function(){
			email = $("#email").val();
			var data = {email:email};
			$.ajax({
				url:"sendCodeEmail",
				data:data,
				success:function(r){
					code = r;
					console.log(r);
					$("#box_check").css("display","block");
				}
			})
			
		})
		
		$("#btnCheckNum").click(function(){
			var input = $("#checkNum").val();
			if(code == input){
				$("#f").css("display","block")
				$(".check").css("display","none")
			}
			else{
				alert("인증코드가 일치하지 않습니다")
			}
		})
	});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<div id="box_email" class="check">
		이메일 : <input type="email" id="email" name="email">
		<button id="btnSendEmail">인증</button>
	</div>
	
	<div id="box_check" class="check">
		인증번호 입력 : <input type="text" id="checkNum" name="checkNum">
		<button id="btnCheckNum">확인</button>
	</div>
	
	
	<form action="join" method="post" id="f">
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
				<th><input type="text" name="email" id="email2"></th>
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