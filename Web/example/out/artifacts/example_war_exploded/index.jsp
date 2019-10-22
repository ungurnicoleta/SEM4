<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 13-May-18
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <form name="Login form" action="/servlets/login" method="POST">
      <div>
        <span>Username:</span>
        <input type="text" name="username" />
      </div>
      <div>
        <span>Password:</span>
        <input type="password" name="password" />
      </div>
      <input type="submit" value="Log in" />
    </form>
  </body>
</html>
