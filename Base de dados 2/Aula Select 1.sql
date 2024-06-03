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
 ORDER BY Renda_Anual DESC ;
 
 #DEFINIR MAIS DE UM CRITÉRIO DE ORDENAÇÃO
 SELECT *
 FROM clientes 
 ORDER BY Renda_Anual DESC, Data_Nascimento DESC, Nome ASC;
 
 
 
 # AS 'ALIAS', LIMIT num_pular, num_apresentar, OFSSET num_pular, ORDER BY Coluna ASC
 
 
 