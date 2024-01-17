<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>

</head>
<body>
<h2>Insert Employee Info</h2>


<form:form modelAttribute="employee" method="post" action="test" >

<%--    <h3 style="color: red">${isAllFieldsEmpty}</h3>--%>




<%--    <label>Name : </label> <br>--%>
<%--    <form:input name="name" path="name" /> <br>--%>
<%--    <p>--%>
<%--        <form:errors path="name" />--%>
<%--    </p>--%>


    <label for="name">Name:</label>
    <form:input type="text" path="name" id="name" name="name" placeholder="Enter Name" />
    <br />
    <p>
        <form:errors path="name" />
    </p>


    <label>Mail ID : </label> <br>
    <form:input type="text" path="email" name="email"/> <br>


    <input type="submit" value="Submit">  <br>



<br>

<a href="list"> <input type="submit" value="View"> </a>
</form:form>
</body>
</html>
