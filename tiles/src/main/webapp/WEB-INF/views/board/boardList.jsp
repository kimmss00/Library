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
<title>Board List</title>
<link href="../resources/css/basic_style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Board List</h1>
<div>
<table>
		<tr><th colspan="6" id="title">방명록</th></tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일</td>
			<td></td>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.no}</td>
				<td><a href='view_detail.do?no=${board.no}'>${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.count}</td>
				<td>${board.date}</td>
				<td><a href="remove.do?no=${board.no}">삭제</a></td>
		</c:forEach>
		<tr><td colspan="6"><a href="view_regist.do"><button>등록</button></a>
	</table>
</div>
</body>
</html>