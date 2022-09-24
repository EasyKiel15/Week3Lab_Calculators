<%-- 
    Document   : agecalculator
    Created on : 24-Sep-2022, 12:59:54 PM
    Author     : ezeki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week3_Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age" value="${age}">
            Enter your age: <input type="number" name="age" value="currentAge"><br>
            <input type="submit" value="Age next birthday">
        </form>
        <p>${message}</p>
    </body>
</html>
