
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.high_light{
		background: yellow;
	}
	
	.active{
		background: pink;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	var booklist;
	
	$.ajax({
		url:"/listBook",
		success:function(arr){
			booklist = arr;
			var time = arr.length*500
			console.log(time)
			setInterval(function(){
				$.each(booklist, function (index) {
		            setTimeout(function () {
		                $("#bookname").html(booklist[index].bookname);
		            }, index * 500); 
		        });
			},time)
		}
	})
	
	$("#list").on("mouseenter","tr", function(){
		$("tr").removeClass("high_light");
		$(this).addClass("high_light");
	});
	
	$("#list").on("click","tr", function(){
		$("tr").removeClass("active");
		$(this).addClass("active");
		
		var tdList = $(this).find("td");
		$("#dno").val( $(tdList[0]).html() );
		$("#dname").val( $(tdList[1]).html() );
		$("#dloc").val( $(tdList[2]).html() );
	});
	
	$("#btnDelete").click(function(){
		var re = confirm("정말로 삭제할까요?");
		if(re == true){
			var data = {dno:$("#dno").val()};
			$.ajax({
				url:"deleteDept",
				data:data,
				success:function(r){
					loadDept();
				}
			});
		}
	});
	
	$("#btnUpdate").click(function(){
		var data = $("#f").serializeArray();
		$.ajax({
			url:"updateDept",
			data:data,
			success:function(r){
				loadDept();
			}
		});
		
		$(".input").val("");
		
	});

	
	
	$("#btnInsert").click(function(){
		var data = $("#f").serializeArray();
		$.ajax({
			url:"insertDept",
			data:data,
			success:function(r){
				loadDept();
			}
		});
		
		$(".input").val("");
		
	});
	
	var loadDept = function(){
		$.ajax({
			url:"listDept",
			success:function(arr){
				$("#list").empty();
				$.each(arr, function(){
					var tr = $("<tr></tr>");
					var td1 = $("<td></td>").html(this.dno);
					var td2 = $("<td></td>").html(this.dname);
					var td3 = $("<td></td>").html(this.dloc);
					$(tr).append(td1, td2, td3);
					$("#list").append(tr);
				});
			}
		});
	}
	
	loadDept();
});
</script>
</head>
<body>
	<form id="f">
		부서번호 : <input type="text" name="dno" id="dno" class="input"><br>
		부서이름 : <input type="text" name="dname" id="dname" class="input"><br>
		부서위치 : <input type="text" name="dloc" id="dloc" class="input"><br>		
	</form>
	<button id="btnInsert">등록</button>
	<button id="btnUpdate">수정</button>
	<button id="btnDelete">삭제</button>
	<br><br>
	
	<div id="listBook">
		책이름:<a id="bookname"></a>
	</div>
	<h2>부서목록</h2>
	<table border="1" width="80%">	
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>부서위치</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
			
</body>
</html>

