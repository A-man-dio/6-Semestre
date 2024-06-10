<?php

include_once '../dbconfig/conexao.php';

include_once '../model/user.php';

class UserRepository {

    public function login($username, $password) {
        $sql = "SELECT * FROM usuario WHERE username = ? AND senha = ?";

        $stmt = Conexao::getConn()->prepare($sql);
        $stmt->bindValue(1, $username);
        $stmt->bindValue(2, $password);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            // Usuário autenticado com sucesso

            $resultado = $stmt->fetch(\PDO::FETCH_ASSOC);
            $objecto = new User();
            //$objecto->setId($resultado["id"]);
            $objecto->setUsername($resultado["username"]);
            $objecto->setPassword($resultado["senha"]);
            $objecto->setNome($resultado["nome"]);
            $objecto->setSobrenome($resultado["sobrenome"]);
            //---------------------------------------
            $objecto->setContacto($resultado["contacto"]);
            $result[] = $objecto;

            return $result;
        } else {
            return null;
        }
    }
    //----------------------------------
    public function deleteUser($username) {
        $sql = 'DELETE FROM usuario WHERE username = ?';

        $stmt = Conexao::getConn()->prepare($sql);
        $stmt->bindValue(1, $username);
        $stmt->execute();
    }

    public function registarUser(User $user) {

        $sql = 'INSERT INTO usuario (nome, sobrenome, username, senha, contacto) VALUES (?,?,?,?,?)';

        $stmt = Conexao::getConn()->prepare($sql);
        $stmt->bindValue(1, $user->getNome());
        $stmt->bindValue(2, $user->getSobrenome());
        $stmt->bindValue(3, $user->getUsername());
        $stmt->bindValue(4, $user->getPassword());
        $stmt->bindValue(5, $user->getContacto());
        $stmt->execute();
    }


}