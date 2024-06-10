<?php
    session_start();
    $username = $_SESSION['username'];
    include ("php/config.php");
    if(isset($_FILES['imagemComida']) && isset($_POST['preco']) && isset($_POST['descricao']) && isset($_POST['NomeComida'])){
        $arquivo = $_FILES['imagemComida'];
        $preco = $_POST['preco'];
        $descricao= $_POST['descricao'];
        $nome= $_POST['NomeComida'];
        if($arquivo ['erro'])
            die("Falha ao enviar aquivo");
        $pasta = "arquivos/";
        $nomeDoArquivo = $arquivo['name'];
        $novoNomeDoArquivo = uniqid();
        $extensao = strtolower(pathinfo($nomeDoArquivo, PATHINFO_EXTENSION));
        if($extensao != "jpg" && $extensao != "png" )
            die ("Tipo de arquivo inválido");
        $path = $pasta . $novoNomeDoArquivo . "." . $extensao;
        $verify = move_uploaded_file($arquivo['tmp_name'], $path);
        if(!$verify)
            echo("<p>Falha ao enviar arquivo</p>");
        else{
        $query = "SELECT conctato FROM usuario WHERE username = '$username'";
        $result = $mysqli->query($query);
        $row = $result->fetch_assoc();
        $contacto = $row['contato'];

            $mysqli->query("INSERT INTO produto(nome,descricao,path_imagem,preco,contacto) VALUES ('$nome','$descricao','$path','$preco',''$contacto)") or die($mysqli->error);
        }
    }
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
                    <input type="submit" class="btn" name="submit" value="Adicionar">
                </div>

                <div class="field">
                    <button class="btn" id = "voltar" onclick="window.location.href='../configPerfil/configPerfil.php'">Voltar</button>
                </div>
            </form>
        </div>
    </div>



</body>
</html>