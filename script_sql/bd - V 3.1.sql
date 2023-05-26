create database bd8;
use bd8;

--Criando tabela CLIENTE
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

--Criando tabela FUNCIONARIO
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

--Criando tabela PRODUTO
create table produto (
	cod_produto int primary key,
	nome_produto varchar (70) not null,
    descricao_produto varchar (150),
    valorun_produto money,
    unidade_produto char (2)
);
go

--Criando tabela SERVICO
create table servico (
	cod_servico int identity(1,1) primary key,
	nome_servico varchar (70) not null,
    descricao_servico varchar (150) ,
    valor_servico money
);
go

--Criando tabela VEICULO
create table veiculo (
	cod_veiculo int primary key,
    placa_veiculo char (7) not null,
    cor_veiculo char (15),
    modelo_veiculo varchar (30),
	marca_veiculo varchar (15),
    ano_veiculo int,
    ativo_veiculo char(3) default ('sim'),
    cod_cliente int not null references cliente
);
go

--Criando tabela ORDEM DE SERVICO
create table ordem_servico (
	cod_ordem int primary key,
    data_criacao date,
    data_exec date,
    status_ordem char (10),
    cod_veiculo int not null references veiculo,
    cod_func int not null references funcionario,
	valor_ordem money
	--valor_ordem as (select valor_servico from servico where cod_servico = cod_servico) + valorun_produto
    --campo calculado: os as valor_servico + valorun_produto
);
go

--Criando tabela do relacionamento n para n PRODUTO-ORDEM DE SERVICO
create table tem (
	cod_produto int not null references produto,
	cod_ordem int not null references ordem_servico,
	unique (cod_produto,cod_ordem)
);
go

--Criando tabela do relacionamento n para n SERVICO-ORDEM DE SERVICO
create table contem (
    cod_servico int not null references ordem_servico,
	cod_ordem int not null references ordem_servico,
	unique (cod_servico,cod_ordem)
);
go

--Sequencia de triggers para substituir o identity por problemas com o funcionamento
--Incremento da pk mesmo sem insert e perca de valores armazenados em cache)
create trigger pk_cliente on cliente instead of insert
as begin
	--Trativa para possivel erro durante a execucao da trigger ou insert dos dados
	begin try
		begin transaction
			declare @ultimo_cod_cliente int
			--Atribui o valor mais alto do codigo para a variavel local
			select @ultimo_cod_cliente = max(cod_cliente) from cliente
			--Soma 1 ao valor do ultimo codigo registrado para usar como o codigo para o novo dado inserido
			--Se o codigo estiver nulo (tabela ainda estiver vazia), atribui o valor 0
			set @ultimo_cod_cliente = isnull(@ultimo_cod_cliente,0) +1

			--Nessa ultima parte, o trigger apenas registra os dados na tabela.
			insert into cliente (
			cod_cliente, nome_cliente,
			doc_cliente, email_cliente,
			telefone_cliente, endereco_cliente,
			cidade_cliente, isPessoaJuridica_cliente, ativo_cliente
			)
			--No lugar da variavel cod_cliente eh colocado o valor da variavel local
			select @ultimo_cod_cliente, nome_cliente, doc_cliente, email_cliente, telefone_cliente, endereco_cliente, cidade_cliente, isPessoaJuridica_cliente, ativo_cliente
			from inserted
			commit
		end try
	begin catch
		--Esse comando retorna a tabela ao estado anterior a tentativa de insert e consequentemente do trigger
		rollback
		--Funciona quase como um print, precisa ser substituido pela expressao throw
		raiserror('Ocorreu um erro ao alterar a movimentação na tabela cliente', 11, 1)
	end catch
end
go

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
		raiserror('Ocorreu um erro ao alterar a movimentação na tabela funcionario', 11, 1)
	end catch
end
go

create trigger pk_produto on produto instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_produto int
			select @ultimo_cod_produto = max(@ultimo_cod_produto) from produto
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
		raiserror('Ocorreu um erro ao alterar a movimentação na tabela produto', 11, 1)
	end catch
end
go

create trigger pk_servico on servico instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_servico int
			select @ultimo_cod_servico = max(@ultimo_cod_servico) from servico
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
		raiserror('Ocorreu um erro ao alterar a movimentação na tabela servico', 11, 1)
	end catch
end
go

create trigger pk_veiculo on veiculo instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_veiculo int
			select @ultimo_cod_veiculo = max(@ultimo_cod_veiculo) from veiculo
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
		raiserror('Ocorreu um erro ao alterar a movimentação na tabela veiculo', 11, 1)
	end catch
end
go

create trigger pk_ordem on ordem_servico instead of insert
as begin
	begin try
		begin transaction
			declare @ultimo_cod_ordem int
			select @ultimo_cod_ordem = max(@ultimo_cod_ordem) from veiculo
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
		raiserror('Ocorreu um erro ao alterar a movimentação na tabela ordem de servico', 11, 1)
	end catch
end
go


--ANOTACOES, COISAS INACABADAS, IMPLEMENTACOES FUTURAS E IDEIAS
--Criar ou incluir na trigger existente para definir o campo de data da inclusao na hora do insert de dados

--Criar uma trigger para atualizar a data quando o status for alterado.
--https://pt.stackoverflow.com/questions/352666/criar-trigger-para-alterar-registro-somente-na-modifica%c3%a7%c3%a3o-de-um-campo

--Salvar os dados de uma tabela em arquivo .csv
--Primeiro, � necess�rio ativar o SQLCMD MODE indo em Query > SQLCMD MODE

-- Esse comando salva as informa��es no .csv e as explica��es est�o em cima.
-- -S . = Servidor | -d curso = banco de dados | -E = Trusted Connection | -Q = query a ser executada | -o = Arquivo para salvar resultados | -W remove espa�os em branco | -s"," = delimitar com , | -h-1 = remover a primeira linha de cabe�alho
!!sqlcmd -S SERVERNAME -d bd8 -E -Q "set nocount on; select * from cliente" -o "c:\tmp\dados.csv" -W -s"," h-1

-- Para descobrir o nome do server
select @@SERVERNAME

-- Para habilitar conex�es remotas
EXEC sp_configure 'remote access', 1;
GO  
RECONFIGURE;  
GO