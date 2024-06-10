<?php

class Product{
    
    private $nome;
    private $descricao;
    private $path_imagem;
    private $preco;
    private $username;
    
    public function __construct($nome = null, $descricao= null, $path_imagem=null , $preco = null 
     ,$username= null) {
        $this->nome = $nome;
        $this->descricao = $descricao;
        $this->path_imagem = $path_imagem;
        $this->preco = $preco;
        $this->username = $username;
    }
    public function getNome() {
        return $this->nome;
    }

    public function setNome($nome) {
        $this->nome = $nome;
    }

    public function getUsername() {
        return $this->username;
    }

    public function setUsername($username) {
        $this->username = $username;
    }

    public function getDescricao() {
        return $this->descricao;
    }

    public function setDescricao($descricao) {
        $this->descricao = $descricao;
    }
 
    public function getPath() {
        return $this->path_imagem;
    }

    public function setPath($path_imagem) {
        $this->path_imagem = $path_imagem;
    }
    
    public function getPreco() {
        return $this->preco;
    }

    public function setPreco($preco) {
        $this->preco = $preco;
    }
   
}