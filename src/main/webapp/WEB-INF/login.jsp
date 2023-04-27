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
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
<div class="col-6 offset-3">
    <h1>Login</h1>

    <form action="login" method="post">
        <div class="form-group mb-2">
            <label for="username">Email</label>
            <input type="email" id="username" class="form-control" name="email" placeholder="Enter email">
        </div>
        <div class="form-group mb-2">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
        </div>
        <div class="form-group mb-2">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>

        <c:if test="${error != null}">
            <div class="alert alert-danger w-25 p-3" role="alert">
                    ${error}
            </div>
        </c:if>
    </form>
    <form action="signup">
        <div class="form-group mb-2">
            <button type="submit" class="btn btn-primary">Signup</button>
        </div>
    </form>

</div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>
