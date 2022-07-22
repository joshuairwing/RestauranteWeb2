<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Pagamento</title>
</head>
<body>
<h1>Cadastro de Nova Formas de Pagamento</h1>

  <form method="post" action="/formaPagamento/cadastro">

      <input type="text" class="login_input" placeholder="Descrição" name="descricao">
      <span class="login_border"></span> <br>

      <input type = "submit" value="Cadastrar"/>

  </form>

${msg}
</body>
</html>