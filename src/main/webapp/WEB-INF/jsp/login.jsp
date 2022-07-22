<!DOCTYPE html>
<html lang="en">
<head>
<script>
const init = () => {

    const validateEmail = (event) =>{ //Validacao do Email
        const input = event.currentTarget;
        const regex =  /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
        const emailTeste = regex.test(input.value);

        // for (; ; ;) {
        // const input = event.currentTarget;
        // }

        if (!emailTeste){
            sumitButton.setAttribute('disabled', 'disabled');
            input.nextElementSibling.classList.add('error');
        } else {
            sumitButton.removeAttribute('disabled');
            input.nextElementSibling.classList.remove('error')
        }
    }

    const validatePassword = (event) => { //Validacao de Senha
        const input = event.currentTarget;

        if (input.value.length < 8){
            sumitButton.setAttribute('disabled', 'disabled');
            input.nextElementSibling.classList.add('error');
        } else {
            sumitButton.removeAttribute('disabled');
            input.nextElementSibling.classList.remove('error')
        }
    }

    const inputEmail = document.querySelector('input[type="email"]');
    const inputPassword = document.querySelector('input[type="password"]');
    const sumitButton = document.getElementById("sumit");

    inputEmail.addEventListener('input', validateEmail);
    inputPassword.addEventListener('input', validatePassword);

    const erroHandler = () => { //Login Invalido

        //if (sumitButton.classList.remove('success')) {
        //
        // }
        sumitButton.classList.remove('success');
        sumitButton.classList.add('error');
        sumitButton.textContent = 'Login Invalido'
    }
    //Login OK
    const sucessHandler = () => {
        sumitButton.classList.remove('error');
        sumitButton.classList.add('success');
        sumitButton.textContent = 'Login OK'
    }

    if(sumitButton) {
        sumitButton.addEventListener('click', (event) => {
            event.preventDefault();

            sumitButton.textContent = ' ';

            //API utilizada: regres.api

            fetch('https://reqres.in/api/login',{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    email: inputEmail.value,
                    password: inputPassword.value
                })
            }).then((response)=> {
                    if (response.status !==200){
                        return erroHandler();
                    }
                    sucessHandler();
            })
                .catch(()=>{
                 erroHandler();
                })
        })
    }
}
window.onload = init;

</script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script defer src="./script.js"></script>
    <title>Login</title>
</head>
<body>

    <main class="login">
        <div class="login_container">
            <h1 class="login_title">Login</h1>
            <form action="" class="login_form">
                <input type="email" class="login_input" placeholder="E-mail">
                <span class="login_border"></span><br>

                <input type="password" class="login_input" placeholder="Password">
                <span class="login_border"></span><br>

                <button id="sumit" class="login_submit">Logar</button><br>
                <a class="login_reset" href="/registro">Sem cadastro? Registre-se.</a>
                <p></p>
            </form>
        </div>

    </main>
</body>
</html>