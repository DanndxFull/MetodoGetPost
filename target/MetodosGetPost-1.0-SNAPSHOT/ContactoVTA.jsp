<%-- 
    Document   : ContactoVTA
    Created on : 17/08/2021, 11:27:07 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contacto</title>
    </head>
    <body>
        <form action="ContactoCTO?accion=agregar" method="POST">
            <legends>Formulario de contacto</legends>
            <fieldset>
                <label>Nombre:</label>
                <input type="text" name="txtnombre" required>
                <label>Correo:</label>
                <input type="email" name="txtcorreo" required>
                <label>Asunto:</label>
                <input type="text" name="txtasunto" required>
                <label>Mensaje:</label>
                <textarea type="text" name="txtmensaje:" required></textarea>
                <input type="submit" value="Enviar Mensaje:">
                <input type="reset" value="Limpiar">
            </fieldset>
        </form>
    </body>
</html>
