<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 13-May-18
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Main page:
    <%
        String username = (String)session.getAttribute("username");
        out.println(username);
    %>
</body>
</html>
