<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
 $(document).ready(function(){
	$('#go_login').on('click',function(){
		$('#frm').attr('action','regist.do');
		$('#frm').submit();
	});
});

</script>
<body>
<h1>login</h1>
<form action="login.do" method="POST">
	<input type="text" name="id">
	<input type="password" name="pwd">
	<input type="submit" value="로그인" id = "go_login">
</form>
</body>
</html>