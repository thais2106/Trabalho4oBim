package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

/**
 * Tela que configura o MioloCadastroCliente e o DAOCliente na mesma tela
 * @author tcrivelatti - 28/10/2015 - 19:30
 *
 */
public class TelaCadCliente extends MolduraAbstrata{
	
	public TelaCadCliente(){
		super();
	}

	@Override
	protected void configuraMiolo() {
		MioloCadCliente mioloCadastroCliente = new MioloCadCliente();
		super.add(mioloCadastroCliente, BorderLayout.CENTER);
		try {
			super.setAcaoSalvar(mioloCadastroCliente.getAcaoSalvar());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
