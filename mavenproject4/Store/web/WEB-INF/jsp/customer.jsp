<%-- 
    Document   : product
    Created on : Aug 16, 2019, 9:49:35 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <a href="index.htm">Naslovna</a>
    <a href="product.htm">Proizvod</a>
    <u>Kupci</u>
    <a href="sales.htm">Prodaja proizvoda</a>
    <title>Kupci</title>
</head>
<body>
    <h1>Pregled kupaca:</h1>
    <a href="customer_create.htm">Kreiraj novog kupca</a>
    <%!List<Customer> listOfAllCustomers;%>
    <%
        listOfAllCustomers=Customer.getAllCustomers();
        for (Customer customer: listOfAllCustomers) {
    %>
    <p>ID: kupca: <% out.println(customer.getCustomerId());%> , NAZIV: <% out.println(customer.getName());%>; 
        <a href="customer_change.htm?idcustomer=<% out.println(customer.getCustomerId());%>">Izmeni kupca</a> , 
        <a href="customer_delete.htm?idcustomer=<% out.println(customer.getCustomerId());%>">Obrisi kupca</a></p>
        <%
    ;}
        %>
</body>
</html>
