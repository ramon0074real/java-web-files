<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition JSP File</title>
</head>
<body>
	<%
	int num1= Integer.parseInt(request.getParameter("num1"));
	int num2= Integer.parseInt(request.getParameter("num2"));
	%>
	
	Addition of two numbers is <%=num1+num2 %>
</body>
</html>