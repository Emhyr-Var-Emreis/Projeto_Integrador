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

public class PainelFuncionario extends JPanel{

	public PainelFuncionario() {
		setBackground(new Color(109, 110, 114)); // Define a cor de fundo do painel em RGB
		setSize(1040,768);
		setLayout(null);
		//Criando texto na tela  
		Titulo lblFuncionario = new Titulo(413, 32, 349, 84,"Funcionários");

		Subtitulo lblOperacao = new Subtitulo(138, 148, 732, 44,"Por favor selecione a operação que deseja realizar:");

		//Criando botões de operações nas tela 
		BotaoMenu btnCadastrarFuncionario = new BotaoMenu("Cadastrar Funcionario", 252, 225, 538, 73);
		btnCadastrarFuncionario.setIcon(new ImageIcon(PainelFuncionario.class.getResource("/img/cadastrar.png")));
		BotaoMenu btnConsultarFuncionario = new BotaoMenu("Consultar Funcionario", 252, 330, 538, 73);
		btnConsultarFuncionario.setIcon(new ImageIcon(PainelFuncionario.class.getResource("/img/consultar.png")));

		//Adicionando elementos a tela
		add(btnCadastrarFuncionario);
		add(btnConsultarFuncionario);
		add(lblFuncionario);
		add(lblOperacao);
		

		btnCadastrarFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PainelCadastrarFuncionarios painelCadastrarFuncionario = new PainelCadastrarFuncionarios();
				add(painelCadastrarFuncionario);
				revalidate();
				repaint();
				

			}
		});
	}
}