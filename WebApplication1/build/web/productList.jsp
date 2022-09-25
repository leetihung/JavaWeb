<%-- 
    Document   : productList
    Created on : 2022/9/24, 上午 11:25:14
    Author     : leeti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商城</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>
    <body>
        <div class="container text-center">
            <h1>手機商城</h1>
        <nav class="navbar navbar-expand-lg bg-light">
            <a class="navbar-brand" href="AddCart">查看購物車</a>
        </nav>
        
        <table class="table" border="1">
            <thead>
                <tr>
                    <td>產品代碼</td>
                    <td>產品名稱</td>
                    <td>產品介紹</td>
                    <td>產品價格</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td><a href="ProductServlet?id=${p.id}">${p.pname}</td>
                    <td>${p.description}</a></td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
