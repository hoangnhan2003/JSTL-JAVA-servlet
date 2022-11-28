<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/21/2022
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>List book</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Category</th>
    </tr>
    <tr>
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.category.name}</td>
    </tr>
</table>
</body>
</html>
