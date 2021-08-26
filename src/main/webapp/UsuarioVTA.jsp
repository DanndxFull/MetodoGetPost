<%-- 
    Document   : UsuarioVTA
    Created on : 19/08/2021, 09:19:26 AM
    Author     : PC
--%>

<%@page import="modelo.dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de usuarios</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th><th>Nombre</th><th>Correo</th><th>ROl</th>
                </tr>
            </thead>
            <tbody>
                <% Object lista = request.getAttribute("lista");
                    if (lista != null) {
                        List<Object> listobj = (List) lista;

                        for (Object i : listobj) {
                            UsuarioDTO usu = (UsuarioDTO) i;

                %>
                <tr>
                    <td><%=usu.getId()%></td>
                    <td><%=usu.getNombre()%></td> 
                    <td><%=usu.getCorreo()%></td> 
                    <td><%=usu.getRol()%></td> 
                </tr>
                <%}
                } else {%>
            <h1>La lista llego nula</h1>          
            <%}%>
        </tbody>
    </table>
</body>
</html>
