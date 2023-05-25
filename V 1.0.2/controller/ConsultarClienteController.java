package controller;

import bancoDeDados.ClientesDAO;
import model.Clientes;
import view.paineis.PainelConsultarClientes;

public class ConsultarClienteController {
	
	private final PainelConsultarClientes viewConsultaClientes;
	
	public ConsultarClienteController (PainelConsultarClientes viewConsultarClientes) {
		this.viewConsultaClientes = viewConsultarClientes;
	}
	
	public String pesquisarCliente() {
		
		String mensagem;
		
		try {
		int codigo = Integer.parseInt(viewConsultaClientes.getTxtCodCliente().getText());

		
		Clientes cliente = new Clientes(codigo);
		
		ClientesDAO clienteDAO = new ClientesDAO();
		
		clienteDAO.pesquisarClienteBanco(cliente);
		
		if(clienteDAO.pesquisarClienteBanco(cliente)!=(null)) {
			viewConsultaClientes.getTxtCodCliente().setText(Integer.toString(cliente.getCodigoCliente()));
			viewConsultaClientes.getTxtNome().setText(cliente.getNome());
			viewConsultaClientes.getTxtEndereco().setText(cliente.getEndereco());
			viewConsultaClientes.getTxtTelefone().setText(cliente.getTelefone());
			viewConsultaClientes.getTxtEmail().setText(cliente.getEmail());
			viewConsultaClientes.getListaPjuridica().setSelectedItem(cliente.getPessoaJuridica());
			viewConsultaClientes.getListaAtivo().setSelectedItem(cliente.getAtivo());
			viewConsultaClientes.getTxtCidade().setText(cliente.getCidade());
			viewConsultaClientes.getTxtDoc().setText(cliente.getDoc());
			mensagem = "Cliente encontrado!";
		}
		else {
			mensagem = "Ocorreu um erro ao buscar o cliente!";
		}
		}
		catch(NumberFormatException erro) {
			mensagem = "Por favor digite um código válido!";
		}
		return mensagem;
	}
	
	public String liberarEdicao() {
		String mensagem;
		pesquisarCliente();
		if(pesquisarCliente().equals("Cliente encontrado!")){
			viewConsultaClientes.getBtnSalvar().setVisible(!viewConsultaClientes.getBtnSalvar().isVisible());
			viewConsultaClientes.getTxtCodCliente().setEditable(!viewConsultaClientes.getTxtCodCliente().isEditable());
			viewConsultaClientes.getTxtNome().setEditable(!viewConsultaClientes.getTxtNome().isEditable());
			viewConsultaClientes.getTxtEndereco().setEditable(!viewConsultaClientes.getTxtEndereco().isEditable());
			viewConsultaClientes.getTxtTelefone().setEditable(!viewConsultaClientes.getTxtTelefone().isEditable());
			viewConsultaClientes.getTxtEmail().setEditable(!viewConsultaClientes.getTxtEmail().isEditable());
			viewConsultaClientes.getListaAtivo().setEnabled(!viewConsultaClientes.getListaAtivo().isEnabled());
			viewConsultaClientes.getListaPjuridica().setEnabled(!viewConsultaClientes.getListaPjuridica().isEnabled());
			viewConsultaClientes.getTxtCidade().setEditable(!viewConsultaClientes.getTxtCidade().isEditable());
			viewConsultaClientes.getTxtDoc().setEditable(!viewConsultaClientes.getTxtDoc().isEditable());
			
			mensagem = "Mudando modo de visualização de Cadastro!";
		}
		else {
			mensagem = "Foi encontrado um erro ao entrar no modo de edicão!";
		}
		return mensagem;
	}
	
	public String atualizarCliente() {
	String mensagem;
	
	int codigo = Integer.parseInt(viewConsultaClientes.getTxtCodCliente().getText());
	String nome = viewConsultaClientes.getTxtNome().getText();
	String endereco = viewConsultaClientes.getTxtEndereco().getText();
	String telefone = viewConsultaClientes.getTxtTelefone().getText();
	String cidade = viewConsultaClientes.getTxtCidade().getText();
	String email = viewConsultaClientes.getTxtEmail().getText();
	String doc = viewConsultaClientes.getTxtDoc().getText();
	String pessoaJuridica = (String) viewConsultaClientes.getListaPjuridica().getSelectedItem();
	String ativo = (String)viewConsultaClientes.getListaAtivo().getSelectedItem();
	
	if(pessoaJuridica.equals("Não") && (doc.length()>11 || doc.length()<11)) {
		mensagem = "O CPF deve conter 11 digitos!";
	}
	else if (pessoaJuridica.equals("Sim") && (doc.length()>14 || doc.length()<14)) {
		mensagem = "O CNPJ deve conter 14 digitos!";
	}
	else {
	Clientes cliente = new Clientes(codigo,nome,doc,email,telefone,endereco,cidade,pessoaJuridica,ativo);
	
	ClientesDAO clienteDAO = new ClientesDAO();
	
	mensagem = clienteDAO.atualizarClienteBanco(cliente);}
	
	return mensagem;
	}
	
}
