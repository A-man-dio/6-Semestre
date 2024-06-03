#produto cartesiano

SELECT pedidos.ID_Pedido,
	   pedidos.Custo_Unit,
	   produtos.ID_Produto,
       pedidos.ID_Produto FROM pedidos,produtos;

#inner join

SELECT pedidos.ID_Pedido,
	   pedidos.Custo_Unit,
	   produtos.ID_Produto,
       pedidos.ID_Produto,
       produtos.Nome_Produto FROM pedidos INNER JOIN produtos ON pedidos.ID_Produto = produtos.ID_Produto;
       
SELECT pe.ID_Pedido,
	   pe.Custo_Unit,
	   produtos.ID_Produto,
       pe.ID_Produto,
       produtos.Nome_Produto FROM pedidos AS pe INNER JOIN produtos ON pe.ID_Produto = produtos.ID_Produto;

#ID do pedido e o nome da loja correspondente
SELECT pedidos.ID_Pedido,
	   produtos.Nome_Produto,
	   lojas.Loja FROM pedidos
       INNER JOIN lojas ON pedidos.ID_Loja = lojas.ID_Loja
       INNER JOIN produtos ON produtos.ID_Produto = pedidos.ID_Produto;
       
SELECT pedidos.ID_Pedido,
	   produtos.Nome_Produto,
	   lojas.Loja FROM pedidos INNER JOIN lojas INNER JOIN produtos  ON pedidos.ID_Loja = lojas.ID_Loja AND produtos.ID_Produto = pedidos.ID_Produto;
       
       
       
#ex 1
SELECT * 
FROM pedidos 
INNER JOIN clientes ON pedidos.ID_Cliente = clientes.ID_Cliente;

#A tabela com mais dados fica sempre a seguir ao from, nesse caso a tabela pedidos (tabela facto), já a tabela cliente (tabela dimensão) tem escala de crescimento minimizado

#ex2
SELECT * 
FROM pedidos 
INNER JOIN produtos ON pedidos.ID_Produto = produtos.ID_Produto ;
       
#ex3
SELECT pe.ID_Pedido,
	   pe.ID_produto,
       pr.Nome_Produto,
       pe.Data_Venda,
       l.loja,
       pe.ID_Loja
FROM pedidos AS pe
INNER JOIN produtos AS pr 
INNER JOIN lojas AS l ON pe.ID_Produto = pr.ID_Produto AND pe.ID_Loja = l.ID_Loja;
       
#ex4



#Criar VIEWS

CREATE VIEW viewClientes AS 
SELECT 
	ID_Cliente,
    Nome,
    Data_Nascimento,
    Email,
    Telefone
FROM clientes;

#ACESSAR VIEW
SELECT *
FROM viewclientes;

SELECT 
	ID_Cliente,
    Nome,
    Email
FROM viewclientes;
       
#alterar view

AlTER VIEW viewClientes AS
SELECT
	  ID_Cliente,
	  Nome,
      Sexo,
	  Data_Nascimento,
      Email,
      Telefone
FROM clientes;
 
CREATE VIEW viewClientesV1 AS
SELECT
	  ID_Cliente AS 'ID',
	  Nome,
      Sexo,
	  Data_Nascimento 'Data de Nascimento',
      Email,
      Telefone
FROM clientes;
       
   SELECT * 
   FROM viewClientesV1
   WHERE Sexo = 'F';
       
  #eliminar view
  
  DROP VIEW viewclientesv1;