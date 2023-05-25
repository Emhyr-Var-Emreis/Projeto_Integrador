package view.estilos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bancoDeDados.ServicosDAO;
import model.Servico;

public class TabelaServico extends JPanel {

    private JTable table;
    private DefaultTableModel model;
    private JButton btnIncluir = new JButton("Incluir");
    private JButton btnApagar = new JButton("Apagar");

    public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnIncluir() {
		return btnIncluir;
	}

	public void setBtnIncluir(JButton btnIncluir) {
		this.btnIncluir = btnIncluir;
	}

	public JButton getBtnApagar() {
		return btnApagar;
	}

	public void setBtnApagar(JButton btnApagar) {
		this.btnApagar = btnApagar;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public TabelaServico() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Código", "Nome", "Valor Mão de obra", "Qtd horas", "Valor Total"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnIncluir);
        buttonPanel.add(btnApagar);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public DefaultTableModel getModel() {
        return model;
    }
    
}
