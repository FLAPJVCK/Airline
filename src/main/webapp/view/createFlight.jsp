<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="destinationList" value='${requestScope["destinationList"]}' />
<c:set var="airplaneList" value='${requestScope["airplaneList"]}' />

<fmt:message key="flight.page.create.name" var="pageName"/>
<fmt:message key="flight.page.flight.number" var="number"/>
<fmt:message key="flight.page.departure.date" var="departureDate"/>
<fmt:message key="flight.page.departure.time" var="departureTime"/>
<fmt:message key="flight.page.destination" var="destination"/>
<fmt:message key="flight.page.airplane.model" var="airplaneModel"/>
<fmt:message key="flight.page.create" var="createFlight"/>

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
        max-width: 400px;
        padding: 15px;
        margin: auto;
    }
</style>

<div class="text-center">
    <div class="form-signin">
        <form action="${pageContext.request.contextPath}/Controller?command=createFlight" method="post">
            <h1 class="h3 mb-3 fw-normal">${pageName}</h1>

            <div class="form-floating">
                <input type="text" name="number" class="form-control" id="floatingName" placeholder="name@example.com">
                <label for="floatingName">${number}</label>
            </div>
            <div class="form-floating">
                <input type="text" name="departureDate" class="form-control" id="floatingSurname" placeholder="Password">
                <label for="floatingSurname">${departureDate}</label>
            </div>
            <div class="form-floating">
                <input type="text" name="departureTime" class="form-control" id="floatingUsername" placeholder="Password">
                <label for="floatingUsername">${departureTime}</label>
            </div>
            <div class="form-floating form-control change_form_right height">
                <label>${destination}</label>
                <select name="destination">
                    <c:forEach var="Destination" items="${destinationList}" >
                            <option value="${Destination.id}">${Destination.airport}</option>
                    </c:forEach>
                </select>
            </div>
            <div style="height: 80px" class="form-floating form-control change_form_right height">
                <label class="change_form_left">${airplaneModel}</label>
                <select name="airplaneModel">
                    <c:forEach var="Airplane" items="${airplaneList}" >
                        <option value="${Airplane.id}">${Airplane.manufacturer.manufacturerName} ${Airplane.model}</option>
                    </c:forEach>
                </select>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">${createFlight}</button>
            <p class="mt-5 mb-3 text-muted">&copy; FLAPJVCK</p>
        </form>
    </div>
</div>

<jsp:include page="template/footer.jsp"/>
