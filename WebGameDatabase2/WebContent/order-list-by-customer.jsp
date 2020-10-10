<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Orders</title>
<link rel="stylesheet" href ="Style/style.css">
</head>
<body>
<form method = "post" action = "orderNavigationServlet">
<table>
<c:forEach items="${requestScope.allOrders}" var="currentOrder">
<tr>
   <td><input type="radio" name="id" value="${currentOrder.id}"></td>
   <td><h2>${currentOrder.orderName}</h2></td></tr>
   <tr><td colspan="3">Order Date: ${currentOrder.orderDate}</td></tr>
   <tr><td colspan="3">Customer: ${currentOrder.customer.customerName}</td></tr>
   <c:forEach var = "orderVal" items = "${currentOrder.listOfGames}">
            <tr><td></td><td colspan="5">
                ${orderVal.name}, ${orderVal.year}, ${orderVal.platforms}, ${orderVal.genre}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToOrder">
<input type = "submit" value = "delete" name="doThisToOrder">
<input type="submit" value = "add" name = "doThisToOrder">
</form>
<a href="addGamesToOrderServlet">Create a new order</a>
<a href="index.html">Add new Game</a>
</body>
</html>