package controller;

import bancoDeDados.ClientesDAO;
import bancoDeDados.VeiculosDAO;
import model.Clientes;
import model.Veiculos;
import view.paineis.PainelConsultarVeiculos;

public class ConsultarVeiculoController {
	
	private final PainelConsultarVeiculos viewConsultaVeiculos;
	
	public ConsultarVeiculoController(PainelConsultarVeiculos viewConsultaVeiculos) {
		this.viewConsultaVeiculos = viewConsultaVeiculos;
	}
	
	public String[] listarClientes() {
		ClientesDAO clienteDAO = new ClientesDAO();
		String[] listaClientesAtivos = clienteDAO.listarClientes();
		return listaClientesAtivos;
	}
	
	public String pesquisarVeiculo() {
		String mensagem;
		try {
			int codigo = Integer.parseInt(viewConsultaVeiculos.getTxtCodVeiculo().getText());
			
			Veiculos veiculo = new Veiculos(codigo);
			
			VeiculosDAO veiculoDAO = new VeiculosDAO();
			
			veiculoDAO.pesquisarVeiculoBanco(veiculo);
			
			if(veiculoDAO.pesquisarVeiculoBanco(veiculo)!=null) {
				viewConsultaVeiculos.getTxtCodVeiculo().setText(Integer.toString(veiculo.getCodigoVeiculo()));
				viewConsultaVeiculos.getTxtCor().setText(veiculo.getCor());
				viewConsultaVeiculos.getTxtMarca().setText(veiculo.getMarca());
				viewConsultaVeiculos.getTxtModelo().setText(veiculo.getModelo());
				viewConsultaVeiculos.getTxtPlaca().setText(veiculo.getPlaca());
				viewConsultaVeiculos.getTxtAno().setText(Integer.toString(veiculo.getAno()));
				viewConsultaVeiculos.getListaAtivo().setSelectedItem(veiculo.getAtivo());
				
				String codigoCliente = Integer.toString(veiculo.getCliente().getCodigoCliente()); // Recebe o codigo do cliente para buscar na lista
				for (int i = 0; i < viewConsultaVeiculos.getListaCliente().getItemCount(); i++) { // 
				    String item = (String) viewConsultaVeiculos.getListaCliente().getItemAt(i); // Obtém o item atual e converte para String.
				    if (item.startsWith(codigoCliente)) { // Verifica se o item  começa com o codigo
				        viewConsultaVeiculos.getListaCliente().setSelectedItem(item); // Se sim, seleciona o item atual usando o índice i.
				        break; // Encerra o loop, já que encontrou o item desejado.
				    }
				}
				mensagem = "Veiculo encontrado!";
			}
			else {
				mensagem = "Ocorreu um errao ao buscar o veiculo!";
			}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um código válido!";
		}
		return mensagem;
	}
	
	public String liberarEdicao() {
		String mensagem;
		pesquisarVeiculo();
		if(pesquisarVeiculo().equals("Veiculo encontrado!")) {
			viewConsultaVeiculos.getBtnSalvar().setVisible(!viewConsultaVeiculos.getBtnSalvar().isVisible());
			viewConsultaVeiculos.getTxtCodVeiculo().setEditable(!viewConsultaVeiculos.getTxtCodVeiculo().isEditable());
			viewConsultaVeiculos.getTxtAno().setEditable(!viewConsultaVeiculos.getTxtAno().isEditable());
			viewConsultaVeiculos.getTxtCor().setEditable(!viewConsultaVeiculos.getTxtCor().isEditable());
			viewConsultaVeiculos.getTxtMarca().setEditable(!viewConsultaVeiculos.getTxtMarca().isEditable());
			viewConsultaVeiculos.getTxtModelo().setEditable(!viewConsultaVeiculos.getTxtModelo().isEditable());
			viewConsultaVeiculos.getTxtPlaca().setEditable(!viewConsultaVeiculos.getTxtPlaca().isEditable());
			viewConsultaVeiculos.getListaAtivo().setEnabled(!viewConsultaVeiculos.getListaAtivo().isEnabled());
			viewConsultaVeiculos.getListaCliente().setEnabled(!viewConsultaVeiculos.getListaCliente().isEnabled());
			
			mensagem = "Mudando modo de visualização de Cadastro!";
		}
		else {
			mensagem = "Foi encontrado um erro ao entrar no modo de edicão!";
		}
		return mensagem;
	}
	
	public String atualizarVeiculo(){
		String mensagem;
		
		try {
			int codigo = Integer.parseInt(viewConsultaVeiculos.getTxtCodVeiculo().getText());
			String placa = viewConsultaVeiculos.getTxtPlaca().getText();
			String cor = viewConsultaVeiculos.getTxtCor().getText();
			String modelo = viewConsultaVeiculos.getTxtModelo().getText();
			String marca = viewConsultaVeiculos.getTxtMarca().getText();
			String ativo = (String) viewConsultaVeiculos.getListaAtivo().getSelectedItem();
			int ano = Integer.parseInt(viewConsultaVeiculos.getTxtAno().getText());

			//pegando o codigo do cliente
			String clienteSelecionado = (String) viewConsultaVeiculos.getListaCliente().getSelectedItem();
			int posicaoDoCodigo = clienteSelecionado.indexOf("-");
			int codigoCliente = Integer.parseInt(clienteSelecionado.substring(0, posicaoDoCodigo));

			ClientesDAO clienteDAO = new ClientesDAO();
			if(clienteDAO.clienteAtivo(codigoCliente)==true) {
				Clientes cliente = new Clientes(codigoCliente);
				Veiculos veiculo = new Veiculos(codigo,placa,modelo,marca,ano,cor, cliente, ativo);

				VeiculosDAO veiculoDAO = new VeiculosDAO();
				mensagem = veiculoDAO.atualizarVeiculoBanco(veiculo);}
			else {
				mensagem = "Atenção: O cliente está INATIVO, por favor selecione um cliente ATIVO!";
			}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um ano valido!";
		}
		return mensagem;
	}
}
