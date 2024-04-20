<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Settings</title>
<link rel="stylesheet" type="text/css" href="css/settingsStyles.css">
</head>

<body>
<div class="settings-container">

  
  <div class="main-content">
  <h2>Settings</h2>

<div class="topnav">
  <a href="http://localhost:8080/TimeClock_Project/settings.jsp">Account</a>
  <a class="active" href="http://localhost:8080/TimeClock_Project/passwordSettings.jsp">Password</a>
  <a href="http://localhost:8080/TimeClock_Project/about.jsp">About</a>
</div>

<div class="employeeInfo">
<form action="passwordSettings" method="post">
<br></br>
  <label for="employeeId">Employee ID</label> <input type="text" id="employeeId" name="employeeId" 
  			value="${employeeId}" readonly><br>
  <label for="password">Password</label> <input type="text" id="password" name="password" 
  			value="*********" readonly><br>
  			
  <h3>Change Password</h3>
 
  <label for="newPassword">New Password</label> <input type="text" id="newPassword" name="newPassword"><br>
  <label for="confirmPassword">Confirm Password</label> <input type="text" id="confirmPassword" name="confirmPassword"><br>

  <button type="submit" id="applyButton" class="applyButton">Save Password</button>
</form>

</div>

<p id="empPChange"></p>

<script>
function myFunction() {
  document.getElementById("empPChange").innerHTML = "Password Saved!";
}
</script>
</div>
</div>
</body>
</html>