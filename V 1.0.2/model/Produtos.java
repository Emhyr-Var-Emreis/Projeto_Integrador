package model;

public class Produtos {
	private int codigoProduto;
	private String nome;
	private double valorUnitario;
	private String descricao;
	private String unidadeMedida;
	
	
	
	public Produtos(int codigoProduto) {
		super();
		this.codigoProduto = codigoProduto;
	}
	public Produtos(String nome, double valorUnitario, String descricao, String unidadeMedida) {
		super();
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
	}
	public Produtos(int codigoProduto, String nome, double valorUnitario, String descricao, String unidadeMedida) {
		super();
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	

}
