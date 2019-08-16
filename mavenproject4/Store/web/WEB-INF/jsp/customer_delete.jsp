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
        <title>Brisanje kupca</title>
    </head>
    <body>
        <h1>Naziv kupca je:</h1>
        ${customer_name}
        
        <form action="customer_delete.htm" method="POST">
            <input type="hidden" name="customer_id" value="${customer_id}">
            <input type="submit" value="Potvrdi">
        </form>
            <a href="customer.htm">Vrati se nazad</a>
    </body>
</html>
