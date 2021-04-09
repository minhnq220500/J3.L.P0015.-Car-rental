<%-- 
    Document   : history
    Created on : Mar 9, 2021, 7:42:20 PM
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

                <form action="searchHistory">
                    <input type="date" name="txtRentalDate" value="${param.txtRentalDate}" required="" />
                    <input type="submit" value="Search" />
                </form>


                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Rental ID</th>
                            <th>Total Price</th>
                            <th>Rental Date</th>
                            <th>Email</th>
                            <th>Discount ID</th>

                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="rental" varStatus="counter" items="${requestScope.LIST_RENTAL}">
                            <tr>
                                <td>
                                    <a href="historyDetail?rentalID=${rental.rentalID}">${rental.rentalID}</a>
                                </td>
                                <td>${rental.totalPrice} $</td>
                                <td> <input type="date" name="txtRentalDate" value="${rental.rentalDate}" /> </td>
                                <td>${rental.email}</td>
                                <td>${rental.discountID}</td>

                                <td>
                                    <form action="DeleteHistoryController">
                                        <input type="hidden" name="txtRentalID" value="${rental.rentalID}" />
                                        <input type="submit" value="Delete" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

                <p style="color: red">${requestScope.NOTE}</p>
            </div>
            <a href="HomeController"><button type="button" class="btn btn-primary">Back to home</button></a>

        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
