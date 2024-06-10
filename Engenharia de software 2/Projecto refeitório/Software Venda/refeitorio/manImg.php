<?php
    if(isset($_FILES['arquivo'])){
        $arquivo = $_FILES['arquivo'];
        if($arquivo ['erro'])
            die("Falha ao enviar aquivo")
        $pasta = "arquivos/";
        $nomeDoArquivo = $arquivo['name'];
        $novoNomeDoArquivo = uniqid();
        $extensao = strtolower(pathinfo($nomeDoArquivo, PATHINFO_EXTENSION));
        if($extensao != "jpg" && $extensao != "png" )
            die ("Tipo de arquivo inválido");
        $verify = move_uploaded_file($arquivo['tmp_name'], $pasta . $novoNomeDoArquivo . "." . $extensao);
        if(!verify)
            echo("<p>Falha ao enviar arquivo</p>");

    }
?>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method = "POST" enctype = "multipart/form-data" action="">
        <p>
            <label for=""> Selecione o arquivo</label>
            <input name = "arquivo" type="file">
        </p>
        <button type ="submit">Enviar arquivo</button>

    </form>
</body>
</html>