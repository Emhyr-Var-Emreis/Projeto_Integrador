package bancoDeDados;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Funcionarios;

public class FuncionarioDAO {

	private BD bd = new BD();

	public String salvarFuncionarioBanco(Funcionarios funcionario) {
		String mensagem;
		String sql;

		bd.getConnection();

		sql = "INSERT INTO funcionario (nome_func, doc_func, email_func, telefone_func, endereco_func, cidade_func, cargo_func, login_func, senha_func)Values (?,?,?,?,?,?,?,?,?)";

		try {
			bd.st = bd.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);//Retorna o codigo gerado no banco
			bd.st.setString(1, funcionario.getNome());
			bd.st.setString(2, funcionario.getDocFuncionario() );
			bd.st.setString(3, funcionario.getEmail());
			bd.st.setString(4, funcionario.getTelefone());
			bd.st.setString(5, funcionario.getEndereco());
			bd.st.setString(6, funcionario.getCidade());
			bd.st.setString(7, funcionario.getCargo());
			bd.st.setString(8, funcionario.getUsuario());
			bd.st.setString(9, funcionario.getSenha());

			bd.st.executeUpdate();
			bd.rs = bd.st.getGeneratedKeys();//Recupera o codigo gerado

			if(bd.rs.next()) {
				int chavePrimaria = bd.rs.getInt(1);
				mensagem = "Funcioário matriculado com sucesso no código " + chavePrimaria ; //inclui o codigo na mensagem
			}
			else {
				mensagem = "Erro ao encotrar o codigo do cliente cadastrado";
			}

		} 
		catch(SQLException erro){

			if (erro.getErrorCode() == 2627) {
				mensagem = "O login ou senha devem ser unicos!";
			} else {
				mensagem = "Não foi possível concluir o cadastro: " + erro;
			}


		}
		finally {
			bd.close();
		}

		return mensagem;

	}

	public Funcionarios pesquisarFuncionarioBanco(Funcionarios funcionario) {
		String sql = "select * from funcionario where matricula_func = ?";
		bd.getConnection();

		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, funcionario.getMatricula());
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) {
				funcionario.setMatricula(bd.rs.getInt(1));
				funcionario.setNome(bd.rs.getString(2));
				funcionario.setDocFuncionario(bd.rs.getString(3));
				funcionario.setEmail(bd.rs.getString(4));
				funcionario.setTelefone(bd.rs.getString(5));
				funcionario.setEndereco(bd.rs.getString(6));
				funcionario.setCidade(bd.rs.getString(7));
				funcionario.setCargo(bd.rs.getString(8));
				funcionario.setUsuario(bd.rs.getString(9));
				funcionario.setSenha(bd.rs.getString(10));
				funcionario.setAtivo(bd.rs.getString(11));
			}
			else {
				funcionario = null;
			}
		}
		catch(SQLException erro) {
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return funcionario;
	}

	public String atualizarFuncionarioBanco(Funcionarios funcionario) {
		String mensagem;
		bd.getConnection();
		String sql;
		sql = "UPDATE funcionario SET nome_func=?, doc_func=?, email_func=?,telefone_func=?,endereco_func=?,cidade_func=?,cargo_func=?,login_func=?,senha_func=?,ativo_func=? WHERE matricula_func=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, funcionario.getNome());
			bd.st.setString(2, funcionario.getDocFuncionario());
			bd.st.setString(3, funcionario.getEmail() );
			bd.st.setString(4, funcionario.getTelefone());
			bd.st.setString(5, funcionario.getEndereco());
			bd.st.setString(6, funcionario.getCidade());
			bd.st.setString(7, funcionario.getCargo());
			bd.st.setString(8, funcionario.getUsuario());
			bd.st.setString(9, funcionario.getSenha());
			bd.st.setString(10, funcionario.getAtivo());
			bd.st.setInt(11, funcionario.getMatricula());
			bd.st.executeUpdate();
			mensagem = "Funcionario alterado com sucesso";
		}
		catch(SQLException erro) {
			
			if (erro.getErrorCode() == 2627) {
				mensagem = "O login ou senha devem ser unicos!";
			} else {
				mensagem = "Não foi possível concluir o cadastro: " + erro;
			}

		}
		finally{
			bd.close();
		}
		return mensagem;
	}
	
	public String autenticarFuncionario(Funcionarios funcionario) {
		String cargo;
		bd.getConnection();
		String sql;
		sql = "SELECT cargo_func FROM funcionario WHERE login_func =? AND senha_func =?;";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, funcionario.getUsuario());
			bd.st.setString(2, funcionario.getSenha());
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
		        cargo = bd.rs.getString(1);
		    } else {
		        cargo = "";
		    }
			
		}
		catch(SQLException erro) {
			cargo = "";
		}
		return cargo;
	}
	
	public String[] listarFuncionario() {
	    BD bd = new BD();
	    bd.getConnection();
	    String sql = "SELECT count(*) AS funcionarios FROM funcionario";
	    String[] listaFuncionarios = null;
	    try {
	        bd.st = bd.con.prepareStatement(sql);
	        bd.rs = bd.st.executeQuery();
	        if (bd.rs.next()) {
	            int numFuncionarios = bd.rs.getInt("funcionarios");
	            listaFuncionarios = new String[numFuncionarios];
	            
	            bd.rs.close();
	            bd.st.close();
	            
	            sql = "SELECT * FROM funcionario";
	            
	            bd.st = bd.con.prepareStatement(sql);
	            bd.rs = bd.st.executeQuery();
	            
	            int i = 0;
	            while (bd.rs.next()) {
	                listaFuncionarios[i] = Integer.toString(bd.rs.getInt("matricula_func")) + "- " + bd.rs.getString("nome_func");
	                i++;
	            }
	            
	            
	        }
	    } catch (SQLException erro) {
	        System.out.println(erro);
	    } finally {
	        bd.close();
	    }
	    return listaFuncionarios;
	}
}