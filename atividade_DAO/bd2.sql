create schema BD2;

use BD2;

create table Departamento(
    id int,
    nome varchar(255),
    primary key(id)
);

create table Colaborador (
    id int,
    cpf varchar(255),
    nome varchar(255),
    endereco varchar(255),
    telefone varchar(255),
    email varchar(255),
    quantidadeFilhos varchar(255),
    idDepartamento int,
    primary key(id),
    foreign key(idDepartamento) references Departamento(id)
);

