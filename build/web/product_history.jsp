<%-- 
    Document   : product_history
    Created on : Jan 16, 2021, 9:35:05 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <c:if test="${sessionScope.LOGIN_USER==null or sessionScope.LOGIN_USER.roleID!='AD'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>
        <a href="MainController?btnAction=Manage Product">Return To Manage Product Page</a>
        
        <c:if test="${not empty requestScope.LIST_HISTORY}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Product History ID</th>
                        <th>Type</th>
                        <th>Record Time</th>
                        <th>Product ID</th>
                        <th>User ID</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_HISTORY}">
                        <tr>
                            <td>${product.productHistoryID}</td>
                            <td>${product.type}</td>
                            <td>${product.recordTime}</td>
                            <td>${product.productID}</td>
                            <td>${product.userID}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
    </body>
</html>
