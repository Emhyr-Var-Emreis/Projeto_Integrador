package view.paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.CadastrarProdutoController;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.Titulo;


public class PainelCadastrarProdutos extends JPanel {

	private final CadastrarProdutoController controller;

	private static final long serialVersionUID = -2599531944041481324L;

	private Titulo lblCadastroProdutos;
	private LabelsTexto lblNome;
	private LabelsTexto lblDescricao;
	private LabelsTexto lblUnidadeMedida;
	private LabelsTexto lblValorUnitario;
	private CamposTexto txtNome;
	private CamposTexto txtDescricao;
	private CamposTexto txtUnidadeMedida;
	private CamposTexto txtValorUnitario;



	public Titulo getLblCadastroProdutos() {
		return lblCadastroProdutos;
	}



	public void setLblCadastroProdutos(Titulo lblCadastroProdutos) {
		this.lblCadastroProdutos = lblCadastroProdutos;
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



	public LabelsTexto getLblUnidadeMedida() {
		return lblUnidadeMedida;
	}



	public void setLblUnidadeMedida(LabelsTexto lblUnidadeMedida) {
		this.lblUnidadeMedida = lblUnidadeMedida;
	}



	public LabelsTexto getLblValorUnitario() {
		return lblValorUnitario;
	}



	public void setLblValorUnitario(LabelsTexto lblValorUnitario) {
		this.lblValorUnitario = lblValorUnitario;
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



	public CamposTexto getTxtUnidadeMedida() {
		return txtUnidadeMedida;
	}



	public void setTxtUnidadeMedida(CamposTexto txtUnidadeMedida) {
		this.txtUnidadeMedida = txtUnidadeMedida;
	}



	public CamposTexto getTxtValorUnitario() {
		return txtValorUnitario;
	}



	public void setTxtValorUnitario(CamposTexto txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}



	public CadastrarProdutoController getController() {
		return controller;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public PainelCadastrarProdutos() {

		controller = new CadastrarProdutoController(this);

		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);

		//Criando texto na tela 

		lblCadastroProdutos = new Titulo(269,32,602,60,"Cadastro de Produto");
		lblNome = new LabelsTexto(145,177,85,29,"Nome");
		lblDescricao = new LabelsTexto(115,229,121,29,"Descrição");
		lblUnidadeMedida = new LabelsTexto(32,282,210,29,"Unidade Medida");
		lblValorUnitario = new LabelsTexto(515,282,170,29,"Valor Unitário");


		//Criando inputs texto na tela
		txtNome = new CamposTexto(260,177,645,29);
		txtDescricao = new CamposTexto(260,229,645,29);
		txtUnidadeMedida = new CamposTexto(260,282,83,29);
		txtValorUnitario = new CamposTexto(715,282,195,29);


		//Criando botoes da tela
		BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
		BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");

		//Adicionando elementos a tela
		add(lblCadastroProdutos);
		add(lblNome);
		add(lblDescricao);
		add(lblUnidadeMedida);
		add(lblValorUnitario);
		add(txtNome);
		add(txtDescricao);
		add(txtUnidadeMedida);
		add(txtValorUnitario);
		add(btnSalvar);
		add(btnLimpar);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.salvarProduto());

			}
		});

		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.limpar();

			}
		});

	}}
