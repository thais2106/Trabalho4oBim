package br.univel.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import br.univel.cadastros.Cliente;

public class ClienteModel extends AbstractTableModel implements TableModel {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
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

}
