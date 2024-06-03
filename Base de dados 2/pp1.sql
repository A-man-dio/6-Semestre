#1-a)
SELECT COUNT(DISTINCT Categoria) AS 'Categorias diferentes'
FROM categorias;

#1-b)
SELECT COUNT(Renda_Anual)  
FROM clientes
WHERE Renda_Anual < 10000;

#1-c)
#id_loja = 3;
SELECT SUM(Receita_Venda) AS 'Receita total março 2024' 
FROM pedidos 
WHERE Data_Venda BETWEEN '2024-03-01' AND '2024-03-31' AND ID_Loja=3;

#1-d) -----------------------------
SELECT MAX(Qtd_Vendida) AS 'Max unidades vendidas em um só pedido' 
FROM pedidos;

select * from pedidos;

#2- a)
SELECT Região,COUNT(DISTINCT Cidade) AS 'Num Cidades diferentes na regiao' 
FROM locais
GROUP BY Região;

#2-b)------------------

#2-c)
SELECT * FROM lojas 
ORDER BY Num_Funcionarios DESC;

#2-d
SELECT Escolaridade, Count(*)
FROM clientes
WHERE Sexo = 'F'
GROUP BY Escolaridade;

#3-a)-----------------------------

select * from clientes;
SELECT case when Estado_Civil = 'S' THEN REPLACE(Estado_Civil,'S','Solteiro')
			when Estado_Civil = 'C' then REPLACE(Estado_Civil,'C','Casado' ) end FROM clientes;


#3-b)
SELECT MID(Email,INSTR(Email,'@'), INSTR(Email,'.com')) FROM clientes;
#WHERE ID_cliente = 5;

#3-c)

SELECT DATE_FORMAT(Data_Nascimento,'%d-%m-%Y') as 'Data nascimento' FROM clientes ;

SELECT 
    Nome,
    CASE 
        WHEN Sexo = 'F' THEN 'Feminino'
        WHEN Sexo = 'M' THEN 'Masculino'
        
    END AS Sexo
FROM 
    clientes;

#4

drop database teste;

CREATE DATABASE IF NOT EXISTS teste;
USE teste;

CREATE TABLE IF NOT EXISTS categorias(
	ID_Categoria int,
    Categoria text
);

CREATE TABLE IF NOT EXISTS clientes(
	ID_Cliente int,
    Nome text,
    Sobrenome text,
    Data_Nascimento text,
    Estado_Civil text,
	Sexo text,
    Email text,
	Telefone text,
	Renda_Anual int,
	Qtd_Filhos int,
	Escolaridade text
    
);

CREATE TABLE IF NOT EXISTS locais(
	Cidade text,
	Estado text,
    Região text
);