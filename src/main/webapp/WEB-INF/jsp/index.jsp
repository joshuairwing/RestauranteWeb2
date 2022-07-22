<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<h1>Index</h1>
<a href="/login"/>Logar</a><br>
<a href="/registro">Registrar</a><br>
<a href="/adm/">Funções do Administrador</a><br>

${msg}


<c:forEach items="${pratos}" var="item">
			<tr>
				<td>${item.nome}</td>
			</tr>
		</c:forEach>
		
</body>
</html>