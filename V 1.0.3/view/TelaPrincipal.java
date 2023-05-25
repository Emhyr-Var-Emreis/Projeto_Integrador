package view;

import javax.swing.*;

import view.estilos.BotaoMenu;
import view.paineis.PainelClientes;
import view.paineis.PainelFuncionario;
import view.paineis.PainelOrdemServico;
import view.paineis.PainelPadrao;
import view.paineis.PainelProdutos;
import view.paineis.PainelRelatorio;
import view.paineis.PainelVeiculos;
import view.paineis.PainelCadastrarVeiculos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
	
	private BotaoMenu btnFuncionarios;

	public BotaoMenu getBtnFuncionarios() {
		return btnFuncionarios;
	}

	public void setBtnFuncionarios(BotaoMenu btnFuncionarios) {
		this.btnFuncionarios = btnFuncionarios;
	}

	public TelaPrincipal() {
		JFrame frame = new JFrame("Oficina Mecanica");
		frame.setSize(1366, 768); // Define o tamanho do JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar o JFrame
		frame.setLayout(null); // Desativa o layout manager para posicionar os componentes manualmente
		frame.setResizable(false); // Define que o JFrame não pode ser redimensionado pelo usuário

		JPanel menuLateral = new JPanel();
		menuLateral.setBounds(0, 0, 326, 768); // Define o tamanho e a posição do JPanel 1
		menuLateral.setBackground(new Color(0, 0, 0)); // Define a cor de fundo do JPanel 1
		menuLateral.setLayout(null);

		// Criação de botões com tamanho fixo de 326x100 pixels
		
		BotaoMenu btnOrdemServico = new BotaoMenu("Ordem de Serviços",0, 32, 326, 78);
        btnOrdemServico.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/Vector.png")));
        BotaoMenu btnClientes = new BotaoMenu("Clientes",0, 116, 326, 78);
        btnClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/Cliente.png")));
        BotaoMenu btnVeiculos = new BotaoMenu("Veículos",0, 228, 326, 78);
        btnVeiculos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/Veiculos.png")));
        BotaoMenu btnProdutos = new BotaoMenu("Produtos",0, 320, 326, 78);
        btnProdutos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/Estoque.png")));
        BotaoMenu btnRelatorios = new BotaoMenu("Relatorios",0, 412, 326, 78);
        btnRelatorios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/Relatorios.png")));
        btnFuncionarios = new BotaoMenu("Funcionarios",0, 494, 326, 78);
        btnFuncionarios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/Usuario.png")));
        BotaoMenu btnSair = new BotaoMenu("Sair",0, 669, 326, 60);
        btnSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/Sair.png")));
		menuLateral.add(btnOrdemServico);
		menuLateral.add(btnClientes);
		menuLateral.add(btnVeiculos);
		menuLateral.add(btnFuncionarios);
		menuLateral.add(btnProdutos);
		menuLateral.add(btnRelatorios);
		menuLateral.add(btnSair);
       

		frame.add(menuLateral); // Adiciona o JPanel 1 ao JFrame

		JPanel container = new JPanel(new BorderLayout()); // Define o layout manager do painel container como BorderLayout
		container.setBounds(326, 0, 1040, 768);

		PainelPadrao painelPrincipal = new PainelPadrao(); 
		painelPrincipal.setBackground(new Color(109, 110, 114)); // Define a cor de fundo do JPanel 2
		painelPrincipal.setSize(1040,768);

		container.add(painelPrincipal); // Adiciona o painel principal ao painel container, na região central
		frame.add(container); // Adiciona o JPanel 2 ao JFrame

		frame.setVisible(true); // Torna o JFrame visível
		
		btnVeiculos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				
				PainelVeiculos painelVeiculo = new PainelVeiculos();
				container.add(painelVeiculo);
				container.revalidate();
		        container.repaint();
				
			}
		});
		
		btnClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				
				PainelClientes painelClientes = new PainelClientes();
				container.add(painelClientes);
				container.revalidate();
		        container.repaint();
				
			}
		});
		
		btnProdutos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				
				PainelProdutos painelProdutos = new PainelProdutos();
				container.add(painelProdutos);
				container.revalidate();
		        container.repaint();
				
			}
		});
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				
				PainelFuncionario painelFuncionario = new PainelFuncionario();
				container.add(painelFuncionario);
				container.revalidate();
		        container.repaint();
				
			}
		});
		
		btnOrdemServico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				
				PainelOrdemServico painelOrdemServico = new PainelOrdemServico();
				container.add(painelOrdemServico);
				container.revalidate();
		        container.repaint();
				
			}
		});
		
		btnRelatorios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				
				PainelRelatorio painelRelatorio = new PainelRelatorio();
				container.add(painelRelatorio);
				container.revalidate();
		        container.repaint();
				
			}
		});
	}
}