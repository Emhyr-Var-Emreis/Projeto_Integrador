package view.paineis;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.CadastrarClienteController;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelCadastrarClientes extends JPanel {
	
	private final CadastrarClienteController controller;
	private static final long serialVersionUID = 4526471595649803728L;
	
	private CamposTexto txtNome;
    private CamposTexto txtEndereco;
    private CamposTexto txtTelefone;
    private CamposTexto txtEmail;
    private CamposTexto txtCidade;
    private CamposTexto txtDoc;
    private ListaSuspensa listaPjuridica;
    private Titulo lblCadastroClientes;
    private LabelsTexto lblNome;
    private LabelsTexto lblEndereco;
    private LabelsTexto lblTelefone;
    private LabelsTexto lblEmail;
    private LabelsTexto lblPjuridica;
    private LabelsTexto lblCidade;
    private LabelsTexto lblDoc;
    
    

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



	public Titulo getLblCadastroClientes() {
		return lblCadastroClientes;
	}



	public void setLblCadastroClientes(Titulo lblCadastroClientes) {
		this.lblCadastroClientes = lblCadastroClientes;
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



	public CadastrarClienteController getController() {
		return controller;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public PainelCadastrarClientes() {
		
		
		//chamando o controller
		controller = new CadastrarClienteController(this);
		
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
		
      //Criando texto na tela 
		
       lblCadastroClientes = new Titulo(269,32,602,60,"Cadastro de Clientes");
       lblNome = new LabelsTexto(145,177,85,29,"Nome");
       lblEndereco = new LabelsTexto(115,229,121,29,"Endereço");
       lblTelefone = new LabelsTexto(128,282,114,29,"Telefone");
       lblEmail = new LabelsTexto(133,335,156,29,"Email");
       lblPjuridica = new LabelsTexto(107,388,141,29,"P.Juridica");
       lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
       lblDoc = new LabelsTexto(429,388,141,29,"CPF/CNPJ");

        
     //Criando inputs texto e lista suspensa na tela
       txtNome = new CamposTexto(260,177,645,29);
       txtEndereco = new CamposTexto(260,229,651,29);
       txtTelefone = new CamposTexto(260,282,195,29);
       txtEmail = new CamposTexto(260,335,651,29);
       String[] itensDropdown = {"Sim","Não"};
       listaPjuridica = new ListaSuspensa(itensDropdown,260,388,82,29);
       txtCidade = new CamposTexto(715,282,195,29);
       txtDoc = new CamposTexto(620,388,285,29);
       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
        
        //Adicionando elementos a tela
        add(lblCadastroClientes);
        add(lblNome);
        add(lblEndereco);
        add(lblTelefone);
        add(lblEmail);
        add(lblPjuridica);
        add(lblCidade);
        add(lblDoc);
        add(txtNome);
        add(txtEndereco);
        add(txtTelefone);
        add(txtEmail);
        add(listaPjuridica);
        add(txtCidade);
        add(txtDoc);
        add(btnSalvar);
        add(btnLimpar);
        
        //Inserindo acao no botao limpar
        btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				controller.limpar();		
			}
		});
        
        //Inserindo acao no botao salvar
        btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.salvarCliente());
			}
		});
        
       
}}
