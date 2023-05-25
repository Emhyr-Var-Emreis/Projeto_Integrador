package bancoDeDados;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Funcionarios;
import model.ItemProduto;
import model.ItemServico;
import model.OrdemServico;
import model.Veiculos;

public class OrdemServicoDAO {
	private BD bd = new BD();

	public String salvarOSBanco(OrdemServico ordemServico) {
		String mensagem;
		String sql;

		bd.getConnection();

		sql = "INSERT INTO ordem_servico (data_exec, data_criacao, status_ordem, valor_ordem, cod_veiculo, cod_func) Values (?, GETDATE(), ?, ?, ?, ?)";
		try {
			bd.st = bd.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			Date dataSql = Date.valueOf(ordemServico.getDataExecucao());
			bd.st.setDate(1, dataSql );
			bd.st.setString(2, ordemServico.getStatus());
			bd.st.setDouble(3, ordemServico.getValorTotal());
			bd.st.setInt(4, ordemServico.getVeiculo().getCodigoVeiculo());
			bd.st.setInt(5, ordemServico.getFuncionario().getMatricula());

			bd.st.executeUpdate();
			bd.rs = bd.st.getGeneratedKeys();

			if (bd.rs.next()) {
				int chavePrimaria = bd.rs.getInt(1);
				mensagem = "Ordem cadastrada com sucesso no código " + chavePrimaria;

				bd.getConnection();
				try {
					
					// Inserção dos itens de produto
					String sqlProduto = "INSERT INTO item_produto (cod_produto, cod_ordem, quantidade_item, valor_item) VALUES (?, ?, ?, ?)";
					bd.st = bd.con.prepareStatement(sqlProduto);
					for (ItemProduto itemproduto : ordemServico.getProdutos()) {
					    bd.st.setInt(1, itemproduto.getCodProduto());
					    bd.st.setInt(2, chavePrimaria);
					    bd.st.setInt(3, itemproduto.getQuantidade());
					    bd.st.setDouble(4, itemproduto.getValor());
					    bd.st.executeUpdate();
					}

					// Inserção dos itens de serviço
					String sqlServico = "INSERT INTO item_servico (cod_servico, cod_ordem, qtdHoras, valorTotal) VALUES (?, ?, ?, ?)";
					bd.st = bd.con.prepareStatement(sqlServico);
					for (ItemServico itemServico : ordemServico.getServico()) {
					    bd.st.setInt(1, itemServico.getCodServico());
					    bd.st.setInt(2, chavePrimaria);
					    bd.st.setInt(3, itemServico.getQuantidadeHoras());
					    bd.st.setDouble(4, itemServico.getValorTotal());
					    bd.st.executeUpdate();
					}

				
				} catch (SQLException erro) {
					mensagem = "Falha ao salvar itens da ordem de serviço: " + erro;
				}
			} else {
				mensagem = "Erro ao encontrar o código da ordem cadastrada";
			}
		} catch (SQLException erro) {
			mensagem = "Não foi possível concluir o cadastro: " + erro;
		} finally {
			bd.close();
		}

		return mensagem;
	}

	public OrdemServico pesquisarOrdemServicoBanco(OrdemServico ordemServico) {
		String sql = "select * from ordem_servico where cod_ordem = ?";
		String sqlProdutos = "select * from item_produto where cod_ordem = ?";
		String sqlServico =  "select * from item_servico where cod_ordem = ?";
		bd.getConnection();

		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, ordemServico.getCodServico());
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { 
				// se existir proximo siginifica que acho o produto
				ordemServico.setCodServico(bd.rs.getInt(1));
				ordemServico.setDataExecucao(LocalDate.parse(bd.rs.getString(2)));
				ordemServico.setDataCriacao(LocalDate.parse(bd.rs.getString(3)));
				ordemServico.setStatus(bd.rs.getString(4));
				ordemServico.setValorTotal(bd.rs.getDouble(5));
				ordemServico.setVeiculo(new Veiculos(bd.rs.getInt(6)));
				ordemServico.setFuncionario(new Funcionarios(bd.rs.getInt(7)));

				bd.st = bd.con.prepareStatement(sqlProdutos);
				bd.st.setInt(1, ordemServico.getCodServico());
				bd.rs = bd.st.executeQuery();


				List<ItemProduto>listaProdutos = new ArrayList<>();

				while(bd.rs.next()) {
					ItemProduto itemProduto = new ItemProduto();
					itemProduto.setCodProduto(bd.rs.getInt(1));
					itemProduto.setQuantidade(bd.rs.getInt(3));
					listaProdutos.add(itemProduto);
				}
				ordemServico.setProdutos(listaProdutos);

				bd.st = bd.con.prepareStatement(sqlServico);
				bd.st.setInt(1, ordemServico.getCodServico());
				bd.rs = bd.st.executeQuery();


				List<ItemServico>listaServico = new ArrayList<>();

				while(bd.rs.next()) {
					ItemServico itemServico = new ItemServico();
					itemServico.setCodServico(bd.rs.getInt(1));
					itemServico.setQuantidadeHoras(bd.rs.getInt(3));
					listaServico.add(itemServico);
				}
				ordemServico.setServico(listaServico);

			}
			else {
				ordemServico = null;	
			}
		}
		catch(SQLException erro){
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return ordemServico;
	}
	
	public String atualizarOSBanco(OrdemServico ordemServico) {
		String mensagem;
		bd.getConnection();
		String sql;
		sql = "UPDATE ordem_servico SET data_exec = ?, status_ordem=?, valor_ordem=?, cod_veiculo=?, cod_func=? WHERE cod_ordem=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			
			Date dataSql = Date.valueOf(ordemServico.getDataExecucao());
			bd.st.setDate(1, dataSql);
			bd.st.setString(2, ordemServico.getStatus());
			bd.st.setDouble(3, ordemServico.getValorTotal());
			bd.st.setInt(4, ordemServico.getVeiculo().getCodigoVeiculo());
			bd.st.setInt(5, ordemServico.getFuncionario().getMatricula());
			bd.st.setInt(6, ordemServico.getCodServico());
			bd.st.executeUpdate();
			
			
			mensagem = "OS alterada com sucesso";
			
			try {
				
				// Inserção dos itens de produto
				String sqlProduto = "UPDATE item_produto SET cod_produto = ?, quantidade_item = ?, valor_item = ? WHERE cod_ordem = ?;";
				bd.st = bd.con.prepareStatement(sqlProduto);
				for (ItemProduto itemproduto : ordemServico.getProdutos()) {
				    bd.st.setInt(1, itemproduto.getCodProduto());
				    bd.st.setInt(2, itemproduto.getQuantidade());
				    bd.st.setDouble(3, itemproduto.getValor());
				    bd.st.setInt(4, ordemServico.getCodServico());
				    bd.st.executeUpdate();
				}

				// Inserção dos itens de serviço
				String sqlServico = "UPDATE item_servico SET cod_servico = ?, qtdHoras = ?, valorTotal = ? WHERE cod_ordem = ?;";
				bd.st = bd.con.prepareStatement(sqlServico);
				for (ItemServico itemServico : ordemServico.getServico()) {
				    bd.st.setInt(1, itemServico.getCodServico());
				    bd.st.setInt(2, itemServico.getQuantidadeHoras());
				    bd.st.setDouble(3, itemServico.getValorTotal());
				    bd.st.setInt(4, ordemServico.getCodServico());
				    bd.st.executeUpdate();
				}

			
			} catch (SQLException erro) {
				mensagem = "Falha ao salvar itens da ordem de serviço: " + erro;
			}

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
