<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Table</title>
</head>
<body>

<table cellpadding="5" border="1">
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Employee Email</th>
        <th>Employee Address</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>

    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.empid}</td>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.address}</td>

            <td><a href="${pageContext.request.contextPath}/delete/${emp.empid}">Delete</a></td>
            <td><a href="${pageContext.request.contextPath}/update/${emp.empid}">Update</a></td>
        </tr>
    </c:forEach>
</table> <br>
<a href="home"> <input type="submit" value="Add"> </a>

</body>
</html>
