<%-- 
    Document   : detail
    Created on : Mar 5, 2021, 8:51:26 PM
    Author     : Ticket 1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header_page_style.jsp"></jsp:include>
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

                    <div class="col-sm-9">
                        <div class="container">
                            <div class="card">
                                <div class="row">
                                    <aside class="col-sm-5 border-right">
                                        <article class="gallery-wrap"> 
                                            <div class="img-big-wrap">
                                                <div> <a href="#"><img src="${requestScope.PRODUCT_CAN_TIM.picture}"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${requestScope.PRODUCT_CAN_TIM.carName}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency"></span><span class="num">${requestScope.PRODUCT_CAN_TIM.price} đ</span>
                                            </span> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Car ID</dt>
                                            <dd>
                                                <p>
                                                    ${requestScope.PRODUCT_CAN_TIM.carID}
                                                </p>
                                            </dd>

                                            <dt>Car Type ID</dt>
                                            <dd>
                                                <p>
                                                    ${requestScope.PRODUCT_CAN_TIM.typeID}
                                                </p>
                                            </dd>

                                            <dt>Color</dt>
                                            <dd>
                                                <p>
                                                    ${requestScope.PRODUCT_CAN_TIM.color}
                                                </p>
                                            </dd>

                                            <dt>Year</dt>
                                            <dd>
                                                <p>
                                                    ${requestScope.PRODUCT_CAN_TIM.year}
                                                </p>
                                            </dd>

                                            <dt>Category ID</dt>
                                            <dd>
                                                <p>
                                                    ${requestScope.PRODUCT_CAN_TIM.categoryID}
                                                </p>
                                            </dd>



                                            <c:if test="${sessionScope.LOGIN_USER!=null and sessionScope.LOGIN_USER.roleID=='AD'}">
                                                <dt>Car ID</dt>
                                                <dd>
                                                    <p>
                                                        ${requestScope.PRODUCT_CAN_TIM.carID}
                                                    </p>
                                                </dd>
                                                <dt>Type ID</dt>
                                                <dd>
                                                    <p>
                                                        ${requestScope.PRODUCT_CAN_TIM.typeID}
                                                    </p>
                                                </dd>
                                            </c:if>

                                        </dl>


                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->


                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer_page_style.jsp"></jsp:include>
    </body>
</html>
