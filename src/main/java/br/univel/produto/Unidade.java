package br.univel.produto;

import javax.swing.JComboBox;

/**
 * Classe Enum de Unidade de Medidas
 * @author tcrivelatti - 27/10/2015 - 20:05
 *
 */
public enum Unidade {
	KG("Kilo"),
	UN("Unidade"),
	PCT("Pacote"),
	CX("Caixa");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Unidade(String nome) {
		this.nome = nome;
	}

	public static void comboboxUnidade(JComboBox cbx) {
		cbx.addItem("Selecionar unidade");
		for (Unidade u : Unidade.values()) {
			cbx.addItem(u);
		}
	}
	
}
