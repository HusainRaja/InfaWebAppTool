<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Page</title>
</head>
<body>
	<h1>${id }</h1>
	<hr>
	<h1>The numbers are :</h1>
	<c:forEach var="item" items="${numbers }">
		<h3>${item }</h3>
	</c:forEach>
</body>