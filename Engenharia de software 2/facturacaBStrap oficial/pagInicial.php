<?php 

    include('produto.php');
    $produtos = getProdutos();
    //var_dump($produtos); die;
    //linha 55 <input type="text" placeholder="Pesquise um produto">
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
                        
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />

    <link rel="stylesheet" href="pagInicial.css">
    <script src="https://use.fontawesome.com/0c7a3095b5.js"></script>
    <script src="https://kit.fontawesome.com/ec00502793.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-4  posPedidoContainer">
                <div class="pos_header">
                    <div class="definicao alinharEsquerda">
                        <a href="login.php"><i class="fa-solid fa-right-from-bracket"></i></a>
                    </div>
                    <p class="logo">EA Facturação</p>
                    <p class="data">22 Junho 2024</p>
                </div>
                <div class="pos_itens_container">
                    
                    <div class="pos_itens">
                        <p class="itensVazio">Sem dados</p>
                    </div>
                    <div class="itens_total_container">
                        <p class="itens_total">
                            <span class="itens_total--label"> TOTAL</span>
                            <span class="itens_total--valor">0 Kz</span>
                        </p>
                     </div>
                </div>
                 <div class="btn_finalizar_container">
                    <a href="javascript:void(0);" class="btn_finalizar">
                        <div  class="btn_finalizar">Finalizar Compra</div> 
                    </a>
                </div>
            </div>
          
            <div class="col-8">
                <div class="pesquisaContainer">
                    
                </div>
     
                <div class="pesqResultadoContainer">
                    <div class="row">
                        <?php foreach($produtos as $produto){ ?>
                        <div class="col-4 prodColContainer" data-pid="<?=$produto['id']?>">
                            <div class="prodResultContainer">
                                <img src="imagens/<?=$produto['img']?>" class="imagemProduto" width="100%" alt="Imagem">
                            
                                <div class="infoProduto">
                                    <p class="NomeProduto"><?= $produto['nome'] ?> </p>
                                    <p class="PrecoProduto"><?= $produto['preco'] ?>Kz</p>
                                </div>
                                
                            </div>
                        </div>
                        <?php    }?>
                        
                    </div>
                </div>

            </div>
           
        </div>
    </div>



    

</body>
<!--<script src="js/jquery/jquery-3.5.1.min.js"></script>-->

<script>
    let produtosJson =  <?= json_encode($produtos) ?>;
    var produtos = {};
    produtosJson.forEach((produto)=> {
        
        produtos[produto.id] = {
            nome : produto.nome,
            estoque : produto.estoque,
            preco : produto.preco
        }
    });
    console.log(produtos);
</script>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" 
integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" 
integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.35.4/js/bootstrap-dialog.min.js" 
integrity="sha512-LbO5ZwEjd9FPp4KVKsS6fBk2RRvKcXYcsHatEapmINf8bMe9pONiJbRWTG9CF/WDzUig99yvvpGb64dNQ27Y4g==" crossorigin="anonymous" 
referrerpolicy="no-referrer"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="pagInicial.js?v=<?=time()?>"></script>
</html>

