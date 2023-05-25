package paineis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import estilos.BotaoMenu;
import estilos.Subtitulo;
import estilos.Titulo;
import view.TelaPrincipal;

public class PainelVeiculos extends JPanel{

	public PainelVeiculos() {
		setBackground(new Color(109, 110, 114)); // Define a cor de fundo do painel em RGB
		setSize(1040,768);
		setLayout(null);
		//Criando texto na tela  
		Titulo lblVeiculos = new Titulo(413, 32, 235, 84,"Veículos");

		Subtitulo lblOperacao = new Subtitulo(138, 148, 732, 44,"Por favor selecione a operação que deseja realizar:");

		//Criando botões de operações nas tela 
		BotaoMenu btnCadastrarVeiculo = new BotaoMenu("Cadastrar Veículos", 252, 225, 538, 73);
		btnCadastrarVeiculo.setIcon(new ImageIcon(PainelVeiculos.class.getResource("/img/cadastrar.png")));
		BotaoMenu btnConsultarVeiculo = new BotaoMenu("Consultar Veículos", 252, 330, 538, 73);
		btnConsultarVeiculo.setIcon(new ImageIcon(PainelVeiculos.class.getResource("/img/consultar.png")));

		//Adicionando elementos a tela
		add(btnCadastrarVeiculo);
		add(btnConsultarVeiculo);
		add(lblVeiculos);
		add(lblOperacao);
		

		btnCadastrarVeiculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelCadastrarVeiculos painelCadastrarVeiculo = new PainelCadastrarVeiculos();
				add(painelCadastrarVeiculo);
				revalidate();
				repaint();
				

			}
		});
		
		btnConsultarVeiculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelConsultaVeiculos painelConsultaVeiculo = new PainelConsultaVeiculos();
				add(painelConsultaVeiculo);
				revalidate();
				repaint();
				

			}
		});
	}
}