<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="userProfile" value='${sessionScope["userProfile"]}' />
<c:set var="currentUserFlightList" value='${sessionScope["currentUserFlightList"]}' />

<fmt:message key="flight.page.flight.number" var="number"/>
<fmt:message key="flight.page.departure.date" var="departureDate"/>
<fmt:message key="flight.page.departure.time" var="departureTime"/>
<fmt:message key="flight.page.destination" var="destination"/>
<fmt:message key="flight.page.airplane.model" var="airplaneModel"/>
<fmt:message key="profile.page.message" var="message"/>

<jsp:include page="template/header.jsp"/>
<h2>${userProfile.name}</h2>
<h2>${userProfile.surname}</h2>
<h2>${userProfile.email}</h2>
<h2>${userProfile.userRank}</h2>

<c:choose>
    <c:when test="${currentUserFlightList == 'empty'}">
        <h3>${message}</h3>
    </c:when>
    <c:otherwise>
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
            <c:forEach var="currentUserFligh" items="${currentUserFlightList}" >
                <tr>
                    <td>${currentUserFligh.flightNumber}</td>
                    <td>${currentUserFligh.departureDate}</td>
                    <td>${currentUserFligh.departureTime}</td>
                    <td>${currentUserFligh.destination.airport}</td>
                    <td>${currentUserFligh.airplane.manufacturer.manufacturerName} ${currentUserFligh.airplane.model}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>


<jsp:include page="template/footer.jsp"/>

