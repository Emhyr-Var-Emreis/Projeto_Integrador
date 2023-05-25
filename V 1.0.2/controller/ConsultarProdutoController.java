package controller;

import bancoDeDados.ProdutosDAO;
import model.Produtos;
import view.paineis.PainelConsultarProdutos;

public class ConsultarProdutoController {

	private final PainelConsultarProdutos viewConsultaProdutos;

	public ConsultarProdutoController(PainelConsultarProdutos viewConsultaProdutos) {
		this.viewConsultaProdutos = viewConsultaProdutos;
	}

	public String pesquisarProduto() {
		String mensagem;
		try {
			int codigo = Integer.parseInt(viewConsultaProdutos.getTxtCodProduto().getText());

			Produtos produto = new Produtos(codigo);

			ProdutosDAO produtoDAO = new ProdutosDAO();

			produtoDAO.pesquisarProdutoBanco(produto);

			if(produtoDAO.pesquisarProdutoBanco(produto)!=null) {
				viewConsultaProdutos.getTxtCodProduto().setText(Integer.toString(produto.getCodigoProduto()));
				viewConsultaProdutos.getTxtNome().setText(produto.getNome());
				viewConsultaProdutos.getTxtDescricao().setText(produto.getDescricao());
				viewConsultaProdutos.getTxtUnidadeMedida().setText(produto.getUnidadeMedida());
				viewConsultaProdutos.getTxtValorUnitario().setText(Double.toString(produto.getValorUnitario()));
				mensagem = "Produto encontrado!";
			}
			else {
				mensagem = "Ocorreu um erro ao buscar o Produto!";
			}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um código válido!";
		}
		return mensagem;
	}
	
	public String liberarEdicao() {
		String mensagem;
		pesquisarProduto();
		if(pesquisarProduto().equals("Produto encontrado!")) {
			viewConsultaProdutos.getBtnSalvar().setVisible(!viewConsultaProdutos.getBtnSalvar().isVisible());
			viewConsultaProdutos.getTxtNome().setEditable(!viewConsultaProdutos.getTxtNome().isEditable());
			viewConsultaProdutos.getTxtCodProduto().setEditable(!viewConsultaProdutos.getTxtCodProduto().isEditable());
			viewConsultaProdutos.getTxtDescricao().setEditable(!viewConsultaProdutos.getTxtDescricao().isEditable());
			viewConsultaProdutos.getTxtUnidadeMedida().setEditable(!viewConsultaProdutos.getTxtUnidadeMedida().isEditable());
			viewConsultaProdutos.getTxtValorUnitario().setEditable(!viewConsultaProdutos.getTxtValorUnitario().isEditable());
			
			mensagem = "Mudando modo de visualização de Cadastro!";
		}
		else {
			mensagem = "Foi encontrado um erro ao entrar no modo de edicão!";
		}
		return mensagem;
	}
	
	public String atualizarProduto() {
		String mensagem;
		try {
			int codigo = Integer.parseInt(viewConsultaProdutos.getTxtCodProduto().getText());
			String nome = viewConsultaProdutos.getTxtNome().getText();
			String descricao = viewConsultaProdutos.getTxtDescricao().getText();
			Double valorUnitario = Double.parseDouble(viewConsultaProdutos.getTxtValorUnitario().getText());
			String unidadeMedida = viewConsultaProdutos.getTxtUnidadeMedida().getText();
			
			Produtos produto = new Produtos(codigo, nome, valorUnitario, descricao, unidadeMedida);
			
			ProdutosDAO produtoDAO = new ProdutosDAO();
			
			mensagem = produtoDAO.atualizarProdutoBanco(produto);
			}
			catch(NumberFormatException erro) {
				mensagem = "Por favor digite um valor unitário valido!";
			}
			return mensagem;
		}
		
	}

