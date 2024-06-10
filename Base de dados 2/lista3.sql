CREATE DATABASE IF NOT EXISTS Complexo_Rita;
CREATE DATABASE IF NOT EXISTS Complexo_Rita;

USE Complexo_Rita;
USE Complexo_rita;

CREATE TABLE Estudantes(
 id_estudante INT PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(100),
 data_nascimento DATE,
 email VARCHAR(100)
);
create table estudantes(
id_estudante int primary key auto_increment,
nome varchar(100),
data_nascimento date,
email varchar (100),
foreign key (nome) references Cursos(nome_curso)
);

CREATE TABLE estudantes(
  id_estudante int primary key auto_increment
);

CREATE TABLE Cursos(
	id_curso INT PRIMARY KEY AUTO_INCREMENT, 
    nome_curso VARCHAR(100),
	duracao INT -- duração em meses
);

CREATE TABLE Professores(
	id_professor INT PRIMARY KEY AUTO_INCREMENT,
    nome_professor VARCHAR(100),
    email_professor VARCHAR(100)
);

CREATE TABLE Disciplinas(
id_disciplina INT PRIMARY KEY AUTO_INCREMENT,
nome_disciplina VARCHAR(100),
id_curso INT,
id_professor INT,
FOREIGN KEY (id_professor) REFERENCES Professores(id_professor),
FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

 CREATE TABLE Matriculas(
 id_matricula INT PRIMARY KEY AUTO_INCREMENT,
 id_estudante INT,
 FOREIGN KEY (id_estudante) REFERENCES Estudantes(id_estudante),
 id_disciplina INT,
 FOREIGN KEY (id_disciplina) REFERENCES Disciplinas(id_disciplina),
 data_matricula DATE
);

CREATE TABLE Avaliacoes(
 id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
 id_matricula INT,
 FOREIGN KEY (id_matricula) REFERENCES Matriculas(id_matricula),
 nota DECIMAL(5,2),
 data_avaliacao DATE
);

show create table Avaliacoes;
CREATE TABLE Departamentos(
 id_departamento INT PRIMARY KEY AUTO_INCREMENT,
 nome_departamento VARCHAR(100),
 id_professor INT,
 FOREIGN KEY (id_professor) REFERENCES Professores(id_professor),
 nota DECIMAL(5,2),
 data_avaliacao DATE
);

INSERT INTO Estudantes (nome, data_nascimento, email) VALUES
    ('Pedro André', '2002-01-12', 'pedro@gmail.com'),
    ('Lucas André', '2002-05-12', 'lucas@sapo.co.pt'),
    ('André Yanga', '2000-09-10', 'andre@gmail.com'),
    ('Samuel Pedro', '2002-07-24', 'samuel@gmail.com'),
    ('Lucas André', '2005-04-22', 'lucas@gmail.com'),
    ('Joana Silva', '2001-03-15', 'joana@gmail.com'),
    ('Carla Mendes', '2003-11-30', 'carla@gmail.com'),
    ('Miguel Santos', '2001-06-07', 'miguel@gmail.com'),
    ('Tiago Costa', '1999-12-25', 'tiago@gmail.com'),
    ('Ana Clara', '2004-08-18', 'ana@gmail.com'),
    ('Beatriz Lima', '2000-04-22', 'beatriz@gmail.com'),
    ('Mariana Sousa', '2002-10-02', 'mariana@gmail.com'),
    ('Gabriel Martins', '2003-07-11', 'gabriel@gmail.com'),
    ('Laura Rocha', '2001-05-30', 'laura@gmail.com'),
    ('Ricardo Pinto', '2004-02-14', 'ricardo@gmail.com'),
    ('Sofia Almeida', '1998-11-05', 'sofia@gmail.com'),
    ('Rodrigo Azevedo', '2000-09-20', 'rodrigo@gmail.com'),
    ('Carolina Dias', '2003-03-10', 'carolina@gmail.com'),
    ('Matheus Gonçalves', '1999-12-03', 'matheus@gmail.com'),
    ('Juliana Barbosa', '2002-08-19', 'juliana@gmail.com'),
    ('Leonardo Fernandes', '2004-01-07', 'leonardo@gmail.com'),
    ('Vitória Ribeiro', '2001-09-21', 'vitoria@gmail.com'),
    ('Rafael Pereira', '2000-07-15', 'rafael@gmail.com'),
    ('Larissa Duarte', '2002-11-09', 'larissa@gmail.com'),
    ('Felipe Teixeira', '2003-06-27', 'felipe@gmail.com');

    insert into Cursos (nome_curso,duracao) values
		('Mecânica',12),
        ('Construção civil',14),
        ('Estomatologia',24),
        ('Informatica',20),
        ('Economia',13);
        
	INSERT INTO Professores (nome_professor, email_professor) VALUES
    ('Eduardo Augusto', 'eduaug@hotmail.com'),
    ('Mariana Lima', 'mariana.lima@hotmail.com'),
    ('Carlos Sousa', 'carlos.sousa@hotmail.com'),
    ('Ana Paula', 'ana.paula@hotmail.com'),
    ('Ricardo Martins', 'ricardo.martins@hotmail.com'),
    ('Luciana Silva', 'luciana.silva@hotmail.com'),
    ('Fernando Alves', 'fernando.alves@hotmail.com'),
    ('Patrícia Ferreira', 'patricia.ferreira@hotmail.com'),
    ('João Mendes', 'joao.mendes@hotmail.com'),
    ('Camila Rocha', 'camila.rocha@hotmail.com');
    
    INSERT INTO Disciplinas (nome_disciplina, id_curso, id_professor) VALUES
    ('Matemática', 1, 1),
    ('Física', 1, 2),
    ('Química', 1, 3),
    ('Biologia', 2, 1),
    ('História', 2, 2),
    ('Geografia', 2, 3),
    ('Literatura', 3, 1),
    ('Filosofia', 3, 2),
    ('Sociologia', 3, 3),
    ('Inglês', 4, 1),
    ('Espanhol', 4, 2),
    ('Francês', 4, 3),
    ('Educação Física', 5, 1),
    ('Artes', 5, 2),
    ('Música', 5, 3);

INSERT INTO Matriculas (id_estudante, id_disciplina, data_matricula) VALUES
    (1, 1, '2024-01-15'),
    (2, 2, '2024-01-16'),
    (3, 3, '2024-01-17'),
    (4, 4, '2024-01-18'),
    (5, 5, '2024-01-19'),
    (6, 1, '2024-01-20'),
    (7, 2, '2024-01-21'),
    (8, 3, '2024-01-22'),
    (9, 4, '2024-01-23'),
    (10, 5, '2024-01-24'),
    (11, 1, '2024-01-25'),
    (12, 2, '2024-01-26'),
    (13, 3, '2024-01-27'),
    (14, 4, '2024-01-28'),
    (15, 5, '2024-01-29'),
    (16, 1, '2024-01-30'),
    (17, 2, '2024-01-31'),
    (18, 3, '2024-02-01'),
    (19, 4, '2024-02-02'),
    (20, 5, '2024-02-03'),
    (21, 1, '2024-02-04'),
    (22, 2, '2024-02-05'),
    (23, 3, '2024-02-06'),
    (24, 4, '2024-02-07'),
    (25, 5, '2024-02-08');

INSERT INTO Avaliacoes (id_matricula, nota, data_avaliacao) VALUES
    (1, 85.5, '2024-02-01'),
    (2, 90.0, '2024-02-02'),
    (3, 78.5, '2024-02-03'),
    (4, 88.0, '2024-02-04'),
    (5, 92.5, '2024-02-05'),
    (6, 75.0, '2024-02-06'),
    (7, 89.0, '2024-02-07'),
    (8, 84.0, '2024-02-08'),
    (9, 91.5, '2024-02-09'),
    (10, 87.0, '2024-02-10'),
    (11, 76.5, '2024-02-11'),
    (12, 93.0, '2024-02-12'),
    (13, 80.5, '2024-02-13'),
    (14, 85.0, '2024-02-14'),
    (15, 88.5, '2024-02-15'),
    (16, 90.5, '2024-02-16'),
    (17, 82.0, '2024-02-17'),
    (18, 77.5, '2024-02-18'),
    (19, 89.5, '2024-02-19'),
    (20, 86.0, '2024-02-20'),
    (21, 78.0, '2024-02-21'),
    (22, 92.0, '2024-02-22'),
    (23, 83.5, '2024-02-23'),
    (24, 87.5, '2024-02-24'),
    (25, 79.0, '2024-02-25'),
    (5, 91.0, '2024-02-26'),
    (4, 80.0, '2024-02-27'),
    (3, 88.0, '2024-02-28'),
    (2, 85.0, '2024-02-29'),
    (1, 90.0, '2024-03-01');
    
    INSERT INTO Departamentos (nome_departamento, id_professor) VALUES
    ('Departamento de Ciências Exatas', 1),
    ('Departamento de Ciências Humanas', 2),
    ('Departamento de Linguagens e Códigos', 3),
    ('Departamento de Idiomas', 4),
    ('Departamento de Artes', 5);
    
    SELECT es.nome,dis.nome_disciplina from Estudantes as es 
    inner join Disciplinas as dis 
    inner join Matriculas as mat 
    on es.id_estudante = mat.id_estudante and dis.id_disciplina = mat.id_disciplina;
    
    
    
    SELECT pr.nome_professor, cur.nome_curso 
    from Professores as pr 
    inner join Cursos as cur 
    inner join Disciplinas as dis 
    on pr.id_professor = dis.id_professor and cur.id_curso = dis.id_curso;
    
    select upper(nome) from Estudantes;
    
    select concat(nome,' (',date_format(data_matricula,'%d-%m-%y'),')' )
    from Estudantes as es 
    inner join Matriculas as mat
    on es.id_estudante = mat.id_estudante;
    
    select cur.nome_curso, count(*)
    from Estudantes as es 
    inner join Matriculas as mat
    inner join Cursos as cur
    inner join Disciplinas as dis
    on es.id_estudante = mat.id_estudante and mat.id_disciplina = dis.id_disciplina and dis.id_curso = cur.id_curso 
    group by cur.nome_curso;
    
    select max(data_matricula) from Matriculas;
    
    select avg(nota), nome_disciplina 
    from Disciplinas as dis 
    inner join Avaliacoes as av 
    inner join Matriculas as mat
    on dis.id_disciplina = mat.id_disciplina 
    and av.id_matricula = mat.id_matricula 
    group by nome_disciplina;
    
	select * from Estudantes order by data_nascimento asc;

  select cur.nome_curso, count(*)
    from Estudantes as es 
    inner join Matriculas as mat
    inner join Cursos as cur
    inner join Disciplinas as dis
    on es.id_estudante = mat.id_estudante and mat.id_disciplina = dis.id_disciplina and dis.id_curso = cur.id_curso 
    group by cur.nome_curso limit 5;
    
    select nome from Estudantes where id_estudante = (select id_estudante from Matriculas group by count(id_disciplina) order by id_disciplina  limit 1);
    
    select * from cursos;
    
    update Cursos
    set nome_curso = 'Gestão'
    where id_curso = '3';
    
    select * from Estudantes;
    
    alter table Estudantes 
    add column telefone varchar(9) default '';
    
    alter table estudantes
    drop column telefone;
    
    insert into Estudantes (nome,data_nascimento,email) VALUES
    ('Eliane Watele','2002-05-25','elianeedna7@gmail.com');