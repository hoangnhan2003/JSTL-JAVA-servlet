<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/15/2022
  Time: 3:51 PM
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
  <style>
    body{
      display: flex;
      justify-content: center;
      align-items: center;
      box-sizing: border-box;
    }
    form{
      display: flex;
      flex-direction: column;
      width: 30%;
      height: 40%;
      border: 1px solid black;
    }
    form input{
      width: 70%;
      padding: 5px;
      margin: 10px 30px;
    }
    .heading{
      letter-spacing: 1px;
      text-align: center;
    }
    .btn-submit{
      padding: 10px;
      background-color: aqua;
      border: transparent;
      width: 20%;
      border-radius: 5px;

    }
    .btn-submit:hover{
      cursor: pointer;
    }
  </style>
</head>
<body>
<form action="/Discount_war_exploded/SolveDiscountServlet" method="post">
  <h2 class="heading">Solve discount</h2>
  <input type="text" class="" name = "description" placeholder="description">
  <input type="text" class="" name="price" placeholder="price">
  <input type="text" class="" name="discount" placeholder="discount percent">
  <input type="submit" class="btn-submit" placeholder="Solve">

</form>
</body>
</html>
