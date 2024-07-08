<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Addition of two numbers</title>
</head>
<body>
	<%
	int num1=Integer.parseInt(request.getParameter("num1"));
	int num2=Integer.parseInt(request.getParameter("num2"));
	%>
	<h1>Sum of the two numbers is: <%= num1 + num2 %></h1> 
	<h1>product of the two numbers is: <%= num1 * num2 %></h1>
	<h1>Division of the two numbers is: <%= num1 / num2 %></h1>
	<h1>Subtraction of the two numbers is: <%= num1 - num2 %></h1>   
	
</body>
</html>