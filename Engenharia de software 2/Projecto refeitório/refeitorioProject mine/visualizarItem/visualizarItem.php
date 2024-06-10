<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualização de Item</title>
    <link rel="stylesheet" href="visualizarItem.css">
</head>

<body>

    <div class="card-container">
        <?php
            include("php/config.php");

            if(isset($_GET['contacto']) && isset($_GET['nome'])) { 
                $contacto = $_GET['contacto'];
                $nome = $_GET['nome'];

                $query = "SELECT * FROM produto WHERE contacto = '$contacto' AND nome = '$nome'";
                $result = $mysqli->query($query);

                if($result->num_rows > 0) {
                    $row = $result->fetch_assoc();
                    $path_imagem = $row['path_imagem'];
                    $nome_produto = $row['nome'];
                    $descricao = $row['descricao'];
                    $preco = $row['preco'];
                    $contacto = $row['contacto'];

                    echo "<div class='card'>
                            <img src='$path_imagem' alt=''>
                            <div class='card-content'>
                                <h3 id='nome'>$nome_produto</h3>
                                <p id='conteudoDescricao'>$descricao</p>
                                <h3>Preço</h3>
                                <p><span id='preco'>$preco</span> kz</p>
                                <h3>Contacto</h3>
                                <p id='contacto'>$contacto</p>
                                <a href='../Perfil/perfil.php' class='btn'>voltar</a>
                            </div>
                          </div>";
                } else {
                    echo "<p>Nenhum produto encontrado com os parâmetros especificados.</p>";
                }
            } else {
                echo "<p>Parâmetros ausentes.</p>";
            }
        ?>
    </div>

</body>

</html>
