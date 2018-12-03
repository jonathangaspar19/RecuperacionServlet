<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo Actor</title>
</head>
<body>
	<div>
		<a href="addActor.jsp">Ver Actores</a>
	</div>
	<form action="inscribirAlumnos" method="post">
		<span>Nombre:</span><input type="text" name="name"> <span>Apellidos:</span><input
			type="text" name="surname"> <input type="submit">
	</form>

	<form action="cargarListado" method="post">
		<input type="submit" value="ver listado">
	</form>


	<%
		List<Actor> Actores = (List<Actor>) request.getAttribute("listAllActores");
		pageContext.setAttribute("actores", Actores);
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
				<td>Editar</td>
				<td>Borrar</td>
				<td>Añadir Macota</td>
				<td>Mascotas</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="owner1" items="${listAllOwners}">
				<tr>
					<td><c:out value="${owner1.codOwner}" /></td>
					<td><c:out value="${owner1.name}" /></td>
					<td><c:out value="${owner1.surname}" /></td>
					<td><a href="/editOwner?codOwner=${owner1.codOwner}">EDIT</a>
					</td>
					<td><a href="/confirmDeleteOwner?codOwner=${owner1.codOwner}">DELETE</a>
					</td>
					<td><a href="/recoveryAddCodOwner?codOwner=${owner1.codOwner}">ADD
							PET</a></td>
					<td><c:forEach var="pet" items="${owner1.mascotas}">
							<c:out value="${pet.name} " />
						</c:forEach></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>