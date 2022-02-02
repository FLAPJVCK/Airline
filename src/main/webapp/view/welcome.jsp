<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="currentFlightList" value='${sessionScope["currentFlightList"]}' />

<fmt:message key="flight.page.flight.number" var="number"/>
<fmt:message key="flight.page.departure.date" var="departureDate"/>
<fmt:message key="flight.page.departure.time" var="departureTime"/>
<fmt:message key="flight.page.destination" var="destination"/>
<fmt:message key="flight.page.airplane.model" var="airplaneModel"/>

<jsp:include page="template/header.jsp"/>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">${number}</th>
        <th scope="col">${departureDate}</th>
        <th scope="col">${departureTime}</th>
        <th scope="col">${destination}</th>
        <th scope="col">${airplaneModel}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="currentFlight" items="${currentFlightList}" >
        <tr>
            <td>${currentFlight.flightNumber}</td>
            <td>${currentFlight.departureDate}</td>
            <td>${currentFlight.departureTime}</td>
            <td>${currentFlight.destination.airport}</td>
            <td>${currentFlight.airplane.manufacturer.manufacturerName} ${currentFlight.airplane.model}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="template/footer.jsp"/>

