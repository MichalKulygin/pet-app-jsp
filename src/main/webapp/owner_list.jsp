<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 2020-11-11
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Owner List</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <table>
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Sex</th>
            <th>Age</th>
            <th>pets number</th>
            <th>pets average age</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${requestScope.owners}" var="owner">
            <tr>
                <td>
                        ${owner.id}
                </td>
                <td>
                        ${owner.firstName}
                </td>
                <td>
                        ${owner.lastName}
                </td>
                <td>
                        ${owner.sex}
                </td>
                <td>
                        ${owner.age}
                </td>
                <td>
                        <%--                <a href="${pageContext.request.contextPath}/student/remove?stId=${student.id}">Remove</a>--%>
                        <%--                <a href="${pageContext.request.contextPath}/student/details?id=${student.id}">Details</a>--%>
                        <%--                <a href="${pageContext.request.contextPath}/student/edit?id=${student.id}">Edit</a>--%>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
