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
		<a href="todoActor.jsp">Atras</a>
	</div>
	<form action="inscribirActores" method="post">
		<span>Nombre:</span><input type="text" name="name"> 
		<span>Apellidos:</span><input type="text" name="surname"> <input type="submit">
	</form>


</body>
</html>