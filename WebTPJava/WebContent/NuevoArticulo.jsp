<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script>
function volver() {
    window.history.back()
}
</script>

<form action="AgregarArticulo" method="post">
		
	
		<table style="width:100%;" >
			<tr>
				<td>Tipo:</td>
				<td>
				<select name="tipo" id="tipo" style="width: 186px; ">
				<OPTION VALUE="Television">Television</OPTION>
				<OPTION VALUE="Lavarropas">Lavarropas</OPTION>
				</select></td>
			</tr>
			
			<tr>
				<td>Descripcion:</td>
				<td><input type="text" name="descripcion" id="descripcion"></td>
			</tr>
			<tr>
				<td>Color:</td>
				<td><select name="color" id="color">
				<OPTION VALUE=""></OPTION>
				<OPTION VALUE="Blanco">Blanco</OPTION>
				<OPTION VALUE="Negro">Negro</OPTION>
				<OPTION VALUE="Rojo">Rojo</OPTION>
				<OPTION VALUE="Azul">Azul</OPTION>
				<OPTION VALUE="Gris">Gris</OPTION>
				</select></td>
			</tr>
			<tr>
				<td>Consumo:</td>
				<td><select name="consumo" id="consumo"><OPTION VALUE=""></OPTION>
				<OPTION VALUE="A">A</OPTION>
				<OPTION VALUE="B">B</OPTION>
				<OPTION VALUE="C">C</OPTION>
				<OPTION VALUE="D">D</OPTION>
				<OPTION VALUE="E">E</OPTION>
				<OPTION VALUE="F">F</OPTION></select></td>
			</tr>
			<tr>
				<td>PrecioBase:</td>
				<td><input type="text" name="precio" id="precio"></td>
			</tr>
			<tr>
				<td>Peso:</td>
				<td><input type="text" name="peso" id="peso"></td>
			</tr>
			<tr>
				<td>Carga:</td>
				<td><input type="text" name="carga" id="carga"></td>
			</tr>
			<tr>
				<td>Pulgadas:</td>
				<td><input type="text" name="pulgadas" id="pulgadas"></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right;"><input type="submit" value="Guardar" style="height: 30px; ">    <input type="button" value="Volver" style="height: 30px;" onclick="volver()"></td>
			</tr>
		</table>
	</form></body>
</html>