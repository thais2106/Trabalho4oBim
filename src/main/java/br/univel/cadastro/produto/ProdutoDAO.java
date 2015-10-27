package br.univel.cadastro.produto;

import java.util.List;

public interface ProdutoDAO {
	public void inserir(Produto c);
	
	public void atualizar(Produto c);
	
	public void excluir (Produto c);
	
	public Produto buscar(int id);
	
	public List<Produto> listar();
}