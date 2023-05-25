package controller;


import bancoDeDados.ServicosDAO;

import model.Servico;

import view.paineis.PainelCadastrarServico;

public class CadastrarServicoController {
	
	private final PainelCadastrarServico viewCadastroServico;
	
	public CadastrarServicoController(PainelCadastrarServico viewCadastroProduto) {
		this.viewCadastroServico = viewCadastroProduto;
	}
	
	public String salvarServico() {
		String mensagem;
		try {
		String nome = viewCadastroServico.getTxtNome().getText();
		String descricao = viewCadastroServico.getTxtDescricao().getText();
		Double valor = Double.parseDouble(viewCadastroServico.getTxtValor().getText());
		
		
		Servico Servico = new Servico(nome, descricao, valor);
		
		ServicosDAO ServicoDAO = new ServicosDAO();
		
		mensagem = ServicoDAO.salvarServicoBanco(Servico);
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um valor unitário valido!";
		}
		return mensagem;
	}
	
	public void limpar() {
		viewCadastroServico.getTxtNome().setText("");
		viewCadastroServico.getTxtDescricao().setText("");
		viewCadastroServico.getTxtValor().setText("");
	}

}
