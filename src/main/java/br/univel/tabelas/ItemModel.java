package br.univel.tabelas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.produto.Produto;
import br.univel.venda.Item;



public class ItemModel extends AbstractTableModel {
	
	private List<Item> itens = new ArrayList<Item>();
	
	public ItemModel(){

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
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
		case 3:
			return "PRECO UNITÁRIO";
		default:
			return "TOTAL";
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
		case 3:
			return i.getPrecounitario();
		default:
			return i.getTotalProduto();
			
		}
	}
	
	public void incluirItem(Item i){	
		
		for (Iterator<Item> iterator = itens.iterator(); iterator.hasNext();) {
			Item item = (Item) iterator.next();
			
			if (item.getIdproduto()==i.getIdproduto()){
				iterator.remove();
			}
			
		}
		
		itens.add(i);
		super.fireTableDataChanged();
	}
	
	public void excluirItem(int row){
		itens.remove(row);
		super.fireTableDataChanged();
	}
	
	public List<Item> retornarItens(){
		return itens;
	}

}
