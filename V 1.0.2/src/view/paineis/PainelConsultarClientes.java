package view.paineis;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ConsultarClienteController;
import view.estilos.BotaoEditar;
import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelConsultarClientes extends JPanel {
	
	private final ConsultarClienteController controller;
	
	private static final long serialVersionUID = 1408949973047635576L;
	
	private CamposTexto txtCodCliente;
	private CamposTexto txtNome;
    private CamposTexto txtEndereco;
    private CamposTexto txtTelefone;
    private CamposTexto txtEmail;
    private CamposTexto txtCidade;
    private CamposTexto txtDoc;
    private ListaSuspensa listaPjuridica;
    private ListaSuspensa listaAtivo;
    private Titulo lblConsultaClientes;
    private LabelsTexto lblCodCliente;
    private LabelsTexto lblNome;
    private LabelsTexto lblEndereco;
    private LabelsTexto lblTelefone;
    private LabelsTexto lblEmail;
    private LabelsTexto lblPjuridica;
    private LabelsTexto lblCidade;
    private LabelsTexto lblDoc;
    private LabelsTexto lblAtivo;

	private BotaoSalvar btnSalvar;
    
    

	public BotaoSalvar getBtnSalvar() {
		return btnSalvar;
	}



	public void setBtnSalvar(BotaoSalvar btnSalvar) {
		this.btnSalvar = btnSalvar;
	}



	public CamposTexto getTxtCodCliente() {
		return txtCodCliente;
	}



	public void setTxtCodCliente(CamposTexto txtCodCliente) {
		this.txtCodCliente = txtCodCliente;
	}



	public CamposTexto getTxtNome() {
		return txtNome;
	}



	public void setTxtNome(CamposTexto txtNome) {
		this.txtNome = txtNome;
	}



	public CamposTexto getTxtEndereco() {
		return txtEndereco;
	}



	public void setTxtEndereco(CamposTexto txtEndereco) {
		this.txtEndereco = txtEndereco;
	}



	public CamposTexto getTxtTelefone() {
		return txtTelefone;
	}



	public void setTxtTelefone(CamposTexto txtTelefone) {
		this.txtTelefone = txtTelefone;
	}



	public CamposTexto getTxtEmail() {
		return txtEmail;
	}



	public void setTxtEmail(CamposTexto txtEmail) {
		this.txtEmail = txtEmail;
	}



	public CamposTexto getTxtCidade() {
		return txtCidade;
	}



	public void setTxtCidade(CamposTexto txtCidade) {
		this.txtCidade = txtCidade;
	}



	public CamposTexto getTxtDoc() {
		return txtDoc;
	}



	public void setTxtDoc(CamposTexto txtDoc) {
		this.txtDoc = txtDoc;
	}



	public ListaSuspensa getListaPjuridica() {
		return listaPjuridica;
	}



	public void setListaPjuridica(ListaSuspensa listaPjuridica) {
		this.listaPjuridica = listaPjuridica;
	}



	public ListaSuspensa getListaAtivo() {
		return listaAtivo;
	}



	public void setListaAtivo(ListaSuspensa listaAtivo) {
		this.listaAtivo = listaAtivo;
	}



	public Titulo getLblConsultaClientes() {
		return lblConsultaClientes;
	}



	public void setLblConsultaClientes(Titulo lblConsultaClientes) {
		this.lblConsultaClientes = lblConsultaClientes;
	}



	public LabelsTexto getLblCodCliente() {
		return lblCodCliente;
	}



	public void setLblCodCliente(LabelsTexto lblCodCliente) {
		this.lblCodCliente = lblCodCliente;
	}



	public LabelsTexto getLblNome() {
		return lblNome;
	}



	public void setLblNome(LabelsTexto lblNome) {
		this.lblNome = lblNome;
	}



	public LabelsTexto getLblEndereco() {
		return lblEndereco;
	}



	public void setLblEndereco(LabelsTexto lblEndereco) {
		this.lblEndereco = lblEndereco;
	}



	public LabelsTexto getLblTelefone() {
		return lblTelefone;
	}



	public void setLblTelefone(LabelsTexto lblTelefone) {
		this.lblTelefone = lblTelefone;
	}



	public LabelsTexto getLblEmail() {
		return lblEmail;
	}



	public void setLblEmail(LabelsTexto lblEmail) {
		this.lblEmail = lblEmail;
	}



	public LabelsTexto getLblPjuridica() {
		return lblPjuridica;
	}



	public void setLblPjuridica(LabelsTexto lblPjuridica) {
		this.lblPjuridica = lblPjuridica;
	}



	public LabelsTexto getLblCidade() {
		return lblCidade;
	}



	public void setLblCidade(LabelsTexto lblCidade) {
		this.lblCidade = lblCidade;
	}



	public LabelsTexto getLblDoc() {
		return lblDoc;
	}



	public void setLblDoc(LabelsTexto lblDoc) {
		this.lblDoc = lblDoc;
	}



	public LabelsTexto getLblAtivo() {
		return lblAtivo;
	}



	public void setLblAtivo(LabelsTexto lblAtivo) {
		this.lblAtivo = lblAtivo;
	}



	public ConsultarClienteController getController() {
		return controller;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public PainelConsultarClientes() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);

		controller = new ConsultarClienteController(this);
		
		//Criando texto na tela 

		lblConsultaClientes = new Titulo(269,32,602,60,"Consulta de Clientes");
		lblCodCliente = new LabelsTexto(68,124,159,29,"Cód Cliente");
		lblNome = new LabelsTexto(145,177,85,29,"Nome");
		lblEndereco = new LabelsTexto(115,229,121,29,"Endereço");
		lblTelefone = new LabelsTexto(128,282,114,29,"Telefone");
		lblEmail = new LabelsTexto(133,335,156,29,"Email");
		lblPjuridica = new LabelsTexto(107,388,141,29,"P.Juridica");
		lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
		lblDoc = new LabelsTexto(429,388,141,29,"CPF/CNPJ");
		lblAtivo = new LabelsTexto(167,449,63,29,"Ativo");


		//Criando inputs texto e listas Suspensas na tela
		txtCodCliente = new CamposTexto(260,124,81,29);
		txtNome = new CamposTexto(260,177,645,29);
		txtNome.setEditable(false);
		txtEndereco = new CamposTexto(260,229,651,29);
		txtEndereco.setEditable(false);
		txtTelefone = new CamposTexto(260,282,195,29);
		txtTelefone.setEditable(false);
		txtEmail = new CamposTexto(260,335,651,29);
		txtEmail.setEditable(false);
		String[] itensAtivo = {"Sim","Não"};
		listaAtivo = new ListaSuspensa(itensAtivo,260,449,82,29);
		listaAtivo.setEnabled(false);
		String[] itensDropdown = {"Sim","Não"};
		listaPjuridica = new ListaSuspensa(itensDropdown,260,388,82,29);
		listaPjuridica.setEnabled(false);
		txtCidade = new CamposTexto(715,282,195,29);
		txtCidade.setEditable(false);
		txtDoc = new CamposTexto(620,388,285,29);
		txtDoc.setEditable(false);



		//Criando botoes da tela
		btnSalvar = new BotaoSalvar("Salvar");
		BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
		BotaoEditar btnEditar = new BotaoEditar("Editar");

		//Adicionando elementos a tela
		add(lblConsultaClientes);
		add(lblCodCliente);
		add(lblNome);
		add(lblEndereco);
		add(lblTelefone);
		add(lblEmail);
		add(lblAtivo);
		add(lblPjuridica);
		add(lblCidade);
		add(lblDoc);
		add(txtCodCliente);
		add(txtNome);
		add(txtEndereco);
		add(txtTelefone);
		add(txtEmail);
		add(listaPjuridica);
		add(txtCidade);
		add(txtDoc);
		add(listaAtivo);
		add(btnSalvar);
		btnSalvar.setVisible(false);
		add(btnPesquisar);
		add(btnEditar);


		//Inserindo acao no botao pesquisar
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.pesquisarCliente());
			}});

		//Inserindo acao no botao editar
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,controller.liberarEdicao());
			}

		});


		//Inserindo acao no botao salvar
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, controller.atualizarCliente() );

			}
		});

	}}