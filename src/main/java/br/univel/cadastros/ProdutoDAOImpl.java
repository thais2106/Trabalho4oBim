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
 * Implementação da classe ProdutoDAO
 * @author Thaís - 02/11/2015 - 16:37:23
 *
 */

public class ProdutoDAOImpl implements ProdutoDAO{
	private String sql;
	private static Connection con;
	
	public Connection getConnection(){
			System.out.println("tenta iniciar a con");
			if (con == null){
				try{
					String url = "jdbc:h2:~/sisvendas";
					String user = "sa";
					String pass = "sa";
						
					con = DriverManager.getConnection(url, user, pass);
				} catch (SQLException e){
					System.out.println("Erro ao abrir conexão");
					e.printStackTrace();
				}
			}
			synchronized (con) {
			return con; //retorna conexão
		}
	}
	
	
	@Override
	public void inserir(Produto p) throws SQLException {
		Connection con = getConnection();
		
		sql = "INSERT INTO PRODUTO(id, codbarras, categoria, descricao, unidade, custo, margemlucro) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ps.setString(2, p.getCodBarras());
		ps.setString(3, p.getCategoria().toString());
		ps.setString(4, p.getDescricao());
		ps.setString(5, p.getUnidade().getNome());
		ps.setBigDecimal(6, p.getCusto());;
		ps.setBigDecimal(7, p.getMargemLucro());
		
		ps.executeUpdate();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto p) throws SQLException {
		Connection con = getConnection();
		
		sql = "UPDATE PRODUTO SET id = ?, codbarras = ?, categoria = ?, descricao = ?, unidade = ?,"
				+ " custo = ?, margemlucro = ? WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ps.setString(2, p.getCodBarras());
		ps.setString(3, p.getCategoria().toString());
		ps.setString(4, p.getDescricao());
		ps.setString(5, p.getUnidade().getNome());
		ps.setBigDecimal(6, p.getCusto());
		ps.setBigDecimal(7, p.getMargemLucro());
		
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void excluir(Produto p) throws SQLException {
		Connection con = getConnection();
		sql = "DELETE FROM PRODUTO WHERE ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public Produto buscar(int id) throws SQLException {
		Connection con = getConnection();
		Produto p = new Produto();
	
		sql = "SELECT * FROM PRODUTO WHERE ID = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("prepare stat");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			p.setId(rs.getInt(1));
			p.setCodBarras(rs.getString(2));
			
			//Percorre lista de valores da Enum Categoria
			for (Categoria c : Categoria.values()) {
				//Se existir um valor de Enum que seja igual a String salva no banco, ele seta a categoria para o Produto
				if (c.toString().equals(rs.getString(3)))
					p.setCategoria(c);
			}
			
			p.setDescricao(rs.getString(4));
			
			for (Unidade u : Unidade.values()) {
				if (u.toString().equals(rs.getString(5)))
					p.setUnidade(u);
			}
			p.setCusto(rs.getBigDecimal(6));
			p.setMargemLucro(rs.getBigDecimal(7));
		}
		
		rs.close();
		ps.close();
		
		return p;
	}

	@Override
	public List<Produto> listar() throws SQLException {
		Connection con = getConnection();
		
		List<Produto> produtos = new ArrayList<Produto>();
				
				
		sql = "SELECT * FROM PRODUTO ORDER BY id ASC";

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()){
			Produto p = new Produto();
			p.setId(rs.getInt(1));
			p.setCodBarras(rs.getString(2));
			
			for (Categoria c : Categoria.values()) {
				if (c.toString().equals(rs.getString(3)))
					p.setCategoria(c);
			}
			
			p.setDescricao(rs.getString(4));
			
			for (Unidade u : Unidade.values()) {
				if (u.getNome().equals(rs.getString(5)))
					p.setUnidade(u);
			}
			
			p.setCusto(rs.getBigDecimal(6));
			p.setMargemLucro(rs.getBigDecimal(7));
			produtos.add(p);
		}
		
		rs.close();
		st.close();
		
		return produtos;
	}

}
