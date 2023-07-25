<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link href="../resources/css/basic_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Member List</h1>
<table>
	<tr><th colspan="3" id = "title">회원 리스트</th></tr>
	<tr>
		<td>순번</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td></td>
<c:forEach var = "list" items="${list}">
	<tr>
		<td>${list.no}</td>
		<td>${list.id}</td>
		<td>${list.pwd}</td>
</c:forEach>

</table>

</body>
</html>