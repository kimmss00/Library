<%@page import="bitedu.bipa.tiles.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 등록</title>
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
		
		$('#go_board_regist').on('click',function(){
			alert('regist');
			$('#frm').attr('action','regist.do');
			$('#date').val(new Date().toISOString());
			$('#frm').submit();
		});
		
		
	});
</script>
</head>
<body>
<form action="" method="get" id="frm">

<table>
<tr><th colspan = "2" id="form">방명록 등록</th></tr>
	<tr>
		<td>번호</td>
		<td><input type="text" name="no" disabled="disabled"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" ></td>
	</tr>
	
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer"></td>
	</tr>
	<tr>
		<th colspan="2">내용</th>
	</tr>
	<td colspan="2">
	<textarea name="content" rows="10" style="width:100%; border: 0; resize: none;"></textarea>
	</td>
	<tr>
		<td colspan = "2" id="sending">
			<input type="submit" value="등록" id="go_board_regist">
			<input type="submit" value="취소" id="go_board_list">
		</td>
	</tr>
</table>
</form>
	
</body>
</html>