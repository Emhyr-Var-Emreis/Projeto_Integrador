package view.paineis;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Cliente;
import model.Veiculo;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelCadastrarVeiculos extends JPanel {
	public PainelCadastrarVeiculos() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
		Cliente cliente = new Cliente();
		
      //Criando texto na tela 
		
       Titulo lblCadastroVeiculos = new Titulo(269,32,602,60,"Cadastro Veículos");
       LabelsTexto lblModelo = new LabelsTexto(128,177,159,29,"Modelo");
       LabelsTexto lblMarca = new LabelsTexto(122,238,159,29,"Marca");
       LabelsTexto lblCliente = new LabelsTexto(101,291,159,29,"Cliente");
       LabelsTexto lblPlaca = new LabelsTexto(612,124,159,29,"Placa");
       LabelsTexto lblCor = new LabelsTexto(633,238,159,29,"Cor");

        
     //Criando inputs texto na tela
       CamposTexto txtModelo = new CamposTexto(260,177,645,29);
       CamposTexto txtMarca = new CamposTexto(260,238,195,29);
       ListaSuspensa txtCliente = new ListaSuspensa(cliente.clientesAtivos(),260,291,641,29);
       CamposTexto txtPlaca = new CamposTexto(710,124,195,29);
       CamposTexto txtCor = new CamposTexto(710,238,195,29);
       
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
        add(txtModelo);
        add(txtMarca);
        add(txtCliente);
        add(txtPlaca);
        add(txtCor);
        add(btnSalvar);
        add(btnLimpar);
        
        
       
}}
