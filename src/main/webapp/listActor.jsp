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
	<form action="cargarListado" method="post">
		<input type="submit" value="ver listado">
	</form>


	<%
		List<Actor> owners = (List<Actor>) request.getAttribute("listAllActores");
		pageContext.setAttribute("owners", owners);
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
			<c:forEach var="owner1" items="${listAllActores}">
				<tr>
					<td><c:out value="${actor1.codActor}" /></td>
					<td><c:out value="${actor1.name}" /></td>
					<td><c:out value="${actor1.surname}" /></td>
					
					<td><a href="/confirmDeleteOwner?codOwner=${actor1.codActor}">DELETE</a>
					</td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>