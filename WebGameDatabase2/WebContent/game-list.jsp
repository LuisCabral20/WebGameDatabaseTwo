<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Database</title>
<link rel="stylesheet" href ="Style/style.css">
</head>
<body>
	<h1>All Games</h1>
	<form method="post" action = "navigationServlet">
		<table>
		<c:forEach items="${requestScope.allGames}" var="currentitem">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.name}</td>
			<td>${currentitem.year}</td>
			<td>${currentitem.platforms}</td>
			<td>${currentitem.genre}</td>
			</tr>
		</c:forEach>
		</table>
		<input type="submit" value ="edit" name="doThisGame">
		<input type="submit" value ="delete" name="doThisGame">
		<input type="submit" value ="add" name="doThisGame">
	</form>
</body>
</html>