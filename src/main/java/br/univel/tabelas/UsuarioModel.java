package br.univel.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.usuario.Usuario;

public class UsuarioModel extends AbstractTableModel {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioModel() {
	
	}
	
	public UsuarioModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 1:
			return "ID USUÁRIO";
		case 2:
			return "ID CLIENTE";
		default:
			return "SENHA";
		}
	}

	@Override
	public Object getValueAt(int row, int col) {
		Usuario u = usuarios.get(row);
		
		switch (col) {
		case 1:
			return u.getId();
		case 2:
			return u.getClienteId();
		default:
			return u.getSenha();
		}
	}
	
	public void incluir(Usuario u) {
		usuarios.add(u);
		super.fireTableDataChanged();
	}

}
