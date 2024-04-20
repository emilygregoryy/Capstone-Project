<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Reset</title>
    <link rel="stylesheet" type="text/css" href="css/settingsStyles.css">
</head>
<body>
<div style="text-align: center">
<h2>Password Reset</h2>
<div class="employeeInfo">
<form action="passwordReset" method="post">
<br></br>
  			
  <h3>New Password</h3>
 
  <label for="newPassword">New Password</label> <input type="text" id="newPassword" name="newPassword"><br>
  <label for="confirmPassword">Confirm Password</label> <input type="text" id="confirmPassword" name="confirmPassword"><br>
  
  <button type="submit" id="applyButton" class="applyButton">Save Password</button>
 
</form>

</div>
</div>

<p id="empPChange"></p>

<script>
function myFunction() {
  document.getElementById("empPChange").innerHTML = "Password Saved!";
}
</script>
</body>
</html>
