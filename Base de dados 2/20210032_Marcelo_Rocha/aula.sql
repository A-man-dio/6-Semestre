#COUNT /contar
select COUNT(Nome) as 'numero de nomes' from clientes;
select COUNT(Telefone) as 'numero de nomes' from clientes; #apenas os telefones que não são null

select count(*) from clientes; #todas as linhas da tabela
select count(*) from pedidos;

#quantidade da marcas distintas na tabela produtos // count (distinct )

select count(distinct Marca_Produto) from produtos;
select count(distinct Sexo) from clientes;
