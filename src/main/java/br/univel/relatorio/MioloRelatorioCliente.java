package br.univel.relatorio;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class MioloRelatorioCliente extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioCliente() {
		setLayout(null);
		
		JLabel lblPesquisaDeClientes = new JLabel("Pesquisa de Clientes");
		lblPesquisaDeClientes.setBounds(0, 0, 98, 14);
		add(lblPesquisaDeClientes);
		
		JRadioButton rdbtnCidade = new JRadioButton("Cidade");
		rdbtnCidade.setBounds(0, 19, 59, 23);
		add(rdbtnCidade);
		
		textField = new JTextField();
		textField.setBounds(65, 20, 165, 20);
		add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnEstado = new JRadioButton("Estado");
		rdbtnEstado.setBounds(240, 19, 59, 23);
		add(rdbtnEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(305, 19, 82, 22);
		add(comboBox);

	}
}
