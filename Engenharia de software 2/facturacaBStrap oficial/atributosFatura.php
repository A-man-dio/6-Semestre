<?php

include ('conexao.php');

//pega todas as faturas
function getVendas(){ 
    //dashboard
    $conn = $GLOBALS['conn'];
    
    $stmt = $conn->prepare("SELECT * FROM venda");
    $stmt->execute();
    $linhas= $stmt->fetchAll(PDO::FETCH_ASSOC);
    return $linhas;
}
//pega uma fatura específica
function getVendaById($id){
    $conn = $GLOBALS['conn'];
    
    $stmt = $conn->prepare("SELECT * FROM venda where id = :id");
    $db_arr = [
        'id' => $id
    ];
    $stmt->execute($db_arr);
    $linha = $stmt->fetch(PDO::FETCH_ASSOC);
    return $linha;
}
//pega o funcionario pelo id q ta na fatura
function getFuncionarioById($venda){
    $conn = $GLOBALS['conn'];
    
    $stmt = $conn->prepare("SELECT * FROM funcionario where id = :id");
    $db_arr = [
        'id' => $venda['id_funcionario']
    ];
    $stmt->execute($db_arr);
    $linha = $stmt->fetch(PDO::FETCH_ASSOC);
    return $linha;
}
//pega o ciente pelo id q ta na fatura
function getClienteById($venda){
    $conn = $GLOBALS['conn'];
    
    $stmt = $conn->prepare("SELECT * FROM cliente where id = :id");
    $db_arr = [
        'id' => $venda['id_cliente']
    ];
    $stmt->execute($db_arr);
    $linha = $stmt->fetch(PDO::FETCH_ASSOC);
    return $linha;
}
//pega os itens vendidos q possuem o mesmo id de venda q a fatura (produtos da mesma fatura)
function getItensVenda($id_venda){ 
    $conn = $GLOBALS['conn'];
    $stmt = $conn->prepare("SELECT * FROM itemVenda where id_venda = :id_venda");
    $db_arr = [
        'id_venda' => $id_venda
    ];
    $stmt->execute($db_arr);
    $linhas= $stmt->fetchAll(PDO::FETCH_ASSOC);
    return $linhas;
}
//dashboard
function getAllItensVenda(){ 
    $conn = $GLOBALS['conn'];
    $stmt = $conn->prepare("SELECT * FROM itemVenda ");
    $stmt->execute();
    $linhas= $stmt->fetchAll(PDO::FETCH_ASSOC);
    return $linhas;
}
//dashboard
function getTotalCompras(){
    $conn = $GLOBALS['conn'];
    $stmt = $conn->prepare("SELECT COUNT(*) as total FROM venda");
    $stmt->execute();
    $total= $stmt->fetch(PDO::FETCH_ASSOC);
    return $total['total'];
}
//dashboard
function getTop5ItensVendidos() {
    $conn = $GLOBALS['conn'];
    $stmt = $conn->prepare("
        SELECT id_produto, COUNT(*) AS quantidade_vendida
        FROM itemVenda
        GROUP BY id_produto
        ORDER BY quantidade_vendida DESC
        LIMIT 5
    ");
    $stmt->execute();
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}
function getTop5ItensVendidosLast30Days() {
    $conn = $GLOBALS['conn'];
    $stmt = $conn->prepare("
        SELECT iv.id_produto, DATE_FORMAT(v.data, '%d/%m/%Y') AS data_venda, SUM(iv.quantidade) AS quantidade_vendida
        FROM itemVenda iv
        JOIN venda v ON iv.id_venda = v.id
        WHERE v.data >= CURDATE() - INTERVAL 30 DAY
        GROUP BY iv.id_produto, DATE(v.data)
        ORDER BY DATE(v.data) ASC, quantidade_vendida DESC
    ");
    $stmt->execute();
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}



?>