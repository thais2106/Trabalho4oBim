package br.univel.cadastro.produto;

import java.util.List;
/**
 * Interface de métodos da classe Produto
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface ProdutoDAO {
	public void inserir(Produto c);
	
	public void atualizar(Produto c);
	
	public void excluir (Produto c);
	
	public Produto buscar(int id);
	
	public List<Produto> listar();
}