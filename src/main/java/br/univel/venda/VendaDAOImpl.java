package br.univel.venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.univel.conexao.ConexaoServidor;

/**
 * Classe que implementa os métodos de manipulação de banco
 * @author Thaís - 06/11/2015 - 22:14:53
 *
 */
public class VendaDAOImpl implements VendaDAO {
	private String sql;
	private static Connection con = ConexaoServidor.getConnection();

	@Override
	public void inserir(Venda v) throws SQLException {
		
		sql = "INSERT INTO VENDA(idvenda, idcliente, nomecliente, valortotal, valorpagamento, datavenda, horavenda)"
				+ "VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, v.getIdVenda());
		ps.setInt(2, v.getIdCliente());
		ps.setString(3, v.getNomeCliente());
		ps.setBigDecimal(4, v.getValorTotal());
		ps.setBigDecimal(5, v.getValorPagamento());
		ps.setDate(6, new java.sql.Date(v.getData().getTime()));
		ps.setTime(7, new java.sql.Time(v.getHora()));
		
		ps.executeUpdate();
		ps.close();
		
		inserirItens(v.getIdVenda(), v.getItens());
	
	}

	
	private void inserirItens(int idvenda, ArrayList<Item> arrayList) throws SQLException {

		sql = "INSERT INTO ITEM(idvenda, idproduto, descricao, quantidade, custo)"
				+ "VALUES(?,?,?,?,?)";
		
		for (Item i : arrayList) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idvenda);
			ps.setInt(2, i.getIdproduto());
			ps.setString(3, i.getDescricao());
			ps.setInt(4, i.getQuantidade());
			ps.setBigDecimal(5, i.getPrecounitario());
			ps.executeUpdate();
			ps.close();
		}
		
	}
	
	@Override
	public Venda buscar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Venda> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int buscarID() throws SQLException {

		int cod = 0;

		sql = "SELECT MAX(idvenda) FROM VENDA";

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.first()) {
			cod = rs.getInt(1);
		}
		
		return cod + 1;
	}

}
