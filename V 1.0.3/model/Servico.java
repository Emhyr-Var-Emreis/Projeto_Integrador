package model;

public class Servico {
	private int codServico;
	private String nome;
	private String descricao;
	private double valor;
	
	
	public Servico(int codServico, String nome, String descricao, double valor) {
		super();
		this.codServico = codServico;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Servico(int codServico) {
		super();
		this.codServico = codServico;
	}
	public Servico(String nome, String descricao, double valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	public int getCodServico() {
		return codServico;
	}
	public void setCodServico(int codServico) {
		this.codServico = codServico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	


}
