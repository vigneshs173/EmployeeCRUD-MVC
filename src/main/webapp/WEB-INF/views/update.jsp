<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>

    <h1>Update your records</h1>

    <form action="updateEmp" method="post" >


        <label>Employee ID : </label> <br>
        <input type="text" name="empid" value="${employee.empid}" readonly> <br>

        <label>Name : </label> <br>
        <input type="text" name="name" value="${employee.name}"> <br>

        <label>Mail ID : </label> <br>
        <input type="text" name="email" value="${employee.email}"> <br>

        <label>Address : </label> <br>
        <input type="text" name="address" value="${employee.address}"> <br>


        <input type="submit" value="UPDATE"/>

    </form>

</body>
</html>
