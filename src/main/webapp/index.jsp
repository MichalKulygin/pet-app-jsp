<%@ page import="java.util.Arrays" %>
<%@ page import="java.net.CookieManager" %>
<%@ page import="java.net.CookiePolicy" %><%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 2020-11-11
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
<h1>

    <%
        CookieManager cm = new CookieManager();
        cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        String userName = request.getParameter("name");
        Cookie[] cookies = request.getCookies();

        if (userName == null) {
            out.print("Hello user!");
        } else {
            out.print("Hello " + userName + "!");
        }
        out.print("<br>");
        for (Cookie cookie : cookies) {
            out.print(cookie.getName());
            out.print("<br>");
            out.print(cookie.getValue());
        }
    %>

</h1>
</body>
</html>
