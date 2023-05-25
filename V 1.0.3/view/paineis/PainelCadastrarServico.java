package view.paineis;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.CadastrarServicoController;
import view.estilos.BotaoLimpar;

import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.Titulo;


public class PainelCadastrarServico extends JPanel {

	private final CadastrarServicoController controller;
	
	private static final long serialVersionUID = 3651751950713351889L;

	private Titulo lblCadastroServico;
	private LabelsTexto lblNome;
	private LabelsTexto lblDescricao;
	private LabelsTexto lblValor;
	private CamposTexto txtNome;
	private CamposTexto txtDescricao;
	private CamposTexto txtValor;
	
	public Titulo getLblCadastroServico() {
		return lblCadastroServico;
	}

	public void setLblCadastroServico(Titulo lblCadastroServico) {
		this.lblCadastroServico = lblCadastroServico;
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

	public CadastrarServicoController getController() {
		return controller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PainelCadastrarServico() {
		
		controller = new CadastrarServicoController(this);
		
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
		
       lblCadastroServico = new Titulo(261,32,602,60,"Cadastro de Serviços");
       lblNome = new LabelsTexto(158,177,69,29,"Nome");
       lblDescricao = new LabelsTexto(105,230,117,29,"Descrição");
       lblValor = new LabelsTexto(610,283,59,29,"Valor");


        
     //Criando inputs texto na tela
       txtNome = new CamposTexto(260,177,650,29);
       txtDescricao = new CamposTexto(260,230,650,29);
       txtValor = new CamposTexto(715,283,195,29);

       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
       
        //Adicionando elementos a tela
        add(lblCadastroServico);
        add(lblNome);
        add(lblDescricao);
        add(lblValor);
        add(txtNome);
        add(txtDescricao);
        add(txtValor);
        add(btnSalvar);
        add(btnLimpar);
        
        btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.salvarServico());
				
			}
		});
        
        btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.limpar();
				
			}
		});
        
        
       
}}