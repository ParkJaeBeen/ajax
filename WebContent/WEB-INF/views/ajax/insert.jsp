<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<h3>게시물 작성</h3>
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" id="bt_title" placeholder="제목을 작성해주세요"></td>
		</tr>
		<tr>
			<th></th>
			<td><textarea id="bt_content" rows="10" cols="50"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="number" id="ut_num"></td>
		</tr>
		<tr>
			<th colspan="2"><button onclick="save()">저장</button></th>
		</tr>
	</table>
</div>
<script>
function save(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/ajax/board/insert');
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				alert(res.msg);
				location.href = res.url;
			}
		}
	}
	var param = {
		bt_title:document.getElementById('bt_title').value,
		bt_content:document.getElementById('bt_content').value,
		ut_num:document.getElementById('ut_num').value
	}
	console.log(param);
	param = JSON.stringify(param);	//구조체 param 을 json 형태의 string 으로 변환
	xhr.send(param);
}
</script>
</body>
</html>