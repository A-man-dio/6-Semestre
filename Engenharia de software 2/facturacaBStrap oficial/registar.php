<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="iniciar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
     <div class="container" id="registar">

         <h1 class="titulo-form">Registar</h1>
         <form method="post" action="sessao.php">
         <div class="input-grupo">
            <label for="pnome">Nome</label>
            <input type="text" name="pnome" id="pnome" placeholder="Insira o nome" required>
            <i class="fas fa-user"></i>
         </div>
         <div class="input-grupo">
            <label for="snome">Sobrenome</label>
            <input type="text" name="snome" id="snome" placeholder="Insira o sobrenome" required>
            <i class="fas fa-user"></i>
         </div>
         <div class="input-grupo">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" placeholder="Insira o email" required>
            <i class="fas fa-envelope"></i>
         </div> 
         <div class="input-grupo">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="Insira uma password" required>
            <i class="fas fa-lock"></i>
         </div> 
         <input type="submit" value="Registar" name="registar" class="btn" id="registarBtn"> 
         </form>
     </div>
     
</body>
</html>