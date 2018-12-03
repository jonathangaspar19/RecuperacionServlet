<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List peliculas</title>
</head>
<body>
	<form action="cargarListadoPeliculas" method="post">
		<input type="submit" value="ver listado">
	</form>


	<%
		List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("listAllPeliculas");
		pageContext.setAttribute("pelicula", peliculas);
	%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<table border="1">
		<thead>
			<tr>
				<td>Cod Owner</td>
				<td>Name</td>
				<td>Surname</td>	
				<td>Borrar</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="owner1" items="${listAllPeliculas}">
				<tr>
					<td><c:out value="${pelicula1.codPelicula}" /></td>
					<td><c:out value="${pelicula1.nombrePelicula}" /></td>
					
					<td><a href="/confirmDeletePelicula?codPelicula=${pelicula1.codPelicula}">DELETE</a>
					</td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>