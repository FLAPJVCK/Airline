<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization" />

<c:set var="flightId" value='${requestScope["flightId"]}' />

<c:set var="pilotsList" value='${requestScope["pilotsList"]}' />
<c:set var="navigatorsList" value='${requestScope["navigatorsList"]}' />
<c:set var="radioOperatorsList" value='${requestScope["radioOperatorsList"]}' />
<c:set var="stewardessesList" value='${requestScope["stewardessesList"]}' />

<c:set var="pilotsCount" value='${requestScope["pilotsCount"]}' />
<c:set var="navigatorsCount" value='${requestScope["navigatorsCount"]}' />
<c:set var="radioOperatorsCount" value='${requestScope["radioOperatorsCount"]}' />
<c:set var="stewardessesCount" value='${requestScope["stewardessesCount"]}' />

<fmt:message key="brigade.page.create.name" var="pageName"/>
<fmt:message key="brigade.page.pilot" var="pilot"/>
<fmt:message key="brigade.page.navigator" var="navigator"/>
<fmt:message key="brigade.page.radio.operator" var="radioOperator"/>
<fmt:message key="brigade.page.stewardess" var="stewardess"/>
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
        height: 110px;
    }
    .form-signin {
        width: 100%;
        max-width: 450px;
        padding: 15px;
        margin: auto;
    }
</style>

<div class="text-center">
    <div class="form-signin">
        <form action="${pageContext.request.contextPath}/Controller?command=createBrigade&flightId=${flightId}" method="post">
            <h1 class="h3 mb-3 fw-normal">${pageName}</h1>

            <div class="form-floating form-control change_form_right height">
                <label class="change_form_left">${pilot} (${pilotsCount})</label>
                <select id="pilot" multiple="multiple" name="pilot">
                    <c:forEach var="Pilot" items="${pilotsList}" >
                        <option value="${Pilot.id}">${Pilot.surname} ${Pilot.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating form-control change_form_right height">
                <label class="change_form_left">${navigator} (${navigatorsCount})</label>
                <select id="navigator" multiple="multiple" name="navigator">
                    <c:forEach var="Navigator" items="${navigatorsList}" >
                        <option value="${Navigator.id}">${Navigator.surname} ${Navigator.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating form-control change_form_right height">
                <label class="change_form_left">${radioOperator} (${radioOperatorsCount})</label>
                <select id="radioOperator" multiple="multiple" name="radioOperator">
                    <c:forEach var="RadioOperator" items="${radioOperatorsList}" >
                        <option value="${RadioOperator.id}">${RadioOperator.surname} ${RadioOperator.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating form-control change_form_right height">
                <label class="change_form_left">${stewardess} (${stewardessesCount})</label>
                <select id="stewardess" multiple="multiple" name="stewardess">
                    <c:forEach var="Stewardess" items="${stewardessesList}" >
                        <option value="${Stewardess.id}">${Stewardess.surname} ${Stewardess.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">${createFlight}</button>
            <p class="mt-5 mb-3 text-muted">&copy; FLAPJVCK</p>
        </form>
    </div>
</div>

<jsp:include page="template/footer.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        var last_valid_selection_pilot = null;
        var last_valid_selection_navigator = null;
        var last_valid_selection_radioOperator = null;
        var last_valid_selection_stewardess = null;

        $('#pilot').change(function(event) {
            if ($(this).val().length > ${pilotsCount}) {

                $(this).val(last_valid_selection_pilot);
            } else {
                last_valid_selection_pilot = $(this).val();
            }
        });
        $('#navigator').change(function(event) {

            if ($(this).val().length > ${navigatorsCount}) {

                $(this).val(last_valid_selection_navigator);
            } else {
                last_valid_selection_navigator = $(this).val();
            }
        });
        $('#radioOperator').change(function(event) {

            if ($(this).val().length > ${radioOperatorsCount}) {

                $(this).val(last_valid_selection_radioOperator);
            } else {
                last_valid_selection_radioOperator = $(this).val();
            }
        });
        $('#stewardess').change(function(event) {

            if ($(this).val().length > ${stewardessesCount}) {

                $(this).val(last_valid_selection_stewardess);
            } else {
                last_valid_selection_stewardess = $(this).val();
            }
        });
    });
</script>

