<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="perfil.css">
</head>

<body>

    <header>
        <div>
            <nav id="barraNav">
               
                <div id="logo">ISP SHOP</div>

                <div>
                    <form action="" id="formPesquisar">
                        <input type="text" id="pesquisar" name="search" placeholder="Pesquisar">
                        <button type="submit" class="botao">Ok</button>
                    </form>
                </div>
               

                <ul id="menuNav1">
                    <li id="itemImagem"><img src="foto-de-perfil-masculino-silhueta-perfil-avatar-icone-simbolo-700-148417577.jpg" alt=""></li>
                    <?php
                        session_start();
                        if(isset($_SESSION['username'])) {
                            $username = $_SESSION['username'];
                            echo "<div id='nomeUsuario'><a href='../configPerfil/configPerfil.php' id='nomeUsuarioLink'>$username</a></div>";
                        } else {
                            echo "<div id='nomeUsuario'><a href='../configPerfil/configPerfil.php' id='nomeUsuarioLink'>Usuário</a></div>";
                        }
                    ?>
                </ul>

            </nav>
        </div>

    </header>

    <div class="card-container">
        <?php
            include("php/config.php");

            $query = "SELECT * FROM produto";
            $result = $mysqli->query($query);

            if($result->num_rows > 0) {
                
                while($row = $result->fetch_assoc()) {
                    $nome = $row['nome'];
                    $descricao = $row['descricao'];
                    $path_imagem = $row['path_imagem'];
                    $contacto_produto = $row['contacto'];

                    echo "<div class='card'>
                            <img src='$path_imagem' alt=''>
                            <div class='card-content'>
                                <h3>$nome</h3>
                                <p>$descricao</p>
                                <a href='../visualizarItem/visualizarItem.php?contacto=$contacto_produto&nome=$nome' class='btn'>ler mais</a>
                            </div>
                          </div>";
                }
            } else {
                
                echo "<p>Nenhum produto disponível no momento.</p>";
            }
        ?>
    </div>
</body>
</html>
