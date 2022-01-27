<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<fmt:message key="signUp.page" var="pageName"/>
<fmt:message key="signUp.page.name" var="name"/>
<fmt:message key="signUp.page.surname" var="surname"/>
<fmt:message key="signUp.page.username" var="username"/>
<fmt:message key="signUp.page.email" var="email"/>
<fmt:message key="signUp.page.password" var="password"/>
<fmt:message key="signUp.page.button" var="button"/>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>
<body class="text-center">
<main class="form-signin">
    <form action="${pageContext.request.contextPath}/Controller?command=register" method="post">

        <a href="${pageContext.request.contextPath}/Controller?command=mainPage">
            <img class="mb-4" src="${pageContext.request.contextPath}/img/favicon.ico" alt="" width="100" height="100">
        </a>
        <h1 class="h3 mb-3 fw-normal">${pageName}</h1>

        <div class="form-floating">
            <input type="text" name="name" class="form-control" id="floatingName" placeholder="name@example.com">
            <label for="floatingName">${name}</label>
        </div>
        <div class="form-floating">
            <input type="text" name="surname" class="form-control" id="floatingSurname" placeholder="Password">
            <label for="floatingSurname">${surname}</label>
        </div>
        <div class="form-floating">
            <input type="text" name="username" class="form-control" id="floatingUsername" placeholder="Password">
            <label for="floatingUsername">${username}</label>
        </div>
        <div class="form-floating">
            <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">${email}</label>
        </div>
        <div class="form-floating">
            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">${password}</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">${button}</button>
        <p class="mt-5 mb-3 text-muted">&copy; FLAPJVCK</p>
    </form>
</main>
</body>
</html>
