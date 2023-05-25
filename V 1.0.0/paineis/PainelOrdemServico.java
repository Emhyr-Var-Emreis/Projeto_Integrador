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
		btnCadastrarOrdemServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/img/cadastrar.png")));
		BotaoMenu btnConsultarOrdemServico = new BotaoMenu("Consultar Ordem de Serviço", 252, 330, 538, 73);
		btnConsultarOrdemServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/img/consultar.png")));
		BotaoMenu btnCadastrarServico = new BotaoMenu("Cadastrar Serviço", 252, 435, 538, 73);
		btnCadastrarServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/img/cadastrar.png")));
		BotaoMenu btnConsultarServico = new BotaoMenu("Consultar Serviço", 252, 534, 538, 73);
		btnConsultarServico.setIcon(new ImageIcon(PainelOrdemServico.class.getResource("/img/consultar.png")));
		
		
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
				PainelCadastrarClientes painelCadastrarOrdemServico = new PainelCadastrarClientes();
				add(painelCadastrarOrdemServico);
				revalidate();
				repaint();
				

			}
		});
	}
}