package br.univel.cadastros;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface de métodos da classe Produto
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface ProdutoDAO {
	public void inserir(Produto p) throws SQLException;
	
	public void atualizar(Produto p);
	
	public void excluir (Produto p);
	
	public Produto buscar(int id);
	
	public List<Produto> listar();
}