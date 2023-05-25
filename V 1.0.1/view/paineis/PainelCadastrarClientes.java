package view.paineis;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Cliente;
import view.estilos.BotaoLimpar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelCadastrarClientes extends JPanel {
	
	private static final long serialVersionUID = 4526471595649803728L;

	public PainelCadastrarClientes() {
		setSize(1040,768);
		setBackground(new Color(109, 110, 114));
		setLayout(null);
		
      //Criando texto na tela 
		
       Titulo lblCadastroClientes = new Titulo(269,32,602,60,"Cadastro de Clientes");
       LabelsTexto lblNome = new LabelsTexto(145,177,85,29,"Nome");
       LabelsTexto lblEndereco = new LabelsTexto(115,229,121,29,"Endereço");
       LabelsTexto lblTelefone = new LabelsTexto(128,282,114,29,"Telefone");
       LabelsTexto lblEmail = new LabelsTexto(133,335,156,29,"Email");
       LabelsTexto lblPjuridica = new LabelsTexto(107,388,141,29,"P.Juridica");
       LabelsTexto lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
       LabelsTexto lblCpf = new LabelsTexto(429,388,141,29,"CPF/CNPJ");

        
     //Criando inputs texto e lista suspensa na tela
       CamposTexto txtNome = new CamposTexto(260,177,645,29);
       CamposTexto txtEndereco = new CamposTexto(260,229,651,29);
       CamposTexto txtTelefone = new CamposTexto(260,282,195,29);
       CamposTexto txtEmail = new CamposTexto(260,335,651,29);
       String[] itensDropdown = {"Sim","Não"};
       ListaSuspensa listaPjuridica = new ListaSuspensa(itensDropdown,260,388,82,29);
       CamposTexto txtCidade = new CamposTexto(715,282,195,29);
       CamposTexto txtCpf = new CamposTexto(620,388,285,29);
       
       //Criando botoes da tela
       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
        
        //Adicionando elementos a tela
        add(lblCadastroClientes);
        add(lblNome);
        add(lblEndereco);
        add(lblTelefone);
        add(lblEmail);
        add(lblPjuridica);
        add(lblCidade);
        add(lblCpf);
        add(txtNome);
        add(txtEndereco);
        add(txtTelefone);
        add(txtEmail);
        add(listaPjuridica);
        add(txtCidade);
        add(txtCpf);
        add(btnSalvar);
        add(btnLimpar);
        
        //Inserindo acao no botao limpar
        btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");
				txtEmail.setText("");
				txtCidade.setText("");
				txtCpf.setText("");
				
			}
		});
        
        //Inserindo acao no botao salvar
        btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				cliente.setTelefone(txtTelefone.getText());
				cliente.setEndereco(txtEndereco.getText());
				cliente.setCidade(txtCidade.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setCpfCnpj(txtCpf.getText());
				if(listaPjuridica.getSelectedIndex()==0) {
					cliente.setIsPessoaJuridica("Sim");
				}
				else if(listaPjuridica.getSelectedIndex()==1) {
					cliente.setIsPessoaJuridica("Não");
				}
			
				JOptionPane.showMessageDialog(null, cliente.salvarCliente(cliente) );
				
			}
		});
        
       
}}
