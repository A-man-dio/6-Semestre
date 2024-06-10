<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Configurações do Perfil</title>
    <link rel="stylesheet" href="configPerfil.css">
</head>

<body>

    <header>
        <nav id="barraNav">
            <div id="logo">ISP SHOP</div>

            <div>
                <form action="" id="formPesquisar">
                    <input type="text" id="pesquisar" name="search" placeholder="Pesquisar">
                    <button type="submit">Ok</button>
                </form>
            </div>

            <a href="../addComida/addComida.php"><button class="botao" id="btnAddComida">Adicionar Comida</button></a>
            <a href="../Perfil/perfil.php"><button class="botao" id="btnVoltar">Voltar</button></a>
        </nav>
    </header>

   

    <div class="card-container">

    <?php
        include_once '../model/product.php';
        include_once '../dbconfig/conexao.php';
        
            $username = $_SESSION["username"];
            $sql = "SELECT * FROM produto where username = ? ";
            
            $stmt = Conexao::getConn()->prepare($sql);
            $stmt->bindValue(1, $username);
            $stmt->execute();
            
            if($stmt->rowCount() > 0) {
                while($row = $stmt->fetch(\PDO::FETCH_ASSOC)) {
                    $nome_produto = $row['nome'];
                    $descricao = $row['descricao'];
                    $path = $row['path_imagem'];
                     ?>
                        <div class="card">
                            <img src="<?php echo $path ?>" alt="">
                            <div class="card-content">
                                <h3><?php echo $nome_produto ?></h3>
                                <p><?php echo $descricao ?></p>
                                <a href="../visualizarItem/visualizarItem.php" class="btn">ler mais</a>
                            </div>
                        </div>
                    <?php
                }
            } else {        
                //echo "<p id='aviso'>Nenhum produto disponível no momento.</p>";
            }
        
        ?>

       
    </div>

</body>

</html>