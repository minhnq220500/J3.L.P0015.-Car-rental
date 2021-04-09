<%-- 
    Document   : cart
    Created on : Mar 8, 2021, 8:34:54 AM
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
                            <th>No</th>
                            <th>Image</th>
                            <th>Car ID</th>
                            <th>Name of Car</th>
                            <th>Price</th>
<!--                            <th>Quantity</th>-->
<!--                            <th>Total Price</th>-->
                            <th>Rental Date</th>
                            <th>Return Date</th>
                            <th>Delete</th>
                            <th>Add 1 more car</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cart" varStatus="counter" items="${sessionScope.CART.cart.values()}">

                        <form action="edit">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    <img src="${cart.picture}" style="width: 100px">
                                </td>
                                <td>
                                    ${cart.carID}
                                </td>
                                <td>
                                    ${cart.carName}
                                </td>
                                <td>
                                    <fmt:formatNumber type="currency" value="${cart.price}"/>
                                </td>
<!--                                <td>
                                    <input type="number" min="1" max="${cart.availableQuantity}" name="txtQuantity" value="${cart.quantity}" class="pl-1" style="width: 60px"/>

                                </td>-->
                               <!-- <td>
                                    <fmt:formatNumber type="currency" value="${cart.quantity*cart.price}"/>
                                </td>-->
                                <td>
                                    <input type="date" name="txtStartDate" value="${cart.startDate}" required="" readonly=""/>
                                </td>
                                <td>
                                    <input type="date" name="txtReturnDate" value="${cart.returnDate}" required="" readonly=""/>
                                </td>
                                <td>
                                    <a href="remove?carID=${cart.carID}" class="btn btn-danger" onclick="return confirm('Are you sure want to remove these car?')" ><i class="fas fa-trash"></i></a>
                                </td>
                                <td>
                                    <input type="hidden" name="txtID" value="${cart.carID}"/>
                                    <input type="hidden" name="txtName" value="${cart.carName}"/>
                                    <input type="hidden" name="txtPrice" value="${cart.price}" />
                                    <input type="hidden" name="txtAvailableQuantity" value="${cart.availableQuantity}"/>

                                    <input class="btn btn-info ml-2" class="fas fa-sync-alt mr-2" type="submit" value="Add" name="btnAction" />
                                </td>
                            </tr>
                        </form>

                    </c:forEach>

                    </tbody>
                </table>
                <hr/>
                <div class="text-right">
                    <h4>Total Money:<fmt:formatNumber type="currency" value="${sessionScope.TOTAL_PRICE}"/></h4>
                </div>
                <div class="text-right">             
                    <form action="useDiscount">
                        Discount code: <input type="text" name="txtDiscountCode" value="${param.txtDiscountCode}" required="" />
                        <input type="submit" value="Use Discount Code" />
                        <p style="color: red">${requestScope.CHECK_EXPIRED}</p>
                        <h4>Total Money After discount:<fmt:formatNumber type="currency" value="${sessionScope.TOTAL_PRICE_DISCOUNT}"/></h4>
                        </hr>
                    </form>

                    <form action="rental">
                        <input type="submit" value="Rental" class="btn btn-success ml-2" id="order" />
                    </form>
                </div>

                <form action="searchHistory">
                    <input type="submit" value="Renting History" name="btnAction" />
                    <!--                    <a href="#">Buying History</a>-->
                </form>

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

