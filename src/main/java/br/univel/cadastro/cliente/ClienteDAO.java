package br.univel.cadastro.cliente;

import java.util.List;

public interface ClienteDAO {
	public void inserir(Cliente c);
	
	public void atualizar(Cliente c);
	
	public void excluir (Cliente c);
	
	public Cliente buscar(int id);
	
	public List<Cliente> listar();
}
