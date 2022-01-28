<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="employee" value='${sessionScope["employee"]}' />
<c:set var="allRanks" value='${sessionScope["allRanks"]}' />
<c:set var="allRoles" value='${sessionScope["allRoles"]}' />

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
<style>
    .change_form_right select{
        width: 75%;
        float: right;
    }
    .change_form_left {
        width: 25%;
        float: left;
    }
    .height{
        height: 58px;
    }
    .form-signin {
        width: 100%;
        max-width: 330px;
        padding: 15px;
        margin: auto;
    }
</style>

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
        <div class="form-floating form-control change_form_right height">
                <label class="change_form_left">${rank}</label>
                <select name="rankName">
                    <c:forEach var="Rank" items="${allRanks}" >
                        <c:choose>
                            <c:when test="${Rank == employee.userRank}">
                                <option value="${Rank}" selected="selected">${Rank}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${Rank}">${Rank}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
        </div>
        <div class="form-floating form-control change_form_right height">
            <label class="change_form_left">${role}</label>
            <select name="roleName">
                <c:forEach var="Role" items="${allRoles}" >
                    <c:choose>
                        <c:when test="${Role == employee.userRole}">
                            <option value="${Role}" selected="selected">${Role}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${Role}">${Role}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">${edit}</button>
        <p class="mt-5 mb-3 text-muted">&copy; FLAPJVCK</p>
    </form>
</div>
</div>




<jsp:include page="template/footer.jsp"/>
