<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Comida</title>
    <link rel="stylesheet" href="addComida.css">
</head>
<body>
    <div class="container">
        <div class="box form-box">
        
        <?php
            include_once '../model/product.php';
            include_once '../dbconfig/conexao.php';

            $product = new Product();
            $preco = filter_input(INPUT_POST, 'preco');
            $descricao = filter_input(INPUT_POST, 'descricao');
            $arquivo = $_FILES['imagemComida'];
            $nome = filter_input(INPUT_POST, 'NomeComida');
            $btn = filter_input(INPUT_POST, 'btn');
            $username = $_SESSION['username'];

            if( isset($btn)){

                if($arquivo ['erro'])
                    die("Falha ao enviar arquivo!");
                $pasta = 'arquivos/';
                $nomeDoArquivo = $arquivo['name'];
                $novoNomeDoArquivo = uniqid();
                $extensao = strtolower(pathinfo($nomeDoArquivo, PATHINFO_EXTENSION));
                if($extensao != "jpg" && $extensao != "png" && $extensao != "jpeg")
                    die ("Tipo de arquivo inválido");
                $tmp_name = $arquivo['tmp_name'];
                $path = $pasta . $novoNomeDoArquivo . "." . $extensao;
                var_dump(move_uploaded_file($tmp_name, $path));
                //sudo chmod -R 777 arquivos
                $verify = move_uploaded_file($tmp_name, $path); 
                
                $product->setNome($nome);
                $product->setDescricao($descricao);
                $product->setPath($path);
                $product->setPreco($preco);
                $product->setUsername($username);

                //var_dump($product);
                
                if(true){
                $sql = 'INSERT INTO produto (nome,descricao,path_imagem,preco,username) VALUES (?,?,?,?,?)';
                $stmt = Conexao::getConn()->prepare($sql);
                $stmt->bindValue(1, $product->getNome());
                $stmt->bindValue(2, $product->getDescricao());
                $stmt->bindValue(3, $product->getPath());
                $stmt->bindValue(4, $product->getPreco());
                $stmt->bindValue(5, $product->getUsername());
                $stmt->execute();
        ?>
            <script>
                    alert("Adição realizada com sucesso");
                    
            </script>
        <?php
                //echo "<meta http-equiv=\"refresh\" content=\"URL=http://localhost/refeitorio/loginCadastro/login.php\">";
                
                
            }
            else{
                ?>
            <script>
                alert("Não foi possivel adicionar o ficheiro");
                </script>
            <?php
            var_dump($tmp_name);
                }
            }
        ?>

            <header>Adicionar Comida</header>
            <form action="" method="post" enctype="multipart/form-data">
                <div class="field input">

                    <label for="NomeComida">Nome da Comida:</label>
                    <input type="text" name="NomeComida" id="NomeComida" placeholder="Digite o nome da comida" required>
                    <label for="Descricao">Descrição da comida:</label>
                    <textarea name="descricao" id="descricao" cols="10" rows="4" placeholder="  Digite a descrição da comida" required></textarea>

                    <label for="Preco">Preço (em kwanzas):</label>
                    <input type="number" id="preco" name="preco" placeholder="Digite o preço da comida"  required>

                    <label for="ImagemComida" id="labelImg">Imagem da comida</label>
                    <input type="file" id="imagemComida" name="imagemComida">
                    
                </div>

                <div class="field">
                    <input type="submit" class="btn" name="btn" value="Adicionar">
                </div>

                <div class="field">
                    <button class="btn" id = "voltar" onclick="window.location.href='../configPerfil/configPerfil.php'">Voltar</button>
                </div>
            </form>
        </div>
    </div>



</body>
</html>