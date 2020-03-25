<%-- 
    Document   : index
    Created on : 24/03/2020, 08:41:52 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hotel transilvania</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
	<form  action ="imprimirreserva" method="get">
            <center>
		<table>
			<tr>
			
			<tr>
				<td> Nombre: </td>
				<td> <input type="text" id="nombre" name="nombre">	</td>
			</tr>
			
			<tr>			
				<td> ID </td>
				<td> <input type="number" id="id" name="id">	</td>
			</tr>
			
			<tr>
				<td>
					<label for="start">Salida: </label>
				</td>
				<td>
					<input type="number" id="dias" name="dias">				
				</td>
						
			</tr>
			<tr>
			<td>Tipo de Habitacion: </td>
			
			<td>
				<select id="tipo" name="tipo"><option>Sencilla</option>
                            <option> Doble</option>
                            <option>Luxury</option></select></td>
							</tr>
			</table>
		<input type="submit">
		
		</form>
    </body>
</html>

