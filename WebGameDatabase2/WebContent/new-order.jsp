  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Order</title>
<link rel="stylesheet" href ="Style/style.css">
</head>
<body>
<form action = "createNewOrderServlet" method="post">
<p><label for ="orderName">Order Name:</label></p> 			<input type ="text" name = "orderName"><br />
<p><label for ="month">Order date:</label></p> 				<input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4"><input type ="text" name = "year" placeholder="yyyy" size="4">
<p><label for ="customerName">Customer Name:</label></p> 	<input type = "text" name = "customerName"><br />

<p><label for ="allGamesToAdd">Available Games:</label></p>

<select name="allGamesToAdd" multiple size="10">
<c:forEach items="${requestScope.allGames}" var="currentgame">
   <option value = "${currentgame.id}">${currentgame.name} | ${currentgame.year} | ${curentgame.platforms} | ${currentgame.genre}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create Order and add games">
</form>
<a href = "index.html">Go add new games instead.</a>
</body>
</html>