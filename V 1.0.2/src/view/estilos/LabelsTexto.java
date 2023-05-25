package view.estilos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelsTexto extends JLabel{
	/**
	 * 
	 * @param x - Posicionamento do elemento no eixo x
	 * @param y - Posicionamento do elemento no eixo y
	 * @param comprimento - Comprimento do elemento
	 * @param altura - Altura do elemento
	 * @param texto - Texto a ser mostrado no elemento
	 */
	public LabelsTexto(int x, int y, int comprimento, int altura, String texto) {
		super(texto);
        setForeground(new Color(255, 255, 255));
        setBounds(x, y, comprimento, altura);
        setFont(new Font("Tahoma", Font.PLAIN, 24));
	}
}

