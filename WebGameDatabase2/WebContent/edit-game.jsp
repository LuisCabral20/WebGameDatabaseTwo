<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" href ="Style/style.css">
</head>
<body>
	<form action ="editGameServlet" method="post">
		<p><label for="name">Name: </label><input type ="text" name ="name" value="${gameToEdit.name}"></p>
		<p><label for="year">Year: </label><input type ="text" name ="year" value="${gameToEdit.year}"></p>
		<p><label for="platforms">Platforms: </label><input type ="text" name ="platforms" value="${gameToEdit.platforms}"></p>
		<p><label for="genres">Genre: </label><input type ="text" name ="genres" value="${gameToEdit.genre}"></p>
		
		<input type ="hidden" name ="id" value="${gameToEdit.id}">
		<p><label></label><input type ="submit" value="Save Edited Game"></p>
	</form>
</body>
</html>