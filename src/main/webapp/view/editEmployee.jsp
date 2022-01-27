<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="employee" value='${sessionScope["employee"]}' />

<fmt:message key="employee.page.name" var="name"/>
<fmt:message key="employee.page.surname" var="surname"/>
<fmt:message key="employee.page.username" var="username"/>
<fmt:message key="employee.page.email" var="email"/>
<fmt:message key="employee.page.password" var="password"/>
<fmt:message key="employee.page.rank" var="rank"/>
<fmt:message key="employee.page.role" var="role"/>
<fmt:message key="employee.page.edit" var="edit"/>
<fmt:message key="employeeEdit.page" var="pageName"/>

<jsp:include page="template/header.jsp"/>

<div class="text-center">
<div class="form-signin">
    <form action="${pageContext.request.contextPath}/Controller?command=editUser&id=${employee.id}" method="post">
        <h1 class="h3 mb-3 fw-normal">${pageName}</h1>

        <div class="form-floating">
            <input type="text" name="name" class="form-control" id="floatingName" placeholder="name@example.com" value="${employee.name}">
            <label for="floatingName">${name}</label>
        </div>
        <div class="form-floating">
            <input type="text" name="surname" class="form-control" id="floatingSurname" placeholder="Password" value="${employee.surname}">
            <label for="floatingSurname">${surname}</label>
        </div>
        <div class="form-floating">
            <input type="text" name="username" class="form-control" id="floatingUsername" placeholder="Password" value="${employee.username}">
            <label for="floatingUsername">${username}</label>
        </div>
        <div class="form-floating">
            <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com" value="${employee.email}">
            <label for="floatingInput">${email}</label>
        </div>
        <div class="form-floating">
            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password" value="${employee.password}">
            <label for="floatingPassword">${password}</label>
        </div>
        <div class="form-floating">
            <input type="text" name="rankId" class="form-control" id="floatingPassword" placeholder="Password" value="${employee.rankId}">
            <label for="floatingPassword">${rank}</label>
        </div>
        <div class="form-floating">
            <input type="text" name="roleId" class="form-control" id="floatingPassword" placeholder="Password" value="${employee.roleId}">
            <label for="floatingPassword">${role}</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">${edit}</button>
        <p class="mt-5 mb-3 text-muted">&copy; FLAPJVCK</p>
    </form>
</div>
</div>


<jsp:include page="template/footer.jsp"/>
