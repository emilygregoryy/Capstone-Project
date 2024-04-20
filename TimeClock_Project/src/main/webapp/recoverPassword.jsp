<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Recovery</title>
    <link rel="stylesheet" type="text/css" href="css/settingsStyles.css">
</head>
<body>
<div style="text-align: center">
<h2>Password Recovery</h2>
    <h3>Please enter your employee ID and your managers password to approve the password reset.</h3>
    <br/>
  
    <form action="recoverPassword" method="post">
  <label for="employeeId">Employee ID</label> <input type="text" id="employeeId" name="employeeId" ><br>
  <label for="managerPassword">Manager Password</label> <input type="password" id="managerPassword" name="managerPassword"><br>
			<br></br>
  <button onclick="location.href = 'http://localhost:8080/TimeClock_Project/passwordreset.jsp';" id="myButton" >Approve</button>
    </form>
        <p>Return to login screen <a href="http://localhost:8080/TimeClock_Project/login.jsp">here.</a></p>
        
        <p class="chaos">Chaos Inc.</p>
</div>
</body>
</html>
