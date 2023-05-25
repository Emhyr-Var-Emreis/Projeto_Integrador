package controller;


import bancoDeDados.ServicosDAO;

import model.Servico;
import view.paineis.PainelConsultaServico;


public class ConsultarServicoController {
	
	private final PainelConsultaServico viewConsultaServico;

	public ConsultarServicoController(PainelConsultaServico viewConsultaServico) {
		this.viewConsultaServico = viewConsultaServico;
	}
	
	public String pesquisarServico() {
		String mensagem;
		try {
			int codigo = Integer.parseInt(viewConsultaServico.getTxtCodServico().getText());

			Servico servico = new Servico(codigo);

			ServicosDAO servicoDAO = new ServicosDAO();

			servicoDAO.pesquisarServicoBanco(servico);

			if(servicoDAO.pesquisarServicoBanco(servico)!=null) {
				viewConsultaServico.getTxtCodServico().setText(Integer.toString(servico.getCodServico()));
				viewConsultaServico.getTxtNome().setText(servico.getNome());
				viewConsultaServico.getTxtDescricao().setText(servico.getDescricao());
				viewConsultaServico.getTxtValor().setText(Double.toString(servico.getValor()));
				mensagem = "servico encontrado!";
			}
			else {
				mensagem = "Ocorreu um erro ao buscar o servico!";
			}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um código válido!";
		}
		return mensagem;
	}
	
	public String liberarEdicao() {
		String mensagem;
		pesquisarServico();
		if(pesquisarServico().equals("servico encontrado!")) {
			viewConsultaServico.getBtnSalvar().setVisible(!viewConsultaServico.getBtnSalvar().isVisible());
			viewConsultaServico.getTxtNome().setEditable(!viewConsultaServico.getTxtNome().isEditable());
			viewConsultaServico.getTxtCodServico().setEditable(!viewConsultaServico.getTxtCodServico().isEditable());
			viewConsultaServico.getTxtDescricao().setEditable(!viewConsultaServico.getTxtDescricao().isEditable());
			viewConsultaServico.getTxtValor().setEditable(!viewConsultaServico.getTxtValor().isEditable());
			
			mensagem = "Mudando modo de visualização de Cadastro!";
		}
		else {
			mensagem = "Foi encontrado um erro ao entrar no modo de edicão!";
		}
		return mensagem;
	}
	
	public String atualizarServico() {
		String mensagem;
		try {
			int codigo = Integer.parseInt(viewConsultaServico.getTxtCodServico().getText());
			String nome = viewConsultaServico.getTxtNome().getText();
			String descricao = viewConsultaServico.getTxtDescricao().getText();
			Double valor = Double.parseDouble(viewConsultaServico.getTxtValor().getText());
			
			Servico servico = new Servico(codigo, nome, descricao, valor);
			
			ServicosDAO servicoDAO = new ServicosDAO();
			
			mensagem = servicoDAO.atualizarServicoBanco(servico);
			}
			catch(NumberFormatException erro) {
				mensagem = "Por favor digite um valor unitário valido!";
			}
			return mensagem;
		}
		
	}


