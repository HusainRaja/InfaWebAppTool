<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<%
		String name = (String) request.getAttribute("name");
	%>

	<h1>
		This is the Home Page -
		<%=name%></h1>
</body>
</html>