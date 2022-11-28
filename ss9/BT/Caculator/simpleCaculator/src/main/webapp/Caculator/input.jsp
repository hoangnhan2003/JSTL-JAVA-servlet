<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/18/2022
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
<h1>Simple Caculator</h1>
<form action="/caculator" method="post">
  <table>
    <tr>
      <td>
        number 1
      </td>
      <td><input type="number" name="number1"></td>
    </tr>
    <tr>
      <td>
        Operator
      </td>
      <td><select name="operator" id="operator">
        <option value="1">+</option>
        <option value="2">-</option>
      </select></td>
    </tr>
    <tr>
      <td>Number 2</td>
      <td><input type="number" name="number2"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit" > </td>
    </tr>
  </table>
</form>
</body>
</html>
