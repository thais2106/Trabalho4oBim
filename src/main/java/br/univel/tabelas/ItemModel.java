package br.univel.tabelas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cadastros.Item;
import br.univel.produto.Produto;



public class ItemModel extends AbstractTableModel {
	
	private List<Item> itens = new ArrayList<Item>();
	
	public ItemModel(){

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		return itens.size();
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID PRODUTO";
		case 1:
			return "DESCRIÇÃO";
		case 2:
			return "QUANTIDADE";
		default:
			return "PRECO UNITÁRIO";
		}
	}

	@Override
	public Object getValueAt(int row, int col) {
		Item i = itens.get(row);
		
		switch (col) {
		case 0:
			return i.getIdproduto();
		case 1:
			return i.getDescricao();
		case 2:
			return i.getQuantidade();
		default:
			return i.getPrecounitario();
		}
	}
	
	public void incluirItem(Item i){
		
		if (!itens.isEmpty()){
			
			for (Iterator<Item> iterator = itens.iterator(); iterator.hasNext();) {
				Item item = (Item) iterator.next();
				
				if (item.getIdproduto()==i.getIdproduto()){
					i.setQuantidade(item.getQuantidade() + 1);
					iterator.remove();
				}
			}
		}
		
		itens.add(i);
		
		super.fireTableDataChanged();
	}

}
