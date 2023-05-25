package controller;

import bancoDeDados.ClientesDAO;
import model.Clientes;
import view.paineis.PainelCadastrarClientes;

public class CadastrarClienteController {
	private final PainelCadastrarClientes viewCadastroClientes;
	
	public CadastrarClienteController(PainelCadastrarClientes viewCadastroClientes) {
		this.viewCadastroClientes = viewCadastroClientes;
	}
	
	public String salvarCliente() {
		
		String mensagem;
		
		String nome = viewCadastroClientes.getTxtNome().getText();
		String endereco = viewCadastroClientes.getTxtEndereco().getText();
		String telefone = viewCadastroClientes.getTxtTelefone().getText();
		String cidade = viewCadastroClientes.getTxtCidade().getText();
		String email = viewCadastroClientes.getTxtEmail().getText();
		String doc = viewCadastroClientes.getTxtDoc().getText();
		String pessoaJuridica = (String) viewCadastroClientes.getListaPjuridica().getSelectedItem();
		
		if(pessoaJuridica.equals("Não") && (doc.length()>11 || doc.length()<11)) {
			mensagem = "O CPF deve conter 11 digitos!";
		}
		else if (pessoaJuridica.equals("Sim") && (doc.length()>14 || doc.length()<14)) {
			mensagem = "O CNPJ deve conter 14 digitos!";
		}
		else {
		Clientes cliente = new Clientes(nome, doc, email, telefone, endereco, cidade, pessoaJuridica);
		
		ClientesDAO clienteDAO = new ClientesDAO();
		
		mensagem = clienteDAO.salvarClientesBanco(cliente);}
		
		return mensagem;
	}
	
	public void limpar() {
		viewCadastroClientes.getTxtNome().setText("");
		viewCadastroClientes.getTxtTelefone().setText("");
		viewCadastroClientes.getTxtEndereco().setText("");
		viewCadastroClientes.getTxtCidade().setText("");
		viewCadastroClientes.getTxtEmail().setText("");
		viewCadastroClientes.getTxtDoc().setText("");

		
	}
	
}
