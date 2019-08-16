<%-- 
    Document   : product_change
    Created on : Aug 16, 2019, 10:24:12 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmena podataka o proizvodu</title>
    </head>
    <body>
        <h1>Stari naziv proizvoda je:</h1>
        ${product_name}

        <p>Unesite novi naziv proizvoda:</p>
        <form action="product_change.htm" method="POST">
            <input type="text" name="new_product_name">
            <input type="hidden" name="new_product_id" value="${product_id}">
            <input type="submit" value="Potvrdi">
        </form>
        <a href="product.htm">Vrati se nazad</a>
    </body>
</html>
