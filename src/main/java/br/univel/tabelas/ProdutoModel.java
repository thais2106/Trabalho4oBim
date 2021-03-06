package br.univel.tabelas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cliente.Cliente;
import br.univel.produto.Produto;

/**
 * Modelo da tabela de produtos.
 * @author Tha�s - 03/11/2015 - 11:12:51
 *
 */

public class ProdutoModel extends AbstractTableModel {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoModel(){
		
	}
	
	public ProdutoModel(List<Produto> p) {
		produtos = p;
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "CODIGO DE BARRAS";
		case 2:
			return "CATEGORIA";
		case 3:
			return "DESCRI��O";
		case 4:
			return "UNIDADE";
		case 5:
			return "CUSTO";
		default:
			return "MARGEM LUCRO";
		}
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		
		Produto p = produtos.get(row);
		
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getCodBarras();
		case 2:
			return p.getCategoria();
		case 3:
			return p.getDescricao();
		case 4:
			return p.getUnidade().getNome();
		case 5:
			return p.getCusto();
		default:
			return p.getMargemLucro();
		}
	}

	public void incluir(Produto p) {
		for (Iterator<Produto> iterator = produtos.iterator(); iterator.hasNext();) {
			Produto produto = (Produto) iterator.next();
			
			if (produto.getId()==p.getId()){
				iterator.remove();
			}
		}
		produtos.add(p);
		super.fireTableDataChanged();
	}

	public void remover(Produto p) {
		produtos.remove(p);
		super.fireTableDataChanged();
	}

}
