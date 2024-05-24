CREATE DATABASE IF NOT EXISTS Loja_da_Quetura; 

USE Loja_da_Quetura;

CREATE TABLE IF NOT EXISTS Produtos(
    id_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(225),
    descricao TEXT,
    preco DECIMAL (10,2),
    categoria VARCHAR(50),
    estoque INT
);

CREATE TABLE IF NOT EXISTS Clientes(	
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(225),
    email VARCHAR(225),
    BI VARCHAR(14),
    endereco VARCHAR(225)
);

CREATE TABLE IF NOT EXISTS Pedidos(	
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT ,
    data_pedido DATE,
    status_ VARCHAR(50),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE IF NOT EXISTS Itens_Pedidos(	
    id_item_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT,
    id_produto INT,
	quantidade INT,
    preco_unitario DECIMAL(10,2),
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
    FOREIGN KEY (id_produto) REFERENCES Produtos(id_produto)
);

INSERT INTO Produtos (nome, descricao, preco, categoria, estoque) VALUES
('Arroz', 'Arroz branco tipo 1, pacote de 1kg', 5.99, 'Grãos', 200),
('Feijão', 'Feijão carioquinha, pacote de 1kg', 7.99, 'Grãos', 150),
('Açúcar', 'Açúcar refinado, pacote de 1kg', 3.49, 'Ingredientes', 300),
('Café', 'Café torrado e moído, pacote de 500g', 9.99, 'Bebidas', 100),
('Leite', 'Leite integral, caixa de 1 litro', 3.79, 'Laticínios', 120),
('Ovos', 'Ovos brancos, dúzia', 5.49, 'Laticínios', 80),
('Pão', 'Pão de forma, pacote com 500g', 4.29, 'Padaria', 90),
('Macarrão', 'Macarrão espaguete, pacote de 500g', 2.99, 'Massas', 200),
('Óleo', 'Óleo de soja, garrafa de 900ml', 6.49, 'Condimentos', 150),
('Sal', 'Sal refinado, pacote de 1kg', 1.99, 'Condimentos', 250),
('Sabonete', 'Sabonete em barra, pacote com 5 unidades', 8.99, 'Higiene', 100),
('Shampoo', 'Shampoo suave, frasco de 400ml', 12.49, 'Higiene', 80),
('Condicionador', 'Condicionador para cabelos secos, frasco de 350ml', 10.99, 'Higiene', 70),
('Detergente', 'Detergente líquido neutro, frasco de 500ml', 4.79, 'Limpeza', 120),
('Desinfetante', 'Desinfetante perfumado, frasco de 1 litro', 7.99, 'Limpeza', 90),
('Esponja', 'Esponja de limpeza, pacote com 3 unidades', 3.29, 'Limpeza', 150),
('Amaciante', 'Amaciante de roupas, frasco de 2 litros', 9.99, 'Limpeza', 80),
('Alho', 'Alho descascado, pacote com 200g', 3.99, 'Temperos', 100),
('Cebola', 'Cebola branca, saco com 1kg', 2.49, 'Legumes', 120),
('Batata', 'Batata inglesa, saco com 5kg', 6.99, 'Legumes', 80),
('Tomate', 'Tomate maduro, caixa com 1kg', 4.99, 'Legumes', 100),
('Cenoura', 'Cenoura orgânica, saco com 500g', 3.29, 'Legumes', 130),
('Maçã', 'Maçã fuji, saco com 1kg', 8.99, 'Frutas', 70),
('Banana', 'Banana nanica, cacho com 1kg', 4.49, 'Frutas', 90),
('Uva', 'Uva rubi, cacho com 500g', 12.99, 'Frutas', 60),
('Laranja', 'Laranja pera, saco com 2kg', 6.79, 'Frutas', 110),
('Papel Higiênico', 'Papel higiênico folha dupla, pacote com 12 rolos', 14.99, 'Higiene', 150),
('Detergente para Roupa', 'Detergente líquido para roupas brancas, garrafa de 2 litros', 11.49, 'Limpeza', 100),
('Limpador Multiuso', 'Limpador multiuso para superfícies, frasco de 500ml', 5.99, 'Limpeza', 120),
('Creme Dental', 'Creme dental com flúor, tubo de 90g', 3.99, 'Higiene', 80),
('Saco de Lixo', 'Saco de lixo 50L, pacote com 10 unidades', 7.49, 'Limpeza', 110),
('Barra de Chocolate', 'Barra de chocolate ao leite, 100g', 3.29, 'Doces', 200),
('Refrigerante', 'Refrigerante sabor cola, garrafa de 2 litros', 5.99, 'Bebidas', 100),
('Suco', 'Suco de laranja natural, garrafa de 1 litro', 7.49, 'Bebidas', 120),
('Biscoito', 'Biscoito recheado de chocolate, pacote de 150g', 2.79, 'Lanches', 150),
('Iogurte', 'Iogurte natural desnatado, pote de 400g', 3.49, 'Laticínios', 100),
('Queijo', 'Queijo muçarela fatiado, pacote de 150g', 7.99, 'Laticínios', 80),
('Presunto', 'Presunto cozido fatiado, pacote de 200g', 6.49, 'Frios', 100),
('Manteiga', 'Manteiga com sal, tablete de 200g', 5.29, 'Laticínios', 90),
('Creme de Leite', 'Creme de leite fresco, lata de 200g', 3.99, 'Laticínios', 110),
('Papel Toalha', 'Papel toalha absorvente, rolo com 50 folhas', 4.99, 'Limpeza', 130),
('Pasta de Dente', 'Pasta de dente com flúor, tubo de 100g', 4.49, 'Higiene', 90),
('Sabão em Pó', 'Sabão em pó para máquina de lavar, pacote de 1kg', 8.99, 'Limpeza', 100),
('Sabão em Barra', 'Sabão em barra neutro, pacote com 5 unidades', 5.49, 'Limpeza', 120),
('Cerveja', 'Cerveja pilsen, lata de 350ml', 2.99, 'Bebidas', 80),
('Vinho', 'Vinho tinto seco, garrafa de 750ml', 15.99, 'Bebidas', 60),
('Limpador de Vidro', 'Limpador de vidro com gatilho, frasco de 500ml', 6.49, 'Limpeza', 100),
('Desodorante', 'Desodorante aerosol, frasco de 150ml', 9.99, 'Higiene', 70),
('Azeitonas', 'Azeitonas verdes recheadas com pimentão, pote de 150g', 4.79, 'Conservas', 90),
('Atum', 'Atum sólido em óleo vegetal, lata de 170g', 3.49, 'Conservas', 110),
('Creme de Leite', 'Creme de leite de soja, lata de 200g', 4.29, 'Laticínios', 80);

SELECT * FROM PRODUTOS;
 
INSERT INTO Clientes (nome, email, BI, endereco) VALUES
('Ana Silva', 'ana.silva@example.com', 'BA12345678', 'Avenida Amílcar Cabral, nº 123, Benguela'),
('José Santos', 'jose.santos@example.com', 'LB87654321', 'Rua da Liberdade, nº 456, Luanda'),
('Maria Oliveira', 'maria.oliveira@example.com', 'KH23456789', 'Avenida Kuito, nº 789, Huambo'),
('Manuel Fernandes', 'manuel.fernandes@example.com', 'UIG98765432', 'Rua da Independência, nº 1011, Uíge'),
('Carla Sousa', 'carla.sousa@example.com', 'HM34567890', 'Bairro Hoji Ya Henda, nº 1213, Malanje'),
('Paulo Costa', 'paulo.costa@example.com', 'CU09876543', 'Avenida Comandante Jika, nº 1415, Cuanza Sul'),
('Helena Ramos', 'helena.ramos@example.com', 'LN45678901', 'Rua Luanda, nº 1617, Luanda Norte'),
('Luís Martins', 'luis.martins@example.com', 'HUI10987654', 'Avenida Humpata, nº 1819, Huíla'),
('Sofia Pereira', 'sofia.pereira@example.com', 'MD56789012', 'Rua Menongue, nº 2021, Moxico'),
('Rui Gonçalves', 'rui.goncalves@example.com', 'BIE21098765', 'Avenida Benguela, nº 2223, Benguela'),
('Ana Carolina', 'ana.carolina@example.com', 'CC67890123', 'Rua Capitão Chavane, nº 2425, Cuanza Sul'),
('João Oliveira', 'joao.oliveira@example.com', 'ZAI32109876', 'Avenida Zaire, nº 2627, Zaire'),
('Margarida Ferreira', 'margarida.ferreira@example.com', 'MAL78901234', 'Rua Malanje, nº 2829, Malanje'),
('Carlos Silva', 'carlos.silva@example.com', 'UIJ43210987', 'Avenida Uíge, nº 3031, Uíge'),
('Teresa Sousa', 'teresa.sousa@example.com', 'NN89012345', 'Rua Ndalatando, nº 3233, Kwanza Norte'),
('Fernando Santos', 'fernando.santos@example.com', 'KK54321098', 'Avenida Kuando Kubango, nº 3435, Kuando Kubango'),
('Diana Costa', 'diana.costa@example.com', 'LS01234567', 'Rua Lunda Sul, nº 3637, Lunda Sul'),
('Eduardo Fernandes', 'eduardo.fernandes@example.com', 'CC65432109', 'Bairro Comandante Cowboy, nº 3839, Cuando Cubango'),
('Isabel Pereira', 'isabel.pereira@example.com', 'BE12345678', 'Avenida Benguela, nº 4041, Benguela'),
('Vasco Ramos', 'vasco.ramos@example.com', 'MB76543210', 'Rua Menongue, nº 4243, Moxico'),
('Andreia Martins', 'andreia.martins@example.com', 'UI23456789', 'Avenida Uíge, nº 4445, Uíge'),
('Hugo Oliveira', 'hugo.oliveira@example.com', 'ZA87654321', 'Rua Zaire, nº 4647, Zaire'),
('Catarina Costa', 'catarina.costa@example.com', 'KK34567890', 'Avenida Kuando Kubango, nº 4849, Kuando Kubango'),
('Nuno Sousa', 'nuno.sousa@example.com', 'BE98765432', 'Avenida Benguela, nº 5051, Benguela'),
('Mónica Silva', 'monica.silva@example.com', 'LL45678901', 'Rua Lunda Norte, nº 5253, Lunda Norte'),
('Ricardo Gonçalves', 'ricardo.goncalves@example.com', 'HUI10987654', 'Avenida Huíla, nº 5455, Huíla'),
('Patrícia Oliveira', 'patricia.oliveira@example.com', 'CC56789012', 'Bairro Comandante Cowboy, nº 5657, Cuando Cubango'),
('Sérgio Almeida', 'sergio.almeida@example.com', 'ML21098765', 'Rua Malanje, nº 5859, Malanje'),
('Vânia Rodrigues', 'vania.rodrigues@example.com', 'CK67890123', 'Rua Cuanza Norte, nº 6061, Cuanza Norte'),
('Fábio Fernandes', 'fabio.fernandes@example.com', 'BE32109876', 'Avenida Benguela, nº 6263, Benguela'),
('Liliana Sousa', 'liliana.sousa@example.com', 'ML78901234', 'Rua Malanje, nº 6465, Malanje'),
('Bruno Costa', 'bruno.costa@example.com', 'ZA43210987', 'Rua Zaire, nº 6667, Zaire'),
('Inês Santos', 'ines.santos@example.com', 'NN89012345', 'Rua Ndalatando, nº 6869, Kwanza Norte'),
('Miguel Silva', 'miguel.silva@example.com', 'BE54321098', 'Avenida Benguela, nº 7071, Benguela'),
('Daniela Fernandes', 'daniela.fernandes@example.com', 'LS01234567', 'Rua Lunda Sul, nº 7273, Lunda Sul'),
('Joana Pereira', 'joana.pereira@example.com', 'ZA65432109', 'Rua Zaire, nº 7475, Zaire'),
('Rúben Oliveira', 'ruben.oliveira@example.com', 'BE12345678', 'Avenida Benguela, nº 7677, Benguela'),
('Andreia Costa', 'andreia.costa@example.com', 'MB76543210', 'Rua Menongue, nº 7879, Moxico'),
('Pedro Santos', 'pedro.santos@example.com', 'UI23456789', 'Avenida Uíge, nº 8081, Uíge'),
('Mariana Almeida', 'mariana.almeida@example.com', 'BE87654321', 'Avenida Benguela, nº 8283, Benguela'),
('Rui Rodrigues', 'rui.rodrigues@example.com', 'ML34567890', 'Rua Malanje, nº 8485, Malanje'),
('Cátia Pereira', 'catia.pereira@example.com', 'BE98765432', 'Avenida Benguela, nº 8687, Benguela'),
('Ricardo Fernandes', 'ricardo.fernandes@example.com', 'LS45678901', 'Rua Lunda Sul, nº 8889, Lunda Sul'),
('Carolina Almeida', 'carolina.almeida@example.com', 'HUI10987654', 'Avenida Huíla, nº 9091, Huíla'),
('Paula Rodrigues', 'paula.rodrigues@example.com', 'CC56789012', 'Bairro Comandante Cowboy, nº 9293, Cuando Cubango'),
('Rita Costa', 'rita.costa@example.com', 'BE21098765', 'Avenida Benguela, nº 9495, Benguela'),
('Vasco Fernandes', 'vasco.fernandes@example.com', 'ML67890123', 'Rua Malanje, nº 9697, Malanje'),
('Ana Santos', 'ana.santos@example.com', 'BE32109876', 'Avenida Benguela, nº 9899, Benguela'),
('Marta Silva', 'marta.silva@example.com', 'LL78901234', 'Rua Lunda Norte, nº 100101, Lunda Norte');

SELECT * FROM Clientes;

INSERT INTO Pedidos (id_cliente, data_pedido, status_) 
VALUES 
    (1, '2024-05-01', 'Pendente'),
    (2, '2024-05-02', 'Em andamento'),
    (3, '2024-05-03', 'Pendente'),
    (4, '2024-05-04', 'Entregue'),
    (5, '2024-05-05', 'Cancelado'),
    (6, '2024-05-06', 'Pendente'),
    (7, '2024-05-07', 'Em andamento'),
    (8, '2024-05-08', 'Pendente'),
    (9, '2024-05-09', 'Entregue'),
    (10, '2024-05-10', 'Pendente'),
    (11, '2024-05-11', 'Cancelado'),
    (12, '2024-05-12', 'Em andamento'),
    (13, '2024-05-13', 'Pendente'),
    (14, '2024-05-14', 'Entregue'),
    (15, '2024-05-15', 'Pendente'),
    (16, '2024-05-16', 'Em andamento'),
    (17, '2024-05-17', 'Pendente'),
    (18, '2024-05-18', 'Cancelado'),
    (19, '2024-05-19', 'Entregue'),
    (20, '2024-05-20', 'Pendente'),
    (21, '2024-05-21', 'Em andamento'),
    (22, '2024-05-22', 'Pendente'),
    (23, '2024-05-23', 'Cancelado'),
    (24, '2024-05-24', 'Entregue'),
    (25, '2024-05-25', 'Pendente'),
    (26, '2024-05-26', 'Em andamento'),
    (27, '2024-05-27', 'Pendente'),
    (28, '2024-05-28', 'Cancelado'),
    (29, '2024-05-29', 'Entregue'),
    (30, '2024-05-30', 'Pendente'),
    (31, '2024-05-31', 'Em andamento'),
    (32, '2024-06-01', 'Pendente'),
    (33, '2024-06-02', 'Cancelado'),
    (34, '2024-06-03', 'Entregue'),
    (35, '2024-06-04', 'Pendente'),
    (36, '2024-06-05', 'Em andamento'),
    (37, '2024-06-06', 'Pendente'),
    (38, '2024-06-07', 'Cancelado'),
    (39, '2024-06-08', 'Entregue'),
    (40, '2024-06-09', 'Pendente'),
    (41, '2024-06-10', 'Em andamento'),
    (42, '2024-06-11', 'Pendente'),
    (43, '2024-06-12', 'Cancelado'),
    (44, '2024-06-13', 'Entregue'),
    (45, '2024-06-14', 'Pendente'),
    (46, '2024-06-15', 'Em andamento'),
    (47, '2024-06-16', 'Pendente'),
    (48, '2024-06-17', 'Cancelado'),
    (49, '2024-06-18', 'Entregue'),
    (50, '2024-06-19', 'Pendente');

SELECT * FROM Pedidos;

INSERT INTO Itens_Pedidos (id_pedido, id_produto, quantidade, preco_unitario) 
VALUES 
    (1, 1, 2, 10.50),
    (1, 2, 1, 15.75),
    (2, 3, 3, 8.99),
    (2, 4, 2, 20.00),
    (3, 1, 1, 10.50),
    (3, 5, 4, 5.25),
    (4, 2, 2, 15.75),
    (4, 3, 1, 8.99),
    (5, 4, 3, 20.00),
    (5, 5, 2, 5.25),
    (6, 1, 2, 10.50),
    (6, 2, 1, 15.75),
    (7, 3, 3, 8.99),
    (7, 4, 2, 20.00),
    (8, 1, 1, 10.50),
    (8, 5, 4, 5.25),
    (9, 2, 2, 15.75),
    (9, 3, 1, 8.99),
    (10, 4, 3, 20.00),
    (10, 5, 2, 5.25),
    (11, 1, 2, 10.50),
    (11, 2, 1, 15.75),
    (12, 3, 3, 8.99),
    (12, 4, 2, 20.00),
    (13, 1, 1, 10.50),
    (13, 5, 4, 5.25),
    (14, 2, 2, 15.75),
    (14, 3, 1, 8.99),
    (15, 4, 3, 20.00),
    (15, 5, 2, 5.25),
    (16, 1, 2, 10.50),
    (16, 2, 1, 15.75),
    (17, 3, 3, 8.99),
    (17, 4, 2, 20.00),
    (18, 1, 1, 10.50),
    (18, 5, 4, 5.25),
    (19, 2, 2, 15.75),
    (19, 3, 1, 8.99),
    (20, 4, 3, 20.00),
    (20, 5, 2, 5.25),
    (21, 1, 2, 10.50),
    (21, 2, 1, 15.75),
    (22, 3, 3, 8.99),
    (22, 4, 2, 20.00),
    (23, 1, 1, 10.50),
    (23, 5, 4, 5.25),
    (24, 2, 2, 15.75),
    (24, 3, 1, 8.99),
    (25, 4, 3, 20.00),
    (25, 5, 2, 5.25);
    
    SELECT * FROM Itens_Pedidos;
    
    #CONSULTAS SQL
    #2-a
    











