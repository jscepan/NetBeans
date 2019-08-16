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
        <title>Kreiranje novog proizvoda</title>
    </head>
    <body>
        <h1>Kreiranje proizvoda</h1>
        <p>Unesite naziv novog proizvoda</p>
        <form action="product_create.htm" method="POST">
            <input type="text" name="product_name">
            <input type="submit" value="Potvrdi">
        </form>
            <a href="product.htm">Vrati se nazad</a>
    </body>
</html>
