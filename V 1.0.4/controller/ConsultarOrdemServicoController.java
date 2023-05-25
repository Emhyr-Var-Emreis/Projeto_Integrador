package controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bancoDeDados.ClientesDAO;
import bancoDeDados.FuncionarioDAO;
import bancoDeDados.OrdemServicoDAO;
import bancoDeDados.ProdutosDAO;
import bancoDeDados.ServicosDAO;
import bancoDeDados.VeiculosDAO;
import model.Clientes;
import model.Funcionarios;
import model.ItemProduto;
import model.ItemServico;
import model.OrdemServico;
import model.Produtos;
import model.Servico;
import model.Veiculos;
import view.paineis.PainelCadastrarOrdemServico;
import view.paineis.PainelConsultaOrdemServico;

public class ConsultarOrdemServicoController {
	private final PainelConsultaOrdemServico viewConsultarOrdemServico;

	public ConsultarOrdemServicoController(PainelConsultaOrdemServico viewConsultarOrdemServico) {
		this.viewConsultarOrdemServico = viewConsultarOrdemServico;
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
								viewConsultarOrdemServico.getTabelaServico().getModel().addRow(new String[]{codigoServico, nomeServico,valorServico, horasServico, valorTotalServico});
								//Atualliza campos de valor

								
								dadosTabela = getDadosTabelaServico();
								
								double valorTotal = 0;

								for (String[] array : dadosTabela) {
									valorTotal += Double.parseDouble(array[4]); // Obter o terceiro elemento do array
								}

								viewConsultarOrdemServico.getTxtValorServico().setText(Double.toString(valorTotal));

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
		int linhaSelecionada = viewConsultarOrdemServico.getTabelaServico().getTable().getSelectedRow();
		// Remove a linha do modelo de tabela
		if (linhaSelecionada >= 0) {
			viewConsultarOrdemServico.getTabelaServico().getModel().removeRow(linhaSelecionada);
			List<String[]>dadosTabela = getDadosTabelaServico();

			double valorTotal = 0;

			for (String[] array : dadosTabela) {
				valorTotal += Double.parseDouble(array[2]); // Obter o terceiro elemento do array
			}
			viewConsultarOrdemServico.getTxtValorServico().setText(Double.toString(valorTotal));
		}
	}

	public List<String[]> getDadosTabelaServico() {
		List<String[]> dados = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) viewConsultarOrdemServico.getTabelaServico().getModel();
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
								viewConsultarOrdemServico.getTabelaProdutos().getModel().addRow(new String[]{codigoProduto,nomeProduto,unidadeProduto, quantidadeProduto, valorUnitario,valorTotal});

								//Atualizando Campo valor


								double valorTotalProdutos = 0;
								dadosTabela = getDadosTabelaProduto();
								
								for (String[] array : dadosTabela) {
									valorTotalProdutos += Double.parseDouble(array[5]); // Obter o terceiro elemento do array
								}

								viewConsultarOrdemServico.getTxtValorProduto().setText(Double.toString(valorTotalProdutos));
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
		DefaultTableModel model = (DefaultTableModel) viewConsultarOrdemServico.getTabelaProdutos().getModel();
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
		int linhaSelecionada = viewConsultarOrdemServico.getTabelaProdutos().getTable().getSelectedRow();
		// Remove a linha do modelo de tabela
		if (linhaSelecionada >= 0) {
			viewConsultarOrdemServico.getTabelaProdutos().getModel().removeRow(linhaSelecionada);
			List<String[]>dadosTabela = getDadosTabelaProduto();

			double valorTotalProdutos = 0;

			for (String[] array : dadosTabela) {
				valorTotalProdutos += Double.parseDouble(array[5]); // Obter o terceiro elemento do array
			}
			viewConsultarOrdemServico.getTxtValorProduto().setText(Double.toString(valorTotalProdutos));

			viewConsultarOrdemServico.getTxtValorTotal().setText(Double.toString(valorTotalProdutos));
		}
	}

	public void atualizarValorTotal() {
		double valorProdutos = Double.parseDouble(viewConsultarOrdemServico.getTxtValorProduto().getText());
		double valorServicos = Double.parseDouble(viewConsultarOrdemServico.getTxtValorServico().getText());
		double valorFinal = valorProdutos + valorServicos;
		viewConsultarOrdemServico.getTxtValorTotal().setText(Double.toString(valorFinal));
	}

	public String pesquisarOS() {
		String mensagem;
		try {
			int codigo = Integer.parseInt(viewConsultarOrdemServico.getTxtCodOs().getText());
			
			viewConsultarOrdemServico.getTabelaServico().getModel().setRowCount(0);
			viewConsultarOrdemServico.getTabelaProdutos().getModel().setRowCount(0);
			

			OrdemServico ordemServico = new OrdemServico(codigo);

			OrdemServicoDAO ordemServicoDao = new OrdemServicoDAO();

			ordemServicoDao.pesquisarOrdemServicoBanco(ordemServico);

			if(ordemServicoDao.pesquisarOrdemServicoBanco(ordemServico)!=null) {
				viewConsultarOrdemServico.getTxtCodOs().setText(Integer.toString(ordemServico.getCodServico()));
				
				
				String diaExecucao = String.valueOf(ordemServico.getDataExecucao().getDayOfMonth());
				String mesExecucao = String.valueOf(ordemServico.getDataExecucao().getMonthValue());
				String anoExecucao = String.valueOf(ordemServico.getDataExecucao().getYear());
				
				viewConsultarOrdemServico.getTxtAnoExecucao().setText(anoExecucao);
				viewConsultarOrdemServico.getTxtMesExecucao().setText(mesExecucao);
				viewConsultarOrdemServico.getTxtDiaExecucao().setText(diaExecucao);
				
				String diaCriacao = String.valueOf(ordemServico.getDataCriacao().getDayOfMonth());
				String mesCriacao = String.valueOf(ordemServico.getDataCriacao().getMonthValue());
				String anoCriacao = String.valueOf(ordemServico.getDataCriacao().getYear());
				
				viewConsultarOrdemServico.getTxtAnoCriacao().setText(anoCriacao);
				viewConsultarOrdemServico.getTxtMesCriacao().setText(mesCriacao);
				viewConsultarOrdemServico.getTxtDiaCriacao().setText(diaCriacao);
				

				String codigoVeiculo = Integer.toString(ordemServico.getVeiculo().getCodigoVeiculo()); // Recebe o codigo do cliente para buscar na lista
				for (int i = 0; i < viewConsultarOrdemServico.getlistaVeiculo().getItemCount(); i++) { // 
					String item = (String) viewConsultarOrdemServico.getListaVeiculo().getItemAt(i); // Obtém o item atual e converte para String.
					if (item.startsWith(codigoVeiculo)) { // Verifica se o item  começa com o codigo
						viewConsultarOrdemServico.getListaVeiculo().setSelectedItem(item); // Se sim, seleciona o item atual usando o índice i.
						break; // Encerra o loop, já que encontrou o item desejado.
					}
				}

				String codigoFuncioanrio = Integer.toString(ordemServico.getFuncionario().getMatricula()); // Recebe o codigo do cliente para buscar na lista
				for (int i = 0; i < viewConsultarOrdemServico.getlistaFuncionario().getItemCount(); i++) { // 
					String item = (String) viewConsultarOrdemServico.getListaFuncionario().getItemAt(i); // Obtém o item atual e converte para String.
					if (item.startsWith(codigoFuncioanrio)) { // Verifica se o item  começa com o codigo
						viewConsultarOrdemServico.getListaFuncionario().setSelectedItem(item); // Se sim, seleciona o item atual usando o índice i.
						break; // Encerra o loop, já que encontrou o item desejado.
					}
				}
				
				List<ItemServico>listaServico = ordemServico.getServico();
				
				int i = 0;



				for (ItemServico itemServico : listaServico) {

					int codigoItemServico = listaServico.get(i).getCodServico();
					int horas = listaServico.get(i).getQuantidadeHoras();

					Servico servico = new Servico(codigoItemServico);
					ServicosDAO servicosDAO = new ServicosDAO();
					servicosDAO.pesquisarServicoBanco(servico);
					if(servicosDAO.pesquisarServicoBanco(servico)!=null) {
						String codigoServico = Integer.toString(servico.getCodServico());
						String nomeServico = servico.getNome();
						String valorServico = Double.toString(servico.getValor());
						String horasServico = Integer.toString(horas);
						String valorTotalServico = Double.toString(servico.getValor()*horas);

						// Adiciona os dados ao modelo de tabela
						viewConsultarOrdemServico.getTabelaServico().getModel().addRow(new String[]{codigoServico, nomeServico,valorServico, horasServico, valorTotalServico});
						i++;

						//Atualliza campos de valor
						List<String[]>dadosTabela = getDadosTabelaServico();

						double valorTotal = 0;

						for (String[] array : dadosTabela) {
							valorTotal += Double.parseDouble(array[4]); // Obter o terceiro elemento do array
						}

						viewConsultarOrdemServico.getTxtValorServico().setText(Double.toString(valorTotal));

					}
				}
				
				List<ItemProduto>listaProdutos = ordemServico.getProdutos();
				i = 0;

				for (ItemProduto itemproduto : listaProdutos) {

					int codigoItemProduto = listaProdutos.get(i).getCodProduto();
					int quantidade = listaProdutos.get(i).getQuantidade();

					Produtos produtos = new Produtos(codigoItemProduto);
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
						viewConsultarOrdemServico.getTabelaProdutos().getModel().addRow(new String[]{codigoProduto,nomeProduto,unidadeProduto, quantidadeProduto, valorUnitario,valorTotal});
						i++;
						//Atualizando Campo valor
						List<String[]>dadosTabela = getDadosTabelaProduto();

						double valorTotalProdutos = 0;

						for (String[] array : dadosTabela) {
							valorTotalProdutos += Double.parseDouble(array[5]); // Obter o terceiro elemento do array
						}

						viewConsultarOrdemServico.getTxtValorProduto().setText(Double.toString(valorTotalProdutos));
					}
				}


				atualizarValorTotal();
				mensagem = "OS encontrada!";
			}



			else {
				mensagem = "Ocorreu um erro ao buscar a OS!";
			}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um código válido!";
		}
		return mensagem;
	}
	
	public String liberarEdicao() {
		String mensagem;
		pesquisarOS();
		if(pesquisarOS().equals("OS encontrada!")) {
			
			viewConsultarOrdemServico.getTxtCodOs().setEditable(!viewConsultarOrdemServico.getTxtCodOs().isEditable());
			viewConsultarOrdemServico.getBtnSalvar().setVisible(!viewConsultarOrdemServico.getBtnSalvar().isVisible());
			viewConsultarOrdemServico.getTabelaServico().getBtnIncluir().setVisible(!viewConsultarOrdemServico.getTabelaServico().getBtnApagar().isVisible());
			viewConsultarOrdemServico.getTabelaServico().getBtnApagar().setVisible(!viewConsultarOrdemServico.getTabelaServico().getBtnApagar().isVisible());
			viewConsultarOrdemServico.getTabelaProdutos().getBtnIncluir().setVisible(!viewConsultarOrdemServico.getTabelaProdutos().getBtnApagar().isVisible());
			viewConsultarOrdemServico.getTabelaProdutos().getBtnApagar().setVisible(!viewConsultarOrdemServico.getTabelaProdutos().getBtnApagar().isVisible());
			viewConsultarOrdemServico.getListaStatus().setEnabled(!viewConsultarOrdemServico.getListaStatus().isEnabled());
			viewConsultarOrdemServico.getListaVeiculo().setEnabled(!viewConsultarOrdemServico.getlistaVeiculo().isEnabled());
			viewConsultarOrdemServico.getlistaFuncionario().setEnabled(!viewConsultarOrdemServico.getListaFuncionario().isEnabled());
			viewConsultarOrdemServico.getTxtDiaExecucao().setEditable(!viewConsultarOrdemServico.getTxtDiaExecucao().isEditable());	
			viewConsultarOrdemServico.getTxtMesExecucao().setEditable(!viewConsultarOrdemServico.getTxtMesExecucao().isEditable());
			viewConsultarOrdemServico.getTxtAnoExecucao().setEditable(!viewConsultarOrdemServico.getTxtAnoExecucao().isEditable());

			
			mensagem = "Mudando modo de visualização de Cadastro!";
		}
		else {
			mensagem = "Foi encontrado um erro ao entrar no modo de edicão!";
		}
		return mensagem;
	}
	
	public String atualizarOS(){
		String mensagem;
		
		try {
			//UPDATE ordem_servico SET data_exec = ?, status_ordem=?, valor_ordem=?, cod_veiculo=?, cod_funcionario=? WHERE cod_ordem=?
			int codigo = Integer.parseInt(viewConsultarOrdemServico.getTxtCodOs().getText());
			String status = (String) viewConsultarOrdemServico.getlistaStatus().getSelectedItem();
			
			int dia = Integer.parseInt(viewConsultarOrdemServico.getTxtDiaExecucao().getText());
			int mes = Integer.parseInt(viewConsultarOrdemServico.getTxtMesExecucao().getText());
			int ano = Integer.parseInt(viewConsultarOrdemServico.getTxtAnoExecucao().getText());
			LocalDate dataOS = LocalDate.of(ano, mes, dia);
			Double valorTotal = Double.parseDouble(viewConsultarOrdemServico.getTxtValorTotal().getText());
			
			
			//pegando o codigo do veiculo
			String veiculoSelecionado = (String) viewConsultarOrdemServico.getListaVeiculo().getSelectedItem();
			int posicaoDoCodigo = veiculoSelecionado.indexOf("-");
			int codigoVeiculo = Integer.parseInt(veiculoSelecionado.substring(0, posicaoDoCodigo));
			
			//pegando o codigo do funcionario
			String FuncionarioSelecionado = (String) viewConsultarOrdemServico.getListaFuncionario().getSelectedItem();
			posicaoDoCodigo = FuncionarioSelecionado.indexOf("-");
			int codigoFuncionario = Integer.parseInt(FuncionarioSelecionado.substring(0, posicaoDoCodigo));
			
			
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
			
			//Segunda parte

			VeiculosDAO veiculoDAO = new VeiculosDAO();
			if(veiculoDAO.veiculoAtivo(codigoVeiculo)==true) {
				Veiculos veiculo = new Veiculos(codigoVeiculo);
				Funcionarios funcionario = new Funcionarios(codigoFuncionario);
				
				OrdemServico ordemServico = new OrdemServico(codigo, status,dataOS, veiculo, funcionario, valorTotal,  produtosTabela, servicoTabela);
				
				OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
				mensagem = ordemServicoDAO.atualizarOSBanco(ordemServico);
				}
			else {
				mensagem = "Atenção: O veiculo está INATIVO, por favor selecione um veiculo ATIVO!";
			}
		}
		catch(DateTimeException erro) {
			mensagem = "Por favor digite uma data válida!";
		}
		return mensagem;
	}
}
