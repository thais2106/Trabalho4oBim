package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

/**
 * Tela que configura o MioloCadastroCliente e o DAOCliente na mesma tela
 * @author tcrivelatti - 28/10/2015 - 19:30
 *
 */
public class TelaCadastroCliente extends MolduraAbstrata{
	
	public TelaCadastroCliente(){
		super();
	}

	@Override
	protected void configuraMiolo() {
		MioloCadastroCliente mioloCadastroCliente = new MioloCadastroCliente();
		super.add(mioloCadastroCliente, BorderLayout.CENTER);
		try {
			super.setAcaoSalvar(mioloCadastroCliente.getAcaoSalvar());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
