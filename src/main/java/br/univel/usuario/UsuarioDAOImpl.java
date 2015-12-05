package br.univel.usuario;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.univel.conexao.ConexaoServidor;
import br.univel.produto.Categoria;
import br.univel.produto.Unidade;

public class UsuarioDAOImpl implements UsuarioDAO{
	private String sql;
	private static Connection con = ConexaoServidor.getConnection();

	@Override
	public void inserir(Usuario u) throws SQLException {
		sql = "INSERT INTO USUARIO (id, idcliente, senha) VALUES (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getId());
		ps.setInt(2, u.getClienteId());
		ps.setString(3, u.getSenha());
		
		ps.executeUpdate();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Usuario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Usuario u) throws SQLException {
		sql = "DELETE FROM USUARIO WHERE ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getId());
		ps.close();
		
		JOptionPane.showMessageDialog(null,	"Usuário removido com sucesso!");
		
	}

	@Override
	public Usuario buscar(int id) throws SQLException {
		Usuario u = new Usuario();
		sql = "SELECT * FROM USUARIO WHERE ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			u.setId(rs.getInt("id"));
			u.setClienteId(rs.getInt("idcliente"));;
		}
		rs.close();
		ps.close();

		return u;
	}

	@Override
	public List<Usuario> listar() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		sql = "SELECT * FROM USUARIO";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()){
			Usuario u = new Usuario();
			u.setId(rs.getInt("id"));
			u.setClienteId(rs.getInt("idcliente"));
			u.setSenha(rs.getString("senha"));
			usuarios.add(u);
		}
		
		rs.close();
		st.close();
		
		return usuarios;
	}
	
	public int buscarID() throws SQLException{
		int cod = 0;
		
		sql = "SELECT MAX(ID) FROM USUARIO";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if (rs.first()){
			cod = rs.getInt(1);
		}
	
		return cod + 1;
	}

}
