<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Works!</title>
</head>
<body>

<h2>Employee List</h2> 
<form action="employeeLogin" method="post">

	<ul>
	<%
	List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");
		for (Employee employee : employeeList) { %>
		
		<li>
			<%= employee.getEmployeeFirstName() %> - <%= employee.getEmployeeLastName() %> - <%= employee.getEmployeeId() %> 
				<input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
				
				<label for="password">Employee Password:</label>
				<input type="password" name="password" required><br>
	
				<input type="submit" value="Login">
			</li>
			
			<% } %>
	
	</ul>
</form>

</body>
</html>