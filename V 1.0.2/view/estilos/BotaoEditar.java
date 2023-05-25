package view.estilos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoEditar extends JButton {

	private static final long serialVersionUID = 5666930950228927595L;

	public BotaoEditar(String texto) { // Cria um construtor que recebe um texto como parâmetro
        super(texto); // Chama o construtor da superclasse JButton com o texto recebido
        setPreferredSize(new Dimension(191, 50)); // Define o tamanho preferencial do botão
        setBackground(new Color(215, 241, 54)); // Define a cor de fundo do botão em RGB
        setForeground(Color.BLACK); // Define a cor do texto do botão como branco
        setIcon(new ImageIcon(BotaoLimpar.class.getResource("/view/img/Editar.png")));
        setFocusPainted(false); // Remove o contorno de foco quando o botão é clicado
        setFont(new Font("Tahoma", Font.PLAIN, 24)); // Define a fonte do texto do botão
        setBorder(BorderFactory.createEmptyBorder()); // Remove a borda do botão
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor do mouse quando estiver sobre o botão
        setBounds(373, 669, 194, 50);
    }
}
