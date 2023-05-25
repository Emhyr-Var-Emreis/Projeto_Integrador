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

public class PainelClientes extends JPanel{

	public PainelClientes() {
		setBackground(new Color(109, 110, 114)); // Define a cor de fundo do painel em RGB
		setSize(1040,768);
		setLayout(null);
		//Criando texto na tela  
		Titulo lblClientes = new Titulo(413, 32, 235, 84,"Clientes");

		Subtitulo lblOperacao = new Subtitulo(138, 148, 732, 44,"Por favor selecione a operação que deseja realizar:");

		//Criando botões de operações nas tela 
		BotaoMenu btnCadastrarCliente = new BotaoMenu("Cadastrar Cliente", 252, 225, 538, 73);
		btnCadastrarCliente.setIcon(new ImageIcon(PainelClientes.class.getResource("/img/cadastrar.png")));
		BotaoMenu btnConsultarCliente = new BotaoMenu("Consultar Cliente", 252, 330, 538, 73);
		btnConsultarCliente.setIcon(new ImageIcon(PainelClientes.class.getResource("/img/consultar.png")));

		//Adicionando elementos a tela
		add(btnCadastrarCliente);
		add(btnConsultarCliente);
		add(lblClientes);
		add(lblOperacao);
		

		btnCadastrarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelCadastrarClientes painelCadastrarCliente = new PainelCadastrarClientes();
				add(painelCadastrarCliente);
				revalidate();
				repaint();
				

			}
		});
		
		btnConsultarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelConsultaClientes painelConsultaCliente = new PainelConsultaClientes();
				add(painelConsultaCliente);
				revalidate();
				repaint();
				

			}
		});
	}
}