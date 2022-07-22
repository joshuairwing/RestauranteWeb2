<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Cadastro de Carro</h1>
	<a href="/">home</a>

	<form method="post" action="/cliente/cadastro">
	
		Placa: <input type="text" name="placa"/>
		Modelo: <input type="text" name="modelo"/>
		Cor: <input type="text" name="cor"/>
		Fabricante: <input type="text" name="fabricante"/>
		
		<input type = "submit" value="cadastrar"/>
	
	</form>

</body>
</html>