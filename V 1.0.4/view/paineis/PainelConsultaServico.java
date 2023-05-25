package view.paineis;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


import controller.ConsultarServicoController;
import view.estilos.BotaoEditar;

import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.Titulo;


public class PainelConsultaServico extends JPanel {

	private static final long serialVersionUID = 419540971453719896L;

	private final ConsultarServicoController controller;

	private Titulo lblCadastroServico;
	private LabelsTexto lblCodServico;
	private LabelsTexto lblNome;
	private LabelsTexto lblDescricao;
	private LabelsTexto lblValor;
	private CamposTexto txtCodServico;
	private CamposTexto txtNome;
	private CamposTexto txtDescricao;
	private CamposTexto txtValor;
	private BotaoSalvar btnSalvar;

	public Titulo getLblCadastroServico() {
		return lblCadastroServico;
	}

	public void setLblCadastroServico(Titulo lblCadastroServico) {
		this.lblCadastroServico = lblCadastroServico;
	}

	public LabelsTexto getLblCodServico() {
		return lblCodServico;
	}

	public void setLblCodServico(LabelsTexto lblCodServico) {
		this.lblCodServico = lblCodServico;
	}

	public LabelsTexto getLblNome() {
		return lblNome;
	}

	public void setLblNome(LabelsTexto lblNome) {
		this.lblNome = lblNome;
	}

	public LabelsTexto getLblDescricao() {
		return lblDescricao;
	}

	public void setLblDescricao(LabelsTexto lblDescricao) {
		this.lblDescricao = lblDescricao;
	}

	public LabelsTexto getLblValor() {
		return lblValor;
	}

	public void setLblValor(LabelsTexto lblValor) {
		this.lblValor = lblValor;
	}

	public CamposTexto getTxtCodServico() {
		return txtCodServico;
	}

	public void setTxtCodServico(CamposTexto txtCodServico) {
		this.txtCodServico = txtCodServico;
	}

	public CamposTexto getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(CamposTexto txtNome) {
		this.txtNome = txtNome;
	}

	public CamposTexto getTxtDescricao() {
		return txtDescricao;
	}

	public void setTxtDescricao(CamposTexto txtDescricao) {
		this.txtDescricao = txtDescricao;
	}

	public CamposTexto getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(CamposTexto txtValor) {
		this.txtValor = txtValor;
	}

	public BotaoSalvar getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(BotaoSalvar btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ConsultarServicoController getController() {
		return controller;
	}

	public PainelConsultaServico() {

		controller = new ConsultarServicoController(this);

		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);

		//Criando texto na tela 

		lblCadastroServico = new Titulo(261,32,602,60,"Consulta de Serviços");
		lblCodServico = new LabelsTexto(101,121,126,29,"Cód Serviço");
		lblNome = new LabelsTexto(158,177,69,29,"Nome");
		lblDescricao = new LabelsTexto(105,230,117,29,"Descrição");
		lblValor = new LabelsTexto(610,283,59,29,"Valor Mão de Obra");



		//Criando inputs texto na tela
		txtCodServico = new CamposTexto(260,124,81,29);
		txtNome = new CamposTexto(260,177,650,29);
		txtNome.setEditable(false);
		txtDescricao = new CamposTexto(260,230,650,29);
		txtDescricao.setEditable(false);
		txtValor = new CamposTexto(715,283,195,29);
		txtValor.setEditable(false);


		//Criando botoes da tela
		btnSalvar = new BotaoSalvar("Salvar");
		BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
		BotaoEditar btnEditar = new BotaoEditar("Editar");

		//Adicionando elementos a tela
		add(lblCadastroServico);
		add(lblCodServico);
		add(lblNome);
		add(lblDescricao);
		add(lblValor);
		add(txtCodServico);
		add(txtNome);
		add(txtDescricao);
		add(txtValor);
		add(btnSalvar);
		add(btnPesquisar);
		add(btnEditar);
		btnSalvar.setVisible(false);

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, controller.pesquisarServico());
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

				JOptionPane.showMessageDialog(null, controller.atualizarServico());

			}
		});


	}}
