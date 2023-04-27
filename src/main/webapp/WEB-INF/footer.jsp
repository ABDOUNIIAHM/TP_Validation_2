<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 26/04/2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Footer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
    </style>
</head>
<body>
<div class="flex-grow-1"></div>
<footer class="bg-dark text-light py-3">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <p>&copy; 2023 The company</p>
            </div>
            <div class="col-md-6 text-end">
                <p>Designed by <a href="#">Aracados</a></p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
