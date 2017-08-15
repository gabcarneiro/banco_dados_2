CREATE DATABASE relacao_programadores;

USE relacao_programadores;

CREATE TABLE Nivel_Programador (
	id int,
	nivel int,
	descricao varchar(50),
	PRIMARY KEY (id)
);

INSERT INTO Nivel_Programador values 
	(1,1,'Junior'),
	(2,2,'Pleno'),
	(3,3,'Senior');

CREATE TABLE Programador (
	id int,
	num_matricula int,
	nome varchar(50),
	setor varchar(50),
	id_nivel int,
	PRIMARY KEY (id),
	FOREIGN KEY (id_nivel) REFERENCES Nivel_Programador(id)
);

CREATE TABLE Nivel_dificuldade(
	id int,
	descricao varchar(30),
	PRIMARY KEY (id)
);

INSERT INTO Nivel_dificuldade values 
	(1,'Facil'),
	(2,'Medio'),
	(3,'Dificil');


CREATE TABLE Programa(
	id int,
	nome varchar(50),
	id_nivel_dificuldade int,
	tempo_estimado date,
	PRIMARY KEY (id)
);

CREATE TABLE Equipe(
	id int,
	id_programador int,
	id_programa int,
	PRIMARY KEY (id),
	FOREIGN KEY (id_programador) REFERENCES Programador(id),
	FOREIGN KEY (id_programa) REFERENCES Programa(id)
);
