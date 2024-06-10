<?php

include_once '../dbconfig/conexao.php';

include_once '../model/product.php';

class ProductRepository {

    public function registarProducto(Product $product) {

        $sql = 'INSERT INTO produto (nome, descricao, path_imagem, preco, username) VALUES (?,?,?,?,?)';

        $stmt = Conexao::getConn()->prepare($sql);
        $stmt->bindValue(1, $product->getNome());
        $stmt->bindValue(2, $product->getDescricao());
        $stmt->bindValue(3, $product->getPath());
        $stmt->bindValue(4, $product->getPreco());
        $stmt->bindValue(5, $product->getUsername());
        $stmt->execute();
    }


}