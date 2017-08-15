CREATE DATABASE relacao_funcionarios;

USE relacao_funcionarios;

CREATE TABLE Funcionario (
	id int,
	num_matricula int,
	nome varchar(50),
	data_nascimento date,
	PRIMARY KEY (ID)
);

CREATE TABLE Dependente (
	id int,
	nome varchar(50),
	id_funcionario int,
	PRIMARY KEY (ID),
	 FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id)
);

CREATE TABLE Curso (
	id int,
	nome varchar(30),
	ano_curso int,
	PRIMARY KEY (id)
);

CREATE TABLE Turma(
	id_funcionario int,
	id_curso int,
	FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id),
	FOREIGN KEY (id_curso) REFERENCES Curso(id)
);