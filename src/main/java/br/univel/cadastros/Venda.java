package br.univel.cadastros;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe com os atributos da venda
 * @author Thaís - 06/11/2015 - 22:15:08
 *
 */
public class Venda {
	private int idVenda;
	private int idCliente;
	private int nomeCliente;
	private BigDecimal valorTotal;
	private BigDecimal valorPagamento;
	private ArrayList<Produto> itens;
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(int nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(BigDecimal valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public ArrayList<Produto> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}
	
}
