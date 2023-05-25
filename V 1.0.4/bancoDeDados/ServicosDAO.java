package bancoDeDados;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;


import model.Servico;

public class ServicosDAO {
	
	private BD bd = new BD();
	
	public String salvarServicoBanco(Servico servico) {
		String mensagem;
		String sql;
		
		bd.getConnection();
		
		sql = "INSERT INTO servico (nome_servico,descricao_servico,valor_servico)Values (?,?,?)";
		try {
			
			bd.st = bd.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //Retorna o codigo gerado no banco
			bd.st.setString(1, servico.getNome());
			bd.st.setString(2, servico.getDescricao());
			bd.st.setDouble(3, servico.getValor());
			
			bd.st.executeUpdate();
			bd.rs = bd.st.getGeneratedKeys();//Recupera o codigo gerado
			
			if(bd.rs.next()) {
				int chavePrimaria = bd.rs.getInt(1);
			mensagem = "Servico Cadastrado com sucesso no código " + chavePrimaria ; //inclui o codigo na mensagem
			}
			else {
				mensagem = "Erro ao encotrar o codigo do Servico cadastrado";
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
	
	public String atualizarServicoBanco(Servico servico) {
		String mensagem;
		bd.getConnection();
		String sql;
		sql = "UPDATE servico SET nome_servico = ?, descricao_servico=?, valor_servico=? WHERE cod_servico=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, servico.getNome());
			bd.st.setString(2, servico.getDescricao());
			bd.st.setDouble(3, servico.getValor());
			bd.st.setInt(4, servico.getCodServico());
			bd.st.executeUpdate();
			mensagem = "Serviço alterado com sucesso";

		}

		catch(SQLException erro){
		        mensagem = "Não foi possível alterar o cadastro: " + erro;


		}

		finally {
			bd.close();
		}

		return mensagem;
		
	}
	
	public Servico pesquisarServicoBanco(Servico servico) {
		String sql = "select * from Servico where cod_Servico = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, servico.getCodServico());
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { // se existir proximo siginifica que acho o Servico
				servico.setCodServico(bd.rs.getInt(1));
				servico.setNome(bd.rs.getString(2));
				servico.setDescricao(bd.rs.getString(3));
				servico.setValor(bd.rs.getDouble(4));
			}
			else {
				servico = null;
			}

		}
		catch(SQLException erro){
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return servico;
	}
	
}


