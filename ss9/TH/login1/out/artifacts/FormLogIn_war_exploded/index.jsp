<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/14/2022
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      form{
        height: 200px;
        width: 300px;
      }
      .login {
        height:100%; width:100%;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
      }
      .login input {
        padding:5px; margin:5px
      }
    </style>
  </head>
  <body>
  <form method="post" action="/login">
    <div class ="login">
      <h2>Login</h2>
      <input type = "text" name="username" size = "30" placeholder="user name" />
      <input type ="password" name = "password" size ="30" placeholder="password" />
      <input type = submit value="Sign in">
    </div>
  </form>
  </body>
</html>
