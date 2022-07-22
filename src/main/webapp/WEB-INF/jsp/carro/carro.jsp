<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Carro de placa ${carro.placa}</h1>
	<a href = "/">home</a></br>
	<a href = "/carro/list">carros cadastrados</a></br>
	
	Modelo:${carro.modelo}<br/>
	Cor:${carro.cor}<br/>
	Fabricante:${carro.fabricante}</br>
	
</body>
</html>