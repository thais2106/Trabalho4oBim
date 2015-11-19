package br.univel.cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.univel.produto.Produto;
/**
 * Interface de métodos da classe Cliente
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface ClienteDAO {
	//Connection getConnection() throws SQLException;
	
	public void inserir(Cliente c) throws SQLException;
	
	public void atualizar(Cliente c) throws SQLException;
	
	public void excluir (Cliente c) throws SQLException;
	
	public Cliente buscar(int id) throws SQLException;
	
	public List<Cliente> listar() throws SQLException;
	
	public List<Cliente> listarNome(String nome) throws SQLException;

}
