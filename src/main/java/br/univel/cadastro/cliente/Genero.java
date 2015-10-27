package br.univel.cadastro.cliente;

/**
 * Classe Enum de Gêneros
 * @author tcrivelatti - 27/10/2015 - 19:53
 *
 */
public enum Genero {
	F("Feminino"),
	M("Masculino");
	
	private String nome;
	
	public String getNome(){
		return nome;
	}
	
	private Genero(String nome){
		this.nome = nome;
	}

}
