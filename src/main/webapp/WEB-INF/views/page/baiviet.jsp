<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/15/2023
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Option 1: Include in HTML -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/assets/navbar.jsp"></jsp:include>

<div class="container">
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach items="${bikes}" var="b">
            <div class="col">
                <div class="card h-100">
                    <img src="${b.img}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${b.title}</h5>
                        <p class="card-text">${b.content}</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-body-secondary">${b.author}</small>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
