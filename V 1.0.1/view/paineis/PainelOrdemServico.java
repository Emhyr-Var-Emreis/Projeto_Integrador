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

public class PainelOrdemServico extends JPanel{

	public PainelOrdemServico() {
		setBackground(new Color(109, 110, 114)); // Define a cor de fundo do painel em RGB
		setSize(1040,768);
		setLayout(null);
		//Criando texto na tela  
		Titulo lblOrdemServico = new Titulo(252, 32, 553, 84,"Ordem de Serviço");

		Subtitulo lblOperacao = new Subtitulo(138, 148, 732, 44,"Por favor selecione a operação que deseja realizar:");

		//Criando botões de operações nas tela 
		BotaoMenu btnCadastrarOrdemServico = new BotaoMenu("Cadastrar Ordem de Serviço", 252, 225, 538, 73);
		btnCadastrarOrdemServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/view/img/cadastrar.png")));
		BotaoMenu btnConsultarOrdemServico = new BotaoMenu("Consultar Ordem de Serviço", 252, 330, 538, 73);
		btnConsultarOrdemServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/view/img/consultar.png")));
		BotaoMenu btnCadastrarServico = new BotaoMenu("Cadastrar Serviço", 252, 435, 538, 73);
		btnCadastrarServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/view/img/cadastrar.png")));
		BotaoMenu btnConsultarServico = new BotaoMenu("Consultar Serviço", 252, 534, 538, 73);
		btnConsultarServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/view/img/consultar.png")));
		
		
		//Adicionando elementos a tela
		add(btnCadastrarOrdemServico);
		add(btnConsultarOrdemServico);
		add(btnCadastrarServico);
		add(btnConsultarServico);
		add(lblOrdemServico);
		add(lblOperacao);
		

		btnCadastrarOrdemServico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelCadastrarOrdemServico painelCadastrarOrdemServico = new PainelCadastrarOrdemServico();
				add(painelCadastrarOrdemServico);
				revalidate();
				repaint();
				

			}
		});
		
		btnConsultarOrdemServico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelConsultaOrdemServico painelConsultaOrdemServico = new PainelConsultaOrdemServico();
				add(painelConsultaOrdemServico);
				revalidate();
				repaint();
				

			}
		});
		
		btnCadastrarServico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelCadastrarServico painelCadastrarServico = new PainelCadastrarServico();
				add(painelCadastrarServico);
				revalidate();
				repaint();
				

			}
		});
		
		btnConsultarServico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelConsultaServico painelConsultaServico = new PainelConsultaServico();
				add(painelConsultaServico);
				revalidate();
				repaint();
				

			}
		});
	}
}