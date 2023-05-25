package view.estilos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class ListaSuspensa extends JComboBox<String>{
	
	/**
	 * 
	 * @param items - variavel do tipo String[] para compor as opcoes da lista
	 * @param x Posicionamento do elemento no eixo x
	 * @param y Posicionamento do elemento no eixo y
	 * @param comprimento - Comprimento do elemento
	 * @param altura - Altura do elemento
	 */
	public ListaSuspensa (String[] items,int x, int y, int comprimento, int altura) {
		super(items);
		setFont(new Font("Tahoma", Font.PLAIN, 24));
		setBounds(x, y, comprimento, altura);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
	}
}
