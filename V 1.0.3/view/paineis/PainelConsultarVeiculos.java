package view.paineis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ConsultarVeiculoController;
import view.estilos.BotaoEditar;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelConsultarVeiculos extends JPanel {
	
	private final ConsultarVeiculoController controller;
	
	private Titulo lblCadastroVeiculos;
	private LabelsTexto lblCodVeiculo;
	private LabelsTexto lblModelo;
	private LabelsTexto lblMarca;
	private LabelsTexto lblCliente;
	private LabelsTexto lblPlaca;
	private LabelsTexto lblCor;
	private LabelsTexto lblAno;
	private LabelsTexto lblAtivo;
	private CamposTexto txtCodVeiculo;
	private CamposTexto txtModelo;
	private CamposTexto txtMarca;
	private ListaSuspensa listaCliente;
	private CamposTexto txtPlaca;
	private CamposTexto txtCor;
	private CamposTexto txtAno;
	private ListaSuspensa listaAtivo;
	private BotaoSalvar btnSalvar;
	
	
	
	public Titulo getLblCadastroVeiculos() {
		return lblCadastroVeiculos;
	}



	public void setLblCadastroVeiculos(Titulo lblCadastroVeiculos) {
		this.lblCadastroVeiculos = lblCadastroVeiculos;
	}



	public LabelsTexto getLblCodVeiculo() {
		return lblCodVeiculo;
	}



	public void setLblCodVeiculo(LabelsTexto lblCodVeiculo) {
		this.lblCodVeiculo = lblCodVeiculo;
	}



	public LabelsTexto getLblModelo() {
		return lblModelo;
	}



	public void setLblModelo(LabelsTexto lblModelo) {
		this.lblModelo = lblModelo;
	}



	public LabelsTexto getLblMarca() {
		return lblMarca;
	}



	public void setLblMarca(LabelsTexto lblMarca) {
		this.lblMarca = lblMarca;
	}



	public LabelsTexto getLblCliente() {
		return lblCliente;
	}



	public void setLblCliente(LabelsTexto lblCliente) {
		this.lblCliente = lblCliente;
	}



	public LabelsTexto getLblPlaca() {
		return lblPlaca;
	}



	public void setLblPlaca(LabelsTexto lblPlaca) {
		this.lblPlaca = lblPlaca;
	}



	public LabelsTexto getLblCor() {
		return lblCor;
	}



	public void setLblCor(LabelsTexto lblCor) {
		this.lblCor = lblCor;
	}



	public LabelsTexto getLblAno() {
		return lblAno;
	}



	public void setLblAno(LabelsTexto lblAno) {
		this.lblAno = lblAno;
	}



	public LabelsTexto getLblAtivo() {
		return lblAtivo;
	}



	public void setLblAtivo(LabelsTexto lblAtivo) {
		this.lblAtivo = lblAtivo;
	}



	public CamposTexto getTxtCodVeiculo() {
		return txtCodVeiculo;
	}



	public void setTxtCodVeiculo(CamposTexto txtCodVeiculo) {
		this.txtCodVeiculo = txtCodVeiculo;
	}



	public CamposTexto getTxtModelo() {
		return txtModelo;
	}



	public void setTxtModelo(CamposTexto txtModelo) {
		this.txtModelo = txtModelo;
	}



	public CamposTexto getTxtMarca() {
		return txtMarca;
	}



	public void setTxtMarca(CamposTexto txtMarca) {
		this.txtMarca = txtMarca;
	}



	public ListaSuspensa getListaCliente() {
		return listaCliente;
	}



	public void setListaCliente(ListaSuspensa listaCliente) {
		this.listaCliente = listaCliente;
	}



	public CamposTexto getTxtPlaca() {
		return txtPlaca;
	}



	public void setTxtPlaca(CamposTexto txtPlaca) {
		this.txtPlaca = txtPlaca;
	}



	public CamposTexto getTxtCor() {
		return txtCor;
	}



	public void setTxtCor(CamposTexto txtCor) {
		this.txtCor = txtCor;
	}



	public CamposTexto getTxtAno() {
		return txtAno;
	}



	public void setTxtAno(CamposTexto txtAno) {
		this.txtAno = txtAno;
	}



	public ListaSuspensa getListaAtivo() {
		return listaAtivo;
	}



	public void setListaAtivo(ListaSuspensa listaAtivo) {
		this.listaAtivo = listaAtivo;
	}



	public BotaoSalvar getBtnSalvar() {
		return btnSalvar;
	}



	public void setBtnSalvar(BotaoSalvar btnSalvar) {
		this.btnSalvar = btnSalvar;
	}



	public ConsultarVeiculoController getController() {
		return controller;
	}



	public PainelConsultarVeiculos() {
		
		controller = new ConsultarVeiculoController(this);
		
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);

		//Criando texto na tela 

		lblCadastroVeiculos = new Titulo(269,32,602,60,"Consulta Veículos");
		lblCodVeiculo = new LabelsTexto(99,124,159,29,"Cód Veículo");
		lblModelo = new LabelsTexto(128,177,159,29,"Modelo");
		lblMarca = new LabelsTexto(122,238,159,29,"Marca");
		lblCliente = new LabelsTexto(101,291,159,29,"Cliente");
		lblPlaca = new LabelsTexto(612,124,159,29,"Placa");
		lblCor = new LabelsTexto(633,238,159,29,"Cor");
		lblAno = new LabelsTexto(122,345,159,29,"Ano");
		lblAtivo = new LabelsTexto(624, 345, 63, 29, "Ativo");


		//Criando inputs texto na tela
		txtCodVeiculo = new CamposTexto(260,124,81,29);
		txtModelo = new CamposTexto(260,177,645,29);
		txtModelo.setEditable(false);
		txtMarca = new CamposTexto(260,238,195,29);
		txtMarca.setEditable(false);
		listaCliente = new ListaSuspensa(controller.listarClientes(),260,291,641,29);
		listaCliente.setEnabled(false);
		txtPlaca = new CamposTexto(710,124,195,29);
		txtPlaca.setEditable(false);
		txtCor = new CamposTexto(710,238,195,29);
		txtCor.setEditable(false);
		txtAno = new CamposTexto(260,345,195,29);
		txtAno.setEditable(false);
		String[] itensAtivo = {"Sim","Não"};
		listaAtivo = new ListaSuspensa(itensAtivo,719,345,82,29);
		listaAtivo.setEnabled(false);

		//Criando botoes da tela
		btnSalvar = new BotaoSalvar("Salvar");
		BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
		BotaoEditar btnEditar = new BotaoEditar("Editar");

		//Adicionando elementos a tela
		add(lblCadastroVeiculos);
		add(lblCodVeiculo);
		add(lblModelo);
		add(lblMarca);
		add(lblCliente);
		add(lblPlaca);
		add(lblCor);
		add(lblAno);
		add(lblAtivo);
		add(txtCodVeiculo);
		add(txtModelo);
		add(txtMarca);
		add(listaCliente);
		add(txtPlaca);
		add(txtCor);
		add(txtAno);
		add(listaAtivo);
		add(btnSalvar);
		btnSalvar.setVisible(false);
		add(btnPesquisar);
		add(btnEditar);
		

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.pesquisarVeiculo());
			}});
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.liberarEdicao());
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.atualizarVeiculo());
				
			}
		});


	}}
