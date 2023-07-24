<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook Write</title>
</head>
<body>

<form action="create.do" method="post">
<table>
	<tr><td>title :</td><td><input type="text" name="title"></td><td></td></tr>
	<tr><td>content :</td><td><input type="text" name="content" size="80"></td><td></td></tr>
	<tr><td>readCount :</td><td><input type="text" name="readCount" value="0" readonly="readonly"></td><td></td></tr>
	<tr><td>date :</td><td><input type="text" name="date" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="YYYY-MM-dd HH:mm:ss"/>" readonly="readonly"></td><td></td></tr>
	<tr><td>userId :</td><td> <input type="text" name="userId"></td><td></td></tr>
	<tr><td colspan="3"><input type="submit" value="글 작성"></td></tr>
</table>	
</form>

</body>
</html>