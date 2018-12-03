<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corfirmar el borrado</title>
</head>

<%
request.getAttribute("codActor");
 
%>
<body>

	<form action="deleteActor" method="get">
		<div>¿Está seguro de que desea borrar el Actor?</div>
		<input type="submit" name="answer" value="SI" />
		<input type="submit" name="answer" value="NO" />
		
		
		<input type="hidden" name="codActor" value="${codActor}" />

	</form>

</body>
</html>