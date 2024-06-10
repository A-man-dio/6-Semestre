
<?php 
   session_start();
?>
<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>Login</title>
</head>

<body>

    <div class="container">
        <div class="box form-box">
        <?php
                include_once '../model/user.php';
                include_once '../controller/UserController.php';
                include_once '../repository/userRepository.php';
                
                $username = filter_input(INPUT_POST, 'username');
                $password = filter_input(INPUT_POST, 'password');
                $btn = filter_input(INPUT_POST, 'btn');
                $userController = new UserController();
                $userRepository = new UserRepository();

                if (isset($btn)) {

                   $result = $userRepository->login( $username, $password) ;
                    if($result != null ) {
                        $_SESSION["loggedin"] = true;
                        $_SESSION["username"] = $_POST["username"];
                        header("location: ../Perfil/perfil.php ");
                    }else{
                    ?>
                    <script>
                        alert("Senha ou Username errada")
                    </script>
                    <?php
                        //echo "<meta http-equiv=\"refresh\" content=\"0;URL=http://localhost/refeitorio/loginCadastro/login.php\">";
                    }
                }

            ?>                        
            <header> Fazer Login</header>
            <form action="" method="post">
                <div class="field input">

                    <label for="Nome">Nome de usuário</label>
                    <input type="text" name="username" id="username" placeholder="Digite o seu nome de usuário" required>

                </div>
                <div class="field input">

                    <label for="password">Senha</label>
                    <input type="password" name="password" id="password" placeholder="Digite a sua senha" required>

                </div>
                <div class="field">
                    <input type="submit" class="btn" name="btn" value="Login">
                </div>
                <div class="links">
                    Ainda não tens uma conta ? <a id="linkRegisto" href="entrar.php">Criar uma conta</a>
                </div>
            </form>

        </div>
       

    </div>





</body>

</html>