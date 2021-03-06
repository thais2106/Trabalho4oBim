package br.univel.cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;

import br.univel.produto.Produto;
/**
 * Interface de m�todos da classe Cliente
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface ClienteDAO {
	
	public void inserir(Cliente c) throws SQLException;
	
	public void atualizar(Cliente c) throws SQLException;
	
	public void excluir (Cliente c) throws SQLException;
	
	public Cliente buscar(int id) throws SQLException;
	
	public int buscarID() throws SQLException;
	
	public List<Cliente> listar() throws SQLException;
	
	public List<Cliente> listarNome(String nome) throws SQLException;

}
