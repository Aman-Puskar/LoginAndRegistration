<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Details of the User</h2>
	<h3>Name: ${user.getName()} </h3>
	<h3>Email: ${user.getEmail()}</h3>
	<h3>City: ${user.getCity()}</h3>
	
	<a href="update">Update Details</a>
</body>
</html>