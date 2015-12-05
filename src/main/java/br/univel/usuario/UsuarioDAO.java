package br.univel.usuario;

import java.util.List;
/**
 * Interface de m�todos da classe Usu�rio
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface UsuarioDAO {
	public void inserir(Usuario c);
	
	public void atualizar(Usuario c);
	
	public void excluir (Usuario c);
	
	public Usuario buscar(int id);
	
	public List<Usuario> listar();
}

