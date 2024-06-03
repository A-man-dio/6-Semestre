#exercicios
#1
select * from produtos where Marca_Produto in('DELL' , 'SAMSUNG' , 'SONY') ;

#2
select * from produtos where Marca_Produto not in('ALTURA' , 'SONY') ;

#3
select * from clientes where Data_Nascimento between '1990-01-01' and '1999-12-31';

#4
select * from clientes order by Renda_Anual desc , Data_Nascimento desc ;

#5
select * from clientes order by Data_Nascimento desc , Renda_Anual desc ;

#6
select * from pedidos
limit 20 offset 5;

#7
select * from pedidos
limit 5,20;

#8
select ID_Pedido as 'Pedido' , Data_Venda as 'Data' 
, Preco_Unit as 'Preço' , 'nova mensagem' as 'Novo'   from pedidos;

#9
set @varNome = 'Basílio';
set @varSobreNome = 'Catanga';
set @varNomeCompleto = concat(@varNome , ' ' ,  @varSobreNome);
set @varNomeCompletoWS = concat_ws(' ' , @varNome , @varSobreNome);
select @varNomeCompleto;
select @varNomeCompletoWS;

select ucase(@varNome);
select lcase(@varNome);

select * , concat_ws(' ' , Nome , Sobrenome) as 'Nome Completo' from clientes;

select * , ucase(concat_ws(' ' , Nome , Sobrenome)) as 'Nome Completo' from clientes;
select * , lcase(concat_ws(' ' , Nome , Sobrenome)) as 'Nome Completo' from clientes;






