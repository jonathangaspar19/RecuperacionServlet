<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nueva mascota</title>
</head>

<%
 request.getAttribute("codOwner");
%>

<body>
	<form action="/addPet" method="post">
		<input type="hidden" name="codOwner" value="<c:out value="${codOwner}"/>" >
		<span>Nombre:</span><input type="text" name="name">
		<input type="submit">
	</form>
</body>
</html>