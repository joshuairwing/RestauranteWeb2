<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Carros cadastrados</h1>
	<a href = "/">home</a>
	
	<table border="1">
		
		<tr><th>Placa</th><th>Modelo</th><th>Cor</th><th>Fabricante</th><th>operacoes<th></tr>
	
		<c:forEach items="${carros}" var="item">
			<tr>
				<td>${item.placa}</td>
				<td>${item.modelo}</td>
				<td>${item.cor}</td>
				<td>${item.fabricante}</td>
				<td><a href="/carro/visualiza/${item.placa}">visualizar</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>