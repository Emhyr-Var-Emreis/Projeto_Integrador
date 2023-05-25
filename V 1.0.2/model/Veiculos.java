package model;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import bancoDeDados.BD;


public class Veiculos {
	private int codigoVeiculo;
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private String cor;
	private Clientes cliente;
	private String ativo;
	
	
	
	public Veiculos(int codigoVeiculo, String placa, String modelo, String marca, int ano, String cor, Clientes cliente,
			String ativo) {
		super();
		this.codigoVeiculo = codigoVeiculo;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
		this.cliente = cliente;
		this.ativo = ativo;
	}
	public Veiculos(int codigoVeiculo) {
		super();
		this.codigoVeiculo = codigoVeiculo;
	}
	public Veiculos(String placa, String modelo, String marca, int ano, String cor, Clientes cliente) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
		this.cliente = cliente;
	}
	public int getCodigoVeiculo() {
		return codigoVeiculo;
	}
	public void setCodigoVeiculo(int codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	
}

