<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
</head>
<body>
    <main class="login">
        <div class="login_container">
            <h1 class="login_title">Registro</h1>
        
            
            <form method="post" action="/cliente/cadastro" class="login_form">

                <input type="text" class="login_input" placeholder="CPF" name="cpf">
                <span class="login_border"></span><br>

                <input type="text" class="login_input" placeholder="Nome" name="nome">
                <span class="login_border"></span><br>
                
                   <input type="text" class="login_input" placeholder="Telefone" name="Telefone">
                <span class="login_border"></span><br>
                
                
                <input type="email" class="login_input" placeholder="E-mail" name="email">
                <span class="login_border"></span><br>

                <input type="password" class="login_input" placeholder="Senha" name="senha">
                <span class="login_border"></span><br>

                <input type="password" class="login_input" placeholder="Repita a senha" name="password_repetida">
                <span class="login_border"></span><br>

		<input type = "submit" value="Cadastrar"/>
            </form>
        </div>


    </main>
</body>
</html>