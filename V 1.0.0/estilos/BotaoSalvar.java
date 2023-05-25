package estilos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoSalvar extends JButton {
    public BotaoSalvar(String texto) { // Cria um construtor que recebe um texto como parâmetro
        super(texto); // Chama o construtor da superclasse JButton com o texto recebido
        setPreferredSize(new Dimension(191, 50)); // Define o tamanho preferencial do botão
        setBackground(new Color(0, 60, 197)); // Define a cor de fundo do botão em RGB
        setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        setIcon(new ImageIcon(BotaoSalvar.class.getResource("/img/Salvar.png")));
        setFocusPainted(false); // Remove o contorno de foco quando o botão é clicado
        setFont(new Font("Tahoma", Font.PLAIN, 24)); // Define a fonte do texto do botão
        setBorder(BorderFactory.createEmptyBorder()); // Remove a borda do botão
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor do mouse quando estiver sobre o botão
        setBounds(830, 694, 191, 50);
    }
}
