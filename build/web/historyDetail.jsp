<%-- 
    Document   : historyDetail
    Created on : Mar 10, 2021, 3:23:09 PM
    Author     : Ticket 1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Product Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>

    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Renting History</b></h2>
                        </div>
                    </div>
                </div>
                <p style="color: red" >${requestScope.NOTIFY}</p>
                <p style="color: red">${requestScope.INVALID}</p>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Detail ID</th>
                            <th>Rental ID</th>
                            <th>Car ID</th>
                            <th>Price</th>
                            <th>Start Date</th>
                            <th>End Date</th> 
                            <th>Feedback Content</th> 
                            <th>Star</th> 
                            <th>Feedback</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="detail" varStatus="counter" items="${requestScope.LIST_DETAIL}">
                            <tr>
                                <td>${detail.detailID}</td>
                                <td>${detail.rentalID} </td>
                                <td>${detail.carID}</td>
                                <td>${detail.price}</td>
                                <td>${detail.startDate} </td>
                                <td>${detail.endDate}</td>
                                <td>${detail.feedbackContent}</td>
                                <td>${detail.rateStar}</td>

                                <td>
                                    <form action="checkEndDate">
                                        <input type="hidden" name="txtDetailID" value="${detail.detailID}" />
                                        <input type="hidden" name="rentalID" value="${detail.rentalID}" />
                                        <input type="submit" value="Take a feedback" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

                <p style="color: red">${requestScope.FEEDBACK_SUCCESS}</p> 
            </div>
            <a href="SearchHistoryController"><button type="button" class="btn btn-primary">Back to renting history</button></a>

        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>

