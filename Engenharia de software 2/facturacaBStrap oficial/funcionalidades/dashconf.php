<?php
include '../conexao.php';

if(isset($_POST['verFatura'])){
    $id_venda = $_POST['escolha'];
    echo "<script>window.location.href = '../fatura.php?idVenda=$id_venda'</script>";
    
}

if (isset($_POST['attEstoque'])) {
    $id_prod = $_POST['escolha'];
    $estoque = $_POST['estoque'];
    if ($estoque < 1)
        echo "<script>alert( 'Insira um valor válido!');
        window.location.href = 'attEstoque.php';</script>";

    $sql = " UPDATE produto SET estoque = :estoque WHERE id = :id_prod";
    $db_arr = [
        'estoque' => $estoque,
        'id_prod' => $id_prod
    ];
    $stmt = $conn->prepare($sql);
    $stmt->execute($db_arr);
    echo "<script>alert( 'Atualização feita com sucesso');
             window.location.href = '../dashboard.php';</script>";
    
}

if (isset($_POST['addProd'])) {
    $nome = $_POST['nome'];
    $preco = $_POST['preco'];
    $estoque = $_POST['estoque'];
    $uploadDir = '../imagens/';

    // Verificar se a imagem foi enviada corretamente
    if (isset($_FILES['imagem']) && $_FILES['imagem']['error'] === UPLOAD_ERR_OK) {
        $fileTmpPath = $_FILES['imagem']['tmp_name'];
        $fileName = $_FILES['imagem']['name'];
        $fileSize = $_FILES['imagem']['size'];
        $fileType = $_FILES['imagem']['type'];
        $fileNameCmps = explode(".", $fileName);
        $fileExtension = strtolower(end($fileNameCmps));

        // Limitar extensões de arquivos permitidas
        $allowedfileExtensions = array('jpg', 'gif', 'png', 'jpeg');
        if (in_array($fileExtension, $allowedfileExtensions)) {
            $newFileName = md5(time() . $fileName) . '.' . $fileExtension;
            $dest_path = $uploadDir . $newFileName;

            if (move_uploaded_file($fileTmpPath, $dest_path)) {
                // Imagem foi movida com sucesso, agora inserir no banco de dados
                try {
                    // Inserir na base de dados
                    $sql = "INSERT INTO produto (nome, img, preco, estoque) SELECT :nome, :imagem, :preco, :estoque";
                    $db_arr = [
                        'nome' => $nome,
                        'imagem' => $newFileName,
                        'preco' => $preco,
                        'estoque' => $estoque
                    ];
                    $stmt = $conn->prepare($sql);
                    $stmt->execute($db_arr);
                    
                    echo "<script>alert('Registro concluído com sucesso');
                         window.location.href = '../dashboard.php';</script>";
                    exit;
                } catch (PDOException $e) {
                    echo "<script>alert('Erro ao inserir no banco de dados: ".$e->getMessage()."');
                    window.location.href = 'registarProd.php';</script>";
                    exit;
                }
            } else {
                echo "<script>alert('Erro ao mover a imagem para o diretório.');
                window.location.href = 'registarProd.php';</script>";
                exit;
            }
        } else {
            echo "<script>alert('Tipo de arquivo não permitido.');
            window.location.href = 'registarProd.php';</script>";
            exit;
        }
    } else {
        echo "<script>alert('Erro no envio da imagem.');
        window.location.href = 'registarProd.php';</script>";
        exit;
    }
}
?>
