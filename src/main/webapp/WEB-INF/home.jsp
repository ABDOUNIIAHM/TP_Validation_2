<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 27/04/2023
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>
<h1>Home</h1>
<div class="container">
    <form action="researched-recipes" method="get">
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Search by title..." name="title">
            <button class="btn btn-outline-secondary" type="submit" name="search" value="title" >Search</button>
        </div>
    </form>
    <form action="researched-recipes" method="get">
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Search by ingredients..." name="ingredients">
            <button class="btn btn-outline-secondary" type="submit" name="search" value="ingredients">Search</button>
        </div>
    </form>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
    <c:forEach var="recipe" items="${recipes}">
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <img src="${recipe.imgUrl}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${recipe.title}</h5>
                    <p class="card-text">${recipe.description}</p>
                </div>
            </div>
        </div>
    </c:forEach>
    </div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>
