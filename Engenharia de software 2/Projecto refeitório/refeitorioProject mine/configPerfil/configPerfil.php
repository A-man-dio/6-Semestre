<?php
include("php/config.php");
session_start();

$username = $_SESSION['username'];
$query = "SELECT contato FROM sua_tabela_de_usuarios WHERE username = '$username'";
$result = $mysqli->query($query);
$row = $result->fetch_assoc();
$contato = $row['contato'];

$query = "SELECT * FROM produto WHERE contato = '$contato'";
$result = $mysqli->query($query);
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

    <?php if ($result->num_rows > 0) { ?>
        <div class="card-container">
            <?php while ($row = $result->fetch_assoc()) { ?>
                <div class="card">
                    <img src="<?php echo $row['path_imagem']; ?>" alt="">
                    <div class="card-content">
                        <h3><?php echo $row['nome']; ?></h3>
                        <p><?php echo $row['descricao']; ?></p>
                        <a href="../visualizarItem/visualizarItem.php" class="btn">ler mais</a>
                    </div>
                </div>
            <?php } ?>
        </div>
    <?php } else { ?>
        <p>Nenhum produto encontrado.</p>
    <?php } ?>

</body>

</html>
