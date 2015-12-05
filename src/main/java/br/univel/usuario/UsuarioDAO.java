package br.univel.usuario;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface de métodos da classe Usuário
 * @author tcrivelatti - 27/10/2015
 *
 */
public interface UsuarioDAO {
	public void inserir(Usuario u) throws SQLException;
	
	public void atualizar(Usuario u);
	
	public void excluir (Usuario u) throws SQLException;
	
	public Usuario buscar(int idUsuario) throws SQLException;
	
	public Usuario buscarUsuario(int idCliente) throws SQLException;
	
	public List<Usuario> listar() throws SQLException;
}

