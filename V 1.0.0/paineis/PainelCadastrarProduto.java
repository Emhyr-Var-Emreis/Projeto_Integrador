package paineis;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import estilos.BotaoLimpar;
import estilos.BotaoSalvar;
import estilos.CamposTexto;
import estilos.LabelsTexto;
import estilos.Titulo;


public class PainelCadastrarProduto extends JPanel {
	public PainelCadastrarProduto() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
		
       Titulo lblCadastroProdutos = new Titulo(269,32,602,60,"Cadastro de Produto");
       LabelsTexto lblCodProduto = new LabelsTexto(68,124,159,29,"Cód Produto");
       LabelsTexto lblNome = new LabelsTexto(145,177,85,29,"Nome");
       LabelsTexto lblDescricao = new LabelsTexto(115,229,121,29,"Descrição");
       LabelsTexto lblUnidadeMedida = new LabelsTexto(32,330,210,29,"Unidade Medida");
       LabelsTexto lblValorUnitario = new LabelsTexto(515,330,170,29,"Valor Unitário");

        
     //Criando inputs texto na tela
       CamposTexto txtCodProduto = new CamposTexto(260,124,81,29);
       CamposTexto txtNome = new CamposTexto(260,177,645,29);
       CamposTexto txtDescricao = new CamposTexto(260,229,645,77);
       CamposTexto txtUnidadeMedida = new CamposTexto(260,330,83,29);
       CamposTexto txtValorUnitario = new CamposTexto(715,330,195,29);

       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
        
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
        add(btnLimpar);
        
        
       
}}
