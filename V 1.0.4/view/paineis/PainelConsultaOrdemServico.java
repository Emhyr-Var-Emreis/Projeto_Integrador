package view.paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.CadastrarOrdemServicoController;
import controller.CadastrarVeiculoController;
import controller.ConsultarOrdemServicoController;
import view.estilos.BotaoEditar;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.TabelaProdutos;
import view.estilos.TabelaServico;
import view.estilos.Titulo;



public class PainelConsultaOrdemServico extends JPanel {


	private final ConsultarOrdemServicoController controller;

	private ListaSuspensa listaStatus;
	private ListaSuspensa listaVeiculo;
	private CamposTexto txtDiaExecucao;
	private CamposTexto txtMesExecucao;
	private CamposTexto txtAnoExecucao;
	private CamposTexto txtDiaCriacao;
	private CamposTexto txtMesCriacao;
	private CamposTexto txtAnoCriacao;
	private ListaSuspensa listaFuncionario;
	private LabelsTexto txtValorServico;
	private LabelsTexto txtValorProduto;
	private LabelsTexto txtValorTotal;
	private TabelaProdutos tabelaProdutos;
	private TabelaServico tabelaServico;
	private CamposTexto txtCodOs;
	private BotaoSalvar btnSalvar;
	
	
	public BotaoSalvar getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(BotaoSalvar btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public CamposTexto getTxtDiaCriacao() {
		return txtDiaCriacao;
	}

	public void setTxtDiaCriacao(CamposTexto txtDiaCriacao) {
		this.txtDiaCriacao = txtDiaCriacao;
	}

	public CamposTexto getTxtMesCriacao() {
		return txtMesCriacao;
	}

	public void setTxtMesCriacao(CamposTexto txtMesCriacao) {
		this.txtMesCriacao = txtMesCriacao;
	}

	public CamposTexto getTxtAnoCriacao() {
		return txtAnoCriacao;
	}

	public void setTxtAnoCriacao(CamposTexto txtAnoCriacao) {
		this.txtAnoCriacao = txtAnoCriacao;
	}

	public CamposTexto getTxtCodOs() {
		return txtCodOs;
	}

	public void setTxtCodOs(CamposTexto txtCodOs) {
		this.txtCodOs = txtCodOs;
	}

	public ListaSuspensa getListaStatus() {
		return listaStatus;
	}

	public void setListaStatus(ListaSuspensa listaStatus) {
		this.listaStatus = listaStatus;
	}

	public ListaSuspensa getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(ListaSuspensa listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

	public CamposTexto getTxtDiaExecucao() {
		return txtDiaExecucao;
	}

	public void setTxtDiaExecucao(CamposTexto txtDiaExecucao) {
		this.txtDiaExecucao = txtDiaExecucao;
	}

	public CamposTexto getTxtMesExecucao() {
		return txtMesExecucao;
	}

	public void setTxtMesExecucao(CamposTexto txtMesExecucao) {
		this.txtMesExecucao = txtMesExecucao;
	}

	public CamposTexto getTxtAnoExecucao() {
		return txtAnoExecucao;
	}

	public void setTxtAnoExecucao(CamposTexto txtAnoExecucao) {
		this.txtAnoExecucao = txtAnoExecucao;
	}

	public ListaSuspensa getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(ListaSuspensa listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public ListaSuspensa getlistaStatus() {
		return listaStatus;
	}

	public void setlistaStatus(ListaSuspensa listaStatus) {
		this.listaStatus = listaStatus;
	}

	public ListaSuspensa getlistaVeiculo() {
		return listaVeiculo;
	}

	public void setlistaVeiculo(ListaSuspensa listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}


	public ListaSuspensa getlistaFuncionario() {
		return listaFuncionario;
	}

	public void setlistaFuncionario(ListaSuspensa listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public LabelsTexto getTxtValorServico() {
		return txtValorServico;
	}

	public void setTxtValorServico(LabelsTexto txtValorServico) {
		this.txtValorServico = txtValorServico;
	}

	public LabelsTexto getTxtValorProduto() {
		return txtValorProduto;
	}

	public void setTxtValorProduto(LabelsTexto txtValorProduto) {
		this.txtValorProduto = txtValorProduto;
	}

	public LabelsTexto getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(LabelsTexto txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public TabelaProdutos getTabelaProdutos() {
		return tabelaProdutos;
	}

	public void setTabelaProdutos(TabelaProdutos tabelaProdutos) {
		this.tabelaProdutos = tabelaProdutos;
	}

	public TabelaServico getTabelaServico() {
		return tabelaServico;
	}

	public void setTabelaServico(TabelaServico tabelaServico) {
		this.tabelaServico = tabelaServico;
	}

	public ConsultarOrdemServicoController getController() {
		return controller;
	}

	public PainelConsultaOrdemServico() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);

		controller = new ConsultarOrdemServicoController(this);

		//Criando texto na tela 

		Titulo lblCadastroServico = new Titulo(81,32,878,60,"Consulta de Ordens de Serviço");
		LabelsTexto lblCodOs = new LabelsTexto(141,90,85,29,"Cod OS");
		LabelsTexto lblStatus = new LabelsTexto(155,127,85,29,"Status");
		LabelsTexto lblVeiculo = new LabelsTexto(139,180,85,29,"Veiculo");
		LabelsTexto lblDataExecucao = new LabelsTexto(480,124,203,29,"Data de Execução");
		LabelsTexto lblFuncionario = new LabelsTexto(546,181,134,29,"Funcionario");
		LabelsTexto lblDataCriacao = new LabelsTexto(546,238,203,29,"Data Criação");
		LabelsTexto lblServico = new LabelsTexto(21,319,92,29,"Serviços");
		LabelsTexto lblProdutos = new LabelsTexto(11,500,102,29,"Produtos");
		LabelsTexto lblValorServico = new LabelsTexto(78, 635, 149, 29, "Valor Serviços");
		LabelsTexto lblValorProduto = new LabelsTexto(377,635,169,29,"Valor Produtos");
		LabelsTexto lblValorTotal = new LabelsTexto(676,635,120,29,"Valor Total");




		//Criando inputs texto na tela
		txtCodOs = new CamposTexto(260,90,81,29);
		String[] statusOS = {"Em orçamento","Aguardando Aprovação","OS Recusada","Em andamento","OS Bloqueada","OS Concluida"};
		listaStatus = new ListaSuspensa(statusOS,260,127,195,29);
		listaStatus.setEnabled(false);
		listaVeiculo = new ListaSuspensa(controller.listarVeiculos(),260,180,195,29);
		listaVeiculo.setEnabled(false);
		txtDiaExecucao = new CamposTexto(715,127,40,29);
		txtDiaExecucao.setEditable(false);
		txtMesExecucao = new CamposTexto(765,127,40,29);
		txtMesExecucao.setEditable(false);
		txtAnoExecucao = new CamposTexto(815,127,82,29);
		txtAnoExecucao.setEditable(false);
		txtDiaCriacao = new CamposTexto(715,238,40,29);
		txtDiaCriacao.setEditable(false);
		txtMesCriacao = new CamposTexto(765,238,40,29);
		txtMesCriacao.setEditable(false);
		txtAnoCriacao = new CamposTexto(815,238,82,29);
		txtAnoCriacao.setEditable(false);
		listaFuncionario = new ListaSuspensa(controller.listarFuncionarios(),715,180,195,29);
		listaFuncionario.setEnabled(false);
		txtValorServico = new LabelsTexto(260,635,82,29,"0.00");
		txtValorProduto = new LabelsTexto(556,635,82,29,"0.00");
		txtValorTotal = new LabelsTexto(828,635,82,29,"0.00");


		//Criando botoes da tela
		BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
		BotaoEditar btnEditar = new BotaoEditar("Editar");
		btnSalvar = new BotaoSalvar("Salvar");

		//Adicionando elementos a tela
		add(lblCadastroServico);
		add(lblStatus);
		add(lblVeiculo);
		add(lblDataExecucao);
		add(lblFuncionario);
		add(lblServico);
		add(lblProdutos);
		add(lblValorServico);
		add(lblValorProduto);
		add(lblValorTotal);
		add(lblFuncionario);
		add(lblCodOs);
		add(listaStatus);
		add(listaVeiculo);
		add(txtDiaExecucao);
		add(txtMesExecucao);
		add(txtAnoExecucao);
		add(txtDiaCriacao);
		add(txtMesCriacao);
		add(txtAnoCriacao);
		add(lblDataCriacao);
		add(listaFuncionario);
		add(txtValorServico);
		add(txtValorProduto);
		add(txtValorTotal);
		add(txtCodOs);
		add(btnPesquisar);
		add(btnSalvar);
		add(btnEditar);

		tabelaProdutos = new TabelaProdutos();
		tabelaProdutos.setBounds(146, 500, 840, 116);
		

		tabelaServico = new TabelaServico();
		tabelaServico.setBounds(146, 319, 726, 116);
		tabelaServico.getBtnIncluir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.incluirServico();
				controller.atualizarValorTotal();

			}
		});

		tabelaServico.getBtnApagar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.retirarServico();
				controller.atualizarValorTotal();

			}
		});
		
		tabelaProdutos.getBtnIncluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.incluirProduto();
				controller.atualizarValorTotal();
				
			}
		});
		
		tabelaProdutos.getBtnApagar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.retirarProdutos();
				controller.atualizarValorTotal();
				
			}
		});

		
		add(tabelaProdutos);
		add(tabelaServico);
		
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.pesquisarOS());
				
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.liberarEdicao());
				
			}
		});
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.atualizarOS());
				
			}
		});
		
		tabelaProdutos.getBtnApagar().setVisible(false);
		tabelaProdutos.getBtnIncluir().setVisible(false);
		tabelaServico.getBtnApagar().setVisible(false);
		tabelaServico.getBtnIncluir().setVisible(false);
		btnSalvar.setVisible(false);

	}}