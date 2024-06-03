
create database novoBanco;
use novoBanco;

create table categorias(
ID_Categoria int auto_increment primary key,
 Categoria varchar(30) not null
);

create table clientes(
ID_Cliente int auto_increment primary key,
Nome varchar(30) not null,
Sobrenome varchar(30) not null,
Data_Nascimento varchar(30) not null,
Estado_Civil varchar(1) not null,
Sexo varchar(1) not null,
Email varchar(100) not null,
Telefone varchar(14) not null,
Renda_Anual float not null,
Qtd_Filhos int not null,
Escolaridade varchar(30) not null
);

create table locais(
Cidade varchar(30) primary key,
Estado varchar(30) not null,
Região varchar(30) not null
);