<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>

<h1>AspireClothing Time Clock</h1>

<form action="login" method="post">
	<% String error = (String)request.getAttribute("error");
		if (error != null) { %>
			<p<%= error %> p> 
			<% } %>
			
	<label for="storeNumber">Store Number:</label>
	<input type="text" id="storeNumber" name="storeNumber" required><br>
	
	<label for="storePassword">Store Password:</label>
	<input type="password" id="storePassword" name="storePassword" required><br>
	
	<input type="submit" value="Submit">

</form>
</body>
</html>

