<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<td>Nombre Escrito:</td>
			<%
			String nombre = (String) request.getAttribute("nombre");
			%>
			<td><%=nombre%></td>
		</tr>
	</table>



</body>
</html>