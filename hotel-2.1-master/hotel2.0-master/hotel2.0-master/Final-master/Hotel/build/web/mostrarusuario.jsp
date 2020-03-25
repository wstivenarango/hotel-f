<%@page import="java.util.List"%>
<%@page import="logica.Usuario"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="logica.Usuario"%>
<!DOCTYPE html>
<% ResultSet usuarios = (ResultSet)session.getAttribute("usuarios"); %>
<% ResultSet reserva = (ResultSet)session.getAttribute("reserva"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios Registrados</title>
        <link rel="STYLESHEET" type="text/css" href="estilo\Estilo1.0.css">
        <script type="text/javascript" src="funciones\funciones.js"></script>
    </head>
    <body background="imagenes1.0\Fondo.jpg">
        <table>
            <tr>
                <td colspan="7">
                    <h1>Usuarios</h1>
                </td>
            </tr>
            <tr>
                <td>Id</td><td>Nombre</td><td>Dias</td><td>Numero de habitacion</td><td>Tipo</td>
            </tr>
                <% while (usuarios.next()){ %>
                    <tr>
                        <td><%= usuarios.getString("con_id") %></td>
                        <td><%= usuarios.getString("con_nombre") %></td>
                        <td><%= usuarios.getString("con_dias") %></td>
                        <td><%= usuarios.getString("con_numhab") %></td>
                        <td><%= usuarios.getString("con_tipo") %></td>
                        <td class="links">
                            <a href="CargarUsuario?op=edit&item=<%= usuarios.getString("con_id") %>">Editar</a>
                            <a href="CargarUsuario?op=delete&item=<%= usuarios.getString("con_id") %>">Borrar</a>
                        </td>
                    </tr>
                <% }%>
                <tr>
                    <td colspan="5" class="links"><a href="index.jsp">Agregar</a></td>
            </tr>
        </table>
    </body>
</html>
