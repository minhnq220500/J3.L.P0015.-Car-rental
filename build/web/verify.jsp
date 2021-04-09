    <%-- 
    Document   : verify
    Created on : Mar 6, 2021, 6:40:25 PM
    Author     : Ticket 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>
        <span>${sessionScope.LOGIN_USER.name}, You have to verify your email before using ours service!</span>
        Click here to verify your email:
        <form action="verify" method="post">
            <input type="submit" value="Verify">
        </form>
        Return later:
        <form action="logout" method="post">
            <input type="submit" value="Return to home page">
        </form>
    </body>
</html>
