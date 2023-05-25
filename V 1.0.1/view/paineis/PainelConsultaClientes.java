package view.paineis;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Cliente;
import view.estilos.BotaoEditar;
import view.estilos.BotaoPesquisar;
import view.estilos.BotaoSalvar;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.ListaSuspensa;
import view.estilos.Titulo;


public class PainelConsultaClientes extends JPanel {

	private static final long serialVersionUID = 1408949973047635576L;

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
		LabelsTexto lblPjuridica = new LabelsTexto(107,388,141,29,"P.Juridica");
		LabelsTexto lblCidade = new LabelsTexto(583,282,102,29,"Cidade");
		LabelsTexto lblCpf = new LabelsTexto(429,388,141,29,"CPF/CNPJ");
		LabelsTexto lblAtivo = new LabelsTexto(167,449,63,29,"Ativo");


		//Criando inputs texto e listas Suspensas na tela
		CamposTexto txtCodCliente = new CamposTexto(260,124,81,29);
		CamposTexto txtNome = new CamposTexto(260,177,645,29);
		txtNome.setEditable(false);
		CamposTexto txtEndereco = new CamposTexto(260,229,651,29);
		txtEndereco.setEditable(false);
		CamposTexto txtTelefone = new CamposTexto(260,282,195,29);
		txtTelefone.setEditable(false);
		CamposTexto txtEmail = new CamposTexto(260,335,651,29);
		txtEmail.setEditable(false);
		String[] itensAtivo = {"Sim","Não"};
		ListaSuspensa listaAtivo = new ListaSuspensa(itensAtivo,260,449,82,29);
		listaAtivo.setEnabled(false);
		String[] itensDropdown = {"Sim","Não"};
		ListaSuspensa listaPjuridica = new ListaSuspensa(itensDropdown,260,388,82,29);
		listaPjuridica.setEnabled(false);
		CamposTexto txtCidade = new CamposTexto(715,282,195,29);
		txtCidade.setEditable(false);
		CamposTexto txtCpf = new CamposTexto(620,388,285,29);
		txtCpf.setEditable(false);



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
		add(lblAtivo);
		add(lblPjuridica);
		add(lblCidade);
		add(lblCpf);
		add(txtCodCliente);
		add(txtNome);
		add(txtEndereco);
		add(txtTelefone);
		add(txtEmail);
		add(listaPjuridica);
		add(txtCidade);
		add(txtCpf);
		add(listaAtivo);
		add(btnSalvar);
		btnSalvar.setVisible(false);
		add(btnPesquisar);
		add(btnEditar);
		
		
		//Inserindo acao no botao pesquisar
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int codCliente = Integer.parseInt(txtCodCliente.getText());
					Cliente cliente = new Cliente();

					if(cliente.pesquisarCliente(codCliente)!=null) {
						cliente = cliente.pesquisarCliente(codCliente);
						txtCodCliente.setText(Integer.toString(cliente.getCodCliente()));
						txtNome.setText(cliente.getNome());
						txtEndereco.setText(cliente.getEndereco());
						txtTelefone.setText(cliente.getTelefone());
						txtEmail.setText(cliente.getEmail());
						if(cliente.getAtivo().equals("sim")) {
							listaAtivo.setSelectedIndex(0);
						}
						else {
							listaAtivo.setSelectedIndex(1);
						}
						if(cliente.getIsPessoaJuridica().equals("Sim")) {
							listaPjuridica.setSelectedIndex(0);
						}
						else {
							listaPjuridica.setSelectedIndex(1);
						}

						txtCidade.setText(cliente.getCidade());
						txtCpf.setText(cliente.getCpfCnpj());
					}
					else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado");
					}
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor digite um código válido!" + erro);
				}
		}});

		//Inserindo acao no botao editar
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				int codCliente = Integer.parseInt(txtCodCliente.getText());
				Cliente cliente = new Cliente();
				if(cliente.pesquisarCliente(codCliente)!=null) {

					//Pesquisando Cliente
					cliente = cliente.pesquisarCliente(codCliente);
					txtCodCliente.setText(Integer.toString(cliente.getCodCliente()));
					txtNome.setText(cliente.getNome());
					txtEndereco.setText(cliente.getEndereco());
					txtTelefone.setText(cliente.getTelefone());
					txtEmail.setText(cliente.getEmail());
					if(cliente.getAtivo().equals("sim")) {
						listaAtivo.setSelectedIndex(0);
					}
					else {
						listaAtivo.setSelectedIndex(1);
					}
					if(cliente.getIsPessoaJuridica().equals("Sim")) {
						listaPjuridica.setSelectedIndex(0);
					}
					else {
						listaPjuridica.setSelectedIndex(1);
					}

					txtCidade.setText(cliente.getCidade());
					txtCpf.setText(cliente.getCpfCnpj());

					//Editando Cliente
					btnSalvar.setVisible(!btnSalvar.isVisible());
					txtCodCliente.setEditable(!txtCodCliente.isEditable());
					txtNome.setEditable(!txtNome.isEditable());
					txtEndereco.setEditable(!txtEndereco.isEditable());
					txtTelefone.setEditable(!txtTelefone.isEditable());
					txtEmail.setEditable(!txtEmail.isEditable());
					listaAtivo.setEnabled(!listaAtivo.isEnabled());
					listaPjuridica.setEnabled(!listaPjuridica.isEnabled());
					txtCidade.setEditable(!txtCidade.isEditable());
					txtCpf.setEditable(!txtCpf.isEditable());
				}

				else {
					JOptionPane.showMessageDialog(null, "Apenas é possível editar um cliente existente!");
				}
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor digite um código válido!");
				}
			}

		});
		
		
		//Inserindo acao no botao salvar
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				cliente.setNome(txtNome.getText());
				cliente.setTelefone(txtTelefone.getText());
				cliente.setEndereco(txtEndereco.getText());
				cliente.setCidade(txtCidade.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setCpfCnpj(txtCpf.getText());
				if(listaAtivo.getSelectedIndex()==0) {
					cliente.setAtivo("sim");
				}
				else if(listaAtivo.getSelectedIndex()==1) {
					cliente.setAtivo("não");
				}
				if(listaPjuridica.getSelectedIndex()==0) {
					cliente.setIsPessoaJuridica("Sim");
				}
				else if(listaPjuridica.getSelectedIndex()==1) {
					cliente.setIsPessoaJuridica("Não");
				}
			
				JOptionPane.showMessageDialog(null, cliente.atualizarCliente(cliente) );
				
			}
			});

	}}