<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/owners">Lista właścicieli zwierząt</a>
    </li>    <li>
        <a href="${pageContext.request.contextPath}/owner/form">Formularz dodawania właścicieli zwierząt</a>
    </li>
</ul>