package br.univel.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Implementação da classe ProdutoDAO
 * @author Thaís - 02/11/2015 - 16:37:23
 *
 */

public class ProdutoDAOImpl implements ProdutoDAO{
	private String sql;
	private Conexao connect;
	
	@Override
	public void inserir(Produto p) throws SQLException {
		Connection con = connect.getConnection();
		
		sql = "INSERT INTO PRODUTO(id, codbarras, categoria, descricao, unidade, custo, margemlucro"
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
	public void atualizar(Produto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Produto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
