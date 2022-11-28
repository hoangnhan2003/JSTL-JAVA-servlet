<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/24/2022
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user managerment</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>

<center>
    <h1>User Managerment Application</h1>
    <h3>
        <a href="/UserServlet?action=create">Add new user</a>
    </h3>
</center>
<center>
    <form action="/UserServlet" method="post">
        <input type="text" placeholder="Find users by country" name="country">
        <input type="submit" value="Find">
        <input type="hidden" name="action" value="find">
    </form>
</center>

<div align="center">
    <table border="1" cellpadding="7" cellspacing="0">
        <caption><h2>List of users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th colspan="2">feature</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td><a href="/UserServlet?action=update&id=${user.id}">Edit</a></td>
                <td><a href="/UserServlet?action=delete-by-procedure&id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"></td>
            <td colspan="2"><a href="/UserServlet?action=sort">Sort by name</a></td>
        </tr>
    </table>
</div>
</body>
</html>
