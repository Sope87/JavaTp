<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form  action="ListaArticulos" method="post">
<div>
			<table>

				<tr style="height: 27px">
					<td style="font-weight: 10pt; text-align: center">Rango
							de valores:</td>
					<td><input type="text" name="minValue"
						style="width: 90px; height: 27px;"></td>
					<td>a</td>
					<td><input type="text" name="maxValue"
						style="width: 90px; height: 27px;"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="submit"  value="Buscar" name="btnBuscar"  ></td>
				</tr>
			</table>
<table>
		<tr>
		<th>Codigo</th><th>Tipo</th><th>Descripcion</th><th>Precio</th>
		</tr>	
		<tr>
			<td>
			<input type="text" id="txtPrueba" name="txtPrueba">
			
			</td>
			<td>
			<%=(String)request.getAttribute("txtDevuelvo") %>
			</td>
		</tr>		
</table>
			</div>
				</form>
</body>
</html>