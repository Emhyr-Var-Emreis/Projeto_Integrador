package view.estilos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Titulo extends JLabel{
	public Titulo(int x, int y, int comprimento, int altura, String texto) {
		super(texto);
        setForeground(new Color(255, 255, 255));
        setBounds(x, y, comprimento, altura);
        setFont(new Font("Tahoma", Font.PLAIN, 60));
	}
}
