package view.paineis;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.estilos.BotaoEditar;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.Titulo;


public class PainelConsultaServico extends JPanel {
	public PainelConsultaServico() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
		
       Titulo lblCadastroServico = new Titulo(261,32,602,60,"Consulta de Serviços");
       LabelsTexto lblCodServico = new LabelsTexto(101,121,126,29,"Cód Serviço");
       LabelsTexto lblNome = new LabelsTexto(158,177,69,29,"Nome");
       LabelsTexto lblDescricao = new LabelsTexto(105,230,117,29,"Descrição");
       LabelsTexto lblValor = new LabelsTexto(610,283,59,29,"Valor");


        
     //Criando inputs texto na tela
       CamposTexto txtCodServico = new CamposTexto(260,124,81,29);
       CamposTexto txtNome = new CamposTexto(260,177,650,29);
       CamposTexto txtDescricao = new CamposTexto(260,230,650,29);
       CamposTexto txtValor = new CamposTexto(715,283,195,29);

       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
       BotaoEditar btnEditar = new BotaoEditar("Editar");
        
        //Adicionando elementos a tela
        add(lblCadastroServico);
       	add(lblCodServico);
        add(lblNome);
        add(lblDescricao);
        add(lblValor);
        add(txtCodServico);
        add(txtNome);
        add(txtDescricao);
        add(txtValor);
        add(btnSalvar);
        add(btnPesquisar);
        add(btnEditar);
        
        
       
}}
