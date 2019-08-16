<%-- 
    Document   : product_change
    Created on : Aug 16, 2019, 10:24:12 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmena podataka o kupcu</title>
    </head>
    <body>
        <h1>Stari naziv kupca je:</h1>
        ${customer_name}

        <p>Unesite novi naziv kupca:</p>
        <form action="customer_change.htm" method="POST">
            <input type="text" name="new_customer_name">
            <input type="hidden" name="new_customer_id" value="${customer_id}">
            <input type="submit" value="Potvrdi">
        </form>
        <a href="customer.htm">Vrati se nazad</a>
    </body>
</html>
