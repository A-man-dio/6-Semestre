<?php
include('dashconf.php');
include('atributosFatura.php');
include('produto.php');
$vendas = getVendas();
$itensVendas = getAllItensVenda();
$totalCompras = getTotalCompras();
$top5 = getTop5ItensVendidos();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
    <script src="https://use.fontawesome.com/0c7a3095b5.js"></script>
    <script src="https://kit.fontawesome.com/ec00502793.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="dashboard.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>

<body>
    <div class="container-fluid">
        <div class="row main">
            <div class="col-4">
                <div class="widgetContainer widgeSale">
                    <div class="definicao alinharEsquerda">
                        <a href="login.php"><i class="fa-solid fa-right-from-bracket"></i></a>
                    </div>
                    <?php $total = 0;
                    foreach ($vendas as $venda) {
                        $total += $venda['total'];
                    } ?>
                    <p class="widgetValue"><?= $total ?> kz</p>
                    <p class="widgetHeader">Total de vendas</p>
                </div>
            </div>
            <div class="col-4">
                <div class="widgetContainer widgetQtySold">
                    <?php $total = 0;
                    foreach ($itensVendas as $iten) {
                        $total += $iten['quantidade'];
                    } ?>
                    <p class="widgetValue"><?= $total ?></p>
                    <p class="widgetHeader">Quantidade vendida</p>
                </div>
            </div>
            <div class="col-4">
                <div class="widgetContainer widgetOrder">
                    <p class="widgetValue"><?= $totalCompras ?></p>
                    <p class="widgetHeader">Total de compras</p>
                </div>
            </div>
        </div>
        <div class="row main">
            <div class="col-md-5 widget2">
                <p>5 produtos mais comprados</p>
                <table class="table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Nº de compras</th>
                        </tr>
                    </thead>
                    <tbody>

                        <?php $i = 1;
                        foreach ($top5 as $produto) { ?>
                            <tr>
                                <td><?= $i ?></td>
                                <td><?= getProdutoById($produto['id_produto'])['nome'] ?></td>
                                <td><?= $produto['quantidade_vendida'] ?></td>
                            </tr>
                        <?php $i++;
                        } ?>
                    </tbody>
                </table>
                <div class="funcionalidades">
                    <div class="funcionalidades btn_finalizar_container">
                        <a href="funcionalidades/registarProd.php" class="btn_finalizar">
                            <div class="btn_finalizar">Adicionar produto</div>
                        </a>
                    </div>
                    <div class="funcionalidades btn_finalizar_container">
                        <a href="funcionalidades/attEstoque.php" class="btn_finalizar">
                            <div class="btn_finalizar">Alterar estoque de um produto</div>
                        </a>
                    </div>
                    <div class="funcionalidades btn_finalizar_container">
                        <a href="registar.php" class="btn_finalizar">
                            <div class="btn_finalizar">Registar funcionario</div>
                        </a>
                    </div>
                    <div class="funcionalidades btn_finalizar_container">
                        <a href="funcionalidades/verFaturas.php" class="btn_finalizar">
                            <div class="btn_finalizar">Vizualizar faturas</div>
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-md-7">
                <p id="dsales">Vendas diárias</p>
                <button class="btn btn-sm btn-default" id="daterange">Selecionar intervalo</button>
                <figure class="highcharts-figure">
                    <div id="container"></div>
                </figure>
            </div>
        </div>
    </div>


    <!-- JavaScript -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    
    <script>
    $(document).ready(function() {
        // Função para obter os dados e atualizar o gráfico
        function atualizarGrafico() {
            $.ajax({
                url: 'grafico.php', // Endpoint PHP para obter dados
                dataType: 'json',
                success: function(data) {
                    Highcharts.chart('container', {
                        chart: {
                            type: 'line'
                        },
                        title: {
                            text: 'Vendas Diárias dos Produtos Mais Vendidos nos Últimos 30 Dias'
                        },
                        xAxis: {
                            categories: data.dias // Array com as datas (últimos 30 dias)
                        },
                        yAxis: {
                            title: {
                                text: 'Quantidade Vendida'
                            }
                        },
                        tooltip: {
                            formatter: function() {
                                return '<b>' + this.x + '</b><br/>' +
                                    this.series.name + ': ' + this.y + '<br/>' +
                                    'Data: ' + this.series.options.data_dates[this.point.index];
                            }
                        },
                        plotOptions: {
                            line: {
                                dataLabels: {
                                    enabled: true
                                },
                                enableMouseTracking: true
                            }
                        },
                        series: data.series // Array com os dados dos produtos
                    });
                }
            });
        }

        // Chamar a função para carregar inicialmente o gráfico
        atualizarGrafico();
    });
</script>
    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>