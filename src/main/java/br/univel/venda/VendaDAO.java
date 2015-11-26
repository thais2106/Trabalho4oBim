package br.univel.venda;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface com a chamada de m�todos da venda
 * @author Tha�s - 06/11/2015 - 22:16:27
 *
 */
public interface VendaDAO {
	
	public void inserir(Venda v) throws SQLException;
	
	public void atualizar(Venda v) throws SQLException;
	
	public void excluir (Venda v) throws SQLException;
	
	public Venda buscar(int id) throws SQLException;
	
	public List<Venda> listar() throws SQLException;
}
