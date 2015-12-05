package br.univel.telas;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MioloNovaSenha extends JPanel {

	/**
	 * Create the panel.
	 */
	public MioloNovaSenha() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastrar nova senha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 430, 156);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(70, 220, 10, 10);
		add(panel_1);

	}

}
