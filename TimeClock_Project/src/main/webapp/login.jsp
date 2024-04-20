<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store Login</title>
<style>
	.input-box {
		border: none;
		padding: 10px;
		background-color: #E5E3E6;
		border-bottom: 3px solid #DEAAEB;
		outline: none;
		font-size: 16px;
		width: 70%;
	} 
	
.input-box::placeholder {
		color: #999;
	}
	
</style>

<link rel="stylesheet" type="text/css" href="css/loginStyles.css">
</head>

<body>

	<div class="container">
		<div class="welcome-side">
			<p class="chaos-text">Chaos Inc.</p>
			
			<div class="decor-circle1"></div>
			<div class="decor-circle2"></div>
			<div class="decor-circle3"></div>
			<div class="decor-circle4"></div>
			<div class="decor-circle5"></div>
			<div class="decor-circle6"></div>
			
			<div class="centered-welcome">
				<h2>Welcome!</h2>
				<br>
				<h1>AspireClothing</h1>
				<h3>Time Clock</h3>
			</div>
		</div>

		<div class="login-side">
		
		<div class="login-title">
			<h2>Enter Store Details</h2>
		</div>

			<form action="login" method="post">
				<%
				String error = (String) request.getAttribute("error");
				%>
				<%
				if (error != null) {
				%>
				<p class="error"><%=error%>
				</p>
				<%
				}
				%>

				<div class="store-number-input">
					<!-- store number input </label> --> 
					<input type="text" id="storeNumber" name="storeNumber" class="input-box" placeholder="Store Number" required>
				</div>

				<div class="password-input">
					<!-- store password input --> 
					<input type="password" id="storePassword" name="storePassword" class="input-box" placeholder="Password" required>
				</div>
				
				<div class="login-button">
					<input type="submit" value="Continue">
				</div>
				
				<p>Forgot Password <a href="http://localhost:8080/TimeClock_Project/recoverPassword.jsp">here.</a></p>
				
				<h3 class="register-title">New Employee?</h3>

			</form>
			<div class="register-button">
					<form action="registerUser" method="get">
						<input type="submit" value="Register">
					</form>
				</div>
		</div>
	</div>
</body>
</html>

