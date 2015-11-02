package br.univel.cadastros;

/**
 * Classe de cadastro de usuário
 * @author tcrivelatti - 27/10/2015 - 20:24
 *
 */
public class Usuario {
	private int id;
	private int clienteId;
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
