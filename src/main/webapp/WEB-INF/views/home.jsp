<html>
<body>
<h2>Insert Employee Info</h2>


<form action="add" method="post">

    <h3 style="color: red">${isAllFieldsEmpty}</h3>

    <label>Employee ID : </label> <br>
    <input type="number" name="empid">
    <h3 style="color: red" >${id}</h3>

    <label>Name : </label> <br>
    <input type="text" name="name">
    <h3 style="color: red">${name}</h3>

    <label>Mail ID : </label> <br>
    <input type="text" name="email">
    <h3 style="color: red">${invalidEmail}</h3>

    <label>Address : </label> <br>
    <input type="text" name="address">
    <h3 style="color: red">${address}</h3>

    <input type="submit" value="Submit">

</form>

<a href="list"> <input type="submit" value="View"> </a>
</body>
</html>
