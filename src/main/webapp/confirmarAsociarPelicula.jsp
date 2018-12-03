<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar el borrado</title>
</head>

<%
request.getAttribute("codActor");
 
%>
<body>

	<form action="asociar" method="get">
		<div>¿Está seguro de que desea asociarlos?</div>
		<input type="submit" name="answer" value="SI" />
		<input type="submit" name="answer" value="NO" />
		
		
		<input type="hidden" name="codPelicula" value="${codPelicula}" />

	</form>

</body>
</html>