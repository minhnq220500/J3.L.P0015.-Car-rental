<%-- 
    Document   : feedback
    Created on : Mar 10, 2021, 4:28:25 PM
    Author     : Ticket 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback Page</title>
        <style>
            input[type=text], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type=number], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type=submit] {
                width: 100%;
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            div {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
        </style>

    </head>
    <body>
        <h1>Feedback Form</h1>

        <form action="feedback">
            <h2>Rental ID: ${requestScope.rentalID} </h2>
            <h2>Rental Detail ID: ${requestScope.txtDetailID}</h2>
            
            <input type="hidden" name="txtDetailID" value="${requestScope.txtDetailID}" />
            <input type="hidden" name="rentalID" value="${requestScope.rentalID}" />
            
            Feedback Content: </br>
            <input type="text" name="txtFeedbackContent" value="" style="width: 500px"/> </br>
            
            Rate Star:</br>
            <select name="ckbStar" style="width: 500px">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select></br>

            <input type="submit" value="Send Feedback" name="btnAction" style="width: 300px" />

        </form>
        </br>
        <form action="historyDetail">
            <input type="hidden" name="rentalID" value="${param.rentalID}" />
            <input type="submit" value="Return to history detail page" name="btnAction" style="width: 300px" />
        </form>
    </body>
</html>
