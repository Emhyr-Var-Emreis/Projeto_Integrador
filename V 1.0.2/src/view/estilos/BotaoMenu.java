package view.estilos;

import javax.swing.*; // Importa a classe JButton da biblioteca Swing
import java.awt.*; // Importa a classe Dimension da biblioteca AWT

public class BotaoMenu extends JButton { // Cria uma classe MeuBotao que estende a classe JButton

    public BotaoMenu(String texto, int x, int y, int comprimento, int altura) { // Cria um construtor que recebe um texto como parâmetro
        super(texto); // Chama o construtor da superclasse JButton com o texto recebido
        setPreferredSize(new Dimension(326, 78)); // Define o tamanho preferencial do botão
        setBackground(new Color(0, 0, 0)); // Define a cor de fundo do botão em RGB
        setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        setFocusPainted(false); // Remove o contorno de foco quando o botão é clicado
        setFont(new Font("Tahoma", Font.PLAIN, 32)); // Define a fonte do texto do botão
        setBorder(BorderFactory.createEmptyBorder()); // Remove a borda do botão
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor do mouse quando estiver sobre o botão
        setBounds(x, y, comprimento, altura);
    }
}
