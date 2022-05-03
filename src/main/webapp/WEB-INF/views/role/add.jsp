<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 03.05.2022
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
    </title>
</head>
<body>
<form:form method="post" modelAttribute="role">
    <form:input path="name"/>
    <form:errors path="name"/>
    <input type="submit"/>
</form:form>
</body>
</html>
