package br.univel.relatorio;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public abstract class MolduraRelatorio extends JPanel {
	private JButton btnGerarRelatrio;
	private JButton btnFechar;
	
	protected abstract void configuraMiolo() throws SQLException;
	
	public void setCloseAction(ActionListener action){
		btnFechar.addActionListener(action);
	}

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public MolduraRelatorio() throws SQLException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{171, 107, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
		GridBagConstraints gbc_btnGerarRelatrio = new GridBagConstraints();
		gbc_btnGerarRelatrio.insets = new Insets(0, 0, 0, 5);
		gbc_btnGerarRelatrio.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGerarRelatrio.gridx = 4;
		gbc_btnGerarRelatrio.gridy = 0;
		panel_1.add(btnGerarRelatrio, gbc_btnGerarRelatrio);
		
		btnFechar = new JButton("Fechar");
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFechar.gridx = 5;
		gbc_btnFechar.gridy = 0;
		panel_1.add(btnFechar, gbc_btnFechar);
		
		configuraMiolo();

	}
	
	public void setAcaoSalvar(Runnable acaoSalvar) {
		btnGerarRelatrio.addActionListener(e -> acaoSalvar.run());
	}

}
