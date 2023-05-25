package estilos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CamposTexto extends JTextField{
	
	public CamposTexto (int x, int y, int comprimento, int altura) {
		setFont(new Font("Tahoma", Font.PLAIN, 24));
		setBounds(x, y, comprimento, altura);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
	}
}
