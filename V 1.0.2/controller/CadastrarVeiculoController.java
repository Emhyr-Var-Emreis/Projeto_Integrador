package controller;

import bancoDeDados.ClientesDAO;
import bancoDeDados.VeiculosDAO;
import model.Clientes;
import model.Veiculos;
import view.paineis.PainelCadastrarVeiculos;

public class CadastrarVeiculoController {
	private final PainelCadastrarVeiculos viewCadastroVeiculos;

	public CadastrarVeiculoController(PainelCadastrarVeiculos viewCadastroVeiculos){
		this.viewCadastroVeiculos = viewCadastroVeiculos;
	}

	public String[] listarClientes() {
		ClientesDAO clienteDAO = new ClientesDAO();
		String[] listaClientesAtivos = clienteDAO.listarClientes();
		return listaClientesAtivos;
	}

	public String salvarVeiculo(){
		String mensagem;

		try {
			String placa = viewCadastroVeiculos.getTxtPlaca().getText();
			String cor = viewCadastroVeiculos.getTxtCor().getText();
			String modelo = viewCadastroVeiculos.getTxtModelo().getText();
			String marca = viewCadastroVeiculos.getTxtMarca().getText();
			int ano = Integer.parseInt(viewCadastroVeiculos.getTxtAno().getText());

			//pegando o codigo do cliente
			String clienteSelecionado = (String) viewCadastroVeiculos.getListaCliente().getSelectedItem();
			int posicaoDoCodigo = clienteSelecionado.indexOf("-");
			int codigoCliente = Integer.parseInt(clienteSelecionado.substring(0, posicaoDoCodigo));

			ClientesDAO clienteDAO = new ClientesDAO();
			if(clienteDAO.clienteAtivo(codigoCliente)==true) {
				Clientes cliente = new Clientes(codigoCliente);
				Veiculos veiculo = new Veiculos(placa, modelo, marca, ano, cor, cliente);

				VeiculosDAO veiculoDAO = new VeiculosDAO();
				mensagem = veiculoDAO.salvarVeiculo(veiculo);}
			else {
				mensagem = "Atenção: O cliente está INATIVO, por favor selecione um cliente ATIVO!";
			}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um ano valido!";
		}
		return mensagem;
	}

	public void limpar() {
		viewCadastroVeiculos.getTxtPlaca().setText("");
		viewCadastroVeiculos.getTxtCor().setText("");
		viewCadastroVeiculos.getTxtModelo().setText("");
		viewCadastroVeiculos.getTxtMarca().setText("");
		viewCadastroVeiculos.getTxtAno().setText("");
	}
}
