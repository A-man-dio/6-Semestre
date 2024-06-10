<?php
session_start();
?>
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
                    <div id="nomeUsuario"><a href="../configPerfil/configPerfil.php" id="nomeUsuarioLink">
                            <?php
                            echo $_SESSION["username"];
                            ?>

                        </a></div>
                </ul>

            </nav>
        </div>

    </header>

    <div class="card-container">

    <?php
           include_once '../model/product.php';
           include_once '../dbconfig/conexao.php';

           $username = $_SESSION["username"];
            $sql = "SELECT * FROM produto where username <> ? ";
            
            $stmt = Conexao::getConn()->prepare($sql);
            $stmt->bindValue(1, $username);
            $stmt->execute();
           
            if($stmt->rowCount() > 0) {
                while($row = $stmt->fetch(\PDO::FETCH_ASSOC)) {
                    $nome = $row['nome'];
                    $descricao = $row['descricao'];
                    $path_imagem = $row['path_imagem'];
                    $username = $row['username'];
                    echo "<div class='card'>
                        <img src='$path_imagem' alt=''>
                            <div class='card-content'>
                                <h3>$nome</h3>
                                <p>$descricao</p>
                                <a href='../visualizarItem/visualizarItem.php?user=$username&nome=$nome' class='btn'>ler mais</a>
                            </div>
                          </div>";
                }
            } else {        
                echo "<p id='aviso'>Nenhum produto disponível no momento.</p>";
            }
        ?>

    </div>
</body>

</html>