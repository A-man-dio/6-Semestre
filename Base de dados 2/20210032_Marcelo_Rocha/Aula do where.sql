#aula do where

#clientes que têm renda anual maior ou igual a 80.000

#where
select * from clientes
where Renda_Anual >=80000;

#do sexo masculino
select * from clientes
where Sexo = 'M';

#de escolaridade parcial
select * from clientes
where Escolaridade = 'Parcial';

#Computadores marca Dell e preço maior ou igual a 2000
select * from produtos
where Marca_Produto = 'DELL' and Preco_Unit >= 2000;

#Computadores marca Dell ou Altura
select * from produtos
where Marca_Produto = 'DELL' or Marca_Produto = 'ALTURA';

#todos os computadores que não são da Samsung;
select * from produtos
where Marca_Produto <> 'SAMSUNG';

select * from produtos
where Not (Marca_Produto = 'SAMSUNG');

# o comando where com is null ou is not null
# os clientes que não têm cadastro de telefone (vazio é diferente de null)

select * from clientes
where Telefone is null;

select * from clientes
where Telefone = '';

select * from clientes
where Telefone is not null;

#where - like
#quais clientes possuem um email do gmail

select * from clientes
where Email like '%gmail%' ; # o % representa qualquer coisa depois vem o gmail depois termina com qualquer coisa

select * from clientes
where Email like 'al%';  #começa com al e termina com qualquer coisa

select * from clientes
where Email like '%hotmail%' or Email like '%outlook%';

select * from clientes where Email like '%.br';

#where (in e not in) , invés de usar o or or or or or podemos usar o IN(valor1 , valor2 , etc)

select * from produtos
where Marca_Produto in('DELL' , 'SONY' , 'ALTURA');

select * from produtos
where Marca_Produto not in('DELL' , 'SONY' , 'ALTURA');


#where BETWEEN - para filtrar os intervalos

select * from produtos
where Preco_Unit >= 1000 and Preco_Unit <= 2500;

select * from produtos
where Preco_Unit between 1000 and 2500;

select * from clientes
where Data_Nascimento between '1995-01-01' and '1999-12-31';











