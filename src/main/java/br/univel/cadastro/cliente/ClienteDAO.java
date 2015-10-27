package br.univel.cadastro.cliente;

import java.util.List;
/**
 * Interface de métodos da classe Cliente
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface ClienteDAO {
	public void inserir(Cliente c);
	
	public void atualizar(Cliente c);
	
	public void excluir (Cliente c);
	
	public Cliente buscar(int id);
	
	public List<Cliente> listar();
}
