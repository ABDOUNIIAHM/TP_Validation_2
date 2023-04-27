<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 27/04/2023
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add-recipe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>

<div class="container mt-5">
<div class="card text-center mx-auto" style="max-width: 400px;">
    <div class="card-header">
        <h5 class="card-title">Add recipe</h5>
    </div>
    <div class="card-body">
        <form action="add-recipe" method="post">
            <div class="mb-3">
                Title:<input name="title" type="text" class="form-control" required>
            </div>
            <div class="mb-3">
                description:<input name="description" type="text" class="form-control" required>
            </div>
            <div class="mb-3">
                Ingredients: <input name="ingredients" type="text" class="form-control">
            </div>
            <div class="mb-3">
                Image: <input name="imgUrl" type="text" class="form-control" >
            </div>
            <div class="mb-3">
                Rating: <input name="rating" type="number" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Recipe</button>
        </form>
    </div>
</div>
</div>

<c:import url="footer.jsp"></c:import>
</body>
</html>
