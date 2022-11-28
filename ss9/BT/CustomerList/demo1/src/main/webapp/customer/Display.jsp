<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/17/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Customer</title>
</head>
<body>
<h1>List student JSTL</h1>
<table border="1">
    <tr>

        <th>Name</th>
        <th>Born Date</th>
        <th>Address</th>
        <th>ImgUrl</th>
    </tr>
    <c:forEach items="${customerList}" var="c">
        <tr>
            <td>${c.name}</td>
            <td>${c.bornDate}</td>
            <td>${c.address}</td>
            <td><img src="${c.imgUrl}" style="width: 70px; object-fit: cover "></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

