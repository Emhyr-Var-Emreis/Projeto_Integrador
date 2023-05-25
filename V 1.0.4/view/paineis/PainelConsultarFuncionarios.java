package view.paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ConsultarFuncionarioController;
import view.estilos.BotaoEditar;
import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelConsultarFuncionarios extends JPanel {
	
	private final ConsultarFuncionarioController controller;
	
	private static final long serialVersionUID = -8027311471986905288L;
	
	private Titulo lblCadastroClientes;
	private LabelsTexto lblMatricula;
	private LabelsTexto lblNome;
	private LabelsTexto lblEndereco;
	private LabelsTexto lblTelefone;
	private LabelsTexto lblEmail;
	private LabelsTexto lblCargo;
	private LabelsTexto lblCidade;
	private LabelsTexto lblCpf;
	private LabelsTexto lblLogin;
	private LabelsTexto lblSenha;
	private LabelsTexto lblAtivo ;
	private CamposTexto txtMatricula;
	private CamposTexto txtNome;
	private CamposTexto txtEndereco;
	private CamposTexto txtTelefone;
	private CamposTexto txtEmail;
	private CamposTexto txtCargo;
	private CamposTexto txtCidade;
	private CamposTexto txtCpf;
	private CamposTexto txtLogin;
	private CamposTexto txtSenha;
	private ListaSuspensa listaAtivo;
	private BotaoSalvar btnSalvar;
	
	
	
	public Titulo getLblCadastroClientes() {
		return lblCadastroClientes;
	}



	public void setLblCadastroClientes(Titulo lblCadastroClientes) {
		this.lblCadastroClientes = lblCadastroClientes;
	}



	public LabelsTexto getLblMatricula() {
		return lblMatricula;
	}



	public void setLblMatricula(LabelsTexto lblMatricula) {
		this.lblMatricula = lblMatricula;
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



	public LabelsTexto getLblAtivo() {
		return lblAtivo;
	}



	public void setLblAtivo(LabelsTexto lblAtivo) {
		this.lblAtivo = lblAtivo;
	}



	public CamposTexto getTxtMatricula() {
		return txtMatricula;
	}



	public void setTxtMatricula(CamposTexto txtMatricula) {
		this.txtMatricula = txtMatricula;
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



	public ConsultarFuncionarioController getController() {
		return controller;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public PainelConsultarFuncionarios() {
		
		controller = new ConsultarFuncionarioController(this);
		
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);

		//Criando texto na tela 

		lblCadastroClientes = new Titulo(269,32,602,60,"Consulta Funcionarios");
		lblMatricula = new LabelsTexto(68,124,159,29,"Matricula");
		lblNome = new LabelsTexto(145,177,85,29,"Nome");
		lblEndereco = new LabelsTexto(115,229,121,29,"Endereço");
		lblTelefone = new LabelsTexto(128,282,114,29,"Telefone");
		lblEmail = new LabelsTexto(133,335,156,29,"Email");
		lblCargo = new LabelsTexto(140,389,88,29,"Cargo");
		lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
		lblCpf = new LabelsTexto(517,388,58,29,"CPF");
		lblLogin = new LabelsTexto(145,441,85,29,"Login");
		lblSenha = new LabelsTexto(145,494,85,29,"Senha");
		lblAtivo = new LabelsTexto(145, 550, 85, 29, "Ativo");


		//Criando inputs texto na tela
		txtMatricula = new CamposTexto(260,124,81,29);
		txtNome = new CamposTexto(260,177,645,29);
		txtNome.setEditable(false);
		txtEndereco = new CamposTexto(260,229,651,29);
		txtEndereco.setEditable(false);
		txtTelefone = new CamposTexto(260,282,195,29);
		txtTelefone.setEditable(false);
		txtEmail = new CamposTexto(260,335,651,29);
		txtEmail.setEditable(false);
		txtCargo = new CamposTexto(260,388,195,29);
		txtCargo.setEditable(false);
		txtCidade = new CamposTexto(715,282,195,29);
		txtCidade.setEditable(false);
		txtCpf = new CamposTexto(620,388,285,29);
		txtCpf.setEditable(false);
		txtLogin = new CamposTexto(260,441,285,29);
		txtLogin.setEditable(false);
		txtSenha = new CamposTexto(260,494,285,29);
		txtSenha.setEditable(false);
		String[] itensAtivo = {"Sim","Não"};
		listaAtivo = new ListaSuspensa(itensAtivo,260,550,82,29);
		listaAtivo.setEnabled(false);

		//Criando botoes da tela
		btnSalvar = new BotaoSalvar("Salvar");
		BotaoEditar btnEditar = new BotaoEditar("Editar");
		BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");

		//Adicionando elementos a tela
		add(lblCadastroClientes);
		add(lblMatricula);
		add(lblNome);
		add(lblEndereco);
		add(lblTelefone);
		add(lblEmail);
		add(lblCargo);
		add(lblCidade);
		add(lblCpf);
		add(lblLogin);
		add(lblSenha);
		add(lblAtivo);
		add(txtMatricula);
		add(txtNome);
		add(txtEndereco);
		add(txtTelefone);
		add(txtEmail);
		add(txtCargo);
		add(txtCidade);
		add(txtCpf);
		add(txtLogin);
		add(listaAtivo);
		add(txtSenha);
		add(btnSalvar);
		btnSalvar.setVisible(false);
		add(btnEditar);
		add(btnPesquisar);
		
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.pesquisarFuncionario());
				
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
				JOptionPane.showMessageDialog(null, controller.atualizarFuncionario());
				
			}
		});


	}}
