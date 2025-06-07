<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>Delete User Details</h2>
		<form action="deleteuser" method="post">
			Email: <input type="email" name="email" placeholder="Enter the email of logged user"/><br><br>
			<input type="submit" value="Delete"/>
		</form>
		
		<%
		String message = (String)request.getAttribute("popup_message");
		  if(message != null && !message.isEmpty()) { 
		%>
			<script>
			alert("<%=  message %>")
	        </script>
	       <% } %>
	    	   
	       
	
	
</body>
</html>