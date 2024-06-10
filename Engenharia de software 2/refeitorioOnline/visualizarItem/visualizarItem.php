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
        include_once '../model/product.php';
        include_once '../dbconfig/conexao.php';
        
        if(isset($_GET['user']) && isset($_GET['nome'])) { 
            
            $username = $_GET['user'];
            $nome = $_GET['nome'];
            $sql = "SELECT * FROM produto where username = ? AND nome = ?";
            
            $stmt = Conexao::getConn()->prepare($sql);
            $stmt->bindValue(1, $username);
            $stmt->bindValue(2, $nome);
            $stmt->execute();
            
            if($stmt->rowCount() > 0) {
                while($row = $stmt->fetch(\PDO::FETCH_ASSOC)) {
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
                }
            } else {        
                //echo "<p id='aviso'>Nenhum produto disponível no momento.</p>";
            }
        }
        ?>
    </div>

    
</body>
</html>