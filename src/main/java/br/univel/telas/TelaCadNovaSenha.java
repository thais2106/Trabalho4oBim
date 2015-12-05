package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

public class TelaCadNovaSenha extends MolduraAbstrata{
	
	public TelaCadNovaSenha() {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		MioloNovaSenha mns = new MioloNovaSenha();
		super.add(mns, BorderLayout.CENTER);
	
		super.setAcaoSalvar(mns.getAcaoSalvar());
		super.setAcaoExcluir(mns.setAcaoExcluir());
	}

}
