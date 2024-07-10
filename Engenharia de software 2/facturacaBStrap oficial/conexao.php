<?php 
    $nomeServer = 'localhost';
    $username = 'root';
    $bdname = 'faturacao';
    $password = '';

    try{
        $conn = new PDO ("mysql:host=$nomeServer;dbname=$bdname",$username,$password);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }
    catch(\Exception $e){
        $error_message = $e->getMessage();
    }

    $GLOBALS ['conn'] = $conn; 
?>