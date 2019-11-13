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
<h3>content</h3>
	<table class="table">
		<thead class="thead-dark">
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax/board/content?cmd=content&bt_num=${param.bt_num}')
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var board = JSON.parse(xhr.responseText);
				var tBody = document.getElementById("tBody");
				var html = '';
				html += '<tr>';
				html += '<th>번호</th>';
				html += '<td>'+board.bt_num+'</td>';
				html += '</tr><tr>';
				html += '<th>제목</th>';
				html += '<td>'+board.bt_title+'</td>';
				html += '</tr><tr>';
				html += '<th>내용</th>';
				html += '<td>'+board.bt_content+'</td>';
				html += '</tr><tr>';
				html += '<th>작성날짜</th>';
				html += '<td>'+board.credat+'</td>';
				html += '</tr><tr>';
				html += '<th>작성시간</th>';
				html += '<td>'+board.cretim+'</td>';				
				html += '</tr><tr>';
				html += '<th>수정날짜</th>';
				html += '<td>'+board.moddat+'</td>';
				html += '</tr><tr>';
				html += '<th>수정시간</th>';
				html += '<td>'+board.modtim+'</td>';
				html += '</tr>';
				html += '<tr>';
				html += '<button onclick="goPage(\'/ajax/update?bt_num=${param.bt_num}\')">수정하기</button>'
				html += '<button onclick="goPage(\'/ajax/list\')">리스트가기</button>'
				html += '</tr>'; 
				tBody.innerHTML = html;
			}
		}
	}
	xhr.send();
}
	
</script>
</body>
</html>