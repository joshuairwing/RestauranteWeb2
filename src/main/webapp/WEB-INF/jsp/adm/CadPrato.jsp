<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Prato</title>
</head>
<body>

<h1>Cadastro de Novo Prato</h1>
  <form method="post" action="/prato/cadastro">

                <input type="text" class="login_input" placeholder="Nome" name="nome">
                <span class="login_border"></span> <br>
                
                <input type="text" class="login_input" placeholder="Descrição" name="descricao">
                <span class="login_border"></span> <br>

                <input type="text" class="login_input" placeholder="Preço" name="preco">
                <span class="login_border"></span> <br>

		        <input type = "submit" value="Cadastrar"/>

  </form>

${msg}
</body>
</html>