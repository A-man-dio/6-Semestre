<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="paginaInicial.css">
</head>
<body>
    <header>
        <nav id="barraNav">
            <ul id="menuNav">
                <li id="logo">ISP SHOP</li>
            </ul>
        </nav>
    </header>
    <nav id="desc1">
        <p class = "v1">
           TEXTO 1
        </p>
    </nav>
    <nav id="desc2">
        <p class = "v1">
           TEXTO 2
        </p>
    </nav>
    <main id="conteudo">
        <h1 id="titulo" class="alinhar">
            DEIXE O SEU DIA MAIS SABOROSO!
        </h1>
        <a href="../loginCadastro/login.php" id="link"><button id="botaoLogin">Login</button></a>
        <p id="texto1" class="alinhar">Ainda não possui uma conta?</p>
        <a href="../loginCadastro/entrar.php"><p id="texto2" class="alinhar">Cadastre-se</p></a>
    </main>
    <footer>
        <p>
            @
        </p>
    </footer>
</body>
</html>
