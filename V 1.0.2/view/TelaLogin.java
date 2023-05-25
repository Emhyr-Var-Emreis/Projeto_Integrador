package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.estilos.BotaoEntrar;
import view.estilos.BotaoMenu;
import view.estilos.CamposTexto;
import view.estilos.LabelsTexto;
import view.estilos.Subtitulo;
import view.paineis.PainelClientes;
import view.paineis.PainelFuncionario;
import view.paineis.PainelOrdemServico;
import view.paineis.PainelPadrao;
import view.paineis.PainelProdutos;
import view.paineis.PainelRelatorio;
import view.paineis.PainelVeiculos;

public class TelaLogin {
	public TelaLogin() {
		JFrame frame = new JFrame("Oficina Mecanica");
		frame.setSize(1366, 768); // Define o tamanho do JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar o JFrame
		frame.setLayout(null); // Desativa o layout manager para posicionar os componentes manualmente
		frame.setResizable(false); // Define que o JFrame não pode ser redimensionado pelo usuário

		JPanel painelLateral = new JPanel();
		painelLateral.setBounds(0, 0, 784, 768); // Define o tamanho e a posição do JPanel 1
		painelLateral.setBackground(new Color(0, 0, 0)); // Define a cor de fundo do JPanel 1
		painelLateral.setLayout(null);

		JPanel painelVazio = new JPanel(new BorderLayout()); 
		painelVazio.setBackground(new Color(109, 110, 114)); // Define a cor de fundo do JPanel 2
		painelVazio.setBounds(784,0,582,768);
		

        // cria um JLabel com a imagem
        JLabel labelImagemLogin = new JLabel();
        labelImagemLogin.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/img/repairLogin.png")));
        labelImagemLogin.setBounds(255, 80, 202, 189);
        
        Subtitulo lblUsuario = new Subtitulo(144, 317, 480, 46, "Usuario");
        Subtitulo lblSenha = new Subtitulo(144, 479, 480, 46, "Usuario");
        CamposTexto txtUsuario = new CamposTexto(130, 363, 448, 46);
        CamposTexto txtSenha = new CamposTexto(130, 525, 448, 46);
        BotaoEntrar btnEntrar = new BotaoEntrar("Entrar");
        
		
        
		frame.add(painelVazio); // Adiciona o JPanel 2 ao JFrame
		frame.add(painelLateral); // Adiciona o JPanel 1 ao JFrame
		painelLateral.add(labelImagemLogin);
		painelLateral.add(lblUsuario);
		painelLateral.add(lblSenha);
		painelLateral.add(txtSenha);
		painelLateral.add(txtUsuario);
		painelLateral.add(btnEntrar);
		frame.setVisible(true); // Torna o JFrame visível


	}
	public static void main(String[] args) {
		
		TelaLogin telaLogin = new TelaLogin();

	}	
}


