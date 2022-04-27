<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
  <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
  <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
</body>
</html>