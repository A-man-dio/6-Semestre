#1a
select count(distinct Categoria) as "Número de categorias existentes" from categorias; -- 7 categorias existentes

#1b
select * from clientes where Renda_Anual < 10000; -- não existe nenhum cliente com renda anual inferior a 10.000 reais

#1c
select sum(Receita_Venda) as "total de receita gerada no mês de março" from lojas inner join pedidos where Loja="salvador" and lojas.ID_Loja = pedidos.ID_Loja and pedidos.Data_Venda like "2024-03%";

#1d
select * from produtos inner join pedidos where produtos.ID_Produto = pedidos.ID_Produto ;

#2a
select Região , count(Cidade) from locais group by Região;

#2b
select Telefone from lojas where Loja like "%t%";

#2c
select * from lojas order by Num_Funcionarios desc;

#2d
select Escolaridade , count(*) from clientes where Sexo = "F" group by Escolaridade;

#3
select *  ,replace(Estado_Civil , "S" , "C" )  from clientes;

#3b
select * from clientes where Email;






