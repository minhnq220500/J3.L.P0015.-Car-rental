<%-- 
    Document   : addMoreCar
    Created on : Mar 18, 2021, 9:05:00 AM
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
                <a class="btn btn-primary" href="listCart">Return to Cart</a>
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
                        <c:forEach var="car" items="${requestScope.LIST_CAR}">
                        <form action="add">
                            <tr>
                                <td>
                                    <img src="${car.picture}" style="width: 100px">
                                </td>
                                <td>
                                    ${car.carID}
                                </td>
                                <td>
                                    ${car.carName}
                                </td>
                                <td>
                                    <fmt:formatNumber type="currency" value="${car.price}"/>
                                </td>
                                <td>
                                    <input type="date" name="txtStartDate" value="${car.startDate}" min="${requestScope.CURRENT_DATE}" required=""/>
                                </td>
                                <td>
                                    <input type="date" name="txtReturnDate" value="${car.returnDate}" min="${requestScope.CURRENT_DATE}" required=""/>
                                </td>
                                <td>
                                    <input type="hidden" name="txtID" value="${car.carID}"/>
                                    <input type="hidden" name="txtStartDate" value="${car.startDate}"/>
                                    <input type="hidden" name="txtEndDate" value="${car.startDate}"/>

                                    <input class="btn btn-info ml-2" class="fas fa-sync-alt mr-2" type="submit" value="Confirm" name="btnAction" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>

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
