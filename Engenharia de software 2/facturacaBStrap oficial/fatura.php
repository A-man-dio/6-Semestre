<?php
include('atributosFatura.php');
include('produto.php');
include('conexao.php');
$id_venda = isset($_GET['idVenda']) ? $_GET['idVenda'] : null;
$venda = getVendaById($id_venda);
$funcionario = getFuncionarioById($venda);
$cliente = getClienteById($venda);
$prodVendidos = getItensVenda($id_venda);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fatura</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.35.4/css/bootstrap-dialog.min.css" 
    integrity="sha512-PvZCtvQ6xGBLWHcXnyHD67NTP+a+bNrToMsIdX/NUqhw+npjLDhlMZ/PhSHZN4s9NdmuumcxKHQqbHlGVqc8ow=="
     crossorigin="anonymous" referrerpolicy="no-referrer">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />

    <link rel="stylesheet" href="fatura.css"> 
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>EA Facturação</h2>
            <p>Talatona</p>
            <p>Nº do Contribuinte: 8799</p>
            <div class="invoice-details">
                <div class="left">
                    <p>Nº da Caixa:<?= $funcionario['id'] ?> </p>
                </div>
                <div class="center">
                    <p>Tipo da Fatura: <?=$venda['tipo_fatura']?></p>
                </div>
                <div class="right">
                    <p>Data: <?=$venda['data']?></p>
                </div>
            </div>
            <hr>
        </div>
        
        <table class="items-table">
            <thead>
                <tr>
                    <th>Nº do Item</th>
                    <th>Produto</th>
                    <th>Preço por Unidade</th>
                    <th>Quantidade</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <!-- Itens da fatura serão gerados dinamicamente aqui -->
                <?php $i=1; $total=0; foreach($prodVendidos as $produto){ ?>
                        <tr>
                            <td><?=$i?></td>
                            <td><?= getProdutoById($produto['id_produto'])['nome'] ?></td>
                            <td><?= $produto['preco_unit'] ?></td>
                            <td><?= $produto['quantidade'] ?></td>
                            <td><?= $produto['sub_total'] ?></td>
                        </tr>
                <?php   $i++; $total +=$produto['sub_total']; }?>
            </tbody>
        </table>
        
        <hr>
        
        <div class="footer">
            <p>Total da Fatura: <?= $total ?> Kz</p>
            <div class="invoice-details">
            
                <div class="detail">
                <span>Nome do cliente: <?= $cliente['nome'] ?> <?= $cliente['sobrenome'] ?></span>
                <span>Tipo de Pagamento: <?= $venda['tipo_pagamento'] ?></span>
                </div>
                <div class="detail">
                <span>Quantia Recebida: <?= $venda['valor_pago'] ?> Kz</span>
                </div>
                <div class="detail">
                <span>Troco: <?= $venda['troco'] ?> Kz</span>
                </div>
            
            </div>
            <p>Atendente do Caixa: <?= $funcionario['nome'] ?> <?= $funcionario['sobrenome'] ?></p>
            <p>Localização da Loja: Talatona,Belas</p>
            <p>Contacto R.H: 955505331</p>
            <p>Fatura Nº: <?= $venda['id'] ?> </p>
            <p>Obrigado, volte sempre!</p>
        </div>
    </div>
</body>
</html>
