<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Owners and their pets</title>
</head>
<body>
	<form action="cargarListadoDirector" method="post">
		<input type="submit" value="ver listado">
	</form>


	<%
		List<Director> directores = (List<Director>) request.getAttribute("listAllDirectores");
		pageContext.setAttribute("directores", directores);
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
				<td>Cod director</td>
				<td>Name</td>
				<td>Surname</td>	
				<td>Borrar</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="owner1" items="${listAllActores}">
				<tr>
					<td><c:out value="${director1.codDirector}" /></td>
					<td><c:out value="${director1.name}" /></td>
					<td><c:out value="${director1.surname}" /></td>
					
					<td><a href="/confirmDeleteOwner?codOwner=${director1.codDirector}">DELETE</a>
					</td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>