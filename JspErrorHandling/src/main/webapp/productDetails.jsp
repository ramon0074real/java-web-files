<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
<jsp:useBean id="product" class="pkg.Product">
<jsp:setProperty name="product" property="*"/>
</jsp:useBean>

<h1>Product Details </h1>
 ID: <jsp:getProperty property="id" name="product"/></br>
 Name: <jsp:getProperty property="name" name="product"/></br>
 Description: <jsp:getProperty property="description" name="product"/></br>
 Price: <jsp:getProperty property="price" name="product"/></br>
</body>
</html>