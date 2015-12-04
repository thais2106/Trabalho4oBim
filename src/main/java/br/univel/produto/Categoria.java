package br.univel.produto;

import javax.swing.JComboBox;

/**
 * Classe Enum de Categorias de Produtos
 * @author tcrivelatti - 27/10/2015 - 20:11
 *
 */

public enum Categoria {
	Limpeza, Pecas, Alimentação, Higiene;
	
	//Popular combobox de Categorias
	public static void comboboxCategoria(JComboBox cbx) {
		cbx.addItem("Selecionar categoria");
		
		for (Categoria c : Categoria.values()) {
			cbx.addItem(c);
		}
	}
}
