package br.univel.cadastro.produto;
/**
 * Classe Enum de Categorias de Produtos
 * @author tcrivelatti - 27/10/2015 - 20:11
 *
 */
public enum Categoria {
	Limpeza("Limpeza"),
	Pecas("Pecas"),
	Alimentação("Alimentação");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Categoria(String nome) {
		this.nome = nome;
	}
}
