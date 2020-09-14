<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huy8895
  Date: 9/14/20
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate email</title>
</head>
<body>

<h1>Email Validate</h1>
<c:choose>
    <c:when test="${isvalid == true }">
        <h3 style="color:green">${message}</h3>
    </c:when>
    <c:otherwise>
        <h3 style="color:red">${message}</h3>
    </c:otherwise>
</c:choose>

<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
</form>
</body>
</html>
