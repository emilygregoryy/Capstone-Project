<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="aspireClothing.servlets.ClockPage" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time Clock</title>
</head>
<body>
	<h2>Time Clock</h2>
		<div>
			
			<p><%= new SimpleDateFormat("EEE MMM dd").format(new Date()) %></p>
			<p><%= new SimpleDateFormat("hh:mm a").format(new Date()) %></p>

			<p>Clock in to</p>
			<p>AspireClothing</p>
			
			<form action="timeClock" method="post">
				<input type="hidden" name="action" value="clockIn">
				<input type="hidden" name="employeeId" value="<%= request.getSession().getAttribute("employeeId") %>">
				<input type="submit" value="Clock In">
			</form>
			
			<form action="timeClock" method="post">
				<input type="hidden" name="action" value="clockOut">
				<input type="hidden" name="employeeId" value="<%= request.getSession().getAttribute("employeeId") %>">
				<input type="submit" value="Clock Out">
			</form>
		</div>
		
	</body>
</html>
