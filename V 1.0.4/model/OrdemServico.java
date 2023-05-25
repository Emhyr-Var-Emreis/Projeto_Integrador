package model;

import java.time.LocalDate;
import java.util.List;

public class OrdemServico {
	private int codServico;
	private String status;
	private LocalDate dataExecucao;
	private Veiculos veiculo;
	private Funcionarios funcionario;
	private double valorTotal;
	private List<ItemProduto> produtos;
	private List<ItemServico> servico;
	private LocalDate dataCriacao;
	
	
	

	
	public OrdemServico(int codServico) {
		super();
		this.codServico = codServico;
	}


	public OrdemServico(String status, LocalDate dataExecucao, Veiculos veiculo, Funcionarios funcionario,
			double valorTotal, List<ItemProduto> produtos, List<ItemServico> servico) {
		super();
		this.status = status;
		this.dataExecucao = dataExecucao;
		this.veiculo = veiculo;
		this.funcionario = funcionario;
		this.valorTotal = valorTotal;
		this.produtos = produtos;
		this.servico = servico;
	}


	public OrdemServico(int codServico, String status, LocalDate dataExecucao, Veiculos veiculo, Funcionarios funcionario,
			double valorTotal, List<ItemProduto> produtos, List<ItemServico> servico) {
		super();
		this.codServico = codServico;
		this.status = status;
		this.dataExecucao = dataExecucao;
		this.veiculo = veiculo;
		this.funcionario = funcionario;
		this.valorTotal = valorTotal;
		this.produtos = produtos;
		this.servico = servico;
	}
	
	
	public Veiculos getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}
	public int getCodServico() {
		return codServico;
	}
	public void setCodServico(int codServico) {
		this.codServico = codServico;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDataExecucao() {
		return dataExecucao;
	}
	public void setDataExecucao(LocalDate dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	public Funcionarios getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	public List<ItemProduto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ItemProduto> produtos) {
		this.produtos = produtos;
	}
	public List<ItemServico> getServico() {
		return servico;
	}
	public void setServico(List<ItemServico> servico) {
		this.servico = servico;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
}
