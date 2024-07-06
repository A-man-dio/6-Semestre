create database livraria_online;

use livraria_online;

create table livros (
	id_livro int primary key auto_increment,
    titulo varchar(50) not null,
    autor varchar(50) not null,
    genero varchar(50) not null,
    preco float not null,
    estoque int not null,
    ano_publicacao int not null
);

create table clientes (
	id_cliente int primary key auto_increment,
    nome varchar(50) not null,
    email varchar(70) not null,
    BI varchar(50) not null,
    endereco varchar(100) not null
);

create table pedidos (
	id_pedido int primary key auto_increment,
    id_cliente int,
    data_pedido int not null,
    status_ varchar(20) not null,
    foreign key (id_cliente) references clientes (id_cliente)
);


create table itens_pedido(
	id_iten_pedido int primary key auto_increment,
    id_pedido int,
    id_livro int not null,
    quantidade int not null,
    preco_unitario float,
    foreign key (id_pedido) references pedidos (id_pedido),
    foreign key (id_livro) references livros (id_livro)
);

INSERT INTO livros(titulo,autor,genero,preco,estoque,ano_publicacao)
VALUES
('O Senhor dos Anéis','J.R.R. Tolkien','Fantasia','59.90','8','1954'),
('Harry Potter','J.K. Rowling','Fantasia','49.90','3','1997'),
('Duna','frank Herbert','Ficção Científica','39.90','0','1965'),
('1984','George Orwell','Ficção Científica','29.90','15','1949'),
('O Pequeno Príncipe','Antoine de Saint-Exupéry','Infantil','19.90','22','1943'),
('A Revolução dos Bichos','George Orwell','Ficção Política','24.90','12','1945'),
('O Hobbit','J.R.R. Tolkien','Fantasia','44.90','5','1937'),
('Neuromancer','William Gibson','Cyberpunk','34.90','9','1984')
;

INSERT INTO clientes(nome,email,BI,endereco)
VALUES
('João Silva','joao.silva@email.com','12345678901','Rua A, 123, Centro'),
('Maria Souza','maria.souza@email.com','98765432109','Avenida B, 456, Bairro Novo'),
('Carlos Santos','carlos.souza@email.com','55555555555','Travessa C, 789, vila Verde'),
('Ana Oliveira','ana.oliveira@email.com','11122233344','Rua D, 000, Jardim')
;

alter table pedidos
drop column data_pedido,
add column data_pedido date not null;

INSERT INTO pedidos(id_cliente,data_pedido,status_)
VALUES
('1','2024-05-15','Entregue'),
('2','2024-05-20','Em processamento'),
('1','2024-06-01','Entregue'),
('3','2024-05-03','Cancelado');

INSERT INTO itens_pedido(id_pedido,id_livro,quantidade,preco_unitario)
VALUES
('1','1','2','59.90'),
('1','5','1','19.90'),
('2','2','1','49.90'),
('3','4','3','29.90'),
('3','6','1','24.90')
;
#b)
select * from livros where estoque >5;
#c)
select titulo, preco from livros where genero = 'Ficção Científica';

select count(*);


#g)
select itp.id_pedido,cli.nome, cli.BI, cli.endereco, pe.data_pedido, lv.titulo, itp.quantidade, itp.preco_unitario 
from clientes as cli
inner join livros as lv
inner join itens_pedido as itp
inner join pedidos as pe 
on pe.id_cliente = cli.id_cliente 
and itp.id_livro = lv.id_livro 
and itp.id_pedido = pe.id_pedido;


#g)
create view pedidos_info as

