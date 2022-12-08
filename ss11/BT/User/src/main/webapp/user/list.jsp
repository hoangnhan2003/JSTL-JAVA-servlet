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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

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
                <td>
                    <a href="/UserServlet?action=update&id=${user.id}">Edit</a>

                </td>
                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop" data-bs-whatever="${user.id}">
                        Delete
                    </button>
<%--                    <a href="/UserServlet?action=delete-by-procedure&id=${user.id}">Delete</a>--%>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"></td>
            <td colspan="2"><a href="/UserServlet?action=sort">Sort by name</a></td>
        </tr>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <a href="#" id="deleteButton">
                        <button type="button" class="btn btn-primary">Delete</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    const exampleModal = document.getElementById('staticBackdrop')
    exampleModal.addEventListener('show.bs.modal', event => {
        const button = event.relatedTarget;
        const userId = button.getAttribute('data-bs-whatever');
        document.getElementById('deleteButton').href = "/UserServlet?action=delete-by-procedure&id=" +userId;
    })
</script>
</body>
</html>
