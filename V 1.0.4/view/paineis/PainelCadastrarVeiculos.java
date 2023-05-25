package view.paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


import controller.CadastrarVeiculoController;


import view.estilos.BotaoLimpar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelCadastrarVeiculos extends JPanel {

	private final CadastrarVeiculoController controller;
	
	private static final long serialVersionUID = -6263702609942259905L;

	
    private Titulo lblCadastroVeiculos;
    private LabelsTexto lblModelo;
    private LabelsTexto lblMarca;
    private LabelsTexto lblCliente;
    private LabelsTexto lblPlaca;
    private LabelsTexto lblCor;
    private LabelsTexto lblAno;
    private CamposTexto txtModelo;
    private CamposTexto txtMarca;
    private ListaSuspensa listaCliente;
    private CamposTexto txtPlaca;
    private CamposTexto txtCor;
    private CamposTexto txtAno;
	
	
	public Titulo getLblCadastroVeiculos() {
		return lblCadastroVeiculos;
	}




	public void setLblCadastroVeiculos(Titulo lblCadastroVeiculos) {
		this.lblCadastroVeiculos = lblCadastroVeiculos;
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




	public CadastrarVeiculoController getController() {
		return controller;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public PainelCadastrarVeiculos() {
		
		controller = new CadastrarVeiculoController(this);
		
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
		//Clientes cliente = new Clientes();
		
      //Criando texto na tela 
		
       lblCadastroVeiculos = new Titulo(269,32,602,60,"Cadastro Veículos");
       lblModelo = new LabelsTexto(128,177,159,29,"Modelo");
       lblMarca = new LabelsTexto(122,238,159,29,"Marca");
       lblCliente = new LabelsTexto(101,291,159,29,"Cliente");
       lblPlaca = new LabelsTexto(612,124,159,29,"Placa");
       lblCor = new LabelsTexto(633,238,159,29,"Cor");
       lblAno = new LabelsTexto(122,345,159,29,"Ano");

        
     //Criando inputs texto na tela
       txtModelo = new CamposTexto(260,177,645,29);
       txtMarca = new CamposTexto(260,238,195,29);
       listaCliente = new ListaSuspensa(controller.listarClientes(),260,291,641,29);
       txtPlaca = new CamposTexto(710,124,195,29);
       txtCor = new CamposTexto(710,238,195,29);
       txtAno = new CamposTexto(260,345,195,29);
       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
        
        //Adicionando elementos a tela
        add(lblCadastroVeiculos);
        add(lblModelo);
        add(lblMarca);
        add(lblCliente);
        add(lblPlaca);
        add(lblCor);
        add(lblAno);
        add(txtModelo);
        add(txtMarca);
        add(listaCliente);
        add(txtPlaca);
        add(txtCor);
        add(txtAno);
        add(btnSalvar);
        add(btnLimpar);
        
      //Inserindo acao no botao salvar
        btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controller.salvarVeiculo());
			}
		});
        
        btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.limpar();
				
			}
		});
        
       
}}
