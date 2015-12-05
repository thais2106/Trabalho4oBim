package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Tela moldura onde aparecerá os campos para preencher 
 * @author tcrivelatti - 28/10/2015
 *
 */

public abstract class MolduraAbstrata extends JPanel {
	private JPanel panel;
	private JButton btnFechar;
	private JButton btnSalvar;
	private JButton btnExcluir;

	protected abstract void configuraMiolo() throws SQLException;
	
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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("src/main/resources/salvar.png"));
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.VERTICAL;
		gbc_btnSalvar.anchor = GridBagConstraints.WEST;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 0;
		panel.add(btnSalvar, gbc_btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("src/main/resources/deletarmaior.png"));
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.fill = GridBagConstraints.BOTH;
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 1;
		gbc_btnExcluir.gridy = 0;
		panel.add(btnExcluir, gbc_btnExcluir);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon("src/main/resources/fechar.png"));
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.fill = GridBagConstraints.VERTICAL;
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 2;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		try {
			configuraMiolo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setAcaoSalvar(Runnable acaoSalvar) {
		btnSalvar.addActionListener(e -> acaoSalvar.run());
	}

	public void setAcaoExcluir(Runnable acaoExcluir) {
		btnExcluir.addActionListener(e -> acaoExcluir.run());
	}

}
