package br.univel.telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Insets;
/**
 * Tela moldura onde aparecerá os campos para preencher 
 * @author tcrivelatti - 28/10/2015
 *
 */

public abstract class MolduraAbstrata extends JPanel {
	private JPanel panel;
	private JButton btnFechar;

	protected abstract void configuraMiolo();
	
	public void setCloseAction(ActionListener action){
		btnFechar.addActionListener(action);
	}
	
	/**
	 * Create the panel.
	 */
	
	public MolduraAbstrata() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblSistemaDeVendas = new JLabel("Sistema de Vendas");
		panel.add(lblSistemaDeVendas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnFechar = new JButton("Fechar");
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 0;
		gbc_btnFechar.gridy = 0;
		panel_1.add(btnFechar, gbc_btnFechar);

		configuraMiolo();
	}

}
