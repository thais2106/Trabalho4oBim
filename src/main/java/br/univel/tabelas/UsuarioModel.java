package br.univel.tabelas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cliente.Cliente;
import br.univel.usuario.Usuario;

public class UsuarioModel extends AbstractTableModel {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioModel() {
	
	}
	
	public UsuarioModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public int getRowCount() {
		return usuarios.size();
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID USUÁRIO";
		case 1:
			return "ID CLIENTE";
		default:
			return "SENHA";
		}
	}

	@Override
	public Object getValueAt(int row, int col) {
		Usuario u = usuarios.get(row);
		
		switch (col) {
		case 0:
			return u.getId();
		case 1:
			return u.getClienteId();
		default:
			return u.getSenha();
		}
	}
	
	public void incluir(Usuario u) {
		for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			
			if (usuario.getId()==u.getId()){
				iterator.remove();
			}
		}
		usuarios.add(u);
		super.fireTableDataChanged();
	}

}
