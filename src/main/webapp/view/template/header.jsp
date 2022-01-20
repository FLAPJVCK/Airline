<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Airline</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body class="container">
<div>
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="${pageContext.request.contextPath}/index.jsp"
           class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <h1 class="main_text">Airline</h1>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Features</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Pricing</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>
        <div class="col-md-3 text-end">
            <c:choose>
                <c:when test="${sessionScope.authorization}">
                    <a href="${pageContext.request.contextPath}/Controller?command=logOut"><button type="button" class="btn btn-outline-primary me-2">Log out</button></a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/Controller?command=logInPage"><button type="button" class="btn btn-outline-primary me-2">Log in</button></a>
                    <a href="${pageContext.request.contextPath}/Controller?command=registerPage"><button type="button" class="btn btn-primary">Sign up</button></a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>
</div>
<h2>Добро пожаловать ${sessionScope.email}</h2>
