<%-- 
    Document   : setRentalDetail
    Created on : Mar 8, 2021, 6:10:28 PM
    Author     : Ticket 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop Homepage - Start Bootstrap Template</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <c:if test="${sessionScope.LOGIN_USER==null or sessionScope.LOGIN_USER.roleID!='US'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <jsp:useBean id="dao" class="minhnq.daos.CarDAO" scope="request"></jsp:useBean>
        <c:set var="productID" value="${requestScope.PRODUCT_ID}"/>
    </head>

    <body>

        <!-- Navigation -->
        <%@include file="NavComponent.jsp" %>

        <!--container-->
        <div class="container" style="margin-top: 7rem;margin-bottom: 7rem">
            <div class="mt-3">
                <h4>Shopping Cart</h4>
                <a class="btn btn-primary" href="HomeController">Continues Shopping</a>
                <table class="w-100 table table-striped mt-3">
                    <thead>
                        <tr>
                            <th>Image</th>
                            <th>Car ID</th>
                            <th>Name of Car</th>
                            <th>Price</th>
                            <th>Start Date</th>
                            <th>Return Date</th>
                            <th>Confirm</th>
                        </tr>
                    </thead>
                    <tbody>

                    <form action="add">
                        <tr>
                            <td>
                                <img src="${requestScope.CAR.picture}" style="width: 100px">
                            </td>
                            <td>
                                ${requestScope.CAR.carID}
                            </td>
                            <td>
                                ${requestScope.CAR.carName}
                            </td>
                            <td>
                                <fmt:formatNumber type="currency" value="${requestScope.CAR.price}"/>
                            </td>
                            <td>
                                <input type="date" name="txtStartDate" value="${requestScope.CAR.startDate}" min="${requestScope.CURRENT_DATE}" required=""/>
                            </td>
                            <td>
                                <input type="date" name="txtReturnDate" value="${requestScope.CAR.returnDate}" min="${requestScope.CURRENT_DATE}" required=""/>
                            </td>
                            <td>
                                <input type="hidden" name="txtID" value="${requestScope.CAR.carID}"/>
                                <input type="hidden" name="txtStartDate" value="${requestScope.CAR.startDate}"/>
                                <input type="hidden" name="txtEndDate" value="${requestScope.CAR.startDate}"/>

                                <input class="btn btn-info ml-2" class="fas fa-sync-alt mr-2" type="submit" value="Confirm" name="btnAction" />
                            </td>
                        </tr>
                    </form>
                    
                    <p style="color: red">${requestScope.INVALID}</p>
                    <p style="color: red">${requestScope.OUT_OF_STOCK}</p>

                    </tbody>
                </table>
                <hr/>
                <hr/>


            </div>
        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark mt-5">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>

