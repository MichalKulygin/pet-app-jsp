<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 2020-11-15
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Owner Details</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <h5>${requestScope.ownerToDisplay.firstName} ${requestScope.ownerToDisplay.lastName}</h5>
    <div>
        <div>
            <table>
                <tr>
                    <td>Imie:</td>
                    <td>${requestScope.ownerToDisplay.firstName}</td>
                </tr>
                <tr>
                    <td>Nazwisko:</td>
                    <td>${requestScope.ownerToDisplay.lastName}</td>
                </tr>
                <tr>
                    <td>Sex:</td>
                    <td>${requestScope.ownerToDisplay.sex.commonName}</td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td>${requestScope.ownerToDisplay.age}</td>
                </tr>
                <tr>
                    <td>pets number:</td>
                    <td>${requestScope.ownerToDisplay.petsNumber}</td>
                </tr>
                <tr>
                    <td>pets avg age:</td>
                    <td>${requestScope.ownerToDisplay.petsAgeAverage}</td>
                </tr>
            </table>
        </div>
        <div>
            <div>
                <a href="${pageContext.request.contextPath}/pet/form?ownerId=${requestScope.ownerToDisplay.id}">Add
                    pet</a>
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Owner name</th>
                        <th>Weight</th>
                        <th>Pure race</th>
                        <th>Race</th>
                        <th>Owner</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${requestScope.ownerToDisplay.petSet}" var="pet">
                        <tr>
                            <td>${pet.id}</td>
                            <td>${pet.name}</td>
                            <td>${pet.age}</td>
                            <td>${pet.owner.firstName}</td>
                            <td>${pet.weight}</td>
                            <td>${pet.pureRace}</td>
                            <td>${pet.race}</td>
                            <td><a href="${pageContext.request.contextPath}/grade/remove?gradeId=${grade.id}">Remove</a>
                            </td>
                            <td><a href="${pageContext.request.contextPath}/grade/edit?gradeId=${grade.id}">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>