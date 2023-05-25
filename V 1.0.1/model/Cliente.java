package model;


import java.sql.SQLException;


import com.mysql.jdbc.PreparedStatement;

import bancoDeDados.BD;

public class Cliente {
	private int codCliente;
	private String nome;
	private String endereco;
	private String telefone;
	private String cidade;
	private String email;
	private String CpfCnpj;
	private String isPessoaJuridica;
	private String Ativo;

	public String getAtivo() {
		return Ativo;
	}
	public void setAtivo(String ativo) {
		Ativo = ativo;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfCnpj() {
		return CpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		CpfCnpj = cpfCnpj;
	}
	public String getIsPessoaJuridica() {
		return isPessoaJuridica;
	}
	public void setIsPessoaJuridica(String isPessoaJuridica) {
		this.isPessoaJuridica = isPessoaJuridica;
	}
	
	/**
	 * 
	 * @param cliente - Recebe um objeto cliente para slavar um cliente dentro do banco de dados
	 * @return String - Retorna uma string com o resultado da operação
	 */
	public String salvarCliente(Cliente cliente) {
		String mensagem;
		BD bd = new BD();
		bd.getConnection();
		String sql;
		sql = "INSERT INTO cliente (nome_cliente,telefone,endereco,cidade,email,Cpf_cnpj,isPessoaJuridica)Values ('" + cliente.getNome() + "','" + cliente.getTelefone() + "','" + cliente.getEndereco() + "','" + cliente.getCidade() + "','" + cliente.getEmail()+"','" +cliente.getCpfCnpj() + "','" + cliente.getIsPessoaJuridica()+"')";
		try {
			bd.st = bd.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			bd.st.executeUpdate();
			bd.rs = bd.st.getGeneratedKeys();
			
			if(bd.rs.next()) {
				int chavePrimaria = bd.rs.getInt(1);
			mensagem = "Cliente Cadastrado com sucesso no código " + chavePrimaria ;
			}
			else {
				mensagem = "Erro ao encotrar o codigo do cliente cadastrado";
			}
		}

		catch(SQLException erro){
		        mensagem = "Não foi possível concluir o cadastro: " + erro;


		}

		finally {
			bd.close();
		}

		return mensagem;

	}
	
	/**
	 * 
	 * @param codCliente - Recebe um codigo de um cliente para executar  a busca no banco de dados
	 * @return Cliente - Retorna um objeto do tipo cliente com as informacoes do codigo indicado
	 */
	public Cliente pesquisarCliente(int codCliente) {
		Cliente cliente = new Cliente();
		String sql = "select * from cliente where cod_cliente = ?";
		BD bd = new BD();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codCliente);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { // se existir proximo siginifica que acho o produto
				cliente.setCodCliente(bd.rs.getInt(1));
				cliente.setNome(bd.rs.getString(2));
				cliente.setTelefone(bd.rs.getString(3));
				cliente.setEndereco(bd.rs.getString(4));
				cliente.setCidade(bd.rs.getString(5));
				cliente.setEmail(bd.rs.getString(6));
				cliente.setCpfCnpj(bd.rs.getString(7));
				cliente.setIsPessoaJuridica(bd.rs.getString(8));
				cliente.setAtivo(bd.rs.getString(9));
			}
			else {
				cliente = null;
			}

		}
		catch(SQLException erro){
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return cliente;
	}
	
	/**
	 * 
	 * @param cliente - recebe um objeto do tipo cliente para sobreescrever informacoes no banco de dados
	 * @return uma string com o resultado da operacao
	 */
	public String atualizarCliente(Cliente cliente) {
		String mensagem;
		BD bd = new BD();
		bd.getConnection();
		String sql;
		sql = "UPDATE cliente SET nome_cliente = '" + cliente.getNome() +"', telefone = '" + cliente.getTelefone() + "', endereco = '" + cliente.getEndereco()+"', cidade = '" + cliente.getCidade() + "', email = '" + cliente.getEmail() + "', CPF_cnpj = '" + cliente.getCpfCnpj()+ "', isPessoaJuridica ='"+ cliente.getIsPessoaJuridica() + "', cliente_ativo ='" + cliente.getAtivo() +"' WHERE cod_cliente = " + cliente.getCodCliente();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.executeUpdate();
			mensagem = "Cliente alterado com sucesso";

		}

		catch(SQLException erro){
		        mensagem = "Não foi possível alterar o cadastro: " + erro;


		}

		finally {
			bd.close();
		}

		return mensagem;
		
	}
	
	public String[] clientesAtivos(){
	    String sql = "SELECT count(*) FROM cliente WHERE cliente_ativo = 'sim'";
	    BD bd = new BD();
	    bd.getConnection();
	    try {
	        bd.st = bd.con.prepareStatement(sql);
	        bd.rs = bd.st.executeQuery();
	        if (bd.rs.next()) {
	            int numClientesAtivos = bd.rs.getInt(1);
	            String[] listaClientes = new String[numClientesAtivos];
	            int i = 0;
	            sql = "SELECT cod_cliente, nome_cliente FROM cliente WHERE cliente_ativo = 'sim'";
	            bd.st = bd.con.prepareStatement(sql);
	            bd.rs = bd.st.executeQuery();
	            while(bd.rs.next()) {
	                listaClientes[i] = Integer.toString(bd.rs.getInt(1)) +" - " + bd.rs.getString(2);
	                i++;
	            }
	            return listaClientes;
	        }
	    }
	    catch(SQLException erro){
	        System.out.println(erro);
	    }
	    finally {
	        bd.close();
	    }
	    return null;
	}
}
