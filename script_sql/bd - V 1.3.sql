--Criar e usar um banco de dados
create database banco3;
use banco3;

--Trabalhar com a data no formato dd/mm/yyyy
set dateformat dmy;


--Criar tabela CLIENTE
create table cliente (
    cod_cliente int identity(1,1) primary key,
    nome_cliente varchar (50) not null,
    doc_cliente char (14) unique not null,
    email_cliente varchar(50),
    telefone_cliente varchar (11),
    endereco_cliente varchar (150),
    cidade_cliente varchar (25),
    uf_cliente char (2),
    isPessoaJuridica_cliente bit not null,
    ativo_cliente char (3) default 'sim');

--Criar tabela FUNCIONÁRIO
create table funcionario (
    cod_func int identity(1,1) primary key,
    matricula_func int unique not null,
    nome_func varchar (50) not null,
	doc_func char (14) unique not null,
    email_func varchar(50),
    telefone_func varchar (11),
    endereco_func varchar (150),
    cidade_func varchar (25),
    uf_func char (2),
    cargo_func varchar (25),
    salario_func money);

--Criar tabela PRODUTO
create table produto (
    cod_produto int identity(1,1) primary key,
    descricao_produto varchar (100),
    valorun_produto money,
    unidade_produto char (2));

--Criar tabela SERVIÇO
create table servico (
    cod_servico int identity(1,1) primary key,
    descricao_servico varchar (50),
    valor_servico money);

--Criar tabela VEÍCULO
create table veiculo (
    cod_veiculo int identity(1,1) primary key,
    placa_veiculo char (7) not null,
    cor_veiculo char (10),
    modelo_veiculo char (20),
	marca_veiculo char (10),
    ano_veiculo int,
    cod_cliente int not null references cliente);

--Criar tabela ORDEM DE SERVIÇO
create table ordemservico (
    cod_ordem int identity(1,1) primary key,
    data_criacao datetime,
    data_exec datetime,
    estado_ordem char (10),
    comentario_ordem varchar (100),
    cod_veiculo int not null references veiculo,
    cod_func int not null references funcionario);

--Inserindo dados na tabela cliente
insert into cliente(nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, uf_cliente, isPessoaJuridica_cliente) values (
    'Fulano da Silva',
    '11111111111',
    'fulano.silvas@gmail.com',
    '11111111111',
    'Rua dos Silva, 63',
    'Indaiatuba', 
	'SP',
    0);
insert into cliente(nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, uf_cliente, isPessoaJuridica_cliente) values (
    'Beltrano da Silva',
    '22222222222222',
    'silvabentraninho@uol.com',
    '22222222222',
    'Rua dos Silva, 1562',
    'Salto',
    'SP',
    1);
insert into cliente(nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, uf_cliente, isPessoaJuridica_cliente) values (
    'Ciclano da Silva',
    '3333333333',
    'ciclanoo494silva3@outlook.com',
    '3333333333',
	'Rua dos Silva, 879',
    'Jundiai',
    'SP',
    0);
insert into cliente(nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, uf_cliente, isPessoaJuridica_cliente) values (
    'Leonardo da Silva',
    '44444444444444',
    'leozinhogameplays@gmail.com',
    '4444444444',
    'Rua dos Silva, 262',
    'Sorocaba',
    'SP',
    1);
--Verificando dados inseridos na tabela cliente
select * from cliente


--Inserindo dados na tabela funcionario
insert into funcionario values (
    11111,
    'Maria Cristina Santos',
    '11111111111',
    'msantos@oficina.com',
    '1111111111',
    'Rua das Marias Funcionárias, 26',
    'Indaiatuba',
    'SP',
    'Secretária',
    1490);
insert into funcionario values (
    22222,
    'Maria Júlia Bezerra',
	'22222222222',
    'mbezerra@oficina.com',
    '22222222222',
    'Rua das Marias Funcionárias, 986',
    'Indaiatuba',
    'SP',
    'Técnica em Mecânica',
    2560);
insert into funcionario values (
    33333,
    'Maria Paula Andrade',
    '33333333333',
    'mandrade@oficina.com',
    '33333333333',
    'Rua das Marias Funcionárias, 546',
    'Indaiatuba',
    'SP',
    'Engenheira Mecânica',
    4720);
insert into funcionario values (
    44444,
    'Maria Clara Ferreira',
	'44444444444',
    'mferreira@oficina.com',
    '44444444444',
    'Rua das Marias Funcionárias, 126',
    'Indaiatuba',
    'SP',
    'Contadora',
    2100);
--Verificando dados inseridos na tabela funcionário
select * from funcionario

--Inserindo dados na tabela produto
insert into produto values (
    'Litro de Oleo Mobil para carro 20w50',
    39.99,
    'lt');
insert into produto values (
    'Par de palheta para parabrisa universal',
    49.99,
    'un');
insert into produto values (
    'Pneu Aro 14 Goodyear 175/65 Direction Touring SL 82T',
    334.34,
	'un');
insert into produto values (
    'Duas peças de lâmpadas Led para farol de carro 60w 9000lm 6000k Ip67',
    97.90,
    'un');
--Verificando dados inseridos na tabela produto
select * from produto


--Inserindo dados na tabela veiculo
insert into veiculo values (
    'RTO4D56',
    'Chumbo',
    'Onix',
    'Chevrolet',
    2021,
    1);
insert into veiculo values (
    'OKP4Q15',
    'Vermelho',
    'Tucson',
    'Hyundai',
    2006,
    2);
insert into veiculo values (
    'XCS9A68',
    'Preto',
    '207 Sedan (Passion)',
	'Peugeot',
    2008,
    3);
insert into veiculo values (
    'DDF8P36',
    'Branco',
    'Uno',
    'Fiat',
    1984,
    4);
--Verificando dados inseridos na tabela produto
select * from veiculo


--Inserindo dados na tabela serviço
insert into servico values (
	'Revisão completa.',
    78.50);
insert into servico values (
	'Troca de pneu.',
    90.20);
insert into servico values (
    'Balanceamento',
    120.92);
insert into servico values (
	'Alinhamento',
    200.10);
--Verificando dados inseridos na tabela serviço
select * from servico


--Inserindo dados na tabela ordem de serviço
insert into ordemservico values (
    '25-04-2023 08:20:30',
    '26-04-2023 11:02:24',
    'Concluída',
    'Foi realizada uma inspeção completa. Não foram encontrados problemas.',
    1,
    2);
insert into ordemservico values (
    '03-05-2022 08:20:30',
    '08-05-2022 11:02:24',
    'Cancelada',
    'Cliente não trouxe o carro para a revisão programada.',
    2,
    3);
insert into ordemservico values (
    '30-03-2023 08:12:09',
    '02-04-2023 09:44:54',
    'Concluída',
    'Balanceamento e alinhamento realizados.',
    3,
    2);
insert into ordemservico values (
    '13-04-2023 15:49:23',
    '14-04-2023 10:25:55',
    'Concluída',
    'Foi realizada uma inspeção completa. Foram encontrados problemas nos fárois, que foram trocados.',
    4,
    3);
--Verificando dados inseridos na tabela ordem de servico
select * from ordemservico