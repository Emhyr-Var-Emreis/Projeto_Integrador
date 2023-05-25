package bancoDeDados;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Clientes;
import model.Veiculos;

public class VeiculosDAO {

	private BD bd = new BD();

	public String salvarVeiculo(Veiculos veiculo) {
		String mensagem;
		String sql;

		bd.getConnection();

		sql = "INSERT INTO veiculo (placa_veiculo,cor_veiculo,modelo_veiculo,marca_veiculo,ano_veiculo,cod_cliente)Values (?,?,?,?,?,?)";
		try {

			bd.st = bd.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //Retorna o codigo gerado no banco
			bd.st.setString(1, veiculo.getPlaca());
			bd.st.setString(2, veiculo.getCor() );
			bd.st.setString(3, veiculo.getModelo());
			bd.st.setString(4, veiculo.getMarca());
			bd.st.setInt(5, veiculo.getAno());
			bd.st.setInt(6, veiculo.getCliente().getCodigoCliente());

			bd.st.executeUpdate();
			bd.rs = bd.st.getGeneratedKeys();//Recupera o codigo gerado

			if(bd.rs.next()) {
				int chavePrimaria = bd.rs.getInt(1);
				mensagem = "Veiculo Cadastrado com sucesso no código " + chavePrimaria ; //inclui o codigo na mensagem
			}
			else {
				mensagem = "Erro ao encotrar o codigo do veiculo cadastrado";
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

	public Veiculos pesquisarVeiculoBanco(Veiculos veiculo) {
		String sql = "select * from veiculo where cod_veiculo = ?";
		bd.getConnection();

		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, veiculo.getCodigoVeiculo());
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { // se existir proximo siginifica que acho o produto
				veiculo.setCodigoVeiculo(bd.rs.getInt(1));
				veiculo.setPlaca(bd.rs.getString(2));
				veiculo.setCor(bd.rs.getString(3));
				veiculo.setModelo(bd.rs.getString(4));
				veiculo.setMarca(bd.rs.getString(5));
				veiculo.setAno(bd.rs.getInt(6));
				veiculo.setAtivo(bd.rs.getString(7));
				veiculo.setCliente(new Clientes(bd.rs.getInt(8)));
			}
			else {
				veiculo = null;	
			}
		}
		catch(SQLException erro){
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return veiculo;
	}
	
	public String atualizarVeiculoBanco(Veiculos veiculo) {
		String mensagem;
		bd.getConnection();
		String sql;
		sql = "UPDATE veiculo SET placa_veiculo = ?, cor_veiculo=?, modelo_veiculo=?, marca_veiculo=?, ano_veiculo=?, ativo_veiculo=?, cod_cliente=? WHERE cod_veiculo=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, veiculo.getPlaca());
			bd.st.setString(2, veiculo.getCor() );
			bd.st.setString(3, veiculo.getModelo());
			bd.st.setString(4, veiculo.getMarca());
			bd.st.setInt(5, veiculo.getAno());
			bd.st.setString(6, veiculo.getAtivo());
			bd.st.setInt(7, veiculo.getCliente().getCodigoCliente());
			bd.st.setInt(8, veiculo.getCodigoVeiculo());
			bd.st.executeUpdate();
			mensagem = "Veiculo alterado com sucesso";

		}

		catch(SQLException erro){
		        mensagem = "Não foi possível alterar o cadastro: " + erro;


		}

		finally {
			bd.close();
		}

		return mensagem;
		
	}

	public String[] listarVeiculos() {
	    BD bd = new BD();
	    bd.getConnection();
	    String sql = "SELECT count(*) AS veiculos FROM veiculo";
	    String[] listaVeiculos = null;
	    try {
	        bd.st = bd.con.prepareStatement(sql);
	        bd.rs = bd.st.executeQuery();
	        if (bd.rs.next()) {
	            int numVeiculo = bd.rs.getInt("veiculos");
	            listaVeiculos = new String[numVeiculo];
	            
	            bd.rs.close();
	            bd.st.close();
	            
	            sql = "SELECT * FROM veiculo";
	            
	            bd.st = bd.con.prepareStatement(sql);
	            bd.rs = bd.st.executeQuery();
	            
	            int i = 0;
	            while (bd.rs.next()) {
	                listaVeiculos[i] = Integer.toString(bd.rs.getInt("cod_veiculo")) + "- " + bd.rs.getString("placa_veiculo");
	                i++;
	            }
	            
	            
	        }
	    } catch (SQLException erro) {
	        System.out.println(erro);
	    } finally {
	        bd.close();
	    }
	    return listaVeiculos;
	}
	
	public boolean veiculoAtivo(int codigo) {
		String veiculoAtivo;
		boolean resultado = false;
		String sql = "SELECT ativo_veiculo FROM veiculo WHERE cod_veiculo = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) { // se existir proximo siginifica que acho o produto
				veiculoAtivo = bd.rs.getString(1);
				if(veiculoAtivo.equals("Sim")||veiculoAtivo.equals("sim")) {
					resultado = true;
				}
			}
			else {
				 veiculoAtivo = null;
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


