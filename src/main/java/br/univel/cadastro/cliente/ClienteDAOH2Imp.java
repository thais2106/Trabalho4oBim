package br.univel.cadastro.cliente;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe com implementações dos métodos de manipulação de banco para a classe Cliente
 * @author tcrivelatti - 29/10/2015 - 19:50:01
 *
 */

public class ClienteDAOH2Imp implements ClienteDAO{
	
	private static Connection con;
	
	private Connection getConnection() throws SQLException{
		synchronized (con) {
			if (con == null){
				String url = "jdbc:h2:~/sisvendas";
				String user = "sa";
				String pass = "sa";
						
				con = DriverManager.getConnection(url, user, pass);
			}
			
			return con;
		}
	}

	@Override
	public void inserir(Cliente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Cliente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Cliente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
