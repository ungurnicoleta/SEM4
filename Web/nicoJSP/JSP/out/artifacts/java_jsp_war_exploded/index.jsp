
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<%!
  String someOutput(HttpSession sessionsa) {
    String message = (String) sessionsa.getAttribute("message");
    sessionsa.removeAttribute("message");
    if (message != null)
      return message + " <br>";
    return "";
  }
%>
<body>
  <span> <%= someOutput(session) %></span>
  <a href="login.jsp">Login</a> <br>
  <a href="upload.jsp">Upload</a> <br>
  <a href="VoteServlet">Vote</a> <br>
  <a href="SeePhotosServlet">See photos</a> <br>
  <a href="LogoutServlet">Logout</a>
</body>
</html>