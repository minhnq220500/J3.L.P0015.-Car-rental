<%-- 
    Document   : home
    Created on : Mar 4, 2021, 10:16:18 PM
    Author     : Ticket 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <!--begin of menu-->
        <jsp:include page="header_page_style.jsp"></jsp:include>
            <!--end of menu-->


            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="HomeController">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                            <ul class="list-group category_block">

                            <c:forEach items="${requestScope.LIST_CATE}" var="cate">
                                <li class="list-group-item text-white ${requestScope.CATE_ID == cate.categoryID? "active":"" } ">
                                    <a href="category?categoryID=${cate.categoryID}">${cate.categoryName}</a>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>



                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach var="car" items="${requestScope.LIST_CAR}">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${car.picture}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?carID=${car.carID}" title="View Car">${car.carName}</a></h4>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${car.price} đ</p>
                                            </div>

                                            <div class="col">
                                                <c:if test="${sessionScope.LOGIN_USER.roleID=='US'}">
                                                    <form action="setDetail">
                                                        <input type="hidden" name="txtID" value="${car.carID}" />
                                                        <input type="submit" value="Add To Cart" name="btnAction" class="btn btn-success btn-block" />
                                                    </form>
                                                </c:if>

                                                <c:if test="${sessionScope.LOGIN_USER==null}">
                                                    <a href="login.jsp" class="btn btn-success btn-block" >Add To Cart</a>
                                                </c:if>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <nav>

                        </nav>
                    </div>
                </div>

            </div>

            <!-- paging --> 
                <nav style="margin: 20px auto; width: 500px" aria-label="...">
                    <ul class="pagination pagination-lg">
                        <c:forEach begin="1" end="${requestScope.endPage}" var="i">
                            <li class="page-item ${requestScope.INDEX==i? "active":""} ">
                                <a class="page-link" href="paging?index=${i}&txtSearch=${param.txtSearch}&categoryID=${param.categoryID}&txtDateFrom=${param.txtDateFrom}&txtDateTo=${param.txtDateTo}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>

            <!-- -->
            <c:if test="${requestScope.SEARCH_DATE !=null } ">
<!--                <nav style="margin: 20px auto; width: 500px" aria-label="...">
                    <ul class="pagination pagination-lg">
                        <c:forEach begin="1" end="${requestScope.endPage}" var="i">
                            <li class="page-item ${requestScope.INDEX==i? "active":""} ">
                                <a class="page-link" href="searchByDate?index=${i}&txtSearch=${param.txtSearch}&categoryID=${param.categoryID}&txtDateFrom=${param.txtDateFrom}&txtDateTo=${param.txtDateTo}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>-->
            </c:if>

        </div>

        <!-- Footer -->
        <jsp:include page="footer_page_style.jsp"></jsp:include>
    </body>
</html>
