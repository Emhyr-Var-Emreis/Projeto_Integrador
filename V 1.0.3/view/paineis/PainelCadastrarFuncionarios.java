package view.paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.CadastrarFuncionarioController;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.Titulo;


public class PainelCadastrarFuncionarios extends JPanel {
	
	private final CadastrarFuncionarioController controller;

	private static final long serialVersionUID = -3095349515888537579L;

	 private Titulo lblCadastroClientes;
	 private LabelsTexto lblNome;
	 private LabelsTexto lblEndereco;
	 private LabelsTexto lblTelefone;
	 private LabelsTexto lblEmail;
	 private LabelsTexto lblCargo;
	 private LabelsTexto lblCidade;
	 private LabelsTexto lblCpf;
	 private LabelsTexto lblLogin;
	 private LabelsTexto lblSenha;
	 private CamposTexto txtNome;
	 private CamposTexto txtEndereco;
	 private CamposTexto txtTelefone;
	 private CamposTexto txtEmail;
	 private CamposTexto txtCargo;
	 private CamposTexto txtCidade;
	 private CamposTexto txtCpf;
	 private CamposTexto txtLogin;
	 private CamposTexto txtSenha;
	 
     
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


	public LabelsTexto getLblCargo() {
		return lblCargo;
	}


	public void setLblCargo(LabelsTexto lblCargo) {
		this.lblCargo = lblCargo;
	}


	public LabelsTexto getLblCidade() {
		return lblCidade;
	}


	public void setLblCidade(LabelsTexto lblCidade) {
		this.lblCidade = lblCidade;
	}


	public LabelsTexto getLblCpf() {
		return lblCpf;
	}


	public void setLblCpf(LabelsTexto lblCpf) {
		this.lblCpf = lblCpf;
	}


	public LabelsTexto getLblLogin() {
		return lblLogin;
	}


	public void setLblLogin(LabelsTexto lblLogin) {
		this.lblLogin = lblLogin;
	}


	public LabelsTexto getLblSenha() {
		return lblSenha;
	}


	public void setLblSenha(LabelsTexto lblSenha) {
		this.lblSenha = lblSenha;
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


	public CamposTexto getTxtCargo() {
		return txtCargo;
	}


	public void setTxtCargo(CamposTexto txtCargo) {
		this.txtCargo = txtCargo;
	}


	public CamposTexto getTxtCidade() {
		return txtCidade;
	}


	public void setTxtCidade(CamposTexto txtCidade) {
		this.txtCidade = txtCidade;
	}


	public CamposTexto getTxtCpf() {
		return txtCpf;
	}


	public void setTxtCpf(CamposTexto txtCpf) {
		this.txtCpf = txtCpf;
	}


	public CamposTexto getTxtLogin() {
		return txtLogin;
	}


	public void setTxtLogin(CamposTexto txtLogin) {
		this.txtLogin = txtLogin;
	}


	public CamposTexto getTxtSenha() {
		return txtSenha;
	}


	public void setTxtSenha(CamposTexto txtSenha) {
		this.txtSenha = txtSenha;
	}


	public CadastrarFuncionarioController getController() {
		return controller;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public PainelCadastrarFuncionarios() {
		
		controller = new CadastrarFuncionarioController(this);
		
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
       lblCadastroClientes = new Titulo(269,32,602,60,"Cadastro Funcionarios");
       lblNome = new LabelsTexto(145,177,85,29,"Nome");
       lblEndereco = new LabelsTexto(115,229,121,29,"Endereço");
       lblTelefone = new LabelsTexto(128,282,114,29,"Telefone");
       lblEmail = new LabelsTexto(133,335,156,29,"Email");
       lblCargo = new LabelsTexto(140,389,88,29,"Cargo");
       lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
       lblCpf = new LabelsTexto(517,388,58,29,"CPF");
       lblLogin = new LabelsTexto(145,441,85,29,"Login");
       lblSenha = new LabelsTexto(145,494,85,29,"Senha");

        
     //Criando inputs texto na tela
       txtNome = new CamposTexto(260,177,645,29);
       txtEndereco = new CamposTexto(260,229,651,29);
       txtTelefone = new CamposTexto(260,282,195,29);
       txtEmail = new CamposTexto(260,335,651,29);
       txtCargo = new CamposTexto(260,388,195,29);
       txtCidade = new CamposTexto(715,282,195,29);
       txtCpf = new CamposTexto(620,388,285,29);
       txtLogin = new CamposTexto(260,441,285,29);
       txtSenha = new CamposTexto(260,494,285,29);
       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
        
        //Adicionando elementos a tela
        add(lblCadastroClientes);
        add(lblNome);
        add(lblEndereco);
        add(lblTelefone);
        add(lblEmail);
        add(lblCargo);
        add(lblCidade);
        add(lblCpf);
        add(lblLogin);
        add(lblSenha);
        add(txtNome);
        add(txtEndereco);
        add(txtTelefone);
        add(txtEmail);
        add(txtCargo);
        add(txtCidade);
        add(txtCpf);
        add(txtLogin);
        add(txtSenha);
        add(btnSalvar);
        add(btnLimpar);
        
        btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.salvarFuncionario());
				
			}
		});
        
        btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.limpar();
				
			}
		});
       
}}
