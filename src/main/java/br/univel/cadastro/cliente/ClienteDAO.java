package br.univel.cadastro.cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * Interface de métodos da classe Cliente
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface ClienteDAO {
	//Connection getConnection() throws SQLException;
	
	public void inserir(Cliente c) throws SQLException;
	
	public void atualizar(Cliente c);
	
	public void excluir (Cliente c);
	
	public Cliente buscar(int id);
	
	public List<Cliente> listar();
}
