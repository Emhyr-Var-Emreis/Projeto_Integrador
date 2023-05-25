package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.LoginController;
import view.estilos.BotaoEntrar;

import view.estilos.CamposTexto;

import view.estilos.Subtitulo;


public class TelaLogin {
	
	private final LoginController controller;
	
	private JFrame frame;
	
    public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	private Subtitulo lblUsuario;
    private Subtitulo lblSenha;
    private CamposTexto txtUsuario;
    private CamposTexto txtSenha;
    private BotaoEntrar btnEntrar;
	
	public Subtitulo getLblUsuario() {
		return lblUsuario;
	}
	public void setLblUsuario(Subtitulo lblUsuario) {
		this.lblUsuario = lblUsuario;
	}
	public Subtitulo getLblSenha() {
		return lblSenha;
	}
	public void setLblSenha(Subtitulo lblSenha) {
		this.lblSenha = lblSenha;
	}
	public CamposTexto getTxtUsuario() {
		return txtUsuario;
	}
	public void setTxtUsuario(CamposTexto txtUsuario) {
		this.txtUsuario = txtUsuario;
	}
	public CamposTexto getTxtSenha() {
		return txtSenha;
	}
	public void setTxtSenha(CamposTexto txtSenha) {
		this.txtSenha = txtSenha;
	}
	public BotaoEntrar getBtnEntrar() {
		return btnEntrar;
	}
	public void setBtnEntrar(BotaoEntrar btnEntrar) {
		this.btnEntrar = btnEntrar;
	}
	public LoginController getController() {
		return controller;
	}
	public TelaLogin() {
		
		controller = new LoginController(this);
		
		frame = new JFrame("Oficina Mecanica");
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
        
        lblUsuario = new Subtitulo(144, 317, 480, 46, "Usuario");
        lblSenha = new Subtitulo(144, 479, 480, 46, "Senha");
        txtUsuario = new CamposTexto(130, 363, 448, 46);
        txtSenha = new CamposTexto(130, 525, 448, 46);
        btnEntrar = new BotaoEntrar("Entrar");
        
		
        
		frame.add(painelVazio); // Adiciona o JPanel 2 ao JFrame
		frame.add(painelLateral); // Adiciona o JPanel 1 ao JFrame
		painelLateral.add(labelImagemLogin);
		painelLateral.add(lblUsuario);
		painelLateral.add(lblSenha);
		painelLateral.add(txtSenha);
		painelLateral.add(txtUsuario);
		painelLateral.add(btnEntrar);
		frame.setVisible(true); // Torna o JFrame visível
		
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,controller.autenticarUsuario());
				
			}
		});

	}

}


