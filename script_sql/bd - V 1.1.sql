--Criar e usar um banco de dados
create database banco1;
use banco1;

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
    isPessoaJuridica bit not null
    ativo char (3) default 'sim');

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
    descricao_produto varchar (35),
    valorun_produto money,
    unidade_produto char (2));

--Criar tabela VEÍCULO
create table veiculo (
    cod_veiculo int identity(1,1) primary key,
    placa_veiculo char (7) not null,
    cor_veiculo char (10),
    modelo_veiculo char (10),
    marca_veiculo char (10),
    ano_veiculo int,
    cod_cliente int not null references cliente);

--Criar tabela SERVIÇO
create table servico (
    cod_servico int identity(1,1) primary key,
    descricao_servico varchar (50),
    valor_servico money);

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
insert into cliente values (
    'Fulano da Silva',
    '11111111111',
    'fulano.silvas@gmail.com',
    '11111111111',
    'Rua dos Silva, 63',
    'Indaiatuba', 'SP',
    0);

insert into cliente values (
    'Beltrano da Silva',
    '22222222222222',
    'silvabentraninho@uol.com',
    '22222222222',
    'Rua dos Silva, 1562',
    'Salto',
    'SP',
    1);

insert into cliente values (
    'Ciclano da Silva',
    '3333333333',
    'ciclanoo494silva3@outlook.com',
    '3333333333',
    'Rua dos Silva, 879',
    'Jundiai',
    'SP',
    0);

insert into cliente values (
    'Leonard0 da Silva',
    '44444444444444',
    'leozinhogameplays@gmail.com',
    '4444444444',
    'Rua dos Silva, 262',
    'Sorocaba',
    'SP',
    1);

--Inserindo dados na tabela funcionario
insert into funcionario values (
    11111,
    'Maria Cristina Santos'
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
    'Maria Júlia Bezerra'
    '22222222222',
    'mbezerra@oficina.com',
    '222222222222',
    'Rua das Marias Funcionárias, 986',
    'Indaiatuba',
    'SP',
    'Técnica em Mecânica',
    2560);

insert into funcionario values (
    33333,
    'Maria Paula Andrade'
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
    'Maria Clara Ferreira'
    '44444444444',
    'mferreira@oficina.com',
    '44444444444',
    'Rua das Marias Funcionárias, 126',
    'Indaiatuba',
    'SP',
    'Contadora',
    2100);

--Inserindo dados na tabela produto
insert into produto values (
    'Litro de Óleo Mobil para carro 20w50',
    39.99,
    'lt');

insert into produto values (
    'Pneu Aro 14 Goodyear 175/65 Direction Touring SL 82T',
    334.34,
    'un');

insert into produto values (
    'Par de palheta para parabrisa universal',
    49.99,
    'un');

insert into produto values (
    'Duas peças de lâmpadas Led para farol de carro 60w 9000lm 6000k Ip67',
    97.90,
    'un');

--Inserindo dados na tabela veiculo
insert into veiculo values (
    'RTO4D56'
    'Chumbo',
    'Onix',
    'Chevrolet',
    2021,
    1);

insert into veiculo values (
    'XCS9A68'
    'Preto',
    '207 Sedan (Passion)',
    'Peugeot',
    2008,
    3);

insert into veiculo values (
    'DDF8P36'
    'Branco',
    'Uno',
    'Fiat',
    1984,
    4);

insert into veiculo values (
    'OKP4Q15'
    'Vermelho',
    'Tucson',
    'Hyundai',
    2006,
    2);

--Inserindo dados na tabela serviço
insert into servico values (
    78.50,
    'Revisão completa.');

insert into servico values (
    90.20,
    'Troca de pneu.');

insert into servico values (
    120.92,
    'Balanceamento');

insert into servico values (
    200.10,
    'Alinhamento');

--Inserindo dados na tabela ordem de serviço
insert into ordemservico values (
    25-04-2023 08:20:30,
    26-04-2023 11:02:24,
    'Concluída',
    'Foi realizada uma inspeção completa. Não foram encontrados problemas.',
    1,
    2);

insert into ordemservico values (
    03-05-2022 08:20:30,
    08-05-2022 11:02:24,
    'Cancelada',
    'Cliente não trouxe o carro para a revisão programada.',
    1,
    2);

insert into ordemservico values (
    25-04-2023 08:20:30,
    26-04-2023 11:02:24,
    'Concluída',
    'Foi realizada uma inspeção completa. Não foram encontrados problemas.',
    1,
    2);

insert into ordemservico values (
    25-04-2023 08:20:30,
    26-04-2023 11:02:24,
    'Concluída',
    'Foi realizada uma inspeção completa. Não foram encontrados problemas.',
    1,
    2);