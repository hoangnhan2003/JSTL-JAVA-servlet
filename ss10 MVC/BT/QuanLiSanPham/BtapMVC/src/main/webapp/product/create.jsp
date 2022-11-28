<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/19/2022
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/productS" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>Producer</td>
            <td><input type="text" name="producer"></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
            <td><input type="reset" value="reset"></td>
        </tr>
        <input type="hidden" name ="action" value="create">
    </table>
</form>
</body>
</html>
