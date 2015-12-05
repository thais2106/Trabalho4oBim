package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;
/**
 * Classe que mostra os campos da tela de cadastro de usuarios na MolduraAbstra
 * @author Thaís - 05/12/2015 - 13:40:53
 *
 */
public class TelaCadUsuario extends MolduraAbstrata{
	
	public TelaCadUsuario() {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		MioloCadUsuario mcu = MioloCadUsuario.getInstance();
		super.add(mcu, BorderLayout.CENTER);
	}

}
