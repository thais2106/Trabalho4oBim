package br.univel.tabelas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import br.univel.cliente.Cliente;

public class ClienteModel extends AbstractTableModel implements TableModel {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public ClienteModel(){
		
	}
	
	public ClienteModel(List<Cliente> c) {
		clientes = c;
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return clientes.size();
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "NOME";
		case 2:
			return "ENDERECO";
		case 3:
			return "CIDADE";
		case 4:
			return "UF";
		case 5:
			return "EMAIL";
		case 6:
			return "TELEFONE";
		default:
			return "GENERO";
		}
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cliente c = clientes.get(row);
		
		switch (col) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getEndereco();
		case 3:
			return c.getCidade();
		case 4:
			return c.getUf();
		case 5:
			return c.getEmail();
		case 6:
			return c.getTelefone();
		default:
			return c.getGenero();
		}
	}
	
	public void incluir(Cliente c){
		for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			
			if (cliente.getId()==c.getId()){
				iterator.remove();
			}
			
		}
		
		clientes.add(c);
		super.fireTableDataChanged();
	}
	
	public void remover(Cliente c){
		clientes.remove(c);
		super.fireTableStructureChanged();
	}
}
