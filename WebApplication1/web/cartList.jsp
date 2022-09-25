<%-- 
    Document   : cartList
    Created on : 2022/9/24, 下午 02:12:43
    Author     : leeti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購物車</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>
    <body>
        <div class="container text-center">
            <h1>手機商城</h1>
            <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="ProductList">返回商城</a>
                </div>
            </nav>
        
        <table class="table" border="1">
            <thead>
                <tr>
                    <td>產品代碼</td>
                    <td>產品名稱</td>
                    <td>產品介紹</td>
                    <td>數量</td>
                    <td>金額</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.cartList}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td><a href="ProductServlet?id=${p.id}">${p.pname}</td>
                        <td>${p.description}</a></td>
                        <td>${p.buynum}</td>
                        <td>${p.buynum * p.price}</td>
                    </tr>
                </c:forEach>
                    
            </tbody>
        </table>    
            <div class="container text-right" >總金額為:${sessionScope.price}</div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        </div>
    </body>
</html>
