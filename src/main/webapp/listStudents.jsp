<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8"/>
    <title>List</title>
</head>
<body>
<link>
<h3>Students list</h3>
<table>
<c:forEach items="${students}" var="student">
    <tr>
        <td><c:out value="${student.id}"></c:out></td>
        <td><c:out value="${student.name}"></c:out></td>
        <td><c:out value="${student.age}"></c:out></td>
        <td>Group: <c:out value="${student.groupId}"></c:out></td>

        <td><a href="${pageContext.request.contextPath}/list/edit?id=${student.id}">edit</a>
            <a href="${pageContext.request.contextPath}/list/delete?id=${student.id}">delete</a>
        </td>
    </tr>
</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/list/add">Add student</a>
</body>
</html>
