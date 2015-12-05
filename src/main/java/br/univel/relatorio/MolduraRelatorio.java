package br.univel.relatorio;

import javax.swing.ImageIcon;
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
	private JButton btnFechar;
	private JButton btnGerar;
	
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
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnGerar = new JButton("Gerar");
		btnGerar.setIcon(new ImageIcon("src/main/resources/relatorio.png"));
		GridBagConstraints gbc_btnGerar = new GridBagConstraints();
		gbc_btnGerar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGerar.fill = GridBagConstraints.BOTH;
		gbc_btnGerar.gridx = 0;
		gbc_btnGerar.gridy = 0;
		panel.add(btnGerar, gbc_btnGerar);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon("src/main/resources/fechar.png"));
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 1;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);
		
		configuraMiolo();

	}

	public void setAcaoGerarRelatorio(Runnable setAcaoGerarRelatorio) {
		btnGerar.addActionListener(e -> setAcaoGerarRelatorio.run());
	}
}
