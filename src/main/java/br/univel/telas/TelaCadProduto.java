package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.univel.cadastros.ProdutoDAOImpl;

/**
 * Tela que configura a MolduraAbstrata com o MioloCadProduto
 * @author Thaís - 02/11/2015 - 16:02:34
 *
 */
public class TelaCadProduto extends MolduraAbstrata{

	public TelaCadProduto() {
		super();
	}
	
	@Override
	protected void configuraMiolo() {
		//Instancia novo Miolo
		MioloCadProduto mcp = new MioloCadProduto();
		ProdutoDAOImpl dao = new ProdutoDAOImpl();
		
		try {
			mcp.txtid.setText(String.valueOf(dao.buscarID()));
		} catch (SQLException e1) {
			System.out.println("Erro ao buscar código do cliente!");
			e1.printStackTrace();
		}
		
		//Adiciona o miolo no centro da MolduraAbstrata	
		super.add(mcp, BorderLayout.CENTER);
		
		try{
			super.setAcaoSalvar(mcp.getAcaoSalvar());
		} catch (SQLException e) {
			System.out.println("Erro ao salvar produto.");
			e.printStackTrace();
		}
		
		try {
			super.setAcaoExcluir(mcp.getAcaoExcluir());
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
