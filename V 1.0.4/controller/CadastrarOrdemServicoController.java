package controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bancoDeDados.FuncionarioDAO;
import bancoDeDados.OrdemServicoDAO;
import bancoDeDados.ProdutosDAO;
import bancoDeDados.ServicosDAO;
import bancoDeDados.VeiculosDAO;
import model.Funcionarios;
import model.ItemProduto;
import model.ItemServico;
import model.OrdemServico;
import model.Produtos;
import model.Servico;
import model.Veiculos;
import view.paineis.PainelCadastrarOrdemServico;

public class CadastrarOrdemServicoController {
	private final PainelCadastrarOrdemServico viewCadastroOrdemServico;

	public CadastrarOrdemServicoController(PainelCadastrarOrdemServico viewCadastroOrdemServico) {
		this.viewCadastroOrdemServico = viewCadastroOrdemServico;
	}

	public String[] listarVeiculos() {
		VeiculosDAO veiculoDAO = new VeiculosDAO();
		String[] listaVeiculos = veiculoDAO.listarVeiculos();
		return listaVeiculos;
	}

	public String[] listarFuncionarios() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		String[] listaFuncionarios = funcionarioDAO.listarFuncionario();
		return listaFuncionarios;
	}


	public void incluirServico() {
		// Cria o JOptionPane com os campos para o usuário digitar os dados
		JTextField codigoCampo = new JTextField();
		JTextField horasCampo = new JTextField();
		Object[] fields = {
				"Código:", codigoCampo,
				"Horas Trabalhadas", horasCampo,
		};
		int result = JOptionPane.showConfirmDialog(null, fields, "Incluir servico", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {

			try {
				// Obtém os dados digitados pelo usuário
				int codigo = Integer.parseInt(codigoCampo.getText());
				int horas = Integer.parseInt(horasCampo.getText());

				//verifica se código já foi inserido
				List<String[]>dadosTabela = getDadosTabelaServico();
				boolean codigoExiste = false;

				for (String[] array : dadosTabela) {

					if (codigo==Integer.parseInt(array[0])) {
						JOptionPane.showMessageDialog(null, "O serviço com o código " + codigo + " já existe na tabela.");
						codigoExiste = true;
						break; // Sai do loop se o código já existe
					}
				}

				if (!codigoExiste) {
					Servico servico = new Servico(codigo);
					ServicosDAO servicosDAO = new ServicosDAO();
					servicosDAO.pesquisarServicoBanco(servico);
					if(servicosDAO.pesquisarServicoBanco(servico)!=null) {
						String codigoServico = Integer.toString(servico.getCodServico());
						String nomeServico = servico.getNome();
						String valorServico = Double.toString(servico.getValor());
						String horasServico = Integer.toString(horas);
						String valorTotalServico = Double.toString(servico.getValor()*horas);

						// Adiciona os dados ao modelo de tabela
						viewCadastroOrdemServico.getTabelaServico().getModel().addRow(new String[]{codigoServico, nomeServico,valorServico, horasServico, valorTotalServico});
						//Atualliza campos de valor


						double valorTotal = 0;
						dadosTabela = getDadosTabelaServico();
						for (String[] array : dadosTabela) {
							valorTotal += Double.parseDouble(array[4]); // Obter o terceiro elemento do array
						}

						viewCadastroOrdemServico.getTxtValorServico().setText(Double.toString(valorTotal));

					}
					else {
						JOptionPane.showMessageDialog(null, "Produto não econtrado!");
					}

				}


			}
			catch(NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Por favor digite valores válidos");
			}
		}
	}

	public void retirarServico() {
		// Obtém a linha selecionada
		int linhaSelecionada = viewCadastroOrdemServico.getTabelaServico().getTable().getSelectedRow();
		// Remove a linha do modelo de tabela
		if (linhaSelecionada >= 0) {
			viewCadastroOrdemServico.getTabelaServico().getModel().removeRow(linhaSelecionada);
			List<String[]>dadosTabela = getDadosTabelaServico();

			double valorTotal = 0;

			for (String[] array : dadosTabela) {
				valorTotal += Double.parseDouble(array[2]); // Obter o terceiro elemento do array
			}
			viewCadastroOrdemServico.getTxtValorServico().setText(Double.toString(valorTotal));
		}
	}

	public List<String[]> getDadosTabelaServico() {
		List<String[]> dados = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) viewCadastroOrdemServico.getTabelaServico().getModel();
		int quantidadeLinhas = model.getRowCount();
		int quanitdadeColunas = model.getColumnCount();

		for (int row = 0; row < quantidadeLinhas; row++) {
			String[] dadosLinha = new String[quanitdadeColunas];
			for (int col = 0; col < quanitdadeColunas; col++) {
				dadosLinha[col] = model.getValueAt(row, col).toString();
			}
			dados.add(dadosLinha);
		}

		return dados;
	}

	public void incluirProduto() {
		// Cria o JOptionPane com os campos para o usuário digitar os dados
		JTextField codigoCampo = new JTextField();
		JTextField quantidadeCampo = new JTextField();
		Object[] fields = {
				"Código:", codigoCampo,
				"Quantidade:", quantidadeCampo,
		};
		int result = JOptionPane.showConfirmDialog(null, fields, "Incluir produto", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {

			try {
				// Obtém os dados digitados pelo usuário
				int codigo = Integer.parseInt(codigoCampo.getText());
				int quantidade = Integer.parseInt(quantidadeCampo.getText());

				List<String[]>dadosTabela = getDadosTabelaProduto();
				boolean codigoExiste = false;

				for (String[] array : dadosTabela) {

					if (codigo==Integer.parseInt(array[0])) {
						JOptionPane.showMessageDialog(null, "O produto com o código " + codigo + " já existe na tabela.");
						codigoExiste = true;
						break; // Sai do loop se o código já existe
					}
				}

				if (!codigoExiste) {

					Produtos produtos = new Produtos(codigo);
					ProdutosDAO produtosDAO = new ProdutosDAO();
					produtosDAO.pesquisarProdutoBanco(produtos);
					if(produtosDAO.pesquisarProdutoBanco(produtos)!=null) {
						String codigoProduto = Integer.toString(produtos.getCodigoProduto());
						String nomeProduto = produtos.getNome();
						String unidadeProduto = produtos.getUnidadeMedida();
						String quantidadeProduto = Integer.toString(quantidade);
						String valorUnitario = Double.toString(produtos.getValorUnitario());
						String valorTotal = Double.toString(produtos.getValorUnitario()*quantidade);


						// Adiciona os dados ao modelo de tabela
						viewCadastroOrdemServico.getTabelaProdutos().getModel().addRow(new String[]{codigoProduto,nomeProduto,unidadeProduto, quantidadeProduto, valorUnitario,valorTotal});

						//Atualizando Campo valor

						dadosTabela = getDadosTabelaProduto();
						double valorTotalProdutos = 0;

						for (String[] array : dadosTabela) {
							valorTotalProdutos += Double.parseDouble(array[5]); // Obter o terceiro elemento do array
						}
						
						

						viewCadastroOrdemServico.getTxtValorProduto().setText(Double.toString(valorTotalProdutos));
					}
					else {
						JOptionPane.showMessageDialog(null, "Produto não econtrado!");
					}

				}
			}
			catch(NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Por favor digite valores válidos");
			}
		}
	}

	public List<String[]> getDadosTabelaProduto() {
		List<String[]> dados = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) viewCadastroOrdemServico.getTabelaProdutos().getModel();
		int quantidadeLinhas = model.getRowCount();
		int quanitdadeColunas = model.getColumnCount();

		for (int row = 0; row < quantidadeLinhas; row++) {
			String[] dadosLinha = new String[quanitdadeColunas];
			for (int col = 0; col < quanitdadeColunas; col++) {
				dadosLinha[col] = model.getValueAt(row, col).toString();
			}
			dados.add(dadosLinha);
		}

		return dados;
	}

	public void retirarProdutos() {
		// Obtém a linha selecionada
		int linhaSelecionada = viewCadastroOrdemServico.getTabelaProdutos().getTable().getSelectedRow();
		// Remove a linha do modelo de tabela
		if (linhaSelecionada >= 0) {
			viewCadastroOrdemServico.getTabelaProdutos().getModel().removeRow(linhaSelecionada);
			List<String[]>dadosTabela = getDadosTabelaProduto();

			double valorTotalProdutos = 0;

			for (String[] array : dadosTabela) {
				valorTotalProdutos += Double.parseDouble(array[5]); // Obter o terceiro elemento do array
			}
			viewCadastroOrdemServico.getTxtValorProduto().setText(Double.toString(valorTotalProdutos));

			viewCadastroOrdemServico.getTxtValorTotal().setText(Double.toString(valorTotalProdutos));
		}
	}

	public void atualizarValorTotal() {
		double valorProdutos = Double.parseDouble(viewCadastroOrdemServico.getTxtValorProduto().getText());
		double valorServicos = Double.parseDouble(viewCadastroOrdemServico.getTxtValorServico().getText());
		double valorFinal = valorProdutos + valorServicos;
		viewCadastroOrdemServico.getTxtValorTotal().setText(Double.toString(valorFinal));
	}

	public String salvarOS() {
		String mensagem;

		try {

			String status = (String) viewCadastroOrdemServico.getlistaStatus().getSelectedItem();

			String veiculoSelecionado = (String) viewCadastroOrdemServico.getlistaVeiculo().getSelectedItem();
			int posicaoDoCodigoVeiculo = veiculoSelecionado.indexOf("-");
			int codigoVeiculo = Integer.parseInt(veiculoSelecionado.substring(0, posicaoDoCodigoVeiculo));
			Veiculos veiculo = new Veiculos(codigoVeiculo);

			String funcionarioSelecionado = (String) viewCadastroOrdemServico.getlistaFuncionario().getSelectedItem();
			int posicaoDoCodigoFuncionario = funcionarioSelecionado.indexOf("-");
			int codigoFuncionario = Integer.parseInt(funcionarioSelecionado.substring(0, posicaoDoCodigoFuncionario));
			Funcionarios funcionario = new Funcionarios(codigoFuncionario);

			int dia = Integer.parseInt(viewCadastroOrdemServico.getTxtDiaExecucao().getText());
			int mes = Integer.parseInt(viewCadastroOrdemServico.getTxtMesExecucao().getText());
			int ano = Integer.parseInt(viewCadastroOrdemServico.getTxtAnoExecucao().getText());
			Double valorTotal = Double.parseDouble(viewCadastroOrdemServico.getTxtValorTotal().getText());
			LocalDate dataOS = LocalDate.of(ano, mes, dia);




			//Construindo as listas com os itens
			List<String[]>dadosTabelaProduto = getDadosTabelaProduto();
			List<ItemProduto>produtosTabela = new ArrayList<>();

			for (String[] array : dadosTabelaProduto) {
				ItemProduto itemProduto = new ItemProduto(); // Mova a criação do objeto para dentro do loop

				itemProduto.setCodProduto(Integer.parseInt(array[0]));
				itemProduto.setQuantidade(Integer.parseInt(array[3]));
				itemProduto.setValor(Double.parseDouble(array[5]));
				produtosTabela.add(itemProduto);
			}


			List<String[]>dadosTabelaServico = getDadosTabelaServico();
			List<ItemServico>servicoTabela = new ArrayList<>();

			for (String[] array : dadosTabelaServico) {
				ItemServico itemServico = new ItemServico(); // Mova a criação do objeto para dentro do loop

				itemServico.setCodServico(Integer.parseInt(array[0]));
				itemServico.setQuantidadeHoras(Integer.parseInt(array[3]));
				itemServico.setValorTotal(Double.parseDouble(array[4]));
				servicoTabela.add(itemServico);
			}

			OrdemServico ordemServico = new OrdemServico(status, dataOS,veiculo, funcionario, valorTotal, produtosTabela, servicoTabela);


			VeiculosDAO veiculoDAO = new VeiculosDAO();
			if(veiculoDAO.veiculoAtivo(codigoVeiculo)==true) {


				OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
				mensagem = ordemServicoDAO.salvarOSBanco(ordemServico);}
			else {
				mensagem = "Atenção: O veiculo está INATIVO, por favor selecione um veiculo ATIVO!";
			}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite valores válidos!";
		}
		catch(DateTimeException e) {
			mensagem = "Por favor digite uma data válida!";
		}
		return mensagem;

	}
}
