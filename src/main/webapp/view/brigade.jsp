<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="brigade" value='${sessionScope["brigade"]}' />

<fmt:message key="employee.page.name" var="name"/>
<fmt:message key="employee.page.surname" var="surname"/>
<fmt:message key="employee.page.rank" var="rank"/>


<jsp:include page="template/header.jsp"/>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">${name}</th>
        <th scope="col">${surname}</th>
        <th scope="col">${rank}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="brigade" items="${brigade}" >
        <tr>
            <td>${brigade.name}</td>
            <td>${brigade.surname}</td>
            <td>${brigade.userRank}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="template/footer.jsp"/>