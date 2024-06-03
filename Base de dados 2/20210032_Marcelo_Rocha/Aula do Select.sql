# a) selecionar todos
SELECT * FROM banco.produtos;

# b) selecionar apenas a coluna Nome_Produto da tabela produto

SELECT Nome_Produto FROM produtos;

# c) selecionar id, nome, preco

SELECT ID_Produto, Nome_Produto, Preco_Unit FROM produtos;

# d) selecionar todas colonas da tabela produtos e adcione uma coluna Novo Preco cujo o resultado é a multiplicação da coluna Preco_Unit vezes 4
SELECT *, (Preco_Unit * 4) AS 'Novo Preco' FROM produtos;

# e) renomear o id produto

SELECT ID_Produto AS 'Nº Produto', Nome_Produto AS 'Nome do Produto', ID_Categoria AS 'Idenficador dq Categoria', Preco_Unit AS 'Preco' FROM produtos;

# 2) Usando a tabela pedidos, renomeie ID_Pedido por Pedido, Data_Venda por Data, Preco_Unit por Preco

SELECT ID_Pedido AS 'Pedido', Data_Venda AS 'Data', Preco_Unit AS 'Preco' FROM pedidos;

# 3) Ainda Usando a tabela pedidos, retorna as colunas renomeadas do exemplo anterior e crie uma coluna calculada (Preco_Unit - Custo_Unit) e renomeie essa coluna por Lucro

SELECT ID_Pedido, Data_Venda, Preco_Unit, (Preco_Unit - Custo_Unit) AS 'Lucro' from Pedidos;

/* Limit e offsset: LIMIT define limite de linhas a serem retornadas, OFFSSET define limite de linhas a serem ignoradas no inicio */

# use o limite para mostar 100 elementos e depois 10, da tabela pedidos

SELECT * FROM pedidos LIMIT 10;

# use LIMIT e OFFSET 

SELECT * FROM pedidos LIMIT 10 OFFSET 5;

# exemplo 3: teste o código e analisa
 
SELECT * FROM pedidos LIMIT 10,50;

/* ORDER BY - Objetivo desse comando é organizar a tabela a partir de uma ou mais colunas daquela tabela Traz dois comandos ASC e DESC. 
-- ASC (Padrão): ordena de forma crescente
        -- Textos: A - Z / Números: Crescente / Data: Da mais antiga a mais recente.
        O DESC é o oposto */
        
# Ordenar a coluna nome da tab cliente de forma ASC      

SELECT * FROM clientes ORDER BY Nome ASC;

# ordenar a culna de forma DESC 

SELECT * FROM clientes ORDER BY Nome DESC;

# ordenar a coluna Renda_Anual da tabela clientes de forma ASC

SELECT * FROM clientes ORDER BY Renda_Anual ASC;

# Ordenar as colunas Renda_Atual e Data_Nascimento ada tabela clientes de forma DESC. (Observe a Agela e Alyssa)

SELECT * FROM clientes ORDER BY Renda_Anual DESC, Data_Nascimento DESC; 

#ordenar as colunas nome e sobrenome da tabela clientes de forma asc
select * from clientes order by Nome asc, Sobrenome asc;

