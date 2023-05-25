package controller;


import bancoDeDados.FuncionarioDAO;
import model.Funcionarios;
import view.paineis.PainelCadastrarFuncionarios;

public class CadastrarFuncionarioController {
	
	private final PainelCadastrarFuncionarios viewCadastrarFuncionarios;
	
	public CadastrarFuncionarioController(PainelCadastrarFuncionarios viewCadastrarFuncionarios) {
		this.viewCadastrarFuncionarios = viewCadastrarFuncionarios;
	}
	
	public String salvarFuncionario() {
		
		String mensagem;
		
		String nome = viewCadastrarFuncionarios.getTxtNome().getText();
		String documento = viewCadastrarFuncionarios.getTxtCpf().getText();
		String email = viewCadastrarFuncionarios.getTxtEmail().getText();
		String telefone = viewCadastrarFuncionarios.getTxtTelefone().getText();
		String endereco = viewCadastrarFuncionarios.getTxtEndereco().getText();
		String cidade = viewCadastrarFuncionarios.getTxtCidade().getText();
		String cargo = viewCadastrarFuncionarios.getTxtCargo().getText();
		String login = viewCadastrarFuncionarios.getTxtLogin().getText();
		String senha = viewCadastrarFuncionarios.getTxtSenha().getText();
		
		if(documento.length()>11||documento.length()<11) {
			mensagem = "O CPF deve conter 11 digitos!";
		}
		
		else if(senha.length()<8) {
			mensagem = "A senha deve conter pelo menos 8 digítos!";
		}
		else if(login.length()<=0) {
			mensagem = "É obrigatório informar um login!";
		}
		else {
			Funcionarios funcionario = new Funcionarios(nome, documento, telefone, endereco, email, cidade, cargo, login, senha);
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			
			mensagem = funcionarioDAO.salvarFuncionarioBanco(funcionario);
		
		}
		return mensagem;
	}
	
	public void limpar() {
		viewCadastrarFuncionarios.getTxtNome().setText("");
		viewCadastrarFuncionarios.getTxtCpf().setText("");
		viewCadastrarFuncionarios.getTxtEmail().setText("");
		viewCadastrarFuncionarios.getTxtTelefone().setText("");
		viewCadastrarFuncionarios.getTxtEndereco().setText("");
		viewCadastrarFuncionarios.getTxtCidade().setText("");
		viewCadastrarFuncionarios.getTxtCargo().setText("");
		viewCadastrarFuncionarios.getTxtLogin().setText("");
		viewCadastrarFuncionarios.getTxtSenha().setText("");
		
	}
	
}
