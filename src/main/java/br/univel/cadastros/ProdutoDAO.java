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
	
	public void atualizar(Produto p) throws SQLException;
	
	public void excluir (Produto p) throws SQLException;
	
	public Produto buscar(int id) throws SQLException;
	
	public List<Produto> listar() throws SQLException;
	
	public List<Produto> listarCodBarras(String codbarras) throws SQLException;
	
	public List<Produto> listarDescricao(String descricao) throws SQLException;
}