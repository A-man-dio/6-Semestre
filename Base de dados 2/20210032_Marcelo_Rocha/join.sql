#aula do join

select * from produtos;
select * from pedidos;

select pedidos.ID_Pedido , pedidos.ID_Loja, pedidos.ID_Produto , produtos.Nome_Produto ,produtos.Marca_Produto, produtos.Num_Serie ,  pedidos.Qtd_Vendida , pedidos.Receita_Venda , pedidos.Custo_Venda , pedidos.Custo_Unit , pedidos.Preco_Unit from pedidos inner join produtos on pedidos.ID_Produto = produtos.ID_Produto; #a tabela maior (com maior registos) é que fica em primeiro logo , pedidos primeiro

select pe.ID_Pedido , pe.ID_Loja, pe.ID_Produto , pr.Nome_Produto ,pr.Marca_Produto, pr.Num_Serie ,  pe.Qtd_Vendida , pe.Receita_Venda , pe.Custo_Venda , pe.Custo_Unit , pe.Preco_Unit from pedidos as pe inner join produtos as pr on pe.ID_Produto = pr.ID_Produto;

#dar nome as tabelas (nesse caso pe e pr , mas é sempre bom meter as pe e as pr , de forma a facilitar a leitura)
select pe.ID_Pedido , pe.ID_Loja, pe.ID_Produto , pr.Nome_Produto ,pr.Marca_Produto, pr.Num_Serie ,  pe.Qtd_Vendida , pe.Receita_Venda , pe.Custo_Venda , pe.Custo_Unit , pe.Preco_Unit from pedidos pe inner join produtos pr on pe.ID_Produto = pr.ID_Produto;


select * from pedidos;
select * from lojas;

select pedidos.ID_Pedido, pedidos.Data_Venda , lojas.Loja , produtos.Nome_Produto , pedidos.Custo_Venda from pedidos inner join lojas on pedidos.ID_Loja = lojas.ID_Loja inner join produtos on pedidos.ID_Produto = produtos.ID_Produto;






#trabalhando com views
#criar view para a tabela clientes , com esses campos
create view viewClientes as 
select ID_Cliente , Nome , Data_Nascimento , Email , Telefone 
from clientes;

select * from viewclientes;

select ID_Cliente , Nome , Email from viewclientes;

#alterar a view
alter view viewclientes as select ID_Cliente , Nome , Sexo , Data_Nascimento , Email , Telefone from clientes;

create view viewClientesOutro as 
select ID_Cliente as 'ID' , Nome , Data_Nascimento as 'Data de Nascimento' , Email , Telefone 
from clientes;

drop view viewclientesoutro;

select * from viewclientesoutro;

create table if not exists departamentos (
	id int primary key,
    nome varchar(20) not null
);


create table if not exists funcionarios (
	id int primary key,
    nome varchar(20) not null ,
    salario float not null,
    departamento_id int not null,
    foreign key (departamento_id) references departamentos(id)
);

insert into departamentos values ( 1 , "Vendas") ,
(2 , "TI");

insert into funcionarios values (1 , "João" , 3000.00 , 1),
(2 , "Maria" , 4000.00 , 2),
(3 , "Pedro" , 3500.00 , 1),
(4 , "Ana" , 3800.00 , 2);

create view viewDetalhesFuncionarios as
select funcionarios.id as "id_funcionario" , funcionarios.nome as "nome_funcionario" , funcionarios.salario as "salario" , departamentos.nome  from funcionarios inner join departamentos on funcionarios.departamento_id = departamentos.id ;

drop view viewdetalhesfuncionarios;

drop table departamentos;

#seleccionar produtos acima da média

select * from produtos where Preco_Unit > 1788.1250;

select avg(Preco_Unit) as "Média" from produtos;

select * from produtos where Preco_Unit > (select avg(Preco_Unit) as "Média" from produtos) ;


#seleccionar os pedidos onde o gerente é marcelo castro (retorne apenas dados da tabela pedidos)
select * from pedidos;
select * from lojas;

select ID_Loja from lojas where Gerente = "Marcelo Castro";  #id da loja do marcelo castro
select * from pedidos where ID_loja = (select ID_Loja from lojas where Gerente = "Marcelo Castro"); #final

#quais produtos são da categoria "Notebook" ? Retorne somente os dados da tabela produtos

select * from produtos;
select * from categorias;

select ID_Categoria from categorias where Categoria = "Notebook";

select * from produtos where ID_Categoria = (select ID_Categoria from categorias where Categoria = "Notebook");

#quais produtos são da categoria "Notebook" , "Monitor" , "Microfone" ?

select ID_Categoria from categorias where Categoria in ("Notebook" , "Monitor" , "Microfone");

select * from produtos where ID_Categoria in (select ID_Categoria from categorias where Categoria in ("Notebook" , "Monitor" , "Microfone"));

#consulta que retorne todas as colunas da tabela de produtos + uma coluna com a média do preço unit

select * , (select avg(Preco_Unit) from produtos) as "Média do preço" from produtos;

#qual a receita total associada aos produtos da marca DELL

select sum(Preco_Unit) from produtos where Marca_Produto = "DELL";

#descubra as informações sobre o cliente que gerou mais receita para a empresa

select * from clientes;
select * from pedidos;

select * from clientes where ID_Cliente = (select ID_Cliente from pedidos group by ID_Cliente order by sum(Receita_Venda) desc limit 1);

select ID_Cliente from pedidos group by ID_Cliente order by sum(Receita_Venda) desc limit 1;

select sum(Receita_Venda) as "soma" from pedidos group by ID_Cliente;

select max(soma) as maximo_soma from (select sum(Receita_Venda) as soma from pedidos group by ID_Cliente) as subconsulta;


#exercicios

#quais pedidos foram feitos na região sudeste
select * from pedidos;
select * from locais;
select * from lojas;

select * from pedidos where ID_Loja in (select ID_Loja from lojas where Loja in (select Cidade from locais where Região = "Sudeste"));

-- select ID_Loja from lojas where Loja in (select Cidade from locais where Região = "Sudeste");
-- select Cidade from locais where Região = "Sudeste";

#do total de vendas por produto qual foi a quantidade máxima , mínima e média
select ID_Produto , count(ID_Produto) from produtos group by ID_Produto;
SELECT 

    *
FROM
    pedidos;

SELECT 
    COUNT(ID_Produto) AS 'total de vendas por produto'
FROM
    pedidos
GROUP BY ID_Produto; 

#máximo , minimo , media
SELECT 
    MAX(total_de_vendas_por_produto) AS máximo,
    MIN(total_de_vendas_por_produto) AS mínimo,
    AVG(total_de_vendas_por_produto) AS média
FROM
    (SELECT 
        COUNT(ID_Produto) AS total_de_vendas_por_produto
    FROM
        pedidos
    GROUP BY ID_Produto) AS nova_tabela




