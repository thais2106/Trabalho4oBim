package br.univel.cadastro.cliente;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Classe com implementações dos métodos de manipulação de banco para a classe Cliente
 * @author tcrivelatti - 29/10/2015 - 19:50:01
 *
 */

public class ClienteDAOH2Imp implements ClienteDAO{
	
	private String sql;
	private static Connection con;
	
	public Connection getConnection() throws SQLException{
		synchronized (con) {
			System.out.println("oi");
			
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
	public void inserir(Cliente c) throws SQLException {
		sql = "INSERT INTO CLIENTE(id, nome, telefone, endereco, cidade, uf, email, genero)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getTelefone());
		ps.setString(4, c.getEndereco());
		ps.setString(5, c.getCidade());
		ps.setString(6, c.getUf().getNome());
		ps.setString(7, c.getEmail());
		ps.setString(8, c.getGenero().getNome());
		
		int res = ps.executeUpdate();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
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
