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


public class PainelCadastrarFuncionarios extends JPanel {
	public PainelCadastrarFuncionarios() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
		
       Titulo lblCadastroClientes = new Titulo(269,32,602,60,"Cadastro Funcionarios");
       LabelsTexto lblMatricula = new LabelsTexto(68,124,159,29,"Matricula");
       LabelsTexto lblNome = new LabelsTexto(145,177,85,29,"Nome");
       LabelsTexto lblEndereco = new LabelsTexto(115,229,121,29,"Endereço");
       LabelsTexto lblTelefone = new LabelsTexto(128,282,114,29,"Telefone");
       LabelsTexto lblEmail = new LabelsTexto(133,335,156,29,"Email");
       LabelsTexto lblCargo = new LabelsTexto(140,389,88,29,"Cargo");
       LabelsTexto lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
       LabelsTexto lblCpf = new LabelsTexto(517,388,58,29,"CPF");

        
     //Criando inputs texto na tela
       CamposTexto txtMatricula = new CamposTexto(260,124,81,29);
       CamposTexto txtNome = new CamposTexto(260,177,645,29);
       CamposTexto txtEndereco = new CamposTexto(260,229,651,29);
       CamposTexto txtTelefone = new CamposTexto(260,282,195,29);
       CamposTexto txtEmail = new CamposTexto(260,335,651,29);
       CamposTexto txtCargo = new CamposTexto(260,388,195,29);
       CamposTexto txtCidade = new CamposTexto(715,282,195,29);
       CamposTexto txtCpf = new CamposTexto(620,388,285,29);
       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
        
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
        add(txtMatricula);
        add(txtNome);
        add(txtEndereco);
        add(txtTelefone);
        add(txtEmail);
        add(txtCargo);
        add(txtCidade);
        add(txtCpf);
        add(btnSalvar);
        add(btnLimpar);
        
        
       
}}
