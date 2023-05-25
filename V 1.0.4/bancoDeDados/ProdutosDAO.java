package bancoDeDados;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Produtos;

public class ProdutosDAO {
	
	private BD bd = new BD();
	
	public String salvarProdutoBanco(Produtos produto) {
		String mensagem;
		String sql;
		
		bd.getConnection();
		
		sql = "INSERT INTO produto (nome_produto,descricao_produto,valorun_produto,unidade_produto)Values (?,?,?,?)";
		try {
			
			bd.st = bd.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //Retorna o codigo gerado no banco
			bd.st.setString(1, produto.getNome());
			bd.st.setString(2, produto.getDescricao());
			bd.st.setDouble(3, produto.getValorUnitario());
			bd.st.setString(4, produto.getUnidadeMedida());
			
			bd.st.executeUpdate();
			bd.rs = bd.st.getGeneratedKeys();//Recupera o codigo gerado
			
			if(bd.rs.next()) {
				int chavePrimaria = bd.rs.getInt(1);
			mensagem = "Produto Cadastrado com sucesso no código " + chavePrimaria ; //inclui o codigo na mensagem
			}
			else {
				mensagem = "Erro ao encotrar o codigo do Produto cadastrado";
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
	

	public Produtos pesquisarProdutoBanco(Produtos produto) {
		String sql = "select * from produto where cod_produto = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, produto.getCodigoProduto());
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { // se existir proximo siginifica que acho o produto
				produto.setCodigoProduto(bd.rs.getInt(1));
				produto.setNome(bd.rs.getString(2));
				produto.setDescricao(bd.rs.getString(3));
				produto.setValorUnitario(bd.rs.getDouble(4));
				produto.setUnidadeMedida(bd.rs.getString(5));
			}
			else {
				produto = null;
			}

		}
		catch(SQLException erro){
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return produto;
	}
	

	public String atualizarProdutoBanco(Produtos produto) {
		String mensagem;
		bd.getConnection();
		String sql;
		sql = "UPDATE produto SET nome_produto = ?, descricao_produto=?, valorun_produto=?, unidade_produto=? WHERE cod_produto=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, produto.getNome());
			bd.st.setString(2, produto.getDescricao());
			bd.st.setDouble(3, produto.getValorUnitario());
			bd.st.setString(4, produto.getUnidadeMedida());
			bd.st.setInt(5, produto.getCodigoProduto());
			bd.st.executeUpdate();
			mensagem = "Produto alterado com sucesso";

		}

		catch(SQLException erro){
		        mensagem = "Não foi possível alterar o cadastro: " + erro;


		}

		finally {
			bd.close();
		}

		return mensagem;
		
	}

}
