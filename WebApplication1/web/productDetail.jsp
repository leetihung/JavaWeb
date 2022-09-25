<%-- 
    Document   : productDetail
    Created on : 2022/9/24, 下午 12:42:48
    Author     : leeti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品細節</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>
    <body>
        <div class="container text-center">
        <h1>手機商城</h1>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="ProductList">返回商城</a>
                <a class="navbar-brand" href="AddCart">查看購物車</a>
            </div>
        </nav>
        <div class="container text-center">
            <div class="row">
                產品代碼:${p.id}
            </div>
            <div class="row">
                產品名稱:${p.pname}
            </div>
            <div class="row">
                產品介紹:${p.description}
            </div>
            <div class="row">
                產品價格:${p.price}
            </div>
        </div>
        <br/>
        <div class="navbar-brand col-5">
        <form method="post" action="AddCart">
            <input hidden="id" name="id" value="${p.id}"/>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">購買數量:</span>
                <input type="text" class="form-control" name="buynum">
                <input class="btn btn-primary" type="submit" value="加入購物車"/>
            </div>
        </form>
        </div>    
        </div>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
       
    </body>
    
</html>
