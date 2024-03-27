<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="aspireClothing.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>AspireClothing Employees</title>

	<script>
		function updateHiddenInputs() {
			var selectedEmployeeId = document.getElementById("employeeList").value;
			document.getElementById("employeeId").value = selectedEmployeeId;
		}
	</script>
</head>
<body>

<h2>Employee List</h2> 
	<form action="employeeList" method="post">
		<select id="employeeList" name="employeeId" onchange="updateHiddenInputs()">

	<%
	@SuppressWarnings("unchecked")
		List<Employee> employeeList= (List<Employee>)request.getAttribute("employeeList");
			for (Employee employee : employeeList) {
	%>
		<option value="<%= employee.getEmployeeId() %>"><%= employee.getEmployeeFirstName() %> <%= employee.getEmployeeLastName() %></option>
		<% } %>
		</select>
		
		<input type="hidden" id="employeeId" name="employeeId" value="">
		<label for="employeePassword">Employee Password:</label>
		<input type="password" id="employeePassword" name="employeePassword" required>
		<input type="submit" value="Login">

	</form>
</body>
</html>

