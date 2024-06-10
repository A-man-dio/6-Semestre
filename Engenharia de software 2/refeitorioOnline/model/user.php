<?php

class User{
    
    private $id;
    private $username;
    private $password;
    private $nome;
    private $sobrenome;
    private $contacto;
   
    
    public function __construct($username = null, $password = null, $nome=null , $sobrenome= null
            , $contacto = null, ) {
        
        $this->username = $username;
        $this->password = $password;
        $this->nome = $nome;
        $this->sobrenome = $sobrenome;
        $this->contacto = $contacto;
    }
    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    // Getter e Setter para $username
    public function getUsername() {
        return $this->username;
    }

    public function setUsername($username) {
        $this->username = $username;
    }

    // Getter e Setter para $password
    public function getPassword() {
        return $this->password;
    }

    public function setPassword($password) {
        $this->password = $password;
    }

    // Getter e Setter para $nome
    public function getNome() {
        return $this->nome;
    }

    public function setNome($nome) {
        $this->nome = $nome;
    }

    // Getter e Setter para $sobrenome
    public function getSobrenome() {
        return $this->sobrenome;
    }

    public function setSobrenome($sobrenome) {
        $this->sobrenome = $sobrenome;
    }

    // Getter e Setter para $contacto
    public function getContacto() {
        return $this->contacto;
    }

    public function setContacto($contacto) {
        $this->contacto = $contacto;
    }
   
}