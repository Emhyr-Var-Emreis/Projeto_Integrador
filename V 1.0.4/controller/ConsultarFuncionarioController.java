package controller;

import bancoDeDados.FuncionarioDAO;
import model.Funcionarios;
import view.paineis.PainelConsultarFuncionarios;

public class ConsultarFuncionarioController {

	private final PainelConsultarFuncionarios viewConsultaFuncionarios;

	public ConsultarFuncionarioController(PainelConsultarFuncionarios viewConsultaFuncionarios) {
		this.viewConsultaFuncionarios = viewConsultaFuncionarios;
	}

	public String pesquisarFuncionario() {

		String mensagem;

		try {
			int matricula = Integer.parseInt(viewConsultaFuncionarios.getTxtMatricula().getText());

			Funcionarios funcionario = new Funcionarios(matricula);

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			
			funcionarioDAO.pesquisarFuncionarioBanco(funcionario);

			if(funcionarioDAO.pesquisarFuncionarioBanco(funcionario)!=null) {
				viewConsultaFuncionarios.getTxtMatricula().setText(Integer.toString(funcionario.getMatricula()));
				viewConsultaFuncionarios.getTxtNome().setText(funcionario.getNome());
				viewConsultaFuncionarios.getTxtCpf().setText(funcionario.getDocFuncionario());
				viewConsultaFuncionarios.getTxtEmail().setText(funcionario.getEmail());
				viewConsultaFuncionarios.getTxtTelefone().setText(funcionario.getTelefone());
				viewConsultaFuncionarios.getTxtEndereco().setText(funcionario.getEndereco());
				viewConsultaFuncionarios.getTxtCidade().setText(funcionario.getCidade());
				viewConsultaFuncionarios.getTxtCargo().setText(funcionario.getCargo());
				viewConsultaFuncionarios.getTxtLogin().setText(funcionario.getUsuario());
				viewConsultaFuncionarios.getTxtSenha().setText(funcionario.getSenha());
				viewConsultaFuncionarios.getListaAtivo().setSelectedItem(funcionario.getAtivo());
				mensagem = "Funcionário Encontrado!";
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
		String teste = pesquisarFuncionario();
		if(teste.equals("Funcionário Encontrado!")) {
			viewConsultaFuncionarios.getBtnSalvar().setVisible(!viewConsultaFuncionarios.getBtnSalvar().isVisible());
			viewConsultaFuncionarios.getTxtMatricula().setEditable(!viewConsultaFuncionarios.getTxtMatricula().isEditable());
			viewConsultaFuncionarios.getTxtNome().setEditable(!viewConsultaFuncionarios.getTxtNome().isEditable());
			viewConsultaFuncionarios.getTxtCpf().setEditable(!viewConsultaFuncionarios.getTxtCpf().isEditable());
			viewConsultaFuncionarios.getTxtEmail().setEditable(!viewConsultaFuncionarios.getTxtEmail().isEditable());
			viewConsultaFuncionarios.getTxtTelefone().setEditable(!viewConsultaFuncionarios.getTxtTelefone().isEditable());
			viewConsultaFuncionarios.getTxtEndereco().setEditable(!viewConsultaFuncionarios.getTxtEndereco().isEditable());
			viewConsultaFuncionarios.getTxtCidade().setEditable(!viewConsultaFuncionarios.getTxtCidade().isEditable());
			viewConsultaFuncionarios.getTxtCargo().setEditable(!viewConsultaFuncionarios.getTxtCargo().isEditable());
			viewConsultaFuncionarios.getTxtLogin().setEditable(!viewConsultaFuncionarios.getTxtLogin().isEditable());
			viewConsultaFuncionarios.getTxtSenha().setEditable(!viewConsultaFuncionarios.getTxtSenha().isEditable());
			viewConsultaFuncionarios.getListaAtivo().setEnabled(!viewConsultaFuncionarios.getListaAtivo().isEnabled());

			mensagem = "Mudando modo de visualização de Cadastro!";

		}
		else {
			mensagem = "Foi encontrado um erro ao entrar no modo de edicão!";
		}
		return mensagem;
	}

	public String atualizarFuncionario(){
		String mensagem;

		int matricula = Integer.parseInt(viewConsultaFuncionarios.getTxtMatricula().getText());
		
		String nome = viewConsultaFuncionarios.getTxtNome().getText();
		String documento = viewConsultaFuncionarios.getTxtCpf().getText();
		String email = viewConsultaFuncionarios.getTxtEmail().getText();
		String telefone = viewConsultaFuncionarios.getTxtTelefone().getText();
		String endereco = viewConsultaFuncionarios.getTxtEndereco().getText();
		String cidade = viewConsultaFuncionarios.getTxtCidade().getText();
		String cargo = viewConsultaFuncionarios.getTxtCargo().getText();
		String login = viewConsultaFuncionarios.getTxtLogin().getText();
		String senha = viewConsultaFuncionarios.getTxtSenha().getText();
		String ativo = (String)viewConsultaFuncionarios.getListaAtivo().getSelectedItem();

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
			Funcionarios funcionario = new Funcionarios(matricula,nome, documento, telefone, endereco, email, ativo, cidade, cargo, login, senha);

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

			mensagem = funcionarioDAO.atualizarFuncionarioBanco(funcionario);

		}
		return mensagem;
	}
}

