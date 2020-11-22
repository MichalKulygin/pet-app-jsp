<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 2020-11-15
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Pet form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <form action="${pageContext.request.contextPath}/pet/form" method="post">
        <input type="hidden" value="${requestScope.ownerIdAttribute}" readonly name="ownerId"/>
        <input type="hidden" value="${requestScope.modifiedPetAttribute.id}" readonly name="petId"/>
        <div>
            <label>Name:</label>
            <input type="text" name="name_field" value="${requestScope.modifiedPetAttribute.name}"/>
        </div>
        <div>
            <label>Age</label>
            <input type="number" step="1" min="1" max="99" name="age_field"
                   value="${requestScope.modifiedPetAttribute.age}"/>
        </div>
        <div>
            <label>Weight</label>
            <input type="number" step="1" min="1" max="99" name="wight_field"
                   value="${requestScope.modifiedPetAttribute.weight}"/>
        </div>
        <div>
            <label>
                <input type="checkbox" name="pureRace_field"
                       <c:if test="${requestScope.modifiedPetAttribute.pureRace}">checked</c:if>>
                <span></span>
            </label>
        </div>
        <div>
            <label>Race</label>
            <select name="race_field">
                <c:forEach items="${requestScope.availableRace}" var="race">
                    <option value="${race}" ${requestScope.modifiedPetAttribute.race == race ? 'selected' : ''}>${race.commonName}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Submit</button>
        <button type="reset">Reset</button>
    </form>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
