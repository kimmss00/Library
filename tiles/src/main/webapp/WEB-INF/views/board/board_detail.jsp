<%@page import="bitedu.bipa.tiles.utils.DateCalculation"%>
<%@page import="bitedu.bipa.tiles.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<link href="../resources/css/basic_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#go_board_list').on('click',function(){
			alert('go list');
			$('#frm').attr('action','list.do');
			$('#frm').attr('method','get');
			$('#frm').submit();
		});
	});
</script>
</head>
<body>
<%
	BoardVO board = (BoardVO)request.getAttribute("board");
%>
<form action="" method="get" id='frm'>
	<table>
		<tr>
			<th colspan="4">게시글</th>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title}</td>
			<th>작성일</th>
			<td>${board.date}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
			<th>조회수</th>
			<td>${board.count}</td>
		</tr>
		<tr>
			<td colspan="4">${board.content}</td>
		</tr>
		<tr>
			<td colspan = "4" id="sending">
			<input type="submit" value="목록" id="go_board_list">
			
		</td>
		</tr>
	</table>


</form>
</body>
</html>
