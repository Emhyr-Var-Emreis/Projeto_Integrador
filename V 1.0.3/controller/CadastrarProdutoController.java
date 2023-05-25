package controller;

import bancoDeDados.ProdutosDAO;
import model.Produtos;
import view.paineis.PainelCadastrarProdutos;

public class CadastrarProdutoController {
	
	private final PainelCadastrarProdutos viewCadastroProdutos;
	
	public CadastrarProdutoController(PainelCadastrarProdutos viewCadastroProduto) {
		this.viewCadastroProdutos = viewCadastroProduto;
	}
	
	public String salvarProduto() {
		String mensagem;
		try {
		String nome = viewCadastroProdutos.getTxtNome().getText();
		String descricao = viewCadastroProdutos.getTxtDescricao().getText();
		Double valorUnitario = Double.parseDouble(viewCadastroProdutos.getTxtValorUnitario().getText());
		String unidadeMedida = viewCadastroProdutos.getTxtUnidadeMedida().getText();
		
		Produtos produto = new Produtos(nome, valorUnitario, descricao, unidadeMedida);
		
		ProdutosDAO produtoDAO = new ProdutosDAO();
		
		mensagem = produtoDAO.salvarProdutoBanco(produto);
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um valor unitário valido!";
		}
		return mensagem;
	}
	
	public void limpar() {
		viewCadastroProdutos.getTxtNome().setText("");
		viewCadastroProdutos.getTxtDescricao().setText("");
		viewCadastroProdutos.getTxtValorUnitario().setText("");
		viewCadastroProdutos.getTxtUnidadeMedida().setText("");
	}
}
