package br.univel.cadastros;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.conexao.ConexaoServidor;
import br.univel.produto.Produto;

/**
 * Classe que implementa os métodos de manipulação de banco
 * 
 * @author Thaís - 06/11/2015 - 22:14:53
 *
 */
public class VendaDAOImpl implements VendaDAO {
	private String sql;
	private static Connection con = ConexaoServidor.getConnection();

	@Override
	public void inserir(Venda v) throws SQLException {
		
		sql = "INSERT INTO VENDA(idvenda, idcliente, nomecliente, valtotal, valpagamento, data, hora)"
				+ "VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, v.getIdVenda());
		ps.setInt(2, v.getIdCliente());
		ps.setString(3, v.getNomeCliente());
		ps.setBigDecimal(4, v.getValorTotal());
		ps.setBigDecimal(5, v.getValorPagamento());
		
		ps.executeUpdate();
		ps.close();
		
		inserirItens(v.getIdVenda(), v.getItens());
		
		JOptionPane.showMessageDialog(null, "Venda salva com sucesso!");
	
	}

	
	private void inserirItens(int idvenda, ArrayList<Produto> itens) throws SQLException {

		sql = "INSERT INTO ITENS(idvenda, idproduto, valproduto)"
				+ "VALUES(?,?,?)";
		
		for (Produto p : itens) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idvenda);
			ps.setInt(2, p.getId());
			ps.setString(3, p.getDescricao());
			ps.setBigDecimal(4, p.getCusto());
			ps.executeUpdate();
			ps.close();
		}
		
		
	}

	@Override
	public void atualizar(Venda v) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Venda v) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Venda buscar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int buscarID() throws SQLException {

		int cod = 0;

		sql = "SELECT MAX(ID) FROM VENDA";

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.first()) {
			cod = rs.getInt(1);
		}
		
		return cod + 1;
	}

}
