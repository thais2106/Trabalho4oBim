package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

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
	protected void configuraMiolo() throws SQLException {
		//Instancia novo Miolo
		MioloCadProduto mcp = new MioloCadProduto();
		
		//Adiciona o miolo no centro da MolduraAbstrata	
		super.add(mcp, BorderLayout.CENTER);
		
	}

}
