<%-- 
    Document   : verifyEmail
    Created on : Mar 11, 2021, 3:19:36 PM
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
        <span>We already send a verification  code to your email.</span>
        
        <form action="verifyEmail" method="post">
            <input type="text" name="txtCode" required="" >
            <input type="submit" value="verify">
        </form>
        
        <p style="color: red">${requestScope.WRONG_CODE}</p>
    </body>
</html>
