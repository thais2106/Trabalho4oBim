package br.univel.venda;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface com a chamada de m�todos da venda
 * @author Tha�s - 06/11/2015 - 22:16:27
 *
 */
public interface VendaDAO {
	
	public void inserir(Venda v) throws SQLException;
	
	public Venda buscar(int id) throws SQLException;
	
	public ArrayList<Venda> listar() throws SQLException;
}
