<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="aspireClothing.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AspireClothing Employees</title>
</head>
<body>

<h2>Employee List</h2> 
<form action="employeeList" method="post">

	<ul>
	<%
	@SuppressWarnings("unchecked")
		List<aspireClothing.Employee> employeeList= (List<aspireClothing.Employee>)request.getAttribute("employeeList");
			for (aspireClothing.Employee employee : employeeList) {
	%>
		
		<li>
			<%= employee.getEmployeeFirstName() %> - <%= employee.getEmployeeLastName() %> - <%= employee.getEmployeeId() %> 
				<input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
				
				<label for="storePassword">Employee Password:</label>
				<input type="password" name="storePassword" required><br>
	
				<input type="submit" value="Login">
			</li>
			
			<% } %>
	
		</ul>
	</form>
</body>
</html>

