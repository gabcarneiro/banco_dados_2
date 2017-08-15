CREATE DATABASE departamento_vendas;

use departamento_vendas;

CREATE TABLE regiao(
	id int,
	nome varchar(40),
	PRIMARY KEY (id)
);

CREATE TABLE ponto_estrategico (
	id int,
	descricao varchar(100),
	id_regiao int,
	PRIMARY KEY(id),
	FOREIGN KEY (id_regiao) REFERENCES regiao(id)

);

CREATE TABLE vendedor (
	id int,
	nome varchar(50),
	id_regiao int,
	PRIMARY KEY(id),
	FOREIGN KEY (id_regiao) REFERENCES regiao(id)
);

CREATE TABLE veiculo (
	id int,
	modelo varchar(50),
	placa varchar(8),
	PRIMARY KEY(id)
);

CREATE TABLE veiculo_vendedor (
    id int,
    id_veiculo int,
    id_vendedor int,
    data_uso date,
    PRIMARY KEY (id),
    FOREIGN KEY (id_veiculo) REFERENCES veiculo(id),
    FOREIGN KEY (id_vendedor) REFERENCES vendedor(id)
);

CREATE TABLE cliente (
    id int,
    nome varchar(50),
    PRIMARY KEY(id)
);

CREATE TABLE nota_fiscal (
    id int,
    id_vendedor int,
    id_cliente int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_vendedor) REFERENCES vendedor(id)
);

CREATE TABLE produto (
    id int,
    descricao varchar(50),
    estoque int,
    preco_atual double(10,2),
    PRIMARY KEY (id)
);

CREATE TABLE item (
    id int,
    quantidade int,
    id_produto int,
    id_nota_fiscal int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_produto) REFERENCES produto(id),
    FOREIGN KEY (id_nota_fiscal) REFERENCES nota_fiscal(id)
);



