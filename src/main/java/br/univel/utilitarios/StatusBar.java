package br.univel.utilitarios;

import java.awt.Dimension;

import javax.swing.JLabel;

public class StatusBar extends JLabel {

	public StatusBar() {
		super();
		super.setPreferredSize(new Dimension(400, 20));
		setMessage("Pronto.");
	}

	public void setMessage(String messagem) {
		setText(" " + messagem);
	}

}
