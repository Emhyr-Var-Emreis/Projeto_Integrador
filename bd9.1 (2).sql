create database bd9
use bd9

set dateformat dmy
go

--Creating table CLIENTE
create table cliente (
    cod_cliente int primary key, 
	nome_cliente varchar (50) not null,
    doc_cliente char (14) unique not null,
    email_cliente varchar(50),
    telefone_cliente varchar (11),
    endereco_cliente varchar (150),
    cidade_cliente varchar (25),
    isPessoaJuridica_cliente char(3),
    ativo_cliente char(3) default ('sim')
);
go

--Creating table FUNCIONARIO
create table funcionario (
	matricula_func int primary key,
	login_func varchar (50) not null,
	senha_func varchar (50) not null,
    nome_func varchar (50) not null,
	doc_func char (14) unique not null,
    email_func varchar(50),
    telefone_func char (11),
    endereco_func varchar (150),
    cidade_func varchar (25),
    cargo_func varchar (25),
    ativo_func char(3) default ('sim')
);
go

--Creating table PRODUTO
create table produto (
	cod_produto int primary key,
	nome_produto varchar (70) not null,
    descricao_produto varchar (150),
    valorun_produto money,
    unidade_produto char (2)
);
go

--Creating table SERVICO
create table servico (
	cod_servico int primary key,
	nome_servico varchar (70) not null,
    descricao_servico varchar (150) ,
    valor_servico money
);
go

--Creating table VEICULO
create table veiculo (
	cod_veiculo int primary key,
    placa_veiculo char (7) not null,
    cor_veiculo char (15),
	marca_veiculo varchar (15),
    modelo_veiculo varchar (30),
    ano_veiculo int,
    ativo_veiculo char(3) default ('sim'),
    cod_cliente int not null references cliente
);
go

--Creating table ORDEM DE SERVICO
create table ordem_servico (
	cod_ordem int primary key,
    data_criacao date,
    data_exec date,
    status_ordem char (20),
	valor_ordem money,
    cod_veiculo int not null references veiculo,
    cod_func int not null references funcionario
);
go

--Creating table that originates from the n-n relationship between tables PRODUTO-ORDEM DE SERVICO
create table item_produto (
	quantidade_item_produto int,
	valor_item_produto money,
	cod_produto int not null references produto,
	cod_ordem int not null references ordem_servico,
	unique (cod_produto, cod_ordem)
);
go

--Creating table that originates from the n-n relationship between tables SERVICO-ORDEM DE SERVICO
create table item_servico (
	quantidadeHoras_item_servico int,
	valor_item_servico int,
    cod_servico int not null references servico,
	cod_ordem int not null references ordem_servico,
	unique (cod_servico, cod_ordem)
);
go

--TRIGGERS - AUTO INCREMENT: PRIMARY KEY--
--'identity' option was messing up with the code 

-- Trigger for CLIENTE
create trigger pk_cliente on cliente instead of insert
as begin
	--Try-Catch to for any error that may happen during the execution of the trigger or insert of the data
	begin try
		begin transaction
			declare @ultimo_cod_cliente int
			--Assigns the highest cod_cliente value the local variable
			select @ultimo_cod_cliente = max(cod_cliente) from cliente
			--Adds 1 to the local variable to use as the primary key for the insert
			--If the cod is null (when the table is still empty), assigns 0 to the local variable and adds 1.
			set @ultimo_cod_cliente = isnull(@ultimo_cod_cliente,0) +1

			--In this last part, it is described the insert process
			insert into cliente (
			cod_cliente, nome_cliente,
			doc_cliente, email_cliente,
			telefone_cliente, endereco_cliente,
			cidade_cliente, isPessoaJuridica_cliente, ativo_cliente
			)
			--The variable cod_cliente is replaced by the local variable
			select @ultimo_cod_cliente, nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, isPessoaJuridica_cliente, ativo_cliente
			from inserted
			commit
		end try
	begin catch
		--Returns the table to its previous state if something fails
		rollback
		--Prints the error and the message
		raiserror('Ocorreu um erro ao realizar a movimentacao na tabela cliente', 11, 1)
	end catch
end
go

-- Trigger for FUNCIONARIO
create trigger pk_func on funcionario instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_func int
			select @ultimo_cod_func = max(matricula_func) from funcionario
			set @ultimo_cod_func = isnull(@ultimo_cod_func,0) +1

			insert into funcionario (
			matricula_func, login_func,
			senha_func, nome_func,
			doc_func, email_func,
			telefone_func, endereco_func,
			cidade_func, cargo_func, ativo_func
			)
			select @ultimo_cod_func, login_func,senha_func, nome_func, doc_func, email_func, telefone_func, endereco_func, cidade_func, cargo_func, ativo_func
			from inserted
			commit
		end try
	begin catch
		rollback
		raiserror('Ocorreu um erro ao realizar a movimentacao na tabela funcionario', 11, 1)
	end catch
end
go

-- Trigger for PRODUTO
create trigger pk_produto on produto instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_produto int
			select @ultimo_cod_produto = max(cod_produto) from produto
			set @ultimo_cod_produto = isnull(@ultimo_cod_produto,0) +1

			insert into produto (
			cod_produto, nome_produto,
			descricao_produto, valorun_produto,
			unidade_produto
			)
			select @ultimo_cod_produto, nome_produto, descricao_produto, valorun_produto, unidade_produto
			from inserted
			commit
		end try
	begin catch
		rollback
		raiserror('Ocorreu um erro ao realizar a movimentacao na tabela produto', 11, 1)
	end catch
end
go

-- Trigger for SERVICO
create trigger pk_servico on servico instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_servico int
			select @ultimo_cod_servico = max(cod_servico) from servico
			set @ultimo_cod_servico = isnull(@ultimo_cod_servico,0) +1

			insert into servico (
			cod_servico, nome_servico,
			descricao_servico, valor_servico
			)
			select @ultimo_cod_servico, nome_servico, descricao_servico, valor_servico			
			from inserted
			commit
		end try
	begin catch
		rollback
		raiserror('Ocorreu um erro ao realizar a movimentacao na tabela servico', 11, 1)
	end catch
end
go

-- Trigger for VEICULO
create trigger pk_veiculo on veiculo instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_veiculo int
			select @ultimo_cod_veiculo = max(cod_veiculo) from veiculo
			set @ultimo_cod_veiculo = isnull(@ultimo_cod_veiculo,0) +1

			insert into veiculo (
			cod_veiculo, placa_veiculo,
			cor_veiculo, modelo_veiculo,
			marca_veiculo, ano_veiculo,
			ativo_veiculo, cod_cliente
			)
			select @ultimo_cod_veiculo, placa_veiculo, cor_veiculo, modelo_veiculo, marca_veiculo, ano_veiculo, ativo_veiculo, cod_cliente	
			from inserted
			commit
		end try
	begin catch
		rollback
		raiserror('Ocorreu um erro ao realizar a movimentacao na tabela veiculo', 11, 1)
	end catch
end
go

-- Trigger for ORDEM_SERVICO
create trigger pk_ordem on ordem_servico instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_ordem int
			select @ultimo_cod_ordem = max(cod_ordem) from ordem_servico
			set @ultimo_cod_ordem = isnull(@ultimo_cod_ordem,0) +1

			insert into ordem_servico(
			cod_ordem, data_criacao, 
			data_exec, status_ordem,
			valor_ordem, cod_veiculo,
			cod_func
			)
			select @ultimo_cod_ordem, data_criacao, data_exec, status_ordem, valor_ordem, cod_veiculo, cod_func	
			from inserted
			commit
		end try
	begin catch
		rollback
		raiserror('Ocorreu um erro ao realizar a movimentacao na tabela ordem de servico', 11, 1)
	end catch
end
go

--Testing inserts
insert into cliente (nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, isPessoaJuridica_cliente) values (
	'Alzira Albenaz Trindade',
	'64374058729',
	'alzira.trindade@geradornv.com.br',
	'28988662478',
	'Rua Pernambuco, 32',
	'Sao Mateus',
	'nao'
	)
insert into cliente (nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, isPessoaJuridica_cliente) values (
	'Dinea Dantas Martins',
	'78753811267',
	'dinea.martins@geradornv.com.br',
	'97976388359',
	'Rua G, 933',
	'Itacoatiara',
	'nao'
	)
insert into cliente (nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, isPessoaJuridica_cliente) values (
	'Tomas Queiroz Marotti',
	'08268271108',
	'tomas.marotti@geradornv.com.br',
	'63988047145',
	'Rua das Jussaras, 77',
	'Araguaina',
	'nao'
	)
insert into cliente (nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, isPessoaJuridica_cliente) values (
	'Ana Cristina Valansuela Velasco',
	'81299935460',
	'ana.velasco@geradornv.com.br',
	'84985534774',
	'Vila Sao Jeronimo, 590',
	'Natal',
	'nao'
	)
insert into funcionario (login_func, senha_func, nome_func, doc_func, email_func, telefone_func, endereco_func, cidade_func, cargo_func) values (
	'ecamara',
	'BE@0heW$mxkL',
	'Edimo Neves Camara',
	'36283906800',
	'edimo.camara@geradornv.com.br',
	'19987683671',
	'Rua Ribeirao Branco, 182',
	'Indaiatuba',
	'Tecnico em Mecanica'
	)
insert into funcionario (login_func, senha_func, nome_func, doc_func, email_func, telefone_func, endereco_func, cidade_func, cargo_func) values (
	'gerente',
	'123',
	'Caleb Nogueira Nazare',
	'33366699912',
	'caleb.nazare@geradornv.com.br',
	'19981426545',
	'Avenida Virgilio Lourenço dos Reis, 32',
	'Indaiatuba',
	'Gerente'
	)
insert into funcionario (login_func, senha_func, nome_func, doc_func, email_func, telefone_func, endereco_func, cidade_func, cargo_func) values (
	'lpassos3',
	'q7Lqio8j9K!r',
	'Laisa Vidal dos Passos',
	'48101468200',
	'laisa.passos@geradornv.com.br',
	'19995046669',
	'Rua 15, 32',
	'Indaiatuba',
	'Contador'
	)
insert into funcionario (login_func, senha_func, nome_func, doc_func, email_func, telefone_func, endereco_func, cidade_func, cargo_func) values (
	'ecunha2',
	'cW_(57EZI#zW',
	'Eldimar Moura Cunha',
	'75180754313',
	'eldimar.cunha@geradornv.com.br',
	'19976433508',
	'Rua Pio Rodrigues, 713',
	'Indaiatuba',
	'Secretario'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Litro de oleo - SW30',
	'Litro de oleo - SW30',
	50,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Filtro de oleo',
	'Filtro de oleo',
	28,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Pastilha',
	'Pastilha',
	140,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Disco',
	'Disco',
	180,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Fluido de freio',
	'Fluido de freio',
	35,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Correia dentada',
	'Correia dentada',
	70,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Sensor da correia dentada',
	'Sensor da correia dentada',
	140,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Correia auxiliar',
	'Correia auxiliar',
	90,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Kit de embreagem',
	'it de embreagem',
	800,
	'un'
	)
insert into produto (nome_produto, descricao_produto, valorun_produto, unidade_produto) values (
	'Fluido de embalagem',
	'Fluido de embalagem',
	35,
	'un'
	)
insert into servico (nome_servico, descricao_servico, valor_servico) values (
	'Troca de Oleo',
	'Utiliza litro de oleo e filtro de oleo',
	120
	)
insert into servico (nome_servico, descricao_servico, valor_servico) values (
	'Troca de pastilhas e discos',
	'Utiliza pastilhas, discos e fluido de freio',
	110
	)
insert into servico (nome_servico, descricao_servico, valor_servico) values (
	'Troca da correia dentada',
	'Utiliza correia dentada, sensor da correia dentada e correia auxiliar',
	110
	)
insert into servico (nome_servico, descricao_servico, valor_servico) values (
	'Troca de embreagem',
	'Utiliza kit de embreagem e fluido de embreagem',
	175
	)
insert into veiculo (placa_veiculo, cor_veiculo, marca_veiculo, modelo_veiculo, ano_veiculo, cod_cliente) values (
	'FQD3F32',
	'Preto',
	'Jeep',
	'Compass',
	2021,
	1
	)
insert into veiculo (placa_veiculo, cor_veiculo, marca_veiculo, modelo_veiculo, ano_veiculo, cod_cliente) values (
	'SFW5T75',
	'Branco',
	'Fiat',
	'Palio',
	2010,
	2
	)
insert into veiculo (placa_veiculo, cor_veiculo, marca_veiculo, modelo_veiculo, ano_veiculo, cod_cliente) values (
	'DAP9S22',
	'Azul',
	'Nissan',
	'Skyline',
	1958,
	3
	)
insert into veiculo (placa_veiculo, cor_veiculo, marca_veiculo, modelo_veiculo, ano_veiculo, cod_cliente) values (
	'FOE0S76',
	'Branco perolado',
	'Hyundai',
	'HB20',
	2021,
	4
	)

--SQL TABLE TO CSV FILE
--Firts: Query > SQLCMD MODE
-- -S . = Server | -d bd = database | -E = Trusted Connection | -Q = query to be execute | -o = path and file | -W remove blanck | -s";" = delimit with ; | -h-1 = removes the headline
!!sqlcmd -S LAPTOP-34IJL33H\SQLEXPRESS -d bd8 -E -Q "set nocount on; select * from cliente" -o "c:\tmp\dados.csv" -W -s";" h-1

-- Server name
select @@SERVERNAME

-- Remote conections
EXEC sp_configure 'remote access', 1;
GO  
RECONFIGURE;  
GO