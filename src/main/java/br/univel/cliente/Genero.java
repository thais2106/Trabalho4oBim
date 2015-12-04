package br.univel.cliente;

import javax.swing.JComboBox;

/**
 * Classe Enum de Gêneros
 * @author tcrivelatti - 27/10/2015 - 19:53
 *
 */
public enum Genero {
	Feminino, Masculino;
	
	public static void comboboxGenero(JComboBox cbx) {
		cbx.addItem("Selecionar genêro");
		
		for (Genero c : Genero.values()) {
			cbx.addItem(c);
		}
	}
}
