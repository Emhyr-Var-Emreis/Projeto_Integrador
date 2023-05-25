package model;

public class Funcionarios {
	private int matricula;
	private String nome;
	private String docFuncionario;
	private String telefone;
	private String endereco;
	private String email;
	
	public Funcionarios(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	public Funcionarios(int matricula, String nome, String docFuncionario, String telefone, String endereco,
			String email, String ativo, String cidade, String cargo, String usuario, String senha) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.docFuncionario = docFuncionario;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.ativo = ativo;
		this.cidade = cidade;
		this.cargo = cargo;
		this.usuario = usuario;
		this.senha = senha;
	}
	private String ativo;

	public Funcionarios(int matricula) {
		super();
		this.matricula = matricula;
	}

	public Funcionarios(String nome, String docFuncionario, String telefone, String endereco, String email,
			String cidade, String cargo, String usuario, String senha) {
		super();
		this.nome = nome;
		this.docFuncionario = docFuncionario;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.cidade = cidade;
		this.cargo = cargo;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String cidade;
	private String cargo;
	private String usuario;
	private String senha;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocFuncionario() {
		return docFuncionario;
	}
	public void setDocFuncionario(String docFuncionario) {
		this.docFuncionario = docFuncionario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
}
