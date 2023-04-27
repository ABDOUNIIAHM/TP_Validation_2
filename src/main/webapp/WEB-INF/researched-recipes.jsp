<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 26/04/2023
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Researched posts</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
  <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
    <c:forEach var="p" items="${foundRecipes}">
      <div class="col">
        <div class="card">
          <img src="${p.imgUrl}" class="card-img-top">
          <div class="card-body">
            <h5 class="card-title">${p.title}</h5>
            <p class="card-text">${p.description}</p>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>
