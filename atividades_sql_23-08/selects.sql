
#1
SELECT clientes.nome, vendas.nro_nota_fiscal, vendas.serie
FROM clientes, vendas
WHERE clientes.id = vendas.id_cliente;

SELECT clientes.nome, vendas.nro_nota_fiscal, vendas.serie
FROM clientes INNER JOIN vendas ON
clientes.id = vendas.id_cliente;

#2
SELECT clientes.nome, vendas.nro_nota_fiscal, vendas.serie, produtos.descricao
FROM clientes, vendas, itens, produtos
WHERE clientes.id = vendas.id_cliente AND
    vendas.id = itens.idVenda AND
    itens.idProduto = produtos.id AND
    produtos.descricao like  ('%Iphone%');

#3
SELECT produtos.descricao, vendas.nro_nota_fiscal, itens.quantidade
FROM vendas, produtos, itens
where itens.idVenda = vendas.id AND
itens.idProduto = produtos.id ORDER BY vendas.nro_nota_fiscal;

#4
ALTER TABLE vendas ADD dia date;

#5
SELECT DATE_FORMAT(datai, '%d-%m-%Y') as dataConvertida from vendas;
