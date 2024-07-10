let script = function(){
    
    this.totalAPagar =0;
    this.userQuantia =0;
    this.itensPedido = {}
    this.userTroco = 0;
    this.pid =0;

    this.produtos = produtos;
    console.log('abriu');


    this.relogio = function(){
        let dataObj = new Date;
        let meses = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outobro', 'Dezembro '];
        let ano = dataObj.getFullYear(); //yyyy
        let mesNum = dataObj.getMonth(); //0-11
        let dataCalc = dataObj.getDate();// 0-23
        let hora = dataObj.getHours();
        let min = dataObj.getMinutes();
        let sec = dataObj.getSeconds();
        document.querySelector('.data').innerHTML= dataCalc + ' - ' + meses[mesNum] + ' - ' + ano + ' | ' + hora + ':' + min + ':' + sec;
        setInterval(this.relogio,1000); 
    }

    this.registarEvento = function(){
         document.addEventListener('click', function(e){
            let elementAlvo = e.target;
            let addListaCompra = ['NomeProduto', 'PrecoProduto', 'infoProduto', 'imagemProduto','prodResultContainer' ];
            //console.log(elementAlvo);
            //console.log(elementAlvo.classList.contains(addListaCompra));
            //se clicar na imagem ou infoProduto adiciona na lista de compra
            //NomeProduto PrecoProduto infoProduto imagemProduto
            for (let i = 0; i < addListaCompra.length; i++) {
                if (elementAlvo.classList.contains(addListaCompra[i])) {
                    //console.log(`Classe encontrada: ${addListaCompra[i]}`);
                    
                    let produtoContainer = elementAlvo.closest('.prodColContainer');
                    let pid = produtoContainer.dataset.pid;
                    carregarScript.pid=pid;
                    let prodInfo = carregarScript.produtos[pid];    

                    if(prodInfo['estoque'] === 0){

                        BootstrapDialog.alert({
                            title: 'Produto fora de estoque',
                            type: BootstrapDialog.TYPE_DANGER,
                            message: 'Aguarde por uma nova remessa'
                        })
                        return false;
                     }
                    //console.log(pid);
                    //console.log(produtoContainer); 
                    let dialogForm = '<h4>' + prodInfo['nome'] + '<span>' + prodInfo['preco'] + ' KZ' + '<span/>' + 
                    '</h4> <input type="number" id="qtdPedido" class="form-control " placeholder ="Insira a quantidade" min="1"/>';
                    BootstrapDialog.confirm({
                         title: 'Adicionar á lista de compras',
                         //type: BootstrapDialog.TYPE_DEFAULT,
                         message: dialogForm,
                         callback: function(addPedido){
                             if(addPedido){
                                 let qtdPedido = parseInt(document.getElementById('qtdPedido').value);
                                 //inserção invalida com numero negativo
                                 if(isNaN(qtdPedido) || qtdPedido < 1){
                                    BootstrapDialog.alert({
                                        title: 'Erro de inserção',
                                        type: BootstrapDialog.TYPE_DANGER,
                                        message: 'Insira uma quantidade válida'
                                    })
                                    return false;
                                 }
                                 //qtd maior q o stock
                                 if( qtdPedido > prodInfo['estoque']){
                                    BootstrapDialog.alert({
                                        title: 'Qauntidade disponível insuficiente',
                                        type: BootstrapDialog.TYPE_DANGER,
                                        message: 'Quantidade disponível no estoque: <strong>' + prodInfo['estoque'] + '</strong>'
                                    })
                                    return false;
                                 }
                                 carregarScript.addEmPedidos(prodInfo, pid, qtdPedido );
                                 console.log(qtdPedido);
                            }
                         }
                    });
                    break;
                }  
            }
            //apagar da lista de pedidos
            if (elementAlvo.classList.contains('apagarPedidoIten')){
                let pid = elementAlvo.dataset.id;
                let prodInfo = carregarScript.itensPedido[pid]; 
                let dialogForm = 'Apagar <strong>' + prodInfo['nome'] + '</strong> da lista?';
                console.log(pid);
                console.log(prodInfo);
                BootstrapDialog.confirm({
                    title: 'Apagar item da lista',
                    type: BootstrapDialog.TYPE_DANGER,
                    message: dialogForm,
                    callback: function(apagar){
                        if(apagar){
                             //ao eliminar devolve a qtd de volta ao estoque, usar na preforma
                            let qtdPedido = prodInfo['qtdPedido'];
                            carregarScript.produtos[pid]['estoque'] += qtdPedido;

                            //remover da lista de pedidos
                            delete  carregarScript.itensPedido[pid];
  
                            carregarScript.attTabelaPedidos();
                        }
                    }
                });
            }

            //diminuir na lista de pedidos
            if (elementAlvo.classList.contains('menosQtdIten')){
                let pid = elementAlvo.dataset.id;

                carregarScript.itensPedido[pid]['qtdPedido']--;
                carregarScript.produtos[pid]['estoque'] ++;
                carregarScript.itensPedido[pid]['subTotal'] = carregarScript.itensPedido[pid]['qtdPedido'] * carregarScript.itensPedido[pid]['precoUnit'];

                if(carregarScript.itensPedido[pid]['qtdPedido'] === 0 )
                delete  carregarScript.itensPedido[pid];
                
                carregarScript.attTabelaPedidos(); 

                console.log(pid);
            }

            //aumentar na lista de pedidos
            if (elementAlvo.classList.contains('maisQtdIten')){
                let pid = elementAlvo.dataset.id;
                
                if(carregarScript.produtos[pid]['estoque'] === 0){

                    BootstrapDialog.alert({
                        title: 'Produto fora de estoque',
                        type: BootstrapDialog.TYPE_DANGER,
                        message: 'Aguarde por uma nova remessa'
                    })
                    return false;
                }

                carregarScript.itensPedido[pid]['qtdPedido']++;
                carregarScript.produtos[pid]['estoque'] --;
                carregarScript.itensPedido[pid]['subTotal'] = carregarScript.itensPedido[pid]['qtdPedido'] * carregarScript.itensPedido[pid]['precoUnit'];
                
                carregarScript.attTabelaPedidos(); 

                console.log(pid);
            }
            //verificações no callback
            if(elementAlvo.classList.contains('btn_finalizar')){
                if(Object.keys(carregarScript.itensPedido).length){
                //  if(1){  
                    let conteudoHtml =' ';
                    let quantPagar=0;
                    let i =1;
                    for (const [pid, itenPedido] of Object.entries(carregarScript.itensPedido)) {
                        conteudoHtml +=`
                        <div class="row">\
                            <div class="col-md-2">`+i+`</div>\
                            <div class="col-md-4">`+itenPedido['nome']+`</div>\
                            <div class="col-md-3">`+itenPedido['qtdPedido']+`</div>\
                            <div class="col-md-3">`+itenPedido['subTotal']+`</div>\
                        </div>`;
                        i++;
                        quantPagar+=itenPedido['subTotal'];
                    }       
                    let conteudo = ' '; 
                    conteudo = `
                    <div class="row"> \
                        <div class="col-md-7"> \
                            <div class="contentor_prod">\
                                <div class="row"> \
                                    <div class="col-md-2">#</div> \
                                    <div class="col-md-4">Produto</div> \ 
                                    <div class="col-md-3">qtd</div> \ 
                                    <div class="col-md-3">Subtotal</div> \ 
                                </div> <br/>\
                                `+ conteudoHtml + `\
                               
                            </div>\
                            <div class="row mb-3">\
                                <div class="col-md-6">\
                                    <label for="formaPagamento">Forma de pagamento</label>\
                                    <select class="form-select" id="formaPagamento">\
                                        <option value="dinheiro">Dinheiro</option>
                                        <option value="cartao">Cartão</option>
                                    </select>\
                                </div>\
                                <div class="col-md-6">\
                                    <label for="formaRecibo">Forma de recibo</label>\
                                    <select class="form-select" id="formaRecibo">\
                                        <option value="recibo">Factura-recibo</option>
                                        <option value="proforma">Factura-proforma</option>
                                    </select>\
                                </div>\
                            </div>   \
                        <div class="row mb-3">\
                            <div class="col-md-6">\
                                <label for="quantia">Quantia</label>\
                                <input type="number" min="${carregarScript.totalAPagar}" class="form-control" id="quantia" placeholder="Insira a quantia">\
                            </div>
                        </div>
                        </div>\
                        <div class="fx"> \
                            <div class="precario_container">\
                                <span class="precario_titulo">TOTAL</span>\
                                <span class="precario">`+quantPagar+`Kz</span>\
                            </div>
                            <div class="troco">\
                                <span class="precario_tituloT">Troco</span>
                                <span class="precarioT">0 Kz</span>\
                            </div>\
                            <div> \
                                <h3>Detalhes do cliente</h3>\
                                <div class="form-group">\
                                    <label for="contacto">Contacto</label>\
                                    <input type="number" min="900000000" max="999999999" id="contacto" placeholder="Insira o contacto do cliente" class="form-control">\
                                </div>\
                                <div class="form-group">\
                                    <label for="nome">Nome</label>\
                                    <input type="text" id="nome" placeholder="Insira o nome do cliente" class="form-control">\
                                </div>\
                                <div class="form-group">\
                                    <label for="sobrenome">Sobrenome</label>\
                                    <input type="text" id="sobrenome" placeholder="Insira o sobrenome do cliente" class="form-control">\
                                </div>\
                            </div>\
                        </div>\
                    </div>`;

                    BootstrapDialog.confirm({
                        type: BootstrapDialog.TYPE_INFO,
                        title: 'Finalizar compra',
                        cssClass: 'dialogFinalizar',
                        message: conteudo,
                        btnOKLabel: 'Confirmar',
                        callback: function(comprar){
                            
                            if(comprar){
                                if(isNaN(carregarScript.userQuantia) || carregarScript.userQuantia < 1 || carregarScript.userQuantia < quantPagar ){
                                   //inserir quantia invalida de pagamento
                                    document.querySelector('.precario_tituloT').innerHTML = 'Em falta';
                                    document.querySelector('.precarioT').innerHTML = quantPagar - carregarScript.userQuantia + ' Kz';
                                    BootstrapDialog.alert({
                                        title: 'Erro de inserção',
                                        type: BootstrapDialog.TYPE_DANGER,
                                        message: 'Insira uma quantia válida'
                                    });
                                    return a;
                                }
                                else{
                                    //salva na 
                                    //on change de contacto preencher nome e sobrenome com dados da bd com inner html
                                    console.log('saving');
                                   var recebe ={};

                                   $.ajax({
                                    url: 'produto.php',
                                    type: 'POST',
                                    data: { action: 'comprar',
                                    data1: carregarScript.itensPedido,
                                    total: carregarScript.totalAPagar,
                                    troco: carregarScript.userTroco,
                                    quantia: carregarScript.userQuantia,
                                    pagamento: document.getElementById('formaPagamento').value,
                                    fatura: document.getElementById('formaRecibo').value,
                                    cliente: {
                                        nome: document.getElementById('nome').value,
                                        sobrenome: document.getElementById('sobrenome').value,
                                        contacto: document.getElementById('contacto').value
                                    } },
                                    dataType: 'json',
                                    success: function(response) {
                                        console.log('Resposta recebida:', response);
                                        recebe = response;
                                        console.log(recebe,"Testeeeee");
                                        let type = response.sucesso ? BootstrapDialog.TYPE_SUCESS : BootstrapDialog.TYPE_DANGER;
                                        console.log(response.sucesso,"sucesso");
                                         BootstrapDialog.alert({
                                            type: type,
                                            title: response.sucesso ? 'Sucesso' : 'Falha',
                                            message: response.mensagem,
                                            callback: function(isOK){
                                                console.log("Ate aqui");
                                                if(response.sucesso == true){
                                                    carregarScript.attProdutos(response);
                                                    BootstrapDialog.confirm({
                                                        type: BootstrapDialog.TYPE_INFO,
                                                        title: 'Gerar fatura?',
                                                        message: 'Clique em confirmar para gerar a fatura',
                                                        btnOKLabel: 'Confirmar',
                                                        callback: function(faturar){
                                                            if(faturar) { 
                                                                window.location.href = 'fatura.php?idVenda='+response.idFatura;
                                                            } 
                                                        }
                                                    });
                                                }
                                            }
                                         });
                                    },
                                    error: function(jqXHR, textStatus, errorThrown) {
                                        console.error('Erro na requisição AJAX:', textStatus, errorThrown);
                                    }
                                    });

                                    
                                    
                                    console.log("reseta");
                                    carregarScript.totalAPagar =0;
                                    carregarScript.userQuantia =0;
                                    carregarScript.itensPedido = {};
                                    carregarScript.userTroco = 0;
                                    carregarScript.attTabelaPedidos();
                                    
                                }
                            }
                        }
                    });
                }
            }  
         });
         document.addEventListener('change', function(e){
            let elementAlvo = e.target;
            let elementAlvoClasses = elementAlvo.classList;
            if(elementAlvo.id === 'quantia'){
                let quantia = elementAlvo.value;
                if(isNaN(quantia) || quantia < 1 || quantia < carregarScript.totalAPagar ){
                    document.querySelector('.precario_tituloT').innerHTML = 'Em falta';
                    document.querySelector('.precarioT').innerHTML = carregarScript.totalAPagar-quantia +' Kz';
                    carregarScript.userQuantia = quantia;
                   
                }else{
                    let troco = quantia - carregarScript.totalAPagar;
                    carregarScript.userQuantia = quantia;
                    document.querySelector('.precario_tituloT').innerHTML = 'Troco';
                    document.querySelector('.precarioT').innerHTML = troco +' Kz';
                    carregarScript.userTroco = troco;
    
                    //console.log(troco);
                }
            }
         });
    }

    this.attProdutos = function(response){

        let produtosJson = response.produtos;
        carregarScript.produtos = {};
        console.log("abriu o att prod");
        produtosJson.forEach((produto)=> {
            carregarScript.produtos[produto.id] = {
                nome : produto.nome,
                estoque : produto.estoque,
                preco : produto.preco
            }
        });

        carregarScript.totalAPagar =0;
        carregarScript.userQuantia =0;
        carregarScript.itensPedido = {};
        carregarScript.userTroco = 0;
        carregarScript.attTabelaPedidos();
    }

    this.attTabelaPedidos = function(){
        carregarScript.totalAPagar = 0;
        let containerPedidos = document.querySelector('.pos_itens');
        let html = '<p class="itensVazio">Sem dados</p>'; 

        if(Object.keys(carregarScript.itensPedido)){

            let tabelaHTML = `
            <table class="table" id="pos_itens_tbl">
                <thead> 
                    <tr>
                        <th>#</th>
                        <th>Produto</th>
                        <th>Preco</th>
                        <th>Qtd</th>
                        <th>Subtotal</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="bod">__ROWS__</tbody>
            </table>`;
            let linha = ' ';
            let linhaNum = 1;
            for (const [pid, itenPedido] of Object.entries(carregarScript.itensPedido)) {
                linha += `
                <tr> 
                    <td> ${linhaNum} </td>
                    <td> ${itenPedido['nome']} </td>
                    <td> ${itenPedido['precoUnit']} </td>
                    <td> ${itenPedido['qtdPedido']} 
                        <a href="javascript:void(0)" class="menosQtdIten"  data-id="${pid}">
                            <i class="fa fa-minus menosQtdIten"  data-id="${pid}" ></i>
                        </a>
                        <a href="javascript:void(0)" class="maisQtdIten"  data-id="${pid}">
                            <i class="fa fa-plus maisQtdIten" data-id="${pid}" ></i> 
                        </a>
                    </td>
                    <td> ${itenPedido['subTotal'] }</td>

                    <td> 
                        <a href="javascript:void(0)" class="pos_item_btn apagarPedidoIten" data-id="${pid}">
                            <i class="fa fa-trash apagarPedidoIten" data-id="${pid}" ></i>
                        </a>
                    </td>

                </tr>
                `;
                //add kz ao preco unit e subtotal
                linhaNum++;
                //console.log(itenPedido);
                carregarScript.totalAPagar += itenPedido['subTotal'] ;

            }
            html = tabelaHTML.replace('__ROWS__',linha);
        }

        containerPedidos.innerHTML = html;
        carregarScript.attValorAPagar();
         

    }

    this.attValorAPagar = function(){
        document.querySelector('.itens_total--valor').innerHTML = carregarScript.totalAPagar + ' Kz';
    }
    
    this.addEmPedidos = function(prodInfo, pid, qtdPedido){

        let atualIDitem = Object.keys(carregarScript.itensPedido);
        let precoSubTotal = prodInfo['preco'] * qtdPedido ;

        if(atualIDitem.indexOf(pid) > -1){
            //console.log('existe, será alterado');
            carregarScript.itensPedido[pid]['subTotal'] += precoSubTotal;
            carregarScript.itensPedido[pid]['qtdPedido'] += qtdPedido;
            console.log("abriu");

        }
        else{
            carregarScript.itensPedido[pid] = {
                nome : prodInfo['nome'],
                precoUnit : prodInfo['preco'],
                qtdPedido : qtdPedido,
                subTotal : precoSubTotal
            };
            //------------------diminui no estoque
        }
        carregarScript.produtos[pid]['estoque'] -= qtdPedido;
        console.log(carregarScript.itensPedido);

        this.attTabelaPedidos();
        
        return ;

    }

    this.iniciar  = function(){
        this.relogio();
        this.registarEvento();
    }
};

let carregarScript = new script;
carregarScript.iniciar();
