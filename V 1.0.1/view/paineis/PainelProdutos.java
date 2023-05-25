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

public class PainelProdutos extends JPanel{

	public PainelProdutos() {
		setBackground(new Color(109, 110, 114)); // Define a cor de fundo do painel em RGB
		setSize(1040,768);
		setLayout(null);
		//Criando texto na tela  
		Titulo lblProdutos = new Titulo(413, 32, 235, 84,"Produtos");

		Subtitulo lblOperacao = new Subtitulo(138, 148, 732, 44,"Por favor selecione a operação que deseja realizar:");

		//Criando botões de operações nas tela 
		BotaoMenu btnCadastrarProdutos = new BotaoMenu("Cadastrar Produtos", 252, 225, 538, 73);
		btnCadastrarProdutos.setIcon(new ImageIcon(PainelProdutos.class.getResource("/view/img/cadastrar.png")));
		BotaoMenu btnConsultarProdutos = new BotaoMenu("Consultar Produtos", 252, 330, 538, 73);
		btnConsultarProdutos.setIcon(new ImageIcon(PainelProdutos.class.getResource("/view/img/consultar.png")));

		//Adicionando elementos a tela
		add(btnCadastrarProdutos);
		add(btnConsultarProdutos);
		add(lblProdutos);
		add(lblOperacao);
		

		btnCadastrarProdutos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelCadastrarProduto painelCadastrarProdutos = new PainelCadastrarProduto();
				add(painelCadastrarProdutos);
				revalidate();
				repaint();
				

			}
		});
		
		btnConsultarProdutos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelConsultaProduto painelConsultaProdutos = new PainelConsultaProduto();
				add(painelConsultaProdutos);
				revalidate();
				repaint();
				

			}
		});
	}
}
