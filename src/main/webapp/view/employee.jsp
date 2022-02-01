<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="employeeList" value='${sessionScope["employeeList"]}' />

<fmt:message key="employee.page.name" var="name"/>
<fmt:message key="employee.page.surname" var="surname"/>
<fmt:message key="employee.page.username" var="username"/>
<fmt:message key="employee.page.email" var="email"/>
<fmt:message key="employee.page.rank" var="rank"/>
<fmt:message key="employee.page.role" var="role"/>
<fmt:message key="employee.page.edit" var="edit"/>
<fmt:message key="employee.page.delete" var="delete"/>

<jsp:include page="template/header.jsp"/>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">${name}</th>
        <th scope="col">${surname}</th>
        <th scope="col">${username}</th>
        <th scope="col">${email}</th>
        <th scope="col">${rank}</th>
        <th scope="col">${role}</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="employee" items="${employeeList}" >
            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.username}</td>
                <td>${employee.email}</td>
                <td>${employee.userRank}</td>
                <td>${employee.userRole}</td>
                <td><a href="${pageContext.request.contextPath}/Controller?command=editUserPage&id=${employee.id}"><button type="button" class="btn btn-warning">${edit}</button></a></td>
                <td><a href="${pageContext.request.contextPath}/Controller?command=deleteUser&id=${employee.id}"><button type="button" class="btn btn-danger">${delete}</button></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jsp:include page="template/footer.jsp"/>
