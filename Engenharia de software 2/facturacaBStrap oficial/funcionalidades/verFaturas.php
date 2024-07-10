<?php
include('../produto.php');
include('../atributosFatura.php');
$vendas = getVendas();
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
    <div class="container" id="verFaturass">

        <h3 class="tituloh3-form">Selecione uma fatura</h3>

        <div class="pesqResultadoContainer">

            <form class="" action="dashconf.php" method="post">

                <div class="contentor_prod faturas">

                    <div class="fatura">

                        <div class="itenfact">Funcionario</div>
                        <div class="itenfact">Cliente</div>
                        <div class="itenfact">Data</div>
                        <div class="itenfact">Opção</div>

                    </div>
                    <?php foreach ($vendas as $venda) { ?>
                        <div class="fatura" data-pid="<?= $venda['id'] ?>">

                            <div class="itenfact"><?= getFuncionarioById($venda)['nome'] ?> <?= getFuncionarioById($venda)['sobrenome'] ?></div>
                            <div class="itenfact"><?= getClienteById($venda)['nome'] ?> <?= getClienteById($venda)['sobrenome'] ?></div>
                            <div class="itenfact"><?= $venda['data'] ?></div>
                            <input type="radio" name="escolha" value="<?= $venda['id'] ?>" id="fatura_<?= $venda['id'] ?>" required>

                        </div>
                    <?php } ?>
                </div>
                <input type="submit" value="Ver fatura" name="verFatura" class="btn" id="registarBtn">
            </form>

        </div>

    </div>
</body>

</html>