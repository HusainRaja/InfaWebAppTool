<%-- <html>
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
</html> --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<div class="container mt-5">

		<form action="userDetails" method="POST">
			

			<div class="form-group">
				<label for="User name">User name</label> <input type="text"
					class="form-control" id="userName" aria-describedby="emailHelp"
					placeholder="Enter name" name="userName" value="admin" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="emailHelp"
					placeholder="Enter email" name="password" value="admin" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="ORSId">Password</label> 
				<select class="form-control" id="ORSId" name="orsid">
				<option value="pdb-MDM_SAMPLE">MDM Sample</option>
				<option value="pdb-TCR_HUB">TCR Hub</option>
				<option value="pdb-CMX_ORS">CMX ORS</option>
				</select>
			</div>
			
			<p style="color:red;">${status }</p>
			<hr>
			<input name="_csrf" type="hidden" value="6553752c-7997-4915-a508-df03a10f0786" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>