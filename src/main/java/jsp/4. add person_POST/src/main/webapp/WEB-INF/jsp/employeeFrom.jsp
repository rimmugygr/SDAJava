<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring boot formularz</title>
</head>
<body>
<h2>Szczegóły pracownika</h2>
<form method="post" action="saveDetails">
    Wprowadź imię pracownika : <input type="text" name="employeeName"/>
    <br>
    Wprowadź adres email prcownika: <input type="email" name="employeeEmail">
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
