package view.estilos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoEntrar extends JButton {

	private static final long serialVersionUID = -5056732040663035291L;

	public BotaoEntrar(String texto) { // Cria um construtor que recebe um texto como parâmetro
        super(texto); // Chama o construtor da superclasse JButton com o texto recebido
        setPreferredSize(new Dimension(187, 66)); // Define o tamanho preferencial do botão
        setBackground(new Color(216, 217, 224)); // Define a cor de fundo do botão em RGB
        setForeground(Color.BLACK); // Define a cor do texto do botão como branco
        setFocusPainted(false); // Remove o contorno de foco quando o botão é clicado
        setFont(new Font("Tahoma", Font.PLAIN, 32)); // Define a fonte do texto do botão
        setBorder(BorderFactory.createEmptyBorder()); // Remove a borda do botão
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor do mouse quando estiver sobre o botão
        setBounds(255, 655, 187, 66);
    }
}
