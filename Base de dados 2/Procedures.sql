
/*
Procedimentos armazenados (Stored Procedures) são blocos de código SQL pré-compilados e armazenados no banco de dados. Eles encapsulam lógica complexa, melhorando a reusabilidade, segurança e performance das suas aplicações.
CALL
SELECT
CARACTERÍSTICAS
	Retorno de Valor: Podem retornar múltiplos valores através de parâmetros de saída (OUT ou INOUT) ou não retornar valor algum.
	Chamada: São chamados usando a instrução CALL (ex: CALL meu_procedimento(param1, param2)).
	Flexibilidade: Podem modificar dados (usar INSERT, UPDATE, DELETE)

Sintaxe de um Procedimento armazenado


	DELIMITER || 

	CREATE PROCEDURE nome_do_procedimento (parametros_de_IN_OUT_se_necessario)
	BEGIN
		-- Código SQL a ser executado;
        -- Código SQL a ser executado;
        -- Código SQL a ser executado;
	END ||

	DELIMITER ;  -- Restaura o delimitador padrão
*/










-- Exemplo 1: Criar um procedimento (saudacao) sem parâmetros que imprima a mensagem "Olá mundo!"

DELIMITER |

CREATE PROCEDURE saudacao()
BEGIN
	SELECT "Olá mundo!";
END |

DELIMITER ;

CALL saudacao();


-- Exemplo 2: Criar um procedimento (cumprimento) que recebe como parâmetro de entrada um nome com no máximo 50 caracteres e depois imprima a mensagem no seguinte formato: Olá, Emanuel Pacavira!

DELIMITER |

CREATE PROCEDURE cumprimento(IN nome VARCHAR(50))
BEGIN
	SELECT CONCAT("Olá ", nome) AS 'Cumprimento';
END |

DELIMITER ;


CALL cumprimento("Emanuel Pacavira");


-- Exemplo 3: Criar um procedimento (calcular_dobro) que recebe como parâmetro de entrada uma variável inteira (numero), e como parâmetro de saída outra variável inteira (dobro). No final calcule o dobro do número inserido e armazene o resultado na variável dobro... 

DELIMITER |

CREATE PROCEDURE calcular_dobro(IN numero INT, OUT dobro INT, OUT multiplicar INT)
BEGIN
	SET dobro = numero * 2;
    SET multiplicar = numero * 10;
END |

DELIMITER ;

CALL calcular_dobro(5, @result1, @result2);
SELECT @result2;

-- Exemplo 4: Criar um procedimento calcular_media, que recebe duas notas como parâmetro de entrada, armazene o resultado da soma em uma nova variável e "retorne" a média na variável média.

DELIMITER |

CREATE PROCEDURE media(IN nota1 DECIMAL(4, 2), IN nota2 DECIMAL(4, 2), OUT media DECIMAL(4,2))
BEGIN
	DECLARE soma DECIMAL(4, 2);
	SET soma = nota1 + nota2;
	SET media = soma/2;
END |

DELIMITER ;

CALL media(20, 10, @resultado);
SELECT @resultado;



-- Exemplo 5: Criar um procedimento (verificar_idade) que recebe como parametro de entrada a idade de uma pessoa e imprima a mensagem informado maior de idade ou menor de idade, tendo em conta a legislação vigente em Angola

DELIMITER |

CREATE PROCEDURE verificar_idade(IN idade INT)
BEGIN
	IF (idade >=18)THEN
		SELECT "MAIOR DE IDADE" AS Resposta;
    ELSE
		SELECT "MENOR DE IDADE" AS Resposta;
    END IF;
END |

DELIMITER ;









-- Exercício 1: Crie e popule o banco de dados a seguir com os dados fornecidos:

	CREATE DATABASE escola;
	USE escola;

	CREATE TABLE alunos (
		id INT PRIMARY KEY AUTO_INCREMENT,
		nome VARCHAR(100),
		idade INT,
		nota DECIMAL(5,2)
	);
	INSERT INTO alunos (nome, idade, nota) VALUES ('Alice', 15, 8.5),
												  ('Bob', 16, 7.0),
												  ('Carol', 17, 9.2),
												  ('David', 14, 6.8);
    INSERT INTO alunos (nome, idade, nota) VALUES ('Judson', 10, 10)



-- Exercício 2: Crie o procedimento verificar_aprovacao que recebe o ID de um aluno e imprima a mensagem 'Aprovado' se a nota for maior ou igual a 7, e 'Reprovado' caso contrário.

DELIMITER |
CREATE PROCEDURE verificar_aprovacao(IN ID INT)
BEGIN
	SELECT 
    CASE 
        WHEN nota >= '7' THEN 'Aprovado'
        WHEN nota < '7' THEN 'Reprovado'
        
    END AS 'Estado'
FROM 
    alunos
where alunos.ID = ID;
END |
DELIMITER ;
drop procedure verificar_aprovacao;

CALL verificar_aprovacao(4);


-- Exercício 3: Crie o procedimento calcular_media da turma, que calcula e mostre a média das notas de todos os alunos

DELIMITER |
CREATE PROCEDURE calcular_media()
BEGIN
	SELECT AVG(nota) AS 'Média das notas' FROM alunos;

END |
DELIMITER ;

drop procedure calcular_media;

CALL calcular_media();
    


-- Exercício 4: Crie o procedimento listar_alunos_aprovados  que lista os nomes e notas de todos os alunos aprovados.

DELIMITER |
CREATE PROCEDURE listar_alunos_aprovados()
BEGIN
	SELECT nome, nota
	FROM alunos
where nota > 7;
END |
DELIMITER ;
drop procedure listar_alunos_aprovados;

CALL listar_alunos_aprovados();



-- Exercíicio 5: Crie o procedimento atualizar_nota que recebe o ID de um aluno e uma nova nota, e atualiza a nota do aluno na tabela.

DELIMITER |
CREATE PROCEDURE atualizar_nota(IN ID INT, IN nNota FLOAT )
BEGIN
	update alunos
    set nota = nNota
    where alunos.ID =ID;
END |
DELIMITER ;
drop procedure atualizar_nota;

CALL atualizar_nota(1,4);

-- Exercício 6: Crie o procedimento remover_aluno que recebe o ID de um aluno e o remove da tabela.




-- Exercício 7: Crie um procedimento (inserir_aluno) que recebe nome, idade e nota, e insere um novo aluno na tabela

-- Exercício 8: Crie um procedimento (contar_por_faixa_etaria) que recebe duas idades como parâmetros e imprima o número de alunos com idade entre esses valores.

-- Exercício 9: Crie um procedimento que imprima o nome e a idade do aluno mais velho da turma















