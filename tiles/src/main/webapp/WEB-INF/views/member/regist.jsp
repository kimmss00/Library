<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
 $(document).ready(function(){
	$('#go_login').on('click',function(){
		$('#frm').attr('action','regist.do');
		alert("회원가입이 완료되었습니다.")
		$('#frm').submit();
	});
});

</script>
<body>
<h1>Regist User</h1>
<form action="regist.do" method="post" id="frm">
<table>
<tr>
	<tr>
		<td>순번</td>
		<td><input type="text" name="no" disabled="disabled"></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀 번호</td>
		<td><input type="text" name="pwd" ></td>
	</tr>
	
	<td colsapn="1" id="sending">
		<input type="submit" value="회원가입" id="go_login">
	</td>
</table>
</form>
</body>
</html>