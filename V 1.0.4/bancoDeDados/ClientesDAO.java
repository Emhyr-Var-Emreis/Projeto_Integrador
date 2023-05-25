package bancoDeDados;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Clientes;

public class ClientesDAO {
	private BD bd = new BD();
	
	/**
	 * 
	 * @param cliente - Recebe um objeto cliente para slavar um cliente dentro do banco de dados
	 * @return String - Retorna uma string com o resultado da operação
	 */
	public String salvarClientesBanco(Clientes cliente) {
		String mensagem;
		String sql;
		
		bd.getConnection();
		
		sql = "INSERT INTO cliente (nome_cliente,doc_cliente,email_cliente,telefone_cliente,endereco_cliente,cidade_cliente,isPessoaJuridica_cliente)Values (?,?,?,?,?,?,?)";
		try {
			
			bd.st = bd.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //Retorna o codigo gerado no banco
			bd.st.setString(1, cliente.getNome());
			bd.st.setString(2, cliente.getDoc() );
			bd.st.setString(3, cliente.getEmail());
			bd.st.setString(4, cliente.getTelefone());
			bd.st.setString(5, cliente.getEndereco());
			bd.st.setString(6, cliente.getCidade());
			bd.st.setString(7, cliente.getPessoaJuridica());
			
			bd.st.executeUpdate();
			bd.rs = bd.st.getGeneratedKeys();//Recupera o codigo gerado
			
			if(bd.rs.next()) {
				int chavePrimaria = bd.rs.getInt(1);
			mensagem = "Cliente Cadastrado com sucesso no código " + chavePrimaria ; //inclui o codigo na mensagem
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
	public Clientes pesquisarClienteBanco(Clientes cliente) {
		String sql = "select * from cliente where cod_cliente = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, cliente.getCodigoCliente());
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { // se existir proximo siginifica que acho o produto
				cliente.setCodigoCliente(bd.rs.getInt(1));
				cliente.setNome(bd.rs.getString(2));
				cliente.setDoc(bd.rs.getString(3));
				cliente.setEmail(bd.rs.getString(4));
				cliente.setTelefone(bd.rs.getString(5));
				cliente.setEndereco(bd.rs.getString(6));
				cliente.setCidade(bd.rs.getString(7));
				cliente.setPessoaJuridica(bd.rs.getString(8));
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
	public String atualizarClienteBanco(Clientes cliente) {
		String mensagem;
		bd.getConnection();
		String sql;
		sql = "UPDATE cliente SET nome_cliente = ?, doc_cliente=?, email_cliente=?, telefone_cliente=?, endereco_cliente=?, cidade_cliente=?, isPessoaJuridica_cliente=?, ativo_cliente=? WHERE cod_cliente=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, cliente.getNome());
			bd.st.setString(2, cliente.getDoc() );
			bd.st.setString(3, cliente.getEmail());
			bd.st.setString(4, cliente.getTelefone());
			bd.st.setString(5, cliente.getEndereco());
			bd.st.setString(6, cliente.getCidade());
			bd.st.setString(7, cliente.getPessoaJuridica());
			bd.st.setString(8, cliente.getAtivo());
			bd.st.setInt(9, cliente.getCodigoCliente());
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
	
	public String[] listarClientes() {
	    BD bd = new BD();
	    bd.getConnection();
	    String sql = "SELECT count(*) AS clientes FROM cliente";
	    String[] listaClientes = null;
	    try {
	        bd.st = bd.con.prepareStatement(sql);
	        bd.rs = bd.st.executeQuery();
	        if (bd.rs.next()) {
	            int numClientes = bd.rs.getInt("clientes");
	            listaClientes = new String[numClientes];
	            
	            bd.rs.close();
	            bd.st.close();
	            
	            sql = "SELECT * FROM cliente";
	            
	            bd.st = bd.con.prepareStatement(sql);
	            bd.rs = bd.st.executeQuery();
	            
	            int i = 0;
	            while (bd.rs.next()) {
	                listaClientes[i] = Integer.toString(bd.rs.getInt("cod_cliente")) + "- " + bd.rs.getString("nome_cliente");
	                i++;
	            }
	            
	            
	        }
	    } catch (SQLException erro) {
	        System.out.println(erro);
	    } finally {
	        bd.close();
	    }
	    return listaClientes;
	}
	
	public boolean clienteAtivo(int codigo) {
		String clienteAtivo;
		boolean resultado = false;
		String sql = "SELECT ativo_cliente FROM cliente WHERE cod_cliente = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { // se existir proximo siginifica que acho o produto
				clienteAtivo = bd.rs.getString(1);
				if(clienteAtivo.equals("Sim")||clienteAtivo.equals("sim")) {
					resultado = true;
				}
			}
			else {
				 clienteAtivo = null;
			}

		}
		catch(SQLException erro){
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return resultado;
	}
}
