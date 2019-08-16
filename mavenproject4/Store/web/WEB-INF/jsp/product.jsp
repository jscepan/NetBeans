<%-- 
    Document   : product
    Created on : Aug 16, 2019, 9:49:35 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <a href="index.htm">Naslovna</a>
    <u>Proizvod</u>
    <a href="customer.htm">Kupci</a>
    <a href="sales.htm">Prodaja proizvoda</a>
    <title>Proizvodi</title>
</head>
<body>
    <h1>Pregled proizvoda:</h1>
    <a href="product_create.htm">Kreiraj novi proizvod</a>
    <%!List<Product> listOfAllProducts;%>
    <%
        listOfAllProducts=Product.getAllProduct();
        for (Product product: listOfAllProducts) {
    %>
    <p>ID: proizvoda: <% out.println(product.getProductId());%> , NAZIV: <% out.println(product.getName());%>; 
        <a href="product_change.htm?idproduct=<% out.println(product.getProductId());%>">Izmeni proizvod</a> , 
        <a href="product_delete.htm?idproduct=<% out.println(product.getProductId());%>">Obrisi proizvod</a></p>
    <%
;}
    %>
</body>
</html>
