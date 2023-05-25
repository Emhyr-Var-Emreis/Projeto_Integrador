package view.paineis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.TelaPrincipal;
import view.estilos.BotaoMenu;
import view.estilos.Subtitulo;
import view.estilos.Titulo;

public class PainelRelatorio extends JPanel{

	public PainelRelatorio() {
		setBackground(new Color(109, 110, 114)); // Define a cor de fundo do painel em RGB
		setSize(1040,768);
		setLayout(null);
		//Criando texto na tela  
		Titulo lblRelatorio = new Titulo(413, 32, 272, 84,"Relatórios");

		Subtitulo lblOperacao = new Subtitulo(101, 151, 845, 44,"Por favor escolha  o relatório que deseja baixar .csv:");

		//Criando botões de operações nas tela 
		BotaoMenu btnRelatorioOS = new BotaoMenu("OS", 32, 227, 430, 73);
		btnRelatorioOS.setIcon(new ImageIcon(PainelRelatorio.class.getResource("/view/img/download.png")));
		BotaoMenu btnRelatorioClientes = new BotaoMenu("Clientes", 32, 308, 430, 73);
		btnRelatorioClientes.setIcon(new ImageIcon(PainelRelatorio.class.getResource("/view/img/download.png")));
		BotaoMenu btnRelatorioVeiculos = new BotaoMenu("Veiculos", 32, 389, 430, 73);
		btnRelatorioVeiculos.setIcon(new ImageIcon(PainelRelatorio.class.getResource("/view/img/download.png")));
		BotaoMenu btnRelatorioFuncionarios = new BotaoMenu("Funcionarios", 32, 470, 430, 73);
		btnRelatorioFuncionarios.setIcon(new ImageIcon(PainelRelatorio.class.getResource("/view/img/download.png")));
		
		BotaoMenu btnRelatorioProdutos = new BotaoMenu("Produtos", 489, 227, 430, 73);
		btnRelatorioProdutos.setIcon(new ImageIcon(PainelRelatorio.class.getResource("/view/img/download.png")));
		BotaoMenu btnRelatorioFaturamentoProdutos = new BotaoMenu("Faturamento Produtos", 489, 308, 430, 73);
		btnRelatorioFaturamentoProdutos.setIcon(new ImageIcon(PainelRelatorio.class.getResource("/view/img/download.png")));
		BotaoMenu btnRelatorioFaturamentoServicos = new BotaoMenu("Faturamento Serviços", 489, 389, 430, 73);
		btnRelatorioFaturamentoServicos.setIcon(new ImageIcon(PainelRelatorio.class.getResource("/view/img/download.png")));


		//Adicionando elementos a tela
		add(btnRelatorioOS);
		add(btnRelatorioClientes);
		add(btnRelatorioVeiculos);
		add(btnRelatorioFuncionarios);
		add(btnRelatorioProdutos);
		add(btnRelatorioFaturamentoProdutos);
		add(btnRelatorioFaturamentoServicos);
		add(lblRelatorio);
		add(lblOperacao);
		

	}
}