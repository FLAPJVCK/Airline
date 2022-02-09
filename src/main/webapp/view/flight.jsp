<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="flightList" value='${sessionScope["flightList"]}' />

<fmt:message key="flight.page.flight.number" var="number"/>
<fmt:message key="flight.page.departure.date" var="departureDate"/>
<fmt:message key="flight.page.departure.time" var="departureTime"/>
<fmt:message key="flight.page.destination" var="destination"/>
<fmt:message key="flight.page.status" var="status"/>
<fmt:message key="flight.page.airplane.model" var="airplaneModel"/>
<fmt:message key="flight.page.create.brigade" var="createBrigade"/>
<fmt:message key="flight.page.see.brigade" var="seeBrigade"/>
<fmt:message key="flight.page.complete.flight" var="сompleteFlight"/>
<fmt:message key="flight.page.create" var="createFlight"/>
<fmt:message key="flight.page.edit" var="edit"/>
<fmt:message key="flight.page.delete" var="delete"/>
<c:set var="userRole" value="${sessionScope.userRole}"/>


<jsp:include page="template/header.jsp"/>
<a style="text-decoration: none" class="d-grid gap-2 col-6 mx-auto" href="${pageContext.request.contextPath}/Controller?command=createFlightPage">
    <button class="btn btn-primary" type="button">${createFlight}</button>
</a>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">${number}</th>
        <th scope="col">${departureDate}</th>
        <th scope="col">${departureTime}</th>
        <th scope="col">${destination}</th>
        <th scope="col">${status}</th>
        <th scope="col">${airplaneModel}</th>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="flight" items="${flightList}" >
        <tr>
            <td>${flight.flightNumber}</td>
            <td>${flight.departureDate}</td>
            <td>${flight.departureTime}</td>
            <td>${flight.destination.airport}</td>
            <td>${flight.flightStatus}</td>
            <td>${flight.airplane.manufacturer.manufacturerName} ${flight.airplane.model}</td>

            <c:choose>
                <c:when test="${flight.flightStatus == 'NOT_READY'}">
                    <td><a href="${pageContext.request.contextPath}/Controller?command=createBrigadePage&flightId=${flight.id}&flightDate=${flight.departureDate}&modelId=${flight.airplane.id}"><button type="button" class="btn btn-info">${createBrigade}</button></a></td>
                    <td><a href="${pageContext.request.contextPath}/Controller?command=editFlightPage&id=${flight.id}"><button type="button" class="btn btn-warning">${edit}</button></a></td>
                    <c:if test="${userRole == 'ADMIN'}">
                        <td><a href="${pageContext.request.contextPath}/Controller?command=deleteFlight&id=${flight.id}"><button type="button" class="btn btn-danger">${delete}</button></a></td>
                    </c:if>
                </c:when>
                <c:when test="${flight.flightStatus == 'READY'}">
                    <td><a href="${pageContext.request.contextPath}/Controller?command=updateFlightStatus&flightId=${flight.id}"><button type="button" class="btn btn-success">${сompleteFlight}</button></a></td>
                    <td><a href="${pageContext.request.contextPath}/Controller?command=editFlightPage&id=${flight.id}"><button type="button" class="btn btn-warning">${edit}</button></a></td>
                    <td><a href="${pageContext.request.contextPath}/Controller?command=BrigadePage&flightId=${flight.id}"><button type="button" class="btn btn-secondary">${seeBrigade}</button></a></td>
                </c:when>
                <c:otherwise>
                    <td><a href="${pageContext.request.contextPath}/Controller?command=BrigadePage&flightId=${flight.id}"><button type="button" class="btn btn-secondary">${seeBrigade}</button></a></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="template/footer.jsp"/>
