<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes Cadastrados</title>
</head>
<body>
<h1>Clientes Cadastrados</h1>

	<c:forEach items="${clientes}" var="item">
				<tr>
					<td>${item.cpf}</td>
				</tr>
	</c:forEach>

</body>
</html>