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
		request.getAttribute("codPelicula");
	%>
	<%
		List<Actor> actor = (List<Actor>) request.getAttribute("listAllActores");
		pageContext.setAttribute("actor", actor);
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
				<td>Cod Actor</td>
				<td>Name</td>
				<td>Surname</td>
				<td>Borrar</td>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="owner1" items="${listAllActores}">
				<tr>
					<td><c:out value="${actor1.codActor}" /></td>
					<td><c:out value="${actor1.nomActor" /></td>


					<td><a
						href="/confirmarAsociarPelicula?codActor=${actor1.codActor}">Asociar
							Actor</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>