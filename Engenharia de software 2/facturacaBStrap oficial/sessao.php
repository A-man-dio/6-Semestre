<?php 
    include 'conexao.php';

    if(isset($_POST['registar'])){
        $pnome = $_POST['pnome'];
        $snome = $_POST['snome'];
        $email = $_POST['email'];
        $password = $_POST['password'];
        $password = md5($password);

        
        //verificar se email já existe
        $sql = " SELECT * FROM funcionario where email = :email";
        $db_arr = [
            'email' => $email
        ];
        $stmt = $conn->prepare($sql);
        $stmt->execute($db_arr);
        $funcionario = $stmt->fetch(PDO::FETCH_ASSOC);

        if($funcionario === false){
            //inserir na bd
            $sql = "
            INSERT INTO funcionario (nome, sobrenome, senha, email, tipo)
            SELECT :nome , :sobrenome, :senha, :email ,1";
            $db_arr = [
                'nome' => $pnome,
                'sobrenome' => $snome,
                'senha' => $password,
                'email' => $email
            ];
            $stmt = $conn->prepare($sql);
            $stmt->execute($db_arr);
            $id_funcionario = $conn->lastInsertId();
            echo "<script>alert( 'Registo concluído com sucesso');
                 window.location.href = 'dashboard.php';</script>";
            
        }else{
            echo "<script>alert( 'O email inserido já está em uso!');
            window.location.href = 'registar.php';</script>";
        }

    }

    if(isset($_POST['logar'])){
        $email = $_POST['email'];
        $password = $_POST['password'];
        $password = md5($password);

        $sql = " SELECT * FROM funcionario where email = :email and senha = :senha";
        $db_arr = [
            'email' => $email,
            'senha' => $password
        ];
        $stmt = $conn->prepare($sql);
        $stmt->execute($db_arr);
        $funcionario = $stmt->fetch(PDO::FETCH_ASSOC);

        if($funcionario === false){
            echo  "<script>
            alert('Email ou password incorreta');
            window.location.href = 'login.php';
            </script>";
        }else
        {
            session_start();
            $_SESSION['id'] = $funcionario['id'];
            $_SESSION['nome'] = $funcionario['nome'];
            $_SESSION['sobrenome'] = $funcionario['sobrenome'];
            $_SESSION['email'] = $funcionario['email'];
            if($funcionario['tipo'] == 1)
                header("location: pagInicial.php");
            else
                header("location: dashboard.php");
        }
    }
?>
