package br.univel.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cadastros.Produto;

/**
 * Modelo da tabela de produtos.
 * @author Thaís - 03/11/2015 - 11:12:51
 *
 */

public class ProdutoModel extends AbstractTableModel {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
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
			return p.getUnidade();
		case 5:
			return p.getCusto();
		default:
			return p.getMargemLucro();
		}
	}

}
