<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8"/>
    <title>Login</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login">
    <label>
        Login:
        <input type="text" name="login" value="user"/>
    </label>
    <label>
        Password:
        <input type="text" name="password" value="pass"/>
    </label>
    <input type="submit" value="login"/>
</form>

</body>
</html>
