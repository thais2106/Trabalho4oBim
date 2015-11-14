package br.univel.cadastros;

import java.math.BigDecimal;

import br.univel.produto.Produto;

/**
 * Classe de itens de venda
 * @author Thaís - 14/11/2015 - 15:04:28
 *
 */

public class Item {
	private int idproduto;
	private String descricao;
	private int quantidade;
	private BigDecimal custo;
	
	public int getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPrecounitario() {
		return custo;
	}
	public void setPrecounitario(BigDecimal precounitario) {
		this.custo = precounitario;
	}
	
	
}
