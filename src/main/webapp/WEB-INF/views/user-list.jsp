<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <style>
        table {
            border-collapse: collapse;
            width: 70%;
        } 
        tr {
        background-color:pink;
        }
        th {
        background-color:yellow;
        	
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        
    </style>
</head>
<body>
    <h2>User Details</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>City</th>
            <th>Operations</th>
        </tr>

        <%
            java.util.List users = (java.util.List) request.getAttribute("users");
            if (users == null || users.isEmpty()) {
        %>
            <tr>
                <td colspan="3" style="text-align:center;">No user data found</td>
            </tr>
        <%
            } else {
                for (Object obj : users) {
                    com.spring.controllers.UserDetailMapper user = (com.spring.controllers.UserDetailMapper) obj;
        %>
            <tr>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getCity() %></td>
                <td><a href="update">Edit</a> <a href="delete">Remove</a></td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
