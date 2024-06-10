<?php
    session_start();
    include("php/config.php");

    if(isset($_POST['submit'])) {
        $username = $_POST['username'];
        $password = $_POST['password'];

        $query = "SELECT * FROM usuario WHERE username = '$username' AND senha = '$password'";
        $result = $mysqli->query($query);

        if($result->num_rows > 0) {
            $_SESSION['username'] = $username;
            header("Location: ../Perfil/perfil.html");
            exit;
        } else {
            echo "<div class='message'>
                    <p>Credenciais inválidas. Por favor, verifique o nome de usuário e senha e tente novamente.</p>
                </div>";
        }
    }
?>
<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="custom/login.css">
    <title>Login do Usuário</title>
</head>

<body>

    <div class="container">
        <div class="box form-box">
            <header> Fazer Login</header>
            <form action="" method="post">
                <div class="field input">

                    <label for="Nome">Nome de usuário</label>
                    <input type="text" name="username" id="Nome" placeholder="Digite o seu nome de usuário" required>

                </div>
                <div class="field input">

                    <label for="password">Senha</label>
                    <input type="password" name="password" id="password" placeholder="Digite a sua senha" required>

                </div>
                <div class="field">
                    <input type="submit" class="btn" name="submit" value="Login">
                </div>

                <div class="field">
                    <button class="btn" id="voltar" onclick="window.location.href='../paginaInicial/paginaInicial.php'">Voltar</button>
                </div>

                <div class="links">
                    Ainda não tens uma conta ? <a id="linkRegisto" href="entrar.php">Criar uma conta</a>
                </div>
            </form>

        </div>


    </div>

</body>

</html>
