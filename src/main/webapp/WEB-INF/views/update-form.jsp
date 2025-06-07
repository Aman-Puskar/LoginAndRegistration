<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Fill the form to update the details</h2>
		<form action="updateDetails" method="post">
			Old Name: <input type="text" name="oldname"/><br><br>
			New Name: <input type="text" name="newname"/><br><br>
			Old Email: <input type="email" name="oldemail"/><br><br>
			Email: <input type="email" name="newemail"/><br><br>
			Old City: <input type="text" name="oldcity"/><br><br>
			New City: <input type="text" name="newcity"/><br><br>
			<input type="submit" value="Submit"/>
		</form>
</body>
</html>