CREATE DATABASE IF NOT EXISTS exerc1;
USE exerc1;

CREATE TABLE IF NOT EXISTS Carro(
	matricula VARCHAR(11 ) PRIMARY KEY,
    marca VARCHAR (10) NOT NULL,
    modelo VARCHAR(10) NOT NULL,
    cor VARCHAR (10) NOT NULL,
    cilindrada INT NOT NULL
);

SELECT * FROM Carro;

INSERT INTO Carro
VALUES( "LD-02-88-BC","Toyota","Rav4","Preto",12);

INSERT INTO Carro
VALUES( "LD-20-13-BC","Toyota","Rav4","Preto",12);

UPDATE Carro
SET cor="Rosa"
WHERE matricula = "LD-02-88-BC";

INSERT INTO Carro
VALUES( "BG-06-07-DC","Toyota","Rav4","Azul",12);

DELETE FROM Carro
WHERE matricula = "BG-06-07-DC";

#SELECT COUNT(*) FROM Carro;