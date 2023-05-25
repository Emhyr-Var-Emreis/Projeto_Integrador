package paineis;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import estilos.BotaoEditar;
import estilos.BotaoLimpar;
import estilos.BotaoPesquisar;
import estilos.BotaoSalvar;
import estilos.CamposTexto;
import estilos.LabelsTexto;
import estilos.Titulo;


public class PainelConsultaClientes extends JPanel {
	public PainelConsultaClientes() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
		
       Titulo lblCadastroClientes = new Titulo(269,32,602,60,"Consulta de Clientes");
       LabelsTexto lblCodCliente = new LabelsTexto(68,124,159,29,"Cód Cliente");
       LabelsTexto lblNome = new LabelsTexto(145,177,85,29,"Nome");
       LabelsTexto lblEndereco = new LabelsTexto(115,229,121,29,"Endereço");
       LabelsTexto lblTelefone = new LabelsTexto(128,282,114,29,"Telefone");
       LabelsTexto lblEmail = new LabelsTexto(133,335,156,29,"Email");
       LabelsTexto lblVeiculo = new LabelsTexto(140,389,88,29,"Veiculo");
       LabelsTexto lblPjuridica = new LabelsTexto(107,443,141,29,"P.Juridica");
       LabelsTexto lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
       LabelsTexto lblCpf = new LabelsTexto(429,441,141,29,"CPF/CNPJ");

        
     //Criando inputs texto na tela
       CamposTexto txtCodCliente = new CamposTexto(260,124,81,29);
       CamposTexto txtNome = new CamposTexto(260,177,645,29);
       CamposTexto txtEndereco = new CamposTexto(260,229,651,29);
       CamposTexto txtTelefone = new CamposTexto(260,282,195,29);
       CamposTexto txtEmail = new CamposTexto(260,335,651,29);
       CamposTexto txtVeiculo = new CamposTexto(260,388,195,29);
       CamposTexto txtPjuridica = new CamposTexto(260,443,82,29);
       CamposTexto txtCidade = new CamposTexto(715,282,195,29);
       CamposTexto txtCpf = new CamposTexto(620,441,285,29);
       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
       BotaoEditar btnEditar = new BotaoEditar("Editar");
        
        //Adicionando elementos a tela
        add(lblCadastroClientes);
        add(lblCodCliente);
        add(lblNome);
        add(lblEndereco);
        add(lblTelefone);
        add(lblEmail);
        add(lblVeiculo);
        add(lblPjuridica);
        add(lblCidade);
        add(lblCpf);
        add(txtCodCliente);
        add(txtNome);
        add(txtEndereco);
        add(txtTelefone);
        add(txtEmail);
        add(txtVeiculo);
        add(txtPjuridica);
        add(txtCidade);
        add(txtCpf);
        add(btnSalvar);
        add(btnPesquisar);
        add(btnEditar);
        
        
       
}}