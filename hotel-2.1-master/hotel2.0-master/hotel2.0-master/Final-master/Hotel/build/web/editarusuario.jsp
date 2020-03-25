<%@page import="logica.Usuario"%>
<%@page import="logica.Reserva"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
        <link rel="STYLESHEET" type="text/css" href="estilo\Estilo1.0.css">
        <script type="text/javascript" src="funciones\funciones.js"></script>
    </head>
    <body background="imagenes1.0\Fondo.jpg">
        <form id="frmActualizarContacto" action="ActuaUsuario" method="get">
            <input type="hidden" id="txtId" name="id" value="<%= ((Usuario) session.getAttribute("usuario")).getId()%>">
            <table>
                <tr>
                    <td colspan="3">
                        <h3 style="font-size: 50px">INFORMACIÓN PERSONAL</h3></td>
                    <td rowspan="3"><img src="imagenes1.0\Gimnasio.png"></img></td>
                </tr>
                <tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" id="nombre" name="nombre" value="<%= ((Usuario) session.getAttribute("usuario")).getNombre()%>"></td>
                </tr>
                <tr>
                    <td>Dias</td>
                    <td><input type="text" id="dias" name="dias" value="<%= ((Reserva) session.getAttribute("reserva")).getDias()%>"></td>
                </tr>
                <tr>
                    <td>Numero de habitacion</td>
                    <td><input type="text" id="num_hab" name="num_hab" value="<%= ((Reserva) session.getAttribute("reserva")).getNum_habitacion()%>"></td>
                </tr>
                <tr>
                    <td>Tipo</td>
                    <td><select id="tipo" name="tipo" value="<%= ((Reserva) session.getAttribute("reserva")).getTipo()%>"><option>Sencilla</option>
                            <option>Doble</option>
                            <option>Luxury</option></select></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="Aceptar" onclick="submit();"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
