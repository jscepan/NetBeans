<%-- 
    Document   : product_delete
    Created on : Aug 16, 2019, 3:29:33 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brisanje proizvoda</title>
    </head>
    <body>
        <h1>Naziv proizvoda je:</h1>
        ${product_name}
        
        <form action="product_delete.htm" method="POST">
            <input type="hidden" name="product_id" value="${product_id}">
            <input type="submit" value="Potvrdi">
        </form>
            <a href="product.htm">Vrati se nazad</a>
    </body>
</html>
