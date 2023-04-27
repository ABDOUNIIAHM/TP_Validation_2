<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 27/04/2023
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>

<div class="container mt-5">
    <div class="card text-center mx-auto" style="max-width: 400px;">
        <div class="card-header">
            <h5 class="card-title">Profile Card</h5>
        </div>
        <div class="card-body">
            <div class="mb-3">
                <p>First name : ${user.firstName}</p>
            </div>
            <div class="mb-3">
                <p>Last name : ${user.lastName}</p>
            </div>

            <div class="mb-3">
                <p>Password : ${user.password}</p>
            </div>
        </div>
        <div class="card-footer">
            <form action="edit-profile" method="get">
                <button type="submit" class="btn btn-secondary">Edit</button>
            </form>
        </div>
    </div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>
