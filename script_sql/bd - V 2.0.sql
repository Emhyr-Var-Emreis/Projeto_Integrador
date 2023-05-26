create database bd5;
use bd5;

create table cliente (
    cod_cliente int identity(1,1) primary key, 
	nome_cliente varchar (50) not null,
    doc_cliente char (14) unique not null,
    email_cliente varchar(50),
    telefone_cliente varchar (11),
    endereco_cliente varchar (150),
    cidade_cliente varchar (25),
    isPessoaJuridica_cliente char(3),
    ativo_cliente char(3)
);

create table funcionario (
	matricula_func int identity(100,100) primary key,
    nome_func varchar (50) not null,
	doc_func char (14) unique not null,
    email_func varchar(50),
    telefone_func char (11),
    endereco_func varchar (150),
    cidade_func varchar (25),
    cargo_func varchar (25),
);

create table produto (
	cod_produto int identity(1,1) primary key,
	nome_produto varchar (70) not null,
    descricao_produto varchar (150),
    valorun_produto money,
    unidade_produto char (2)
);

create table servico (
	cod_servico int identity(1,1) primary key,
	nome_servico varchar (70) not null,
    descricao_servico varchar (150) ,
    valor_servico money
);

create table veiculo (
	cod_veiculo int identity(1,1) primary key,
    placa_veiculo char (7) not null,
    cor_veiculo char (15),
    modelo_veiculo varchar (30),
	marca_veiculo varchar (15),
    ano_veiculo int,
    cod_cliente int not null references cliente
);

create table ordem_servico (
	cod_ordem int identity(1,1) primary key,
    data_criacao date,
    data_exec date,
    status_ordem char (10),
	valor_ordem money,
    cod_veiculo int not null references veiculo,
    cod_func int not null references funcionario
);

create table tem (
	cod_produto int not null references produto,
	cod_ordem int not null references ordem_servico
);

create table contem (
    cod_servico int not null references ordem_servico,
	cod_ordem int not null references ordem_servico
);