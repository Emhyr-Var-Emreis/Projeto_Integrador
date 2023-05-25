package paineis;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import estilos.Subtitulo;

public class PainelPadrao extends JPanel{

	public PainelPadrao() {
		setBackground(new Color(109, 110, 114)); // Define a cor de fundo do painel em RGB
        setSize(1040, 768);
        setLayout(null);
        
        Subtitulo lblUsuario = new Subtitulo(32, 126, 1008, 44,"Olá [Nome do Usuario]");
        Subtitulo lblSaudacao = new Subtitulo(32, 204, 1008, 44,"Seja bem-vindo(a) ao sistema de Gerenciador de OS!");
        
        add(lblUsuario);
        add(lblSaudacao);
	}
}
