#COUNT /contar
select COUNT(Nome) as 'numero de nomes' from clientes;
select COUNT(Telefone) as 'numero de telefones' from clientes; #apenas os telefones que não são null

select count(*) from clientes; #todas as linhas da tabela
select count(*) from pedidos;

#quantidade da marcas distintas na tabela produtos // count (distinct )

select count(distinct Marca_Produto) from produtos;

SELECT 
    COUNT(DISTINCT Sexo)
FROM
    clientes;



#SUM , AVG , MIN e MAX

select sum(Receita_Venda) as "soma" , avg(Receita_Venda) as "média" , min(Receita_Venda) as "mínimo"  , 
max(Receita_Venda) as "máximo" from Pedidos;


#group by
-- podemos agrupar colunas

#quantidade de produtos de cada marca
select Marca_Produto, count(*) as "quantidade de produtos" from produtos group by Marca_Produto;
select * from produtos;
select Marca_Produto from produtos group by Marca_Produto; #nome das marcas distintas de produtos

#quantidade de clientes por sexo
select Sexo, count(*) as "quantidade de clientes por sexo" from clientes group by Sexo;

#quantidade de vendas por ID do produto , use a tabela pedidos
select Id_Produto , count(*) as "quantidade de vendas por ID produto" from pedidos group by ID_Produto;
select Id_Produto , sum(Receita_Venda) as "quantidade de vendas por ID produto" from pedidos group by ID_Produto;
select * from pedidos order by ID_Produto asc;


select
ID_Cliente ,
ucase(Nome) as 'Nome',









