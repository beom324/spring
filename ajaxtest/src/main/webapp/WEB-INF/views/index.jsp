<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	$(function(){
		var data ;
		$.ajax({
			url : "/listDept",
			success : function(r){
				var data = r
				$.each(data,function(){
					var tr = $("<tr></tr>")
					
					var td1 = $("<td></td>").html(this.dno)
					var td2 = $("<td></td>").html(this.dname)
					var td3 = $("<td></td>").html(this.dloc)
					
					var table = $("#list").append(tr)
					
					table.append(td1,td2,td3)					
				})
			}
		})
	})
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서목록</h2>
	<table border="1" width="80%">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>부서위치</th>
			</tr>				
		</thead>
		<tbody id="list">
		</tbody>
	
	</table>
</body>
</html>