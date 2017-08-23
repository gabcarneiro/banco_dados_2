CREATE DATABASE relacao_vendas;

use relacao_vendas;

CREATE TABLE clientes (
    id int PRIMARY KEY,
    idade int,
    nome varchar(50),
    escolaridade varchar(30),
    email varchar(50),
    estado varchar(2)
);

CREATE TABLE vendas (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nro_nota_fiscal int,
    serie varchar(10),
    datai date,
    id_cliente int,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

CREATE TABLE produtos (
    id int  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao varchar(80),
    preco double(10,2)
);

CREATE TABLE itens(
    id int PRIMARY KEY AUTO_INCREMENT,
    idVenda int,
    idProduto int,
    quantidade int,
    FOREIGN KEY (idVenda) REFERENCES vendas(id),
    FOREIGN KEY (idProduto) REFERENCES produtos(id)
);

INSERT INTO produtos(descricao,preco) values
    ('Tv LCD 32', 1.699);
INSERT INTO produtos(descricao,preco) values
    ('Mouse Optico Microsoft', 158.36),
    ('Telefone Celular Iphone', 1989.25),
    ('Home Theater Phillips', 999),
    (' ',0);

INSERT INTO clientes VALUES
    (1, 27, 'Andreia Biancato', 'mestrado', 'teste@teste.com', 'RS'),
    (2, 27, 'Marcelia Soares', 'superior compelo', 'andreia@gmail.com', 'SC'),
    (3,27,'Juliana Baroni', 'primario incompleto', 'ju@gmail.com', 'SP'),
    (10, 27, 'Panicat', 'jardim completo', 'biscate@band.com', 'RJ');

INSERT INTO vendas VALUES
    (1, 1233, 'ab', '2012-03-03', 1),
    (2, 555, 'c3f', '2011-03-03', 2),
    (3, 778, 'vb4', '2011-12-03', 2),
    (4, 5553, 'cbt', '2011-12-09', 3);

INSERT INTO itens(idVenda,idProduto,quantidade) values
    (1,1,2),
    (1,2,3),
    (1,3,5),
    (2,2,1),
    (3,1,2),
    (3,2,1),
    (3,3,4),
    (4,1,1);