<?php

include ('conexao.php');
$action = isset($_POST['action']) ? $_POST['action'] : '';
//$action = isset($_GET['action']) ? $_GET['action']: ' ';


if($action === 'comprar')
{
    salvarProdutos();
}

function getProdutos(){ 
    $conn = $GLOBALS['conn'];
    //add na tabela descricao, img, preco, estoque,
    $stmt = $conn->prepare("SELECT * FROM produto");
    $stmt->execute();
    $linhas= $stmt->fetchAll(PDO::FETCH_ASSOC);
    return $linhas;
    
}

//pega um produto pelo seu ID
function getProdutoById($id){
    $conn = $GLOBALS['conn'];
    
    $stmt = $conn->prepare("SELECT * FROM produto where id = :id");
    $db_arr = [
        'id' => $id
    ];
    $stmt->execute($db_arr);
    $linha = $stmt->fetch(PDO::FETCH_ASSOC);
    return $linha;
}

//fazer venda
function salvarProdutos(){
    session_start();
    try {
    $data = $_POST['data1'];
    $cliente = $_POST['cliente'];
    $pagamento = $_POST['pagamento'];
    $fatura = $_POST['fatura'];
    $troco =$_POST['troco'];
    $quantia=$_POST['quantia'];
    $total=$_POST['total'];
    $conn = $GLOBALS['conn'];

    //adiciona o cliente, caso o contacto ainda n exista
    $sql = "
    INSERT INTO cliente (nome, sobrenome, contacto)
    SELECT :nome , :sobrenome, :contacto
    WHERE NOT EXISTS (SELECT 1 FROM cliente WHERE contacto = :contacto);
    ";
    $db_arr = [
        'nome' => $cliente['nome'],
        'sobrenome' => $cliente['sobrenome'],
        'contacto' => $cliente['contacto']
    ];
    $stmt = $conn->prepare($sql);
    $stmt->execute($db_arr);

    $id_cliente = $conn->lastInsertId();
    
    if ($id_cliente == "" ||$id_cliente == false || $id_cliente == 0) {
        $stmt = $conn->prepare("SELECT id FROM cliente WHERE contacto = :contacto");
        $stmt->execute(['contacto' => $cliente['contacto']]);
        $existingClient = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($existingClient) {
            $id_cliente = $existingClient['id'];
        }
    }
    //salvar os dados da venda
        $sql = "
        INSERT INTO venda 
                (id_cliente, id_funcionario, data, total, tipo_pagamento, tipo_fatura, valor_pago, troco)
        values  (:id_cliente, :id_funcionario, :data, :total, :tipo_pagamento, :tipo_fatura, :valor_pago, :troco)
        ";
        $db_arr = [
            'id_cliente' => $id_cliente,
            'id_funcionario' => $_SESSION['id'],
            'data' => date('Y-m-d H:i:s'),
            'total' => $total,
            'tipo_pagamento' => $pagamento,
            'tipo_fatura' => $fatura,
            'valor_pago' => $quantia,
            'troco' => $troco
        ];
        
        $stmt = $conn->prepare($sql);
        $stmt->execute($db_arr);
        $id_venda = $conn->lastInsertId();
        
        //itenVenda
        
        foreach($data as $id_produto => $pedidoItem){
            $sql = "
            INSERT INTO itemVenda 
                    (id_venda, id_produto, preco_unit, quantidade, sub_total)
            values  (:id_venda, :id_produto, :preco_unit, :quantidade, :sub_total)
            ";
            $db_arr = [
                'id_venda' => $id_venda,
                'id_produto' => $id_produto,
                'preco_unit' => $pedidoItem['precoUnit'],
                'quantidade' => $pedidoItem['qtdPedido'],
                'sub_total' => $pedidoItem['subTotal'],
            ];
            $stmt = $conn->prepare($sql);
            $stmt->execute($db_arr);

            $stmt = $conn->prepare("SELECT estoque FROM produto where id =$id_produto");
            $stmt->execute();
            $produto =$stmt->fetch(PDO::FETCH_ASSOC);
            $estoque_actual = (int) $produto["estoque"];
            $estoque_novo = $estoque_actual - $pedidoItem['qtdPedido']; 
            if($fatura == "recibo"){
                //fazer alterações no estoque
                $sql = "
                UPDATE produto 
                        SET  
                        estoque =?
                        WHERE id =?
                ";
                $stmt = $conn->prepare($sql);
                $stmt->execute([$estoque_novo, $id_produto]);
            }
        }
        
     

        echo json_encode([
            'sucesso' => true,
            'mensagem' => 'Compra finalizada com sucesso',
            'produtos' => getProdutos(),
            'idFatura' => $id_venda
        ]);
        
    } catch (Exception $e) {
        $ver=false;
        echo json_encode([
            'sucesso' => false,
            'mensagem' => 'Erro ao comprar'
        ]);
    }

}
?>