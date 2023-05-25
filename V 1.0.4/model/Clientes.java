package model;

public class Clientes {
	private int codigoCliente;
	private String nome;
	private String doc;
	private String email;
	private String telefone;
	private String endereco;
	private String cidade;
	private String pessoaJuridica;
	private String ativo;

	
	
	
	public Clientes(int codigoCliente, String nome, String doc, String email, String telefone, String endereco,
			String cidade, String pessoaJuridica, String ativo) {
		super();
		this.codigoCliente = codigoCliente;
		this.nome = nome;
		this.doc = doc;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.pessoaJuridica = pessoaJuridica;
		this.ativo = ativo;
	}



	public Clientes(String nome, String doc, String email, String telefone, String endereco, String cidade,
			String pessoaJuridica) {
		super();
		this.nome = nome;
		this.doc = doc;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.pessoaJuridica = pessoaJuridica;
	}



	public Clientes(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}



	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(String pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	

}
