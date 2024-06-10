<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="entrar.css">
    <title>Signin</title>
</head>

<body>
    <div class="container">
        <div class="box form-box">

            <?php
                include_once '../model/user.php';
                include_once '../controller/UserController.php';

                $nome = filter_input(INPUT_POST, 'nome');
                $sobrenome = filter_input(INPUT_POST, 'sobrenome');
                $username = filter_input(INPUT_POST, 'username');
                $password = filter_input(INPUT_POST, 'password');
                $contato = filter_input(INPUT_POST, 'contacto');
                $btn = filter_input(INPUT_POST, 'btn');
                
                
                $userController = new UserController();

                if (isset($btn)) {
                    
                    $user = new User();
                    $user->setNome($nome);
                    $user->setSobrenome($sobrenome); 
                    $user->setUsername($username);
                    $user->setPassword($password);
                    $user->setContacto($contato);
                ?>

                    <script>
                        alert("Cadastro feito com sucesso");
                    </script>
                <?php
                    $userController->addUser($user);
                    echo "<meta http-equiv=\"refresh\" content=\"URL=http://localhost/refeitorio/loginCadastro/login.php\">";
                }
            ?>


            <header>Registrar</header>
            <form action="" method="post">
                <div class="field input">

                    <label for="Nome">Nome:</label>
                    <input type="text" name="nome" id="nome" placeholder="Digite o seu nome" required>
                    </div>

                <div class="field input">

                    <label for="Sobrenone">Sobrenome:</label>
                    <input type="text" name="sobrenome" id="sobrenome" placeholder="Digite o seu sobrenome" required>
                    
                </div>

                 <div class="field input">

                    <label for="Nome de Usuário">Nome de Usuário:</label>
                    <input type="text" name="username" id="username" placeholder="Digite o seu nome de usuário" required>
                    
                </div>

                <div class="field input">

                    <label for="Nome de Usuário">Contacto:</label>
                    <input type="text" name="contacto" id="contacto" placeholder="Digite o seu número" required>
                
                </div>

                <div class="field input">

                    <label for="password">Senha</label>
                    <input type="password" name="password" id="password" placeholder="Digite a sua senha" required>
                </div>

                <div class="field">
                    <input type="submit" class="btn" name="btn" value="Criar Conta">
                </div>
            </form>

        </div>


    </div>


</body>

</html>