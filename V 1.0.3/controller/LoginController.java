package controller;

import bancoDeDados.FuncionarioDAO;
import model.Funcionarios;
import view.TelaInicial;
import view.TelaLogin;
import view.TelaPrincipal;

public class LoginController {
	
	private final TelaLogin viewLogin;
	
	public LoginController(TelaLogin viewLogin) {
		this.viewLogin = viewLogin;
		
	}
	
	public String autenticarUsuario(){
		String mensagem;
		
		String login = viewLogin.getTxtUsuario().getText();
		String senha = viewLogin.getTxtSenha().getText();
		
		Funcionarios funcionario = new Funcionarios(login,senha);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if(funcionarioDAO.autenticarFuncionario(funcionario).equals("Gerente")) {
			mensagem = "Acesso autorizado GERENTE"; 
			viewLogin.getFrame().dispose();
			TelaPrincipal telaPrincipal = new TelaPrincipal();
			
		}
		else if(funcionarioDAO.autenticarFuncionario(funcionario).equals("")){
			mensagem = "Usuário ou senha incorretos!";
		}
		else{
			mensagem ="Acesso autorizado!";
			viewLogin.getFrame().dispose();
			TelaPrincipal telaPrincipal = new TelaPrincipal();
			telaPrincipal.getBtnFuncionarios().setVisible(false);
		}
		return mensagem;
	}

}
