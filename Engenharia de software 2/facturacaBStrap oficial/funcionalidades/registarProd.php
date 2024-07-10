<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <div class="container" id="addProd">
        <h1 class="titulo-form">Adicionar Produto</h1>
        <form method="post" action="dashconf.php" enctype="multipart/form-data">
            <div class="input-grupo">
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" placeholder="Insira o nome do produto" required>
            </div>
            <div class="input-grupo">
                <label for="imagem">Imagem</label>
                <input type="file" name="imagem" id="imagem" placeholder="Insira uma imagem do produto" required>
            </div>
            <div class="input-grupo">
                <label for="preco">Preço</label>
                <input type="number" min="0" name="preco" id="preco" placeholder="Insira o preço" required>
            </div>
            <div class="input-grupo">
                <label for="estoque">Estoque</label>
                <input type="number" min="1" name="estoque" id="estoque" placeholder="Insira a quantidade em estoque" required>
            </div>
            <input type="submit" value="Adicionar" name="addProd" class="btn" id="registarBtn">
        </form>
    </div>
</body>
</html>
