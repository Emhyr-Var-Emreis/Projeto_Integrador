package view.paineis;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


import controller.ConsultarProdutoController;
import view.estilos.BotaoEditar;

import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.Titulo;


public class PainelConsultarProdutos extends JPanel {

	private final ConsultarProdutoController controller;
	
	private Titulo lblCadastroProdutos;
	private LabelsTexto lblCodProduto;
	private LabelsTexto lblNome;
	private LabelsTexto lblDescricao;
	private LabelsTexto lblUnidadeMedida;
	private LabelsTexto lblValorUnitario;
	private CamposTexto txtNome;
	private CamposTexto txtDescricao;
	private CamposTexto txtUnidadeMedida;
	private CamposTexto txtValorUnitario;
	private CamposTexto txtCodProduto;
	private BotaoSalvar btnSalvar;
	
	public Titulo getLblCadastroProdutos() {
		return lblCadastroProdutos;
	}

	public void setLblCadastroProdutos(Titulo lblCadastroProdutos) {
		this.lblCadastroProdutos = lblCadastroProdutos;
	}

	public LabelsTexto getLblCodProduto() {
		return lblCodProduto;
	}

	public void setLblCodProduto(LabelsTexto lblCodProduto) {
		this.lblCodProduto = lblCodProduto;
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

	public CamposTexto getTxtCodProduto() {
		return txtCodProduto;
	}

	public void setTxtCodProduto(CamposTexto txtCodProduto) {
		this.txtCodProduto = txtCodProduto;
	}

	public BotaoSalvar getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(BotaoSalvar btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public ConsultarProdutoController getController() {
		return controller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = -7899800350557387897L;

	public PainelConsultarProdutos() {
		
		controller = new ConsultarProdutoController(this);
		
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
		
       lblCadastroProdutos = new Titulo(269,32,602,60,"Consulta de Produto");
       lblCodProduto = new LabelsTexto(68,124,159,29,"Cód Produto");
       lblNome = new LabelsTexto(145,177,85,29,"Nome");
       lblDescricao = new LabelsTexto(115,229,121,29,"Descrição");
       lblUnidadeMedida = new LabelsTexto(32,282,210,29,"Unidade Medida");
       lblValorUnitario = new LabelsTexto(515,282,170,29,"Valor Unitário");

        
     //Criando inputs texto na tela
       txtCodProduto = new CamposTexto(260,124,81,29);
       txtNome = new CamposTexto(260,177,645,29);
       txtNome.setEditable(false);
       txtDescricao = new CamposTexto(260,229,645,29);
       txtDescricao.setEditable(false);
       txtUnidadeMedida = new CamposTexto(260,282,83,29);
       txtUnidadeMedida.setEditable(false);
       txtValorUnitario = new CamposTexto(715,282,195,29);
       txtValorUnitario.setEditable(false);

       
       //Criando botoes da tela
       btnSalvar = new BotaoSalvar("Salvar");
       BotaoEditar btnEditar = new BotaoEditar("Editar");
       BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
        
        //Adicionando elementos a tela
        add(lblCadastroProdutos);
        add(lblCodProduto);
        add(lblNome);
        add(lblDescricao);
        add(lblUnidadeMedida);
        add(lblValorUnitario);
        add(txtCodProduto);
        add(txtNome);
        add(txtDescricao);
        add(txtUnidadeMedida);
        add(txtValorUnitario);
        add(btnSalvar);
        btnSalvar.setVisible(false);
        add(btnPesquisar);
        add(btnEditar);
        
        btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, controller.pesquisarProduto());
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
 				
 				JOptionPane.showMessageDialog(null, controller.atualizarProduto());
 				
 			}
 		});
        
       
}}
