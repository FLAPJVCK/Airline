<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<fmt:message key="header.language" var="language"/>
<fmt:message key="header.my.profile" var="myProfile"/>
<fmt:message key="header.flights" var="flights"/>
<fmt:message key="header.employees" var="employees"/>
<fmt:message key="header.logIn" var="logIn"/>
<fmt:message key="header.signUp" var="signUp"/>
<fmt:message key="header.logOut" var="logOut"/>
<c:set var="userRole" value="${sessionScope.userRole}"/>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Airline</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</head>
<body class="container">
<div>
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="${pageContext.request.contextPath}/Controller?command=mainPage"
           class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <h1 class="main_text">Airline</h1>
        </a>
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <c:if test="${userRole == 'WORKER'}">
                <li><a href="${pageContext.request.contextPath}/Controller?command=profilePage" class="nav-link px-3 link-dark">${myProfile}</a></li>
            </c:if>
            <c:if test="${userRole == 'MANAGER'}">
                <li><a href="${pageContext.request.contextPath}/Controller?command=profilePage" class="nav-link px-3 link-dark">${myProfile}</a></li>
                <li><a href="${pageContext.request.contextPath}/Controller?command=flightPage" class="nav-link px-3 link-dark">${flights}</a></li>
            </c:if>
            <c:if test="${userRole == 'ADMIN'}">
                <li><a href="${pageContext.request.contextPath}/Controller?command=profilePage" class="nav-link px-3 link-dark">${myProfile}</a></li>
                <li><a href="${pageContext.request.contextPath}/Controller?command=flightPage" class="nav-link px-3 link-dark">${flights}</a></li>
                <li><a href="${pageContext.request.contextPath}/Controller?command=employeePage" class="nav-link px-3 link-dark">${employees}</a></li>
            </c:if>
        </ul>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                ${language}
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Controller?command=change_locale&amp;locale=ru">Русский</a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Controller?command=change_locale&amp;locale=en">English</a></li>
            </ul>
        </div>
        <div class="col-md-3 text-end">
            <c:choose>
                <c:when test="${userRole == 'WORKER' || userRole == 'MANAGER' || userRole == 'ADMIN'}">
                    <a href="${pageContext.request.contextPath}/Controller?command=logOut"><button type="button" class="btn btn-outline-primary me-2">${logOut}</button></a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/Controller?command=logInPage"><button type="button" class="btn btn-outline-primary me-2">${logIn}</button></a>
                    <a href="${pageContext.request.contextPath}/Controller?command=registerPage"><button type="button" class="btn btn-primary">${signUp}</button></a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>
</div>

