package br.univel.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe com os atributos da venda
 * @author Thaís - 06/11/2015 - 22:15:08
 *
 */
public class Venda {
	private int idVenda;
	private int idCliente;
	private String nomeCliente;
	private BigDecimal valorTotal;
	private BigDecimal valorPagamento;
	private ArrayList<Item> itens;
	private Date data;
	private long hora;
	
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
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
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
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> list) {
		this.itens = list;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public long getHora() {
		return hora;
	}
	public void setHora(long hora) {
		this.hora = hora;
	}
	
}
