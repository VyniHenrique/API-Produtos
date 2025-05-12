create table produto (
    id varchar(255) not null primary key,
    nome varchar(40) not null,
    descricao varchar(300),
    preco numeric(6,2) not null
);