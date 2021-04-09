<%-- 
    Document   : header_page_style
    Created on : Mar 4, 2021, 10:17:02 PM
    Author     : Ticket 1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Car</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">

                <c:if test="${sessionScope.LOGIN_USER!=null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#"> Hello ${sessionScope.LOGIN_USER.name}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.LOGIN_USER==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login Account</a>
                    </li>
                </c:if>

            </ul>

            <!--search form-->
            <form action="searchByName" method="GET" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <p style="color: white"> Search by name  </p>
                    <input name="txtSearch" value="${param.txtSearch}" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search..." required="">
                    <div class="input-group-append">

                        <input type="hidden" name="index" value="1" required="" />

                        <button type="submit" class="btn btn-secondary btn-number" name="btnAction"value="Search" >
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
            <!--search form-->

            <!--            search form
            -->

            <form action="searchByDate" method="GET" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <p style="color: white">   Search By Date  </p>
                    <p></p>
                    <input name="txtDateFrom" value="${param.txtDateFrom}" type="date" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="From..." required="" >
                    <input name="txtDateTo" value="${param.txtDateTo}" type="date" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="To..." required="">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number" name="btnAction"value="Search By Date" >
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
            <p style="color: red">${requestScope.INVALID}</p>
            <!--search form-->

            <!--            search form
            -->

<!--            <form action="searchByQuantity" method="GET" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <p style="color: white">   Search by Quantity  </p>
                    <p></p>
                    <input name="txtQuantity" value="${param.txtQuantity}" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Number..." required="" >
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number" name="btnAction"value="Search By Quantity" >
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>-->
            <!--search form-->
            
            <c:if test="${sessionScope.LOGIN_USER!=null and sessionScope.LOGIN_USER.roleID!='AD'}">
                <a class="btn btn-success btn-sm ml-3" href="listCart">
                    <i class="fa fa-shopping-cart"></i> View Cart
                    <!--                    <span class="badge badge-light">3</span>-->
                </a>
            </c:if>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Welcome to Rental Car Store!</h1>
    </div>
</section>
<!--end of menu-->


