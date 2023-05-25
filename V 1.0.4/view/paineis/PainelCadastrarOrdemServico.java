package view.paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.CadastrarOrdemServicoController;
import controller.CadastrarVeiculoController;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.TabelaProdutos;
import view.estilos.TabelaServico;
import view.estilos.Titulo;



public class PainelCadastrarOrdemServico extends JPanel {


	private final CadastrarOrdemServicoController controller;

	private ListaSuspensa listaStatus;
	private ListaSuspensa listaVeiculo;
	private CamposTexto txtDiaExecucao;
	private CamposTexto txtMesExecucao;
	private CamposTexto txtAnoExecucao;
	private ListaSuspensa listaFuncionario;
	private LabelsTexto txtValorServico;
	private LabelsTexto txtValorProduto;
	private LabelsTexto txtValorTotal;
	private TabelaProdutos tabelaProdutos;
	private TabelaServico tabelaServico;
	
	

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

	public CadastrarOrdemServicoController getController() {
		return controller;
	}

	public PainelCadastrarOrdemServico() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);

		controller = new CadastrarOrdemServicoController(this);

		//Criando texto na tela 

		Titulo lblCadastroServico = new Titulo(81,32,878,60,"Cadastro de Ordens de Serviço");
		LabelsTexto lblStatus = new LabelsTexto(155,127,85,29,"Status");
		LabelsTexto lblVeiculo = new LabelsTexto(139,180,85,29,"Veiculo");
		LabelsTexto lblDataExecucao = new LabelsTexto(480,124,203,29,"Data de Execução");
		LabelsTexto lblFuncionario = new LabelsTexto(546,181,134,29,"Funcionario");
		LabelsTexto lblServico = new LabelsTexto(21,319,92,29,"Serviços");
		LabelsTexto lblProdutos = new LabelsTexto(11,500,102,29,"Produtos");
		LabelsTexto lblValorServico = new LabelsTexto(78, 635, 149, 29, "Valor Serviços");
		LabelsTexto lblValorProduto = new LabelsTexto(377,635,169,29,"Valor Produtos");
		LabelsTexto lblValorTotal = new LabelsTexto(676,635,120,29,"Valor Total");




		//Criando inputs texto na tela
		String[] statusOS = {"Em orçamento","Aguardando Aprovação","OS Recusada","Em andamento","OS Bloqueada","OS Concluida"};
		listaStatus = new ListaSuspensa(statusOS,260,127,195,29);
		listaVeiculo = new ListaSuspensa(controller.listarVeiculos(),260,180,195,29);
		txtDiaExecucao = new CamposTexto(715,127,40,29);
		txtMesExecucao = new CamposTexto(765,127,40,29);
		txtAnoExecucao = new CamposTexto(815,127,82,29);
		listaFuncionario = new ListaSuspensa(controller.listarFuncionarios(),715,180,195,29);
		txtValorServico = new LabelsTexto(260,635,82,29,"0.00");
		txtValorProduto = new LabelsTexto(556,635,82,29,"0.00");
		txtValorTotal = new LabelsTexto(828,635,82,29,"0.00");


		//Criando botoes da tela
		BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");

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
		add(listaStatus);
		add(listaVeiculo);
		add(txtDiaExecucao);
		add(txtMesExecucao);
		add(txtAnoExecucao);
		add(listaFuncionario);
		add(txtValorServico);
		add(txtValorProduto);
		add(txtValorTotal);
		add(btnSalvar);

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
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.salvarOS());
				
				
			}
		});
	}}

