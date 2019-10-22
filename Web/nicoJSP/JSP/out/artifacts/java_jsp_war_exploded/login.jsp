
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    String someOutput(HttpSession sessionsa) {
        String error = (String) sessionsa.getAttribute("error");
        sessionsa.removeAttribute("error");
        if (error != null)
            return error;
        return "";
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
    <span style="color: red;"> <%= someOutput(session) %></span>
    <form action="LoginServlet" method="post">
        username: <input type="text" name="user" /> <br>
        password: <input type="password" name="password"> <br>
        <input type="submit" value="Log in">
    </form>
</body>
</html>
