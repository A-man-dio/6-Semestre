SELECT * FROM banco.produtos;

SELECT Nome_Produto FROM banco.produtos;

SELECT ID_Produto,Nome_Produto,Preco_Unit FROM banco.produtos;

SELECT *,Preco_Unit * 4 
FROM banco.produtos;

SELECT *,Preco_Unit * 4 AS 'Novo preco'
FROM banco.produtos;

SELECT ID_Produto AS 'Nº Produto', Nome_Produto AS 'Nome do Produto', ID_Categoria AS 'Identificador da categoria',Preco_Unit AS Preco
FROM banco.produtos;

SELECT ID_Produto AS 'Nº Produto', Nome_Produto AS 'Nome do Produto', ID_Categoria AS 'Identificador da categoria',Preco_Unit AS Preco, (Preco_Unit - Custo_Unit) AS 'Lucro'
FROM banco.produtos;
 
 #limitar num de resultados do select
 
 SELECT * 
 FROM pedidos
 LIMIT 100;
 
 #OFFSET ignora N linhas desde o início
 SELECT * 
 FROM pedidos
 LIMIT 10
 OFFSET 5;
 
 SELECT * 
 FROM pedidos
 LIMIT 10,50;
 
 SELECT * 
 FROM pedidos
 LIMIT 50 OFFSET 10;
 
 SELECT *
 FROM clientes 
 ORDER BY Renda_Anual ASC ;
 
 #DEFINIR MAIS DE UM CRITÉRIO DE ORDENAÇÃO
 SELECT *
 FROM clientes 
 ORDER BY Renda_Anual DESC, Data_Nascimento DESC, Nome ASC;
 
 SELECT *
FROM cliente
WHERE Renda_anual >= 800000;

SELECT * 
FROM clientes
WHERE Sexo = ‘M’;

SELECT * 
FROM clientes
WHERE Escolaridade = 'Parcial' ;

#WHERE COM OPERADOR LÓGICO

#WHERE COND1 OP_LOG COND2

SELECT *
FROM Produtos
WHERE Marca_Produto = 'DELL' AND Preco_Unit >= 2000 ;

SELECT *
FROM Produtos
WHERE Marca_Produto = 'DELL' OR Marca_Produto = 'ALTURA' ;  

SELECT *
FROM Produtos
WHERE NOT Marca = 'Samsung' ;

 #ou

SELECT *
FROM Produtos
WHERE Marca <> 'Samsung' ;

# para retornar string vazia

SELECT *
FROM clientes
WHERE Telefone = '' ;

#EXECRCICIOS
#1
SELECT * FROM produtos WHERE Marca_Produto IN ('DELL','SONY','SAMSUNG');
#2
SELECT * FROM produtos WHERE Marca_Produto NOT IN ('ALTURA','SONY');
#3 
SELECT * FROM clientes WHERE Data_Nascimento BETWEEN '1990/01/01' AND '1999/12/31' ORDER BY Data_Nascimento ASC;
#4
SELECT * FROM clientes ORDER BY Renda_Anual DESC, Data_Nascimento DESC;
#5
SELECT * FROM clientes ORDER BY Data_Nascimento DESC,Renda_Anual DESC;
#6
SELECT * FROM pedidos LIMIT 20 OFFSET 5;
#7
SELECT * FROM pedidos LIMIT 5,20;
#8
SELECT ID_Pedido AS 'Pedido', Data_Venda AS 'Data', Preco_Unit AS 'Preco', 'Nova Mensagem' AS 'Novo' FROM pedidos ;
#9

#SET @completo = CONCAT(@nome1,' ',@nome2);
SET @nome1 = 'Eunice';
SET @nome2 = 'Soleno';

SET @completo = CONCAT_WS('_',@nome1,@nome2);
SELECT @completo As 'cliente';

#COUNT, COUNT(*), COUNT(DISTINCT)

SELECT COUNT(Nome) FROM clientes;

SELECT COUNT(Telefone) FROM clientes;

SELECT COUNT(*) FROM produtos;

SELECT * FROM produtos;

SELECT COUNT(DISTINCT Marca_Produto) FROM produtos;
SELECT DISTINCT Marca_Produto FROM produtos;

SELECT COUNT(DISTINCT Sexo) FROM clientes;

SELECT 
	SUM(Receita_Venda) AS 'Receita total', AVG(Receita_Venda) AS 'Media total' 
FROM pedidos;

SELECT 
	MIN(Receita_Venda) AS 'Minimo total' 
FROM pedidos;

SELECT 
	MAX(Receita_Venda) AS 'Maximo total' 
FROM pedidos;

SELECT * FROM produtos;

SELECT COUNT(DISTINCT Marca_Produto) FROM produtos;
-- group by

SELECT Marca_Produto, COUNT(*) AS 'QTD'
FROM produtos
GROUP BY Marca_Produto;

SELECT Sexo, COUNT(*) AS 'QTD' FROM clientes GROUP BY Sexo;

SELECT ID_Produto, COUNT(*) AS 'QTD' FROM pedidos GROUP BY ID_Produto;


SELECT 
ID_Cliente,
CONCAT_WS(' ', Nome, Sobrenome) AS 'Nome Completo'
FROM clientes;

SELECT Sexo,Escolaridade,
AVG(Renda_Anual) AS 'Renda'
FROM clientes
GROUP BY Escolaridade, Sexo;

SELECT Escolaridade,
COUNT(Escolaridade) AS 'Qtd'
FROM clientes
GROUP BY Escolaridade;

SELECT Escolaridade,
COUNT(Escolaridade) AS 'Qtd'
FROM clientes
WHERE Sexo = 'F'
GROUP BY Escolaridade;

-- APLICAR O FILTRO NO GRUPO
-- escolaridade com mais de 25 alunos

SELECT Escolaridade, COUNT(*)
FROM clientes
GROUP BY Escolaridade
HAVING COUNT(*) > 25;



