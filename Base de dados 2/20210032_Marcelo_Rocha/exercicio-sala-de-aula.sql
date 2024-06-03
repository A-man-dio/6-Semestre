create database if not exists Loja_da_Quetura;

CREATE TABLE IF NOT EXISTS Produtos (
    id_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    descricao TEXT,
    preco DECIMAL(10 , 2 ),
    categoria VARCHAR(50),
    estoque INT
);

CREATE TABLE IF NOT EXISTS Clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255),
    BI VARCHAR(14),
    endereco VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Pedidos (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    data_pedido DATE,
    status_ VARCHAR(50),
    FOREIGN KEY (id_cliente)
        REFERENCES Clientes (id_cliente)
);

CREATE TABLE IF NOT EXISTS Itens_Pedido (
    id_item_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT,
    id_produto INT,
    quantidade INT,
    preco_unitario DECIMAL(10 , 2 ),
    FOREIGN KEY (id_pedido)
        REFERENCES pedidos (id_pedido),
    FOREIGN KEY (id_produto)
        REFERENCES produtos (id_produto)
);

INSERT INTO Produtos (nome, descricao, preco, categoria, estoque) VALUES
('Smartphone Samsung Galaxy S21', 'Smartphone Samsung Galaxy S21 256GB 5G Desbloqueado - Phantom Gray', 1299.99, 'Eletrônicos', 100),
('Notebook Dell Inspiron 15', 'Notebook Dell Inspiron 15, Intel Core i7, 16GB RAM, 512GB SSD, Tela 15.6", Windows 11', 1599.00, 'Eletrônicos', 80),
('Tênis Nike Air Max 270', 'Tênis Nike Air Max 270 Masculino - Preto/Vermelho', 399.90, 'Calçados', 200),
('Camiseta Polo Lacoste', 'Camiseta Polo Lacoste Masculina Slim Fit - Azul Marinho', 89.99, 'Moda', 150),
('Smart TV LG 55"', 'Smart TV LG 55" 4K UHD HDR AI ThinQ Smart TV - 55UN731C', 999.00, 'Eletrônicos', 70),
('Fone de Ouvido Apple AirPods Pro', 'Fone de Ouvido Apple AirPods Pro com Estojo de Recarga', 279.00, 'Eletrônicos', 120),
('Relógio Casio G-Shock', 'Relógio Casio G-Shock GA-2100-1ADR - Preto', 299.99, 'Acessórios', 100),
('Bolsa Feminina Guess', 'Bolsa Feminina Guess com Alça de Ombro - Rosa', 149.50, 'Moda', 90),
('Câmera DSLR Canon EOS Rebel T7', 'Câmera DSLR Canon EOS Rebel T7 24.1MP, Full HD, Wi-Fi', 549.00, 'Fotografia', 50),
('Mochila Executiva Swissgear', 'Mochila Executiva Swissgear Wenger Legacy para Notebook até 15.6"', 79.90, 'Acessórios', 180),
('Console PlayStation 5', 'Console PlayStation 5 com Leitor de Blu-Ray', 499.99, 'Games', 30),
('Jogo Cyberpunk 2077', 'Jogo Cyberpunk 2077 para PlayStation 4', 39.90, 'Games', 200),
('Cadeira Gamer DXRacer', 'Cadeira Gamer DXRacer Racing Series, Preto/Vermelho', 299.00, 'Móveis', 100),
('Panela de Pressão Elétrica Electrolux', 'Panela de Pressão Elétrica Electrolux 5L', 199.99, 'Eletrodomésticos', 150),
('Sapato Social Ferracini', 'Sapato Social Ferracini Masculino em Couro Legítimo - Preto', 159.90, 'Calçados', 120),
('Máquina de Café Nespresso', 'Máquina de Café Nespresso Inissia', 199.00, 'Eletrodomésticos', 80),
('Óculos de Sol Ray-Ban Aviador', 'Óculos de Sol Ray-Ban Aviador Unissex - Preto', 149.99, 'Acessórios', 100),
('Perfume Carolina Herrera 212 VIP', 'Perfume Carolina Herrera 212 VIP Feminino Eau de Parfum 80ml', 299.00, 'Beleza', 200),
('Monitor Gamer Samsung Odyssey', 'Monitor Gamer Samsung Odyssey G3 LC27G35TQWLXZD 27" Curvo, Full HD, 165Hz', 349.99, 'Eletrônicos', 80),
('Cadeira de Escritório Ergonômica', 'Cadeira de Escritório Ergonômica com Encosto de Cabeça - Preta', 199.00, 'Móveis', 100),
('Mala de Viagem Swisswin', 'Mala de Viagem Swisswin Trolley ABS, 20", Preta', 69.90, 'Viagem', 150),
('Tênis Adidas Ultraboost', 'Tênis Adidas Ultraboost Masculino - Branco/Cinza', 179.99, 'Calçados', 120),
('Câmera GoPro Hero 10 Black', 'Câmera GoPro Hero 10 Black 5.3K, 23MP, Wi-Fi, Bluetooth', 499.00, 'Fotografia', 50),
('Mochila Escolar Sestini', 'Mochila Escolar Sestini Swissgear com Rodinhas - Rosa', 59.99, 'Moda', 180),
('Fritadeira Elétrica Air Fryer Philips Walita', 'Fritadeira Elétrica Air Fryer Philips Walita Viva Collection 2.2L', 299.00, 'Eletrodomésticos', 100),
('Jaqueta Corta-Vento Adidas', 'Jaqueta Corta-Vento Adidas Masculina - Azul Marinho', 79.90, 'Moda', 150),
('Ventilador de Teto Spirit', 'Ventilador de Teto Spirit Wind 203 Branco', 249.99, 'Eletrodomésticos', 90),
('Máquina de Lavar Consul', 'Máquina de Lavar Consul 11kg, 16 Programas de Lavagem', 899.00, 'Eletrodomésticos', 70),
('Sofá Retrátil e Reclinável', 'Sofá Retrátil e Reclinável 3 Lugares Suede Amassado - Marrom', 1399.00, 'Móveis', 50),
('Chapinha Taiff', 'Chapinha Taiff Supermini Bivolt', 89.90, 'Beleza', 120),
('Micro-ondas Electrolux', 'Micro-ondas Electrolux 20L, 700W, 220V', 299.00, 'Eletrodomésticos', 100),
('Fogão 4 Bocas Consul', 'Fogão 4 Bocas Consul CFO4VATUNA, Acendimento Automático', 599.00, 'Eletrodomésticos', 80),
('Secador de Cabelo Gama Italy', 'Secador de Cabelo Gama Italy Eleganza 2200W', 129.90, 'Beleza', 150),
('Mochila Notebook Lenovo', 'Mochila Notebook Lenovo B510 15.6" Preta', 49.99, 'Acessórios', 200),
('Escova de Dentes Elétrica Oral-B', 'Escova de Dentes Elétrica Oral-B Professional Care 1000', 129.00, 'Higiene', 100),
('Caixa de Som JBL Charge 5', 'Caixa de Som JBL Charge 5 Bluetooth, 20 Horas de Bateria, À Prova D’Água', 299.99, 'Eletrônicos', 70),
('Fone de Ouvido JBL TUNE 500BT', 'Fone de Ouvido JBL TUNE 500BT Bluetooth', 79.99, 'Eletrônicos', 120),
('Churrasqueira Elétrica Britânia', 'Churrasqueira Elétrica Britânia CGB2 N2, 220V', 129.00, 'Eletrodomésticos', 100),
('Mala de Viagem Polo King', 'Mala de Viagem Polo King ABS 20" Preta', 89.90, 'Viagem', 150),
('Sapato Feminino Vizzano', 'Sapato Feminino Vizzano em Couro Sintético - Nude', 59.99, 'Calçados', 120),
('Perfume Masculino Ferrari Black', 'Perfume Masculino Ferrari Black Eau de Toilette 125ml', 79.90, 'Beleza', 200),
('Monitor LG 27"', 'Monitor LG 27" LED Full HD 27MK400H-B.AWZ', 199.00, 'Eletrônicos', 80),
('Cadeira de Praia Mor', 'Cadeira de Praia Mor Reclinável em 8 Posições - Azul', 49.99, 'Lazer', 100),
('Fralda Huggies Turma da Mônica', 'Fralda Huggies Turma da Mônica Supreme Care Tam. M - 80 Unidades', 79.90, 'Bebês', 200),
('Brinquedo Lego Classic', 'Brinquedo Lego Classic Caixa de Peças - 1500 Peças', 59.90, 'Brinquedos', 80),
('Sunga Masculina Adidas', 'Sunga Masculina Adidas 3S Preta', 39.90, 'Moda Praia', 150),
('Bicicleta Caloi', 'Bicicleta Caloi Ceci Aro 26, 18 Marchas, Suspensão Dianteira - Rosa', 499.00, 'Esporte', 90),
('Geladeira Consul', 'Geladeira Consul Frost Free Duplex 340L, Branca', 1999.00, 'Eletrodomésticos', 100),
('Escova de Cabelo Tangle Teezer', 'Escova de Cabelo Tangle Teezer Compact Styler - Pink Kitty', 29.90, 'Beleza', 120),
('Creme Facial Nivea', 'Creme Facial Nivea Hidratante para Pele Seca - 100ml', 19.99, 'Beleza', 100),
('Livro "A Garota no Trem"', 'Livro "A Garota no Trem" de Paula Hawkins', 34.90, 'Livros', 150),
('Relógio Feminino Swatch', 'Relógio Feminino Swatch Skin Skinchic Rose Gold', 129.00, 'Acessórios', 80),
('Mesa de Jantar 6 Lugares', 'Mesa de Jantar 6 Lugares Tampo de Vidro - Canela/Off-White', 599.00, 'Móveis', 100);



INSERT INTO Clientes (nome, email, BI, endereco) VALUES
('Ana Costa', 'ana.costa@email.com', '54321098765432', 'Rua das Árvores, 321'),
('José Pereira', 'jose.pereira@email.com', '21098765432109', 'Avenida Central, 654'),
('Mariana Fernandes', 'mariana.fernandes@email.com', '54321098765432', 'Rua da Praia, 987'),
('Carlos Rodrigues', 'carlos.rodrigues@email.com', '67890123456789', 'Avenida dos Girassóis, 234'),
('Sofia Almeida', 'sofia.almeida@email.com', '78901234567890', 'Rua das Pedras, 567'),
('Rui Santos', 'rui.santos@email.com', '89012345678901', 'Avenida das Palmeiras, 890'),
('Diana Marques', 'diana.marques@email.com', '10987654321098', 'Rua das Margaridas, 1234'),
('Tiago Costa', 'tiago.costa@email.com', '98765432109876', 'Avenida das Tulipas, 5678'),
('Inês Oliveira', 'ines.oliveira@email.com', '76543210987654', 'Rua do Mar, 9012'),
('Ricardo Pereira', 'ricardo.pereira@email.com', '65432109876543', 'Avenida dos Coqueiros, 3456'),
('Patrícia Silva', 'patricia.silva@email.com', '54321098765432', 'Rua das Violetas, 7890'),
('Hugo Ferreira', 'hugo.ferreira@email.com', '43210987654321', 'Avenida dos Pinheiros, 2345'),
('Catarina Sousa', 'catarina.sousa@email.com', '32109876543210', 'Rua dos Lírios, 6789'),
('Paulo Martins', 'paulo.martins@email.com', '21098765432109', 'Avenida das Rosas, 12345'),
('Carla Costa', 'carla.costa@email.com', '09876543210987', 'Rua dos Cravos, 67890'),
('André Santos', 'andre.santos@email.com', '98765432109876', 'Avenida dos Jardins, 123456'),
('Lúcia Oliveira', 'lucia.oliveira@email.com', '87654321098765', 'Rua dos Oceanos, 234567'),
('Miguel Fernandes', 'miguel.fernandes@email.com', '76543210987654', 'Avenida das Águias, 345678'),
('Beatriz Marques', 'beatriz.marques@email.com', '65432109876543', 'Rua das Gaivotas, 456789'),
('António Pereira', 'antonio.pereira@email.com', '54321098765432', 'Avenida das Cerejeiras, 567890'),
('Diana Almeida', 'diana.almeida@email.com', '43210987654321', 'Rua dos Castanheiros, 1234567'),
('José Silva', 'jose.silva@email.com', '32109876543210', 'Avenida das Hortênsias, 2345678'),
('Sara Costa', 'sara.costa@email.com', '10987654321098', 'Rua das Orquídeas, 3456789'),
('Ricardo Fernandes', 'ricardo.fernandes@email.com', '09876543210987', 'Avenida das Amendoeiras, 4567890'),
('Inês Santos', 'ines.santos@email.com', '98765432109876', 'Rua dos Louros, 5678901'),
('Hugo Oliveira', 'hugo.oliveira@email.com', '87654321098765', 'Avenida das Figueiras, 6789012'),
('Ana Martins', 'ana.martins@email.com', '76543210987654', 'Rua das Oliveiras, 7890123'),
('João Sousa', 'joao.sousa@email.com', '65432109876543', 'Avenida das Acácias, 8901234'),
('Marta Ferreira', 'marta.ferreira@email.com', '54321098765432', 'Rua das Papoilas, 9012345'),
('André Costa', 'andre.costa@email.com', '43210987654321', 'Avenida das Açucenas, 12345678'),
('Carolina Rodrigues', 'carolina.rodrigues@email.com', '32109876543210', 'Rua dos Narcisos, 23456789'),
('Bruno Marques', 'bruno.marques@email.com', '10987654321098', 'Avenida das Dálias, 34567890'),
('Patrícia Almeida', 'patricia.almeida@email.com', '09876543210987', 'Rua dos Crisântemos, 45678901'),
('Diogo Oliveira', 'diogo.oliveira@email.com', '98765432109876', 'Avenida das Glicínias, 56789012'),
('Ana Sousa', 'ana.sousa@email.com', '87654321098765', 'Rua dos Jasmins, 67890123'),
('Ricardo Costa', 'ricardo.costa@email.com', '76543210987654', 'Avenida das Margaridas, 78901234'),
('Marta Silva', 'marta.silva@email.com', '65432109876543', 'Rua das Hortênsias, 89012345'),
('João Ferreira', 'joao.ferreira@email.com', '54321098765432', 'Avenida das Orquídeas, 90123456'),
('Sofia Santos', 'sofia.santos@email.com', '43210987654321', 'Rua das Begônias, 123456789'),
('Daniel Rodrigues', 'daniel.rodrigues@email.com', '32109876543210', 'Avenida das Camélias, 234567890'),
('Miguel Almeida', 'miguel.almeida@email.com', '10987654321098', 'Rua das Violetas, 345678901'),
('Catarina Costa', 'catarina.costa@email.com', '09876543210987', 'Avenida das Hortênsias, 456789012'),
('Gonçalo Martins', 'goncalo.martins@email.com', '98765432109876', 'Rua das Margaridas, 567890123');


INSERT INTO Clientes (nome, email, BI, endereco) VALUES
('João Silva', 'joao@example.com', '12345678901234', 'Rua A, nº 123'),
('Maria Santos', 'maria@example.com', '98765432109876', 'Avenida B, nº 456'),
('Pedro Oliveira', 'pedro@example.com', '56789012345678', 'Rua C, nº 789'),
('Ana Costa', 'ana@example.com', '34567890123456', 'Rua D, nº 1011'),
('Carlos Pereira', 'carlos@example.com', '90123456789012', 'Avenida E, nº 1213'),
('Mariana Ferreira', 'mariana@example.com', '67890123456789', 'Rua F, nº 1415'),
('José Santos', 'jose@example.com', '23456789012345', 'Rua G, nº 1617'),
('Paula Martins', 'paula@example.com', '89012345678901', 'Avenida H, nº 1819'),
('Fernando Silva', 'fernando@example.com', '45678901234567', 'Rua I, nº 2021'),
('Sandra Almeida', 'sandra@example.com', '01234567890123', 'Rua J, nº 2223'),
('Rui Sousa', 'rui@example.com', '78901234567890', 'Avenida K, nº 2425'),
('Lúcia Gonçalves', 'lucia@example.com', '56789012345678', 'Rua L, nº 2627'),
('André Oliveira', 'andre@example.com', '90123456789012', 'Rua M, nº 2829'),
('Inês Pereira', 'ines@example.com', '67890123456789', 'Avenida N, nº 3031'),
('Jorge Fernandes', 'jorge@example.com', '23456789012345', 'Rua O, nº 3233'),
('Cátia Silva', 'catia@example.com', '89012345678901', 'Avenida P, nº 3435'),
('Hugo Santos', 'hugo@example.com', '45678901234567', 'Rua Q, nº 3637'),
('Teresa Martins', 'teresa@example.com', '01234567890123', 'Avenida R, nº 3839'),
('Miguel Ferreira', 'miguel@example.com', '78901234567890', 'Rua S, nº 4041'),
('Carla Sousa', 'carla@example.com', '56789012345678', 'Avenida T, nº 4243'),
('Ricardo Gonçalves', 'ricardo@example.com', '90123456789012', 'Rua U, nº 4445'),
('Catarina Oliveira', 'catarina@example.com', '67890123456789', 'Avenida V, nº 4647'),
('David Almeida', 'david@example.com', '23456789012345', 'Rua W, nº 4849'),
('Sofia Sousa', 'sofia@example.com', '89012345678901', 'Avenida X, nº 5051'),
('Júlio Fernandes', 'julio@example.com', '45678901234567', 'Rua Y, nº 5253'),
('Raquel Silva', 'raquel@example.com', '01234567890123', 'Avenida Z, nº 5455'),
('Andréa Martins', 'andrea@example.com', '78901234567890', 'Rua AA, nº 5657'),
('Ricardo Gonçalves', 'ricardo@example.com', '56789012345678', 'Avenida BB, nº 5859'),
('Cátia Pereira', 'catia@example.com', '90123456789012', 'Rua CC, nº 6061'),
('José Oliveira', 'jose@example.com', '67890123456789', 'Avenida DD, nº 6263'),
('Mariana Almeida', 'mariana@example.com', '23456789012345', 'Rua EE, nº 6465'),
('Pedro Martins', 'pedro@example.com', '89012345678901', 'Avenida FF, nº 6667'),
('Ana Santos', 'ana@example.com', '45678901234567', 'Rua GG, nº 6869'),
('Paulo Fernandes', 'paulo@example.com', '01234567890123', 'Avenida HH, nº 7071'),
('Inês Oliveira', 'ines@example.com', '78901234567890', 'Rua II, nº 7273'),
('Miguel Pereira', 'miguel@example.com', '56789012345678', 'Avenida JJ, nº 7475'),
('Sara Gonçalves', 'sara@example.com', '90123456789012', 'Rua KK, nº 7677'),
('Rui Almeida', 'rui@example.com', '67890123456789', 'Avenida LL, nº 7881'),
('Tânia Fernandes', 'tania@example.com', '23456789012345', 'Rua MM, nº 8083'),
('Fábio Santos', 'fabio@example.com', '89012345678901', 'Avenida NN, nº 8285'),
('Carla Oliveira', 'carla@example.com', '45678901234567', 'Rua OO, nº 8487'),
('Hugo Martins', 'hugo@example.com', '01234567890123', 'Avenida PP, nº 8689'),
('Vânia Almeida', 'vania@example.com', '78901234567890', 'Rua QQ, nº 8891'),
('Ricardo Silva', 'ricardo@example.com', '56789012345678', 'Avenida RR, nº 9093'),
('Andreia Fernandes', 'andreia@example.com', '90123456789012', 'Rua SS, nº 9295'),
('Gustavo Santos', 'gustavo@example.com', '67890123456789', 'Avenida TT, nº 9497'),
('Carolina Sousa', 'carolina@example.com', '23456789012345', 'Rua UU, nº 9699'),
('Bruno Oliveira', 'bruno@example.com', '89012345678901', 'Avenida VV, nº 98101'),
('Rita Pereira', 'rita@example.com', '12345678901234', 'Rua XX, nº 102103'),
('Manuel Santos', 'manuel@example.com', '98765432109876', 'Avenida YY, nº 104105'),
('Andreia Costa', 'andreia@example.com', '56789012345678', 'Rua ZZ, nº 106107'),
('Patrícia Almeida', 'patricia@example.com', '45678901234567', 'Rua WW, nº 100101');


INSERT INTO Pedidos (id_pedido, id_cliente, data_pedido, status_) VALUES
(1, 24, '2024-05-16', 'Pendente'),
(2, 18, '2024-05-15', 'Concluído'),
(3, 11, '2024-05-14', 'Pendente'),
(4, 5, '2024-05-13', 'Em andamento'),
(5, 39, '2024-05-12', 'Concluído'),
(6, 35, '2024-05-11', 'Pendente'),
(7, 48, '2024-05-10', 'Concluído'),
(8, 22, '2024-05-09', 'Pendente'),
(9, 28, '2024-05-08', 'Em andamento'),
(10, 15, '2024-05-07', 'Concluído'),
(11, 2, '2024-05-06', 'Pendente'),
(12, 44, '2024-05-05', 'Em andamento'),
(13, 43, '2024-05-04', 'Concluído'),
(14, 30, '2024-05-03', 'Pendente'),
(15, 49, '2024-05-02', 'Concluído'),
(16, 12, '2024-05-01', 'Pendente'),
(17, 33, '2024-04-30', 'Em andamento'),
(18, 40, '2024-04-29', 'Concluído'),
(19, 50, '2024-04-28', 'Pendente'),
(20, 23, '2024-04-27', 'Concluído'),
(21, 31, '2024-04-26', 'Pendente'),
(22, 3, '2024-04-25', 'Em andamento'),
(23, 25, '2024-04-24', 'Concluído'),
(24, 4, '2024-04-23', 'Pendente'),
(25, 7, '2024-04-22', 'Concluído'),
(26, 21, '2024-04-21', 'Pendente'),
(27, 38, '2024-04-20', 'Em andamento'),
(28, 29, '2024-04-19', 'Concluído'),
(29, 9, '2024-04-18', 'Pendente'),
(30, 36, '2024-04-17', 'Concluído'),
(31, 42, '2024-04-16', 'Pendente'),
(32, 17, '2024-04-15', 'Em andamento'),
(33, 6, '2024-04-14', 'Concluído'),
(34, 47, '2024-04-13', 'Pendente'),
(35, 20, '2024-04-12', 'Concluído'),
(36, 26, '2024-04-11', 'Pendente'),
(37, 46, '2024-04-10', 'Em andamento'),
(38, 32, '2024-04-09', 'Concluído'),
(39, 8, '2024-04-08', 'Pendente'),
(40, 34, '2024-04-07', 'Concluído'),
(41, 16, '2024-04-06', 'Pendente'),
(42, 45, '2024-04-05', 'Em andamento'),
(43, 13, '2024-04-04', 'Concluído'),
(44, 41, '2024-04-03', 'Pendente'),
(45, 27, '2024-04-02', 'Concluído'),
(46, 19, '2024-04-01', 'Pendente'),
(47, 1, '2024-03-31', 'Em andamento'),
(48, 37, '2024-03-30', 'Concluído'),
(49, 10, '2024-03-29', 'Pendente'),
(50, 14, '2024-03-28', 'Concluído');

INSERT INTO Itens_Pedido (id_item_pedido, id_pedido, id_produto, quantidade, preco_unitario) VALUES
(1, 23, 34, 3, 10.50),
(2, 37, 22, 2, 15.25),
(3, 10, 15, 1, 20.00),
(4, 42, 48, 4, 8.75),
(5, 18, 5, 2, 12.50),
(6, 27, 50, 3, 18.00),
(7, 30, 29, 1, 25.50),
(8, 14, 2, 5, 9.75),
(9, 6, 39, 2, 14.25),
(10, 43, 33, 3, 21.00),
(11, 3, 47, 4, 7.50),
(12, 12, 44, 2, 13.25),
(13, 47, 27, 1, 22.00),
(14, 22, 14, 3, 17.75),
(15, 32, 24, 2, 11.50),
(16, 41, 8, 4, 6.75),
(17, 9, 17, 2, 10.50),
(18, 21, 46, 3, 15.25),
(19, 36, 49, 1, 20.00),
(20, 1, 43, 4, 8.75),
(21, 46, 16, 2, 12.50),
(22, 49, 18, 3, 18.00),
(23, 48, 13, 1, 25.50),
(24, 33, 19, 5, 9.75),
(25, 13, 31, 2, 14.25),
(26, 20, 26, 3, 21.00),
(27, 24, 25, 4, 7.50),
(28, 38, 4, 2, 13.25),
(29, 2, 45, 1, 22.00),
(30, 11, 28, 3, 17.75),
(31, 28, 3, 2, 11.50),
(32, 35, 42, 4, 6.75),
(33, 15, 32, 2, 10.50),
(34, 25, 40, 3, 15.25),
(35, 16, 11, 1, 20.00),
(36, 26, 21, 4, 8.75),
(37, 5, 38, 2, 12.50),
(38, 50, 1, 3, 18.00),
(39, 44, 12, 1, 25.50),
(40, 45, 35, 5, 9.75),
(41, 8, 30, 2, 14.25),
(42, 19, 37, 3, 21.00),
(43, 29, 10, 4, 7.50),
(44, 4, 9, 2, 13.25),
(45, 17, 41, 1, 22.00),
(46, 40, 20, 3, 17.75),
(47, 39, 7, 2, 11.50),
(48, 7, 23, 4, 6.75),
(49, 31, 36, 2, 10.50),
(50, 34, 6, 3, 15.25);

select * from itens_pedido;

select * from produtos where estoque < 100;
select * from produtos;

select nome , preco from produtos where categoria = "Eletrônicos";

select * from produtos order by preco desc limit 5;




























