<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 2020-11-11
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Owner form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <form action="${pageContext.request.contextPath}/owner/form" method="post">
        <div>
            <label>First name:</label>
            <input type="text" name="first_name_field"/>
        </div>
        <div>
            <label>Last name:</label>
            <input type="text" name="last_name_field"/>
        </div>
        <div>
            <label>Age</label>
            <input type="number" step="1" min="1" max="99" name="age_field"/>
        </div>
        <div>
            <label>Sex</label>
            <select name="sex_field">
                <c:forEach items="${requestScope.availableSex}" var="sex">
                    <option value="${sex}">${sex.commonName}</option>
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
