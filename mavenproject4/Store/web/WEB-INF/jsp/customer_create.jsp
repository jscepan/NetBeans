<%-- 
    Document   : product_create
    Created on : Aug 16, 2019, 12:18:29 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kreiranje novog kupca</title>
    </head>
    <body>
        <h1>Kreiranje kupca</h1>
        <p>Unesite naziv novog kupca</p>
        <form action="customer_create.htm" method="POST">
            <input type="text" name="customer_name">
            <input type="submit" value="Potvrdi">
        </form>
            <a href="customer.htm">Vrati se nazad</a>
    </body>
</html>
