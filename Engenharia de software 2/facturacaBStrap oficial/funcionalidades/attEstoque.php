<?php
include('../produto.php');
$produtos = getProdutos();
//var_dump($produtos); die;
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />

    <link rel="stylesheet" href="estilo.css">
</head>

<body>
    <div class="container" id="attEstoque">

        <h3 class="tituloh3-form">Selecione um produto</h3>

        <div class="pesqResultadoContainer">

            <form class="" action="dashconf.php" method="post">

                <div class="pri row contentor_prod">
                    <?php foreach ($produtos as $produto) { ?>
                        <div class="col-4 prodColContainer" data-pid="<?= $produto['id'] ?>">
                            <div class="prodResultContainer">
                                <img src="../imagens/<?= $produto['img'] ?>" class="imagemProduto" width="100%" alt="Imagem">
                                <div class="infoProduto">
                                    <p class="NomeProduto"><?= $produto['nome'] ?> </p>
                                    <input type="radio" name="escolha" value="<?= $produto['id'] ?>" id="produto_<?= $produto['id'] ?>" required>
                                </div>
                            </div>
                        </div>
                    <?php } ?>
                </div>
                <div class="input-grupo">
                    <label for="estoque">Estoque</label>
                    <input type="number" min="1" name="estoque" id="estoque" placeholder="Insira a nova quantidade de estoque" required>
                </div>
                <input type="submit" value="Aualizar Estoque" name="attEstoque" class="btn" id="registarBtn">
            </form>


        </div>



    </div>
</body>

</html>