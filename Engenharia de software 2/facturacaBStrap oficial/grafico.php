<?php
include 'atributosFatura.php'; 
include 'produto.php';

// Função para obter os top 5 produtos vendidos nos últimos 30 dias


// Inicialização das variáveis para armazenar os dados do gráfico
$top5_last30days = getTop5ItensVendidosLast30Days(); // Obter dados dos top 5 produtos vendidos nos últimos 30 dias

// Preparar arrays para enviar como JSON
$dias = array(); // Array para os últimos 30 dias
$series = array(); // Array para as séries de dados

// Montar os dados para o gráfico
foreach ($top5_last30days as $produto) {
    $id_produto = $produto['id_produto'];
    $data_venda = $produto['data_venda'];
    $quantidade_vendida = intval($produto['quantidade_vendida']); // Converter para inteiro

    // Verificar se já existe uma série para este produto
    $indice_serie = array_search($id_produto, array_column($series, 'id_produto'));

    if ($indice_serie !== false) {
        // Adicionar ponto de dados à série existente
        $series[$indice_serie]['data'][] = $quantidade_vendida;
        $series[$indice_serie]['data_dates'][] = $data_venda;
    } else {
        // Criar uma nova série para o produto
        $produto_nome = getProdutoById($id_produto)['nome']; // Obter nome do produto

        $series[] = array(
            'name' => $produto_nome,
            'id_produto' => $id_produto,
            'data' => array($quantidade_vendida), // Primeiro ponto de dados
            'data_dates' => array($data_venda) // Array de datas correspondentes
        );
    }

    // Adicionar a data aos dias se ainda não estiver presente
    if (!in_array($data_venda, $dias)) {
        $dias[] = $data_venda;
    }
}

// Reverter a ordem dos arrays para corrigir a ordem no gráfico
$dias = array_reverse($dias);
foreach ($series as &$serie) {
    $serie['data'] = array_reverse($serie['data']);
    $serie['data_dates'] = array_reverse($serie['data_dates']);
}

// Montar o array final para retornar como JSON
$final_data = array(
    'dias' => $dias,
    'series' => $series
);

// Retornar como JSON

echo json_encode($final_data);
