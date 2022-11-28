<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/17/2022
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Create new student</h1>
<form action="Display.jsp" method="post">
  <table border="1">

    <tr>
      <td>Name</td>
      <td><input type="text" name="name" /></td>
    </tr>
    <tr>
      <td>Born Date</td>
      <td><input type="text" name="bornDate"  /></td>
    </tr>
    <tr>
      <td>Address</td>
      <td><input type="text" name="address"  /></td>
    </tr>
    <tr>
      <td>Image</td>
      <td><input type="text" name="imgUrl"  /></td>
    </tr>

    <tr>
      <td><input type="submit" value="Đăng ký"></td>
      <td><input type="reset" value="Nhập lại"></td>
    </tr>
  </table>
</form>
</body>
</html>
