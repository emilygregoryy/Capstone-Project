<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>

<body>

<h1>AspireClothing Time Clock</h1>

<form action="login" method="post">
	<% String error = (String)request.getAttribute("error");
		if (error != null) { %>
			<p<%= error %> p> 
			<% } %>
			
	<label for="storeId">Store Number:</label>
	<input type="text" id="storeId" name="storeId" required><br>
	
	<label for="password">Store Password:</label>
	<input type="password" id="password" name="password" required><br>
	
	<input type="submit" value="Submit">

</form>
</body>
</html>