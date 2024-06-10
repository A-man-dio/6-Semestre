<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="custom/entrar.css">
    <title>Registrar Usuário</title>
</head>

<body>
    <div class="container">
        <div class="box form-box">
            <header>Registrar</header>
            <?php
            include("php/config.php");

            if(isset($_POST['submit'])) {
                
                $nome = $_POST['Nome'];
                $sobrenome = $_POST['Sobrenome'];
                $username = $_POST['Nome_de_Usuário'];
                $password = $_POST['password'];
                $contacto = $_POST['contacto'];

                $query = "SELECT * FROM usuario WHERE username = '$username'";
                $result = $mysqli->query($query);

                if($result->num_rows > 0) {
                    echo "<div class='message'>
                            <p>Já existe um usuário com este nome de usuário. Por favor, escolha outro.</p>
                        </div>";
                } else {
                    $query = "INSERT INTO usuario (nome, sobrenome, username, senha, contacto) VALUES ('$nome', '$sobrenome', '$username', '$password', '$contacto')";
                    if($mysqli->query($query)) {
                        header("Location: login.html");
                        exit;
                    } else {
                        echo "<div class='message'>
                                <p>Ocorreu um erro ao processar o registro. Por favor, tente novamente.</p>
                            </div>";
                    }
                }
            }
            ?>
            <form action="" method="post">
                <div class="field input">

                    <label for="Nome">Nome:</label>
                    <input type="text" name="Nome" id="Nome" placeholder="Digite o seu nome" required>
                    <label for="Sobrenome">Sobrenome:</label>
                    <input type="text" name="Sobrenome" id="Sobrenome" placeholder="Digite o seu sobrenome" required>
                    <label for="Nome_de_Usuário">Nome de Usuário:</label>
                    <input type="text" name="Nome_de_Usuário" id="Nome_de_Usuário"
                        placeholder="Digite o seu nome de usuário" required>
                </div>

                <div class="field input">
                    <label for="password">Senha</label>
                    <input type="password" name="password" id="password" placeholder="Digite a sua senha" required>
                </div>

                <div class="field input">
                    <label for="contacto">Contacto</label>
                    <input type="text" name="contacto" id="contacto" placeholder="Digite o seu número de telefone" pattern="[0-9]{9}" required title="Este campo não aceita letras e apenas aceita números com 9 dígitos">
                </div>

                <div class="field">
                    <input type="submit" class="btn" name="submit" value="Entrar">
                </div>

                <div class="field">
                    <button class="btn" id="voltar" onclick="window.location.href='../paginaInicial/paginaInicial.php'">Voltar</button>
                </div>

                <div class="links">
                    Já tem uma conta ? <a id="linkCadastrar" href="login.php">Fazer login</a>
                </div>
            </form>

        </div>


    </div>


</body>

</html>
