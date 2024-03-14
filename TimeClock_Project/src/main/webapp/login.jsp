<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<%
if("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit")!=null)
{
	String store_id= request.getParameter("username");
	String password= request.getParameter("password");
	if("AspireClothing".equalsIgnoreCase(store_id) && "Aspire".equalsIgnoreCase(password))
	{
 		out.println("Welcome");
	}
	else
	{
		out.println("Credentials wrong, please try again!");
	}
}
%>
<body>

<h1>Login</h1>

<form method="post">
	Store ID: <input type="text" name="username"><br>
	Password: <input type="password" name="password"><br>
</form>

<button onclick="myFunc()">Submit</button>
<button type="reset" >Reset</button>

    <script> 
        function myFunc() { 
            window.location.href = "http://localhost:8082/Capstone_P/EmpListPage.jsp"; 
        } 
    </script> 

</body>
</html>