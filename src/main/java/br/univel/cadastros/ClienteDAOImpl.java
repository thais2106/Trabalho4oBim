package br.univel.cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Classe com implementações dos métodos de manipulação de banco para a classe Cliente
 * @author tcrivelatti - 29/10/2015 - 19:50:01
 *
 */

public class ClienteDAOImpl implements ClienteDAO{
	
	private String sql;
	private static Connection con;
	
	public Connection getConnection(){
			if (con == null){ //Se não ouver conexão instanciada
				try{ // Tenta abrir uma nova conexão
					String url = "jdbc:h2:~/sisvendas";
					String user = "sa";
					String pass = "sa";
						
					con = DriverManager.getConnection(url, user, pass);
				} catch (SQLException e){ //Se não conseguir abrir conexão, retorna erro
					System.out.println("Erro ao abrir conexão");
					e.printStackTrace();
				}
			}
			synchronized (con) {
			return con; //retorna conexão
		}
	}

	@Override
	public void inserir(Cliente c) throws SQLException {
		Connection con = getConnection();
		
		sql = "INSERT INTO CLIENTE(id, nome, telefone, endereco, cidade, uf, email, genero)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getTelefone());
		ps.setString(4, c.getEndereco());
		ps.setString(5, c.getCidade());
		ps.setString(6, c.getUf().toString());
		ps.setString(7, c.getEmail());
		ps.setString(8, c.getGenero().toString());
		
		ps.executeUpdate();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Cliente c) throws SQLException {
		Connection con = getConnection();
		
		sql = "UPDATE CLIENTE SET id = ?, nome = ?, endereco = ?, cidade = ?, uf = ?,"
				+ " email = ?, telefone = ?, genero = ? WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getEndereco());
		ps.setString(4, c.getCidade());
		ps.setString(5, c.getUf().toString());
		ps.setString(6, c.getEmail());
		ps.setString(7, c.getTelefone());
		ps.setString(8, c.getGenero().toString());
		ps.setInt(9, c.getId());
		
		ps.executeUpdate();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
		
	}

	@Override
	public void excluir(Cliente c) throws SQLException {
		Connection con = getConnection();
		sql = "DELETE FROM CLIENTE WHERE ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.executeUpdate();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
		
	}

	@Override
	public Cliente buscar(int id) throws SQLException {
		Connection con = getConnection();
		Cliente c = new Cliente();
	
		sql = "SELECT * FROM CLIENTE WHERE ID = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setTelefone(rs.getString(3));
			c.setEndereco(rs.getString(4));
			c.setCidade(rs.getString(5));
			
			for (UF uf : UF.values()) {
				if (uf.toString().equals(rs.getString(6)))
					c.setUf(uf);
			}
			
			c.setEmail(rs.getString(7));
			
			for (Genero g : Genero.values()) {
				if (g.toString().equals(rs.getString(8)))
					c.setGenero(g);
			}
		}
		
		rs.close();
		ps.close();
		
		return c;

	}

	@Override
	public List<Cliente> listar() throws SQLException {
		Connection con = getConnection();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
				
		sql = "SELECT * FROM CLIENTE ORDER BY id ASC";

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()){
			Cliente c = new Cliente();
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setTelefone(rs.getString(3));
			c.setEndereco(rs.getString(4));
			c.setCidade(rs.getString(5));
			
			for (UF uf : UF.values()) {
				if (uf.toString().equals(rs.getString(6)))
					c.setUf(uf);
			}
			
			c.setEmail(rs.getString(7));
			
			for (Genero g : Genero.values()) {
				if (g.toString().equals(rs.getString(8)))
					c.setGenero(g);
			}
			
			clientes.add(c);
		}
		
		rs.close();
		st.close();
		
		return clientes;
	}
	
}
