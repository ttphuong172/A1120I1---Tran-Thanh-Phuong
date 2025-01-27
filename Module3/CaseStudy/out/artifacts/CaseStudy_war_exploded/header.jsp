<%--
  Created by IntelliJ IDEA.
  User: phuongtt
  Date: 6/21/2021
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <link rel="stylesheet" href="./css/main.css">
</head>
<body>
<div id="header" class="" style="display: flex; justify-content: space-between;background-color: lightsteelblue">
    <div class="logo col-sm-9">
        <img src="../img/logo.jpg" alt="logo">
    </div>
    <div class="name col-sm-3">
        <h3>${sessionScope.login.employee.name}</h3>
    </div>
</div>
<div id="nav" class="row">
    <div class="menu col-sm-8">
        <ul>
            <a href="">
                <li>Home</li>
            </a>
            <a href="/employee">
                <li>Employee</li>
            </a>
            <a href="/customer">
                <li>Customer</li>
            </a>
            <a href="/service">
                <li>Service</li>
            </a>
            <a href="/contract">
                <li>Contract</li>
            </a>
            <a href="/contractdetail">
                <li>Contract Detail</li>
            </a>
        </ul>
    </div>
    <div class="input_icon col-sm-4">
        <input type="text" id="search" placeholder="search">
        <i class="icon fas fa-search"></i>
    </div>
</div>
</body>
</html>
