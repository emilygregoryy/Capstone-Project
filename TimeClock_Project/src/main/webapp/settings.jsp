<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acount Settings</title>
<link rel="stylesheet" type="text/css" href="css/settingsStyles.css">
</head>

<body>
<div class="settings-container">
  
  <div class="main-content">
  <h2>Settings</h2>

<div class="topnav">
  <a class="active" href="http://localhost:8080/TimeClock_Project/settings">Account</a>
  <a href="http://localhost:8080/TimeClock_Project/passwordSettings.jsp">Password</a>
  <a href="http://localhost:8080/TimeClock_Project/about.jsp">About</a>
</div>

<div class="employeeInfo">
<form action="/settings" method="get">
<br></br>
  <label for="employeeId">Employee ID</label> <input type="text" id="employeeId" name="employeeId" 
  			value="${employeeId}" readonly><br>
  <label for="firstName">First Name</label> <input type="text" id="firstName" name="firstName"
  			value="${firstName}"><br>
  <label for="lastName">Last Name</label> <input type="text" id="lastName" name="lastName"
			value="${lastName}"><br>
  <label for="phoneNumber">Phone Number</label> <input type="text" id="phoneNumber" name="phoneNumber"
			value="${phoneNumber}"><br>
  <button type="submit" id="applyButton" class="applyButton">Save Changes</button>
</form>
</div>

<p id="empDChange"></p>

<script>
function myFunction() {
  document.getElementById("empDChange").innerHTML = "Changes Saved!";
}
</script>
</div>

</div>
</body>

</html>

